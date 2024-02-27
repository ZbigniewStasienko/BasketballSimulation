import java.io.PrintWriter;

// Class that prints a match summary and a series of matches summary to the file
public class Printer {

    // Function printing the result of a single match
    public static void printStats(PrintWriter fileWriter, Guard guardTeamOne, Forward forwardTeamOne, Center centerTeamOne, Guard guardTeamTwo, Forward forwardTeamTwo, Center centerTeamTwo, FinalScore score) {
        int oneGame = 1;
        fileWriter.println("End of the game");
        fileWriter.println("Stats from the game: \n");
        fileWriter.println(guardTeamOne.getName());
        fileWriter.println(guardTeamOne.stats.printStats(oneGame));
        guardTeamOne.averageStats.setAverageStats(guardTeamOne.stats);
        fileWriter.println();

        fileWriter.println(forwardTeamOne.getName());
        fileWriter.println(forwardTeamOne.stats.printStats(oneGame));
        forwardTeamOne.averageStats.setAverageStats(forwardTeamOne.stats);
        fileWriter.println();

        fileWriter.println(centerTeamOne.getName());
        fileWriter.println(centerTeamOne.stats.printStatsCenter(oneGame));
        centerTeamOne.averageStats.setAverageStats(centerTeamOne.stats);
        fileWriter.println();

        fileWriter.println(guardTeamTwo.getName());
        fileWriter.println(guardTeamTwo.stats.printStats(oneGame));
        guardTeamTwo.averageStats.setAverageStats(guardTeamTwo.stats);
        fileWriter.println();

        fileWriter.println(forwardTeamTwo.getName());
        fileWriter.println(forwardTeamTwo.stats.printStats(oneGame));
        forwardTeamTwo.averageStats.setAverageStats(forwardTeamTwo.stats);
        fileWriter.println();

        fileWriter.println(centerTeamTwo.getName());
        fileWriter.println(centerTeamTwo.stats.printStatsCenter(oneGame));
        centerTeamTwo.averageStats.setAverageStats(centerTeamTwo.stats);
        fileWriter.println();

        if (score.getTeamOne() > score.getTeamTwo()) {
            fileWriter.println("Team One won");
        } else {
            fileWriter.println("Team Two won");
        }
        fileWriter.println("Final score");
        fileWriter.println("Team One: " + score.getTeamOne() + " - Team Two: " + score.getTeamTwo() + "\n");
        score.setTOneScores(score.getTeamOne());
        score.setTTwoScores(score.getTeamTwo());
        // We clear the current statistics so that we can count the data from zero in the next match
        guardTeamOne.stats.clearStats();
        forwardTeamOne.stats.clearStats();
        centerTeamOne.stats.clearStats();
        guardTeamTwo.stats.clearStats();
        forwardTeamTwo.stats.clearStats();
        centerTeamTwo.stats.clearStats();
        score.setTeamOne(0);
        score.setTeamTwo(0);
    }

    // Function printing average statistics of all played matches
    public static void printAverageStats(PrintWriter fileWriter, Guard guardTeamOne, Forward forwardTeamOne, Center centerTeamOne, Guard guardTeamTwo, Forward forwardTeamTwo, Center centerTeamTwo, FinalScore score){
        fileWriter.println("Average stats: \n");
        fileWriter.println(guardTeamOne.getName() + " (Attack:" + guardTeamOne.getShooting() + " Defence:" + guardTeamOne.getDefence() + ")");
        fileWriter.println(guardTeamOne.averageStats.printStats(score.getNrOfGames()));
        guardTeamOne.averageStats.setAverageStats(guardTeamOne.stats);
        fileWriter.println();

        fileWriter.println(forwardTeamOne.getName() + " (Attack:" + forwardTeamOne.getShooting() + " Defence:" + forwardTeamOne.getDefence() + ")");
        fileWriter.println(forwardTeamOne.averageStats.printStats(score.getNrOfGames()));
        forwardTeamOne.averageStats.setAverageStats(forwardTeamOne.stats);
        fileWriter.println();

        fileWriter.println(centerTeamOne.getName() + " (Attack:" + centerTeamOne.getShooting() + " Defence:" + centerTeamOne.getDefence() + " Rebounding:" + centerTeamOne.getRebound() + ")");
        fileWriter.println(centerTeamOne.averageStats.printStatsCenter(score.getNrOfGames()));
        centerTeamOne.averageStats.setAverageStats(centerTeamOne.stats);
        fileWriter.println();

        fileWriter.println(guardTeamTwo.getName() + " (Attack:" + guardTeamTwo.getShooting() + " Defence:" + guardTeamTwo.getDefence() + ")");
        fileWriter.println(guardTeamTwo.averageStats.printStats(score.getNrOfGames()));
        guardTeamTwo.averageStats.setAverageStats(guardTeamTwo.stats);
        fileWriter.println();

        fileWriter.println(forwardTeamTwo.getName() + " (Attack:" + forwardTeamTwo.getShooting() + " Defence:" + forwardTeamTwo.getDefence() + ")");
        fileWriter.println(forwardTeamTwo.averageStats.printStats(score.getNrOfGames()));
        forwardTeamTwo.averageStats.setAverageStats(forwardTeamTwo.stats);
        fileWriter.println();

        fileWriter.println(centerTeamTwo.getName() + " (Attack:" + centerTeamTwo.getShooting() + " Defence:" + centerTeamTwo.getDefence() + " Rebounding:" + centerTeamTwo.getRebound() + ")");
        fileWriter.println(centerTeamTwo.averageStats.printStatsCenter(score.getNrOfGames()));
        centerTeamTwo.averageStats.setAverageStats(centerTeamTwo.stats);
        fileWriter.println();

        fileWriter.println("Final scores:");
        fileWriter.println(score.printFinalScores());
    }
}
