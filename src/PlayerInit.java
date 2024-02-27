import java.util.ArrayList;

// Class used for random generating players
public class PlayerInit {

    private static ArrayList<Integer> takenNames = new ArrayList<>();
    private static ArrayList<Integer> takenNumbers = new ArrayList<>();
    Randomize rand = new Randomize();

    // Name container that we draw player names from
    String[] nameContainer = {
            "Liam", "Noah", "Oliver", "Elijah", "William", "James", "Benjamin", "Lucas", "Henry", "Alexander",
            "Mason", "Michael", "Ethan", "Daniel", "Jacob", "Logan", "Jackson", "Levi", "Sebastian", "Mateo",
            "Jack", "Owen", "Theodore", "Aiden", "Samuel", "Joseph", "John", "David", "Wyatt", "Matthew",
            "Luke", "Asher", "Carter", "Julian", "Grayson", "Leo", "Jayden", "Gabriel", "Isaac", "Lincoln",
            "Anthony", "Hudson", "Dylan", "Kobe", "Thomas", "Charles", "Christopher", "Jaxon", "Maverick"
    };

    public Guard generateGuard(int id) {
        int nameId;
        while(true){
            nameId = rand.randomRange(0, nameContainer.length);
            if(!takenNames.contains(nameId)){
                takenNames.add(nameId);
                break;
            }
        }
        int number;
        while(true){
            number = rand.randomRange(1, 99);
            if(!takenNumbers.contains(number)){
                takenNumbers.add(number);
                break;
            }
        }
        takenNumbers.add(number);
        double shooting = rand.randomRange(20,80);
        double defence = 100 - shooting;
        shooting = shooting / 100;
        defence = defence / 100;
        return new Guard(nameContainer[nameId], number, shooting, defence, id, 1, 1);
    }

    public Forward generateForward(int id) {
        int nameId;
        while(true){
            nameId = rand.randomRange(0, nameContainer.length);
            if(!takenNames.contains(nameId)){
                takenNames.add(nameId);
                break;
            }
        }
        int number;
        while(true){
            number = rand.randomRange(1, 99);
            if(!takenNumbers.contains(number)){
                takenNumbers.add(number);
                break;
            }
        }
        takenNumbers.add(number);
        double shooting = rand.randomRange(20,80);
        double defence = 100 - shooting;
        shooting = shooting / 100;
        defence = defence / 100;
        return new Forward(nameContainer[nameId], number, shooting, defence, id, 1, 1);
    }

    public Center generateCenter(int id) {
        int nameId;
        while(true){
            nameId = rand.randomRange(0, nameContainer.length);
            if(!takenNames.contains(nameId)){
                takenNames.add(nameId);
                break;
            }
        }
        int number;
        while(true){
            number = rand.randomRange(1, 99);
            if(!takenNumbers.contains(number)){
                takenNumbers.add(number);
                break;
            }
        }
        takenNumbers.add(number);
        double shooting = rand.randomRange(20,49);
        double defence = rand.randomRange(20,49);
        double rebound = 100 - shooting - defence;
        shooting = shooting / 100;
        defence = defence / 100;
        rebound = rebound / 100;
        return new Center(nameContainer[nameId], number, shooting, defence, id, 1, 1, rebound);
    }



}
