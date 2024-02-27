import java.util.Random;

// Class responsible for generating random values
public class Randomize {
    Random randomGenerator = new Random();

    public double random0to1(){
        return Math.random();
    }
    public int randomRange(int start, int end){
        return randomGenerator.nextInt(end - start) + start;
    }
}
