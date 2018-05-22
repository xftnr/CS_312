import java.util.*;
import java.awt.*;
public class Turtle extends Critter {
    private int waitPeriod;
    private int turnsWaited;
    private Direction direction_I_Move;
    private boolean iAmHungry;
    private Random randNumGen = new Random();
    public Turtle(Direction d) {
        direction_I_Move = d;
        final int MIN_TURNS = 5;
        final int RANGE = 6;
        waitPeriod = randNumGen.nextInt(RANGE) + MIN_TURNS;
        turnsWaited = waitPeriod;
        // default value for iAmHungry is correct.
    }
    public boolean eat() {
        boolean result = iAmHungry;
        iAmHungry = false;
        return result;
    }
    public Color getColor() {
        return Color.GREEN;
    }
    public String toString() {
        return "T";
    }

    public Attack fight(String opponent) {
        Attack result = Attack.SCRATCH;
        if (opponent.equals("S")) {
            result = Attack.POUNCE;
        } else if (iAmHungry) {
            result = Attack.ROAR;
        }

        return result;
    }  

    public Direction getMove() {
        Direction result = Direction.CENTER;
        if (turnsWaited == waitPeriod) {
            result = direction_I_Move;
            turnsWaited = 0;
            iAmHungry = true;
        } else {
            turnsWaited++;
        }
        return result;
    }
}