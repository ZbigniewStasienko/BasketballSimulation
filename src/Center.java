/*Class defining Center
Differs from the standard player model in that he can rebound the ball after a missed shot*/
public class Center extends Player{

    private final double rebound;
    public Center(String name, int number, double shooting, double defence, int id, int positionX, int positionY, double rebound) {
        super(name, number, shooting, defence, id, positionX, positionY);
        this.rebound = rebound;
    }
    public double getRebound() {
        return rebound;
    }
}
