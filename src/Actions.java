import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Actions {
    private static PrintWriter fileWriter;
    private static Field field;
    private static Ball ball;
    private static FinalScore score;
    private static final Randomize randomize = new Randomize();
    private static Guard guardTeamOne;
    private static Guard guardTeamTwo;
    private static Forward forwardTeamOne;
    private static Forward forwardTeamTwo;
    private static Center centerTeamOne;
    private static Center centerTeamTwo;
    private static Player playerWithBallOffence;
    private static Player playerWithBallDefence;
    private static Player playerWithoutBallOffence1;
    private static Player playerWithoutBallOffence2;
    private static Player playerWithoutBallDefence1;
    private static Player playerWithoutBallDefence2;
    private static int actionNr = 1;
    private static double random;

    public static void setActionNr(int actionNr) {
        Actions.actionNr = actionNr;
    }

    public static Guard getGuardTeamOne() {
        return guardTeamOne;
    }

    public static Guard getGuardTeamTwo() {
        return guardTeamTwo;
    }

    public static Forward getForwardTeamOne() {
        return forwardTeamOne;
    }

    public static Forward getForwardTeamTwo() {
        return forwardTeamTwo;
    }

    public static Center getCenterTeamOne() {
        return centerTeamOne;
    }

    public static Center getCenterTeamTwo() {
        return centerTeamTwo;
    }

    public static FinalScore getScore() {
        return score;
    }

    public static void setScore(FinalScore score) {
        Actions.score = score;
    }

    public void setPlayground(Field playground) {
        Actions.field = playground;
    }

    public static Field getField() {
        return field;
    }

    public PrintWriter getFileWriter() {
        return fileWriter;
    }
    public void setBall(Ball ball) {
        this.ball = ball;
    }

    // Function opening the file to which the simulation progress will be saved
    public void creationOfFile() {
        try {
            fileWriter = new PrintWriter("simulation.txt", "UTF-8");
        } catch (
                FileNotFoundException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        fileWriter.println("Opening of the document");
        fileWriter.println();
    }

    // Constructor of the class, setting up players and creating the field on which we will play the match
    public Actions(Guard guard1, Guard guard2, Forward forward1, Forward forward2, Center center1, Center center2) {
        guardTeamOne = guard1;
        guardTeamTwo = guard2;
        forwardTeamOne = forward1;
        forwardTeamTwo = forward2;
        centerTeamOne = center1;
        centerTeamTwo = center2;
        creationOfFile();
    }

   // Function for changing ball possession in case of the end of an action by one of the teams.
    public void changePossesion() {
        if (ball.getTeamId() == 1) {
            ball.setTeamId(2);
            ball.setPlayerId(randomize.randomRange(1,3) + 3);
        } else {
            ball.setTeamId(1);
            ball.setPlayerId(randomize.randomRange(1,3));
        }
    }

    // Function for drawing the team starting the match
    public static int firstPlayer() {
        fileWriter.println("Drawing the starting team");
        int firstIdPlayer = randomize.randomRange(1,6);
        if (firstIdPlayer < 4) {
            fileWriter.println("Team One starts the game");
        } else {
            fileWriter.println("Team Two starts the game");
        }
        fileWriter.println();
        return firstIdPlayer;
    }
    // Function that returns to us a player object based on their unique ID number
    public Player playerFromId(int idOfPlayer) {
        if (idOfPlayer == 1) {
            return guardTeamOne;
        } else if (idOfPlayer == 2) {
            return forwardTeamOne;
        } else if (idOfPlayer == 3) {
            return centerTeamOne;
        } else if (idOfPlayer == 4) {
            return guardTeamTwo;
        } else if (idOfPlayer == 5) {
            return forwardTeamTwo;
        } else {
            return centerTeamTwo;
        }
    }

    // Function that divides players based on who possesses the ball
    public void dividePlayers() {
        if (ball.getTeamId() == 1) {
            if (ball.getPlayerId() == 1) {
                playerWithBallOffence = guardTeamOne;
                playerWithBallDefence = guardTeamTwo;
                playerWithoutBallDefence1 = forwardTeamTwo;
                playerWithoutBallDefence2 = centerTeamTwo;
                playerWithoutBallOffence1 = forwardTeamOne;
                playerWithoutBallOffence2 = centerTeamOne;
            } else if (ball.getPlayerId() == 2) {
                playerWithBallOffence = forwardTeamOne;
                playerWithBallDefence = forwardTeamTwo;
                playerWithoutBallDefence1 = guardTeamTwo;
                playerWithoutBallDefence2 = centerTeamTwo;
                playerWithoutBallOffence1 = guardTeamOne;
                playerWithoutBallOffence2 = centerTeamOne;
            } else {
                playerWithBallOffence = centerTeamOne;
                playerWithBallDefence = centerTeamTwo;
                playerWithoutBallDefence1 = guardTeamTwo;
                playerWithoutBallDefence2 = forwardTeamTwo;
                playerWithoutBallOffence1 = guardTeamOne;
                playerWithoutBallOffence2 = forwardTeamOne;
            }

        } else {
            if (ball.getPlayerId() == 4) {
                playerWithBallOffence = guardTeamTwo;
                playerWithBallDefence = guardTeamOne;
                playerWithoutBallDefence1 = forwardTeamOne;
                playerWithoutBallDefence2 = centerTeamOne;
                playerWithoutBallOffence1 = forwardTeamTwo;
                playerWithoutBallOffence2 = centerTeamTwo;
            } else if (ball.getPlayerId() == 5) {
                playerWithBallOffence = forwardTeamTwo;
                playerWithBallDefence = forwardTeamOne;
                playerWithoutBallDefence1 = guardTeamOne;
                playerWithoutBallDefence2 = centerTeamOne;
                playerWithoutBallOffence1 = guardTeamTwo;
                playerWithoutBallOffence2 = centerTeamTwo;
            } else {
                playerWithBallOffence = centerTeamTwo;
                playerWithBallDefence = centerTeamOne;
                playerWithoutBallDefence1 = guardTeamOne;
                playerWithoutBallDefence2 = forwardTeamOne;
                playerWithoutBallOffence1 = guardTeamTwo;
                playerWithoutBallOffence2 = forwardTeamTwo;
            }
        }
    }

    // Function adds the score in case one of the teams earns points
    public void addScore() {
        if (ball.getTeamId() == 1) {
            score.setTeamOne(score.getTeamOne() + 1);
        } else {
            score.setTeamTwo(score.getTeamTwo() + 1);
        }
    }

    // Function that randomly selects options for the player who is currently in possession of the ball
    public int playerWithBallOffenceOptions() {
        random = randomize.random0to1();
        // Case when a player decides to shoot for the basket
        if (random <= 0.33) {
            fileWriter.println(playerWithBallOffence.getName() + " shoots");
            int condition2 = 1;
            // Case for centers, where the shot can be blocked
            if (ball.getPlayerId() == 3 || ball.getPlayerId() == 6) {
                double random2 = randomize.random0to1();
                if (random2 <= playerWithBallDefence.getDefence()) {
                    fileWriter.println(playerWithBallDefence.getName() + " blocked the shot");
                    fileWriter.println("Change of possesion - shot was blocked");
                    ball.setLastPlayerWithBall(0);
                    fileWriter.println();
                    playerWithBallDefence.stats.setDefence(playerWithBallDefence.stats.getDefence() + 1);
                    playerWithBallOffence.stats.setMissed2ptShots(playerWithBallOffence.stats.getMissed2ptShots() + 1);
                    changePossesion();
                    condition2 = 0;
                    return 1;
                }
            }
            // Case when the shot was made - we check whether it was made or not and return the appropriate number
            if (condition2 == 1) {
                boolean isMade = playerWithBallOffence.shoot();
                if (isMade) {
                    fileWriter.println(playerFromId(ball.getPlayerId()).getName() + " made shot");
                    if (ball.getLastPlayerWithBall() != 0) {
                        fileWriter.println("Assist from player " + playerFromId(ball.getLastPlayerWithBall()).getName());
                        playerFromId(ball.getLastPlayerWithBall()).stats.setAssist(playerFromId(ball.getLastPlayerWithBall()).stats.getAssist() + 1);
                    }
                    fileWriter.println("Change of possesion - shot was made");
                    addScore();
                    ball.setLastPlayerWithBall(0);
                    fileWriter.println();
                    playerWithBallOffence.stats.setMade2ptShots(playerWithBallOffence.stats.getMade2ptShots() + 1);
                    changePossesion();
                    return 5;
                } else {
                    fileWriter.println(playerFromId(ball.getPlayerId()).getName() + " missed shot");
                    playerWithBallOffence.stats.setMissed2ptShots(playerWithBallOffence.stats.getMissed2ptShots() + 1);
                    return 4;
                }
            }
            return 0;
            // Player decided to pass the ball
        } else if (random > 0.33 && random <= 0.67) {
            ball.setLastPlayerWithBall(ball.getPlayerId());
            ball.setPlayerId(playerWithBallOffence.pass());
            fileWriter.println(playerFromId(ball.getLastPlayerWithBall()).getName() + " passed the ball to " + playerFromId(ball.getPlayerId()).getName());
            return 2;
            // Player dribbled
        } else {
            ball.setLastPlayerWithBall(0);
            fileWriter.println(playerWithBallOffence.getName() + " dribbles");
            return 3;
        }
    }

    // Function that performs action of a team
    // Action ends when the ball changes possession from one team to the other
    public void oneAction() {

        fileWriter.println("Action number " + (actionNr));
        fileWriter.println();
        actionNr++;

        int condition3;
        if (ball.getTeamId() == 1) {
            condition3 = 1;
            fileWriter.println("Team One in action");
        } else {
            condition3 = 2;
            fileWriter.println("Team Two in action");
        }

        // Placing players on their initial positions on the field
        dividePlayers();
        field.createPlayground();
        StartPositions.startingPositions(playerWithBallOffence, playerWithBallDefence, playerWithoutBallOffence1, playerWithoutBallDefence1, playerWithoutBallOffence2, playerWithoutBallDefence2);
        putPlayerOnField(playerWithBallOffence);
        putPlayerOnField(playerWithBallDefence);
        putPlayerOnField(playerWithoutBallOffence1);
        putPlayerOnField(playerWithoutBallDefence1);
        putPlayerOnField(playerWithoutBallOffence2);
        putPlayerOnField(playerWithoutBallDefence2);
        field.printField();
        fileWriter.println((playerFromId(ball.getPlayerId())).getName() + " has ball");

        // Loop in which subsequent steps in the action of a given team are performed
        while (ball.getTeamId() == condition3) {
            // Placing players on the field who do not have the ball or defend the ball - they always make a move on the field
            dividePlayers();
            field.createPlayground();
            settingPlayer(playerWithoutBallOffence1, playerWithoutBallDefence1, playerWithBallOffence, playerWithBallDefence, playerWithoutBallOffence2, playerWithoutBallDefence2);
            putPlayerOnField(playerWithoutBallOffence1);
            putPlayerOnField(playerWithoutBallDefence1);
            settingPlayer(playerWithoutBallOffence2, playerWithoutBallDefence2, playerWithoutBallOffence1, playerWithoutBallDefence1, playerWithBallOffence, playerWithBallDefence);
            putPlayerOnField(playerWithoutBallOffence2);
            putPlayerOnField(playerWithoutBallDefence2);


            int option = playerWithBallOffenceOptions();

            // Player dribbled
            if (option == 3) {
                settingPlayer(playerWithBallOffence, playerWithBallDefence, playerWithoutBallOffence1, playerWithoutBallDefence1, playerWithoutBallOffence2, playerWithoutBallDefence2);
            }
            // Player passed the ball
            if (option == 2) {
                // Redefining players with and without the ball
                dividePlayers();
                putPlayerOnField(playerWithoutBallOffence1);
                putPlayerOnField(playerWithoutBallDefence1);
                putPlayerOnField(playerWithoutBallOffence2);
                putPlayerOnField(playerWithoutBallDefence2);
            }
            // Placing player with the ball with its defender

            putPlayerOnField(playerWithBallOffence);
            putPlayerOnField(playerWithBallDefence);

            // Players shot was made
            if (option == 5) {
                field.createPlayground();
                field.made();
            }

            // Player missed his shot
            if (option == 4) {
                field.createPlayground();
                field.miss();
            }

            // Player was blocked
            if (option == 1) {
                field.createPlayground();
                field.block();
            }


            field.printField();

            // Case when defender stole tha ball from the player
            if (option == 3) {
                random = randomize.random0to1();
                if (random <= playerWithBallDefence.getDefence() && ball.getPlayerId() != 3 && ball.getPlayerId() != 6) {
                    fileWriter.println(playerWithBallDefence.getName() + " steal");
                    playerWithBallDefence.stats.setDefence(playerWithBallDefence.stats.getDefence() + 1);
                    fileWriter.println("Change of possesion - opponent stole the ball");
                    ball.setLastPlayerWithBall(0);
                    fileWriter.println();
                    changePossesion();
                    field.createPlayground();
                    field.steal();
                    field.printField();
                }
            }

            // Case when center rebounds ball
            if (option == 4) {
                random = randomize.random0to1();
                Center centerOffence;
                Center centerDefence;
                if (ball.getTeamId() == 1) {
                    centerOffence = centerTeamOne;
                    centerDefence = centerTeamTwo;
                } else {
                    centerOffence = centerTeamTwo;
                    centerDefence = centerTeamOne;
                }
                // Case when center grabs an offensive rebound
                if (random <= centerOffence.getRebound()) {
                    if (ball.getTeamId() == 1) {
                        fileWriter.println(centerTeamOne.getName() + " offensive rebound");
                        ball.setPlayerId(3);
                        centerOffence.stats.setOffensiveRebounds(centerOffence.stats.getOffensiveRebounds() + 1);
                    } else {
                        fileWriter.println(centerTeamTwo.getName() + " offensive rebound");
                        ball.setPlayerId(6);
                        centerOffence.stats.setOffensiveRebounds(centerOffence.stats.getOffensiveRebounds() + 1);
                    }
                    // Once center got offensive rebound, it is necessary to identify the players with and without the ball once again
                    dividePlayers();
                    field.createPlayground();
                    putPlayerOnField(playerWithBallOffence);
                    putPlayerOnField(playerWithBallDefence);
                    putPlayerOnField(playerWithoutBallOffence1);
                    putPlayerOnField(playerWithoutBallDefence1);
                    putPlayerOnField(playerWithoutBallOffence2);
                    putPlayerOnField(playerWithoutBallDefence2);
                    field.printField();

                } else {
                    // Case when defending center got rebound - change of possesion
                    fileWriter.println("Change of possesion - opponents got rebound");
                    ball.setLastPlayerWithBall(0);
                    fileWriter.println();
                    centerDefence.stats.setDefensiveRebounds(centerDefence.stats.getDefensiveRebounds() + 1);
                    changePossesion();
                }
            }
        }
    }

    // Check whether the player whose position we want to change does not enter an already occupied position
    public static boolean checkerPlayer(Player p1, Player p2, Player p2d, Player p3, Player p3d) {
        if (((p1.getPositionX() == p2.getPositionX()) && (p1.getPositionY() == p2.getPositionY())) || ((p1.getPositionX() == p2d.getPositionX()) && (p1.getPositionY() == p2d.getPositionY()))) {
            return false;
        } else {
            if (((p1.getPositionX() == p3.getPositionX()) && (p1.getPositionY() == p3.getPositionY())) || ((p1.getPositionX() == p3d.getPositionX()) && (p1.getPositionY() == p3d.getPositionY()))) {
                return false;
            } else {
                return true;
            }
        }
    }

    // Function that places defender on the pitch
    public static boolean checkerDefenderPlayer(Player p1, Player p1d, Player p2, Player p2d, Player p3, Player p3d) {
        // Placing defender on the field
        if (p1.getPositionX() > 6 && p1.getPositionX() < 10 && p1.getPositionY() < 4) {
            p1d.setPositionX(p1.getPositionX());
            p1d.setPositionY(p1.getPositionY() + 1);

        } else if (p1.getPositionX() > 6 && p1.getPositionX() < 10 && p1.getPositionY() > 7) {
            p1d.setPositionX(p1.getPositionX());
            p1d.setPositionY(p1.getPositionY() - 1);

        } else if (p1.getPositionX() == 9 && p1.getPositionY() > 0 && p1.getPositionY() < 6) {
            p1d.setPositionX(p1.getPositionX());
            p1d.setPositionY(p1.getPositionY() + 1);

        } else if (p1.getPositionX() == 9 && p1.getPositionY() > 5 && p1.getPositionY() < 11) {
            p1d.setPositionX(p1.getPositionX());
            p1d.setPositionY(p1.getPositionY() - 1);
        } else {
            p1d.setPositionX(p1.getPositionX() + 1);
            p1d.setPositionY(p1.getPositionY());
        }

        // Checking if the position is not already occupied
        if (((p1d.getPositionX() == p2.getPositionX()) && (p1d.getPositionY() == p2.getPositionY())) || ((p1d.getPositionX() == p2d.getPositionX()) && (p1d.getPositionY() == p2d.getPositionY()))) {
            return false;
        } else {
            if (((p1d.getPositionX() == p3.getPositionX()) && (p1d.getPositionY() == p3.getPositionY())) || ((p1d.getPositionX() == p3d.getPositionX()) && (p1d.getPositionY() == p3d.getPositionY()))) {
                return false;
            } else {
                return true;
            }
        }
    }


    // Function that searches for a new position for a player so that it does not overlap another player's field
    public static void settingPlayer(Player p1, Player p1d, Player p2, Player p2d, Player p3, Player p3d) {
        int condition = 0;
        int previousPositionX = p1.getPositionX();
        int previousPositionY = p1.getPositionY();
        while (condition == 0) {
            p1.move();
            if (checkerPlayer(p1, p2, p2d, p3, p3d)) {
                if (checkerDefenderPlayer(p1, p1d, p2, p2d, p3, p3d)) {
                    condition = 1;
                } else {
                    p1.setPositionX(previousPositionX);
                    p1.setPositionY(previousPositionY);
                }
            } else {
                p1.setPositionX(previousPositionX);
                p1.setPositionY(previousPositionY);
            }
        }
    }

    // Function that puts the player on the field according to coordinates
    public static void putPlayerOnField(Player player) {
        field.setCourtWithPlayer(player.getPositionX(), player.getPositionY(), player.getId(), ball.getPlayerId());
    }
}