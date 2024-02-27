public class Main {
    public static final int guardTeamOneId = 1;
    public static final int forwardTeamOneId = 2;
    public static final int centerTeamOneId = 3;
    public static final int guardTeamTwoId = 4;
    public static final int forwardTeamTwoId = 5;
    public static final int centerTeamTwoId = 6;
    public static int gamesToPlay = -1;
    public static int generatingPlayersOption = -1;
    public static void runSimulation() {
        int finalScore = 21;

        Ball ball = new Ball();

        Field playground = new Field();

        Guard guardTeamOne = null;
        Guard guardTeamTwo = null;
        Forward forwardTeamOne = null;
        Forward forwardTeamTwo = null;
        Center centerTeamOne = null;
        Center centerTeamTwo = null;

        if(generatingPlayersOption == -1 || gamesToPlay == -1){
            return;
        }

        if(generatingPlayersOption == 1){
            PlayerInit playerInit = new PlayerInit();
            guardTeamOne = playerInit.generateGuard(guardTeamOneId);
            guardTeamTwo = playerInit.generateGuard(guardTeamTwoId);
            forwardTeamOne = playerInit.generateForward(forwardTeamOneId);
            forwardTeamTwo = playerInit.generateForward(forwardTeamTwoId);
            centerTeamOne = playerInit.generateCenter(centerTeamOneId);
            centerTeamTwo = playerInit.generateCenter(centerTeamTwoId);
        }
        if(generatingPlayersOption == 2){
            PlayerReader playerReader = new PlayerReader();
            playerReader.readPlayersFromFile();
            guardTeamOne = playerReader.guardTeamOne;
            guardTeamTwo = playerReader.guardTeamTwo;
            forwardTeamOne = playerReader.forwardTeamOne;
            forwardTeamTwo = playerReader.forwardTeamTwo;
            centerTeamOne = playerReader.centerTeamOne;
            centerTeamTwo = playerReader.centerTeamTwo;
        }

        Actions actions = new Actions(guardTeamOne, guardTeamTwo, forwardTeamOne, forwardTeamTwo, centerTeamOne, centerTeamTwo);

        FinalScore score = new FinalScore(0, 0, gamesToPlay);
        Actions.setScore(score);

        // Loop in which we play a series of matches
        for(int a = 0; a < gamesToPlay; a++){

            // We draw a player and a team that will start the match
            int firstPossesion = Actions.firstPlayer();

            ball.setPlayerId(firstPossesion);
            if(firstPossesion < 4){
                firstPossesion = 1;
            } else {
                firstPossesion = 2;
            }
            ball.setTeamId(firstPossesion);
            actions.setBall(ball);
            actions.setPlayground(playground);

            int[] numbers = {guardTeamOne.getNumber(), forwardTeamOne.getNumber(), centerTeamOne.getNumber(), guardTeamTwo.getNumber(), forwardTeamTwo.getNumber(), centerTeamTwo.getNumber()};
            Actions.getField().setPlayerNumbers(numbers);

            // Loop in which a single match is played
            while (Actions.getScore().getTeamOne() < finalScore && Actions.getScore().getTeamTwo() < finalScore){
                actions.oneAction();
                if(Actions.getScore().getTeamTwo() == finalScore || Actions.getScore().getTeamOne() == finalScore){
                    break;
                }
                actions.oneAction();
            }

            Actions.setActionNr(1);
            Printer.printStats(actions.getFileWriter(), Actions.getGuardTeamOne(), Actions.getForwardTeamOne(), Actions.getCenterTeamOne(), Actions.getGuardTeamTwo(), Actions.getForwardTeamTwo(), Actions.getCenterTeamTwo(), Actions.getScore());

        }
        Printer.printAverageStats(actions.getFileWriter(), Actions.getGuardTeamOne(), Actions.getForwardTeamOne(), Actions.getCenterTeamOne(), Actions.getGuardTeamTwo(), Actions.getForwardTeamTwo(), Actions.getCenterTeamTwo(), Actions.getScore());
        actions.getFileWriter().println();
        actions.getFileWriter().println("Closing the document");
        actions.getFileWriter().close();
    }
}
