import java.util.ArrayList;
import java.util.List;

//Class storing the final result of a single match and the results of a series of matches
public class FinalScore {
    private int TeamOne;
    private int TeamTwo;
    private int nrOfGames;

    // List with the results of team no. 1
    private List<Integer> TOneScores = new ArrayList<>();
    // List with the results of team no. 2
    private List<Integer> TTwoScores = new ArrayList<>();

    public int getNrOfGames() {
        return nrOfGames;
    }
    public void setTOneScores(int finalScore) {
        this.TOneScores.add(finalScore);
    }
    public void setTTwoScores(int finalScore) {
        this.TTwoScores.add(finalScore);
    }
    public FinalScore(int teamOne, int teamTwo, int nr) {
        TeamOne = teamOne;
        TeamTwo = teamTwo;
        nrOfGames = nr;
    }

    public int getTeamOne() {
        return TeamOne;
    }

    public void setTeamOne(int teamOne) {
        TeamOne = teamOne;
    }

    public int getTeamTwo() {
        return TeamTwo;
    }

    public void setTeamTwo(int teamTwo) {
        TeamTwo = teamTwo;
    }

    // Function displaying a summary of the results of all played games
    public String printFinalScores() {
        String out = "\n";
        int t1Win = 0;
        int t2Win = 0;
        for(int i = 0; i < nrOfGames; i++){
            out = out + "Game number: "+ (i+1) +" Team One: " + TOneScores.get(i) + " - " + "Team Two: " + TTwoScores.get(i) + "\n";
        }
        for(int i = 0; i < nrOfGames; i++){
            if(TOneScores.get(i) > TTwoScores.get(i)){
                t1Win++;
            } else {
                t2Win++;
            }
        }
        out = out + "Team One won: " + t1Win + " times\n";
        out = out + "Team Two won: " + t2Win + " times\n";
        return out;
    }
}
