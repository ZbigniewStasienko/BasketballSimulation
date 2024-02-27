// Abstract class that prototypes a player
public abstract class Player implements PlayerActions{
    Stats stats = new Stats(0,0,0,0,0,0);
    Stats averageStats = new Stats(0,0,0,0,0,0);

    private String name;
    private int number;
    private double shooting;
    private double defence;
    private int id;
    private int positionX;
    private int positionY;
    Randomize randomize = new Randomize();

    public Player(String name, int number, double shooting, double defence, int id, int positionX, int positionY) {
        this.shooting = shooting;
        this.defence = defence;
        this.id = id;
        this.positionX = positionX;
        this.positionY = positionY;
        this.name = name;
        this.number = number;
    }

    public int getPositionX() {
        return positionX;
    }
    public int getId() {
        return id;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public String getName() {
        return name;
    }
    public double getDefence() {
        return defence;
    }

    public double getShooting() {
        return shooting;
    }

    public int getNumber() {
        return number;
    }

    // Function informing whether the player scored or not
    // We take into account the player's distance from the basket
    @Override
    public boolean shoot() {
        double random = randomize.random0to1();
        if (random <= (shooting - distanceFromBasket(positionX,positionY))) {
            return true;
        } else {
            return false;
        }
    }

    // Function counting the current distance of the player from the basket
    public double distanceFromBasket(int x, int y) {
        double basketY = 5.5d;
        double basketX = 1;
        return Math.sqrt(Math.pow(basketX - x,2) + Math.pow(basketY - y,2)) / 200;
    }


    // We check whether the drawn co-roots are within the boundaries of the playing field
    public boolean moveChecker(int x, int y) {
        int outX1 = 0;
        int outX2 = 10;
        int outY1 = 0;
        int outY2 = 11;
        if(x == outX1 || x == outX2){
            return false;
        }
        else if(y == outY1 || y == outY2){
            return false;
        }
        else{
            return true;
        }
    }


    // Function that randomly selects new X and Y coordinates for our player
    // We complete the player's movement in the Actions class, where we take into account the position of other players
    @Override
    public void move() {
        boolean cond = false;
        int prevX = positionX;
        int prevY = positionY;
        while(!cond){
            switch (randomize.randomRange(1, 8)) {
                case 1:
                    positionX--;
                    break;
                case 2:
                    positionX++;
                    break;
                case 3:
                    positionY++;
                    break;
                case 4:
                    positionY--;
                    break;
                case 5:
                    positionX--;
                    positionY++;
                    break;
                case 6:
                    positionX--;
                    positionY--;
                    break;
                case 7:
                    positionX++;
                    positionY++;
                    break;
                case 8:
                    positionX++;
                    positionY--;
                    break;
                default:
                    break;
            }
            cond = moveChecker(positionX, positionY);
            if(!cond){
                positionX = prevX;
                positionY = prevY;
            }
        }
    }

    // A function that returns the ID of the player to whom the ball is to be passed
    @Override
    public int pass(){
        if(id == 1){
            return randomize.randomRange(1,2) + 1;
        } else if( id == 2){
            if(randomize.randomRange(1,2) == 1){
                return 1;
            } else {
                return 3;
            }
        } else if( id == 3){
            return randomize.randomRange(1,2);
        }
        if(id == 4){
            return randomize.randomRange(1,2) + 4;
        } else if( id == 5){
            if(randomize.randomRange(1,2) == 1){
                return 4;
            } else {
                return 6;
            }
        } else {
            return randomize.randomRange(1,2) + 3;
        }
    }
}
