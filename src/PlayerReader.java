import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Class used to read player data from file
public class PlayerReader {

    public Guard guardTeamOne;
    public Forward forwardTeamOne;
    public Center centerTeamOne;
    public Guard guardTeamTwo;
    public Forward forwardTeamTwo;
    public Center centerTeamTwo;

    public void readPlayersFromFile() {
        String fileName = "data.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int counter = 0;
            while ((line = br.readLine()) != null && counter < 9) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                    String name = parts[0];
                    int number = Integer.parseInt(parts[1]);
                    double shooting = Double.parseDouble(parts[2]);
                    double defence = Double.parseDouble(parts[3]);
                    if(counter == 2){
                        guardTeamOne = new Guard(name, number, shooting, defence, Main.guardTeamOneId, 1,1);
                    }
                    if(counter == 3){
                        forwardTeamOne = new Forward(name, number, shooting, defence, Main.forwardTeamOneId, 1,1);
                    }
                    if(counter == 6){
                        guardTeamTwo = new Guard(name, number, shooting, defence, Main.guardTeamTwoId, 1,1);
                    }
                    else {
                        forwardTeamTwo = new Forward(name, number, shooting, defence, Main.forwardTeamTwoId, 1,1);
                    }
                }
                if (parts.length == 5 && counter != 0) {
                    String name = parts[0];
                    int number = Integer.parseInt(parts[1]);
                    double shooting = Double.parseDouble(parts[2]);
                    double defence = Double.parseDouble(parts[3]);
                    double rebound = Double.parseDouble(parts[4]);
                    if(counter == 4){
                        centerTeamOne = new Center(name, number, shooting, defence, Main.centerTeamOneId, 1,1, rebound);
                    }
                    else {
                        centerTeamTwo = new Center(name, number, shooting, defence, Main.centerTeamTwoId, 1,1, rebound);
                    }
                }
                counter++;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
