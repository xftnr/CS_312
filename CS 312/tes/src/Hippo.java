import java.awt.*;
import java.util.Random;
/**
 * CS312 Assignment 11.
 *
 * On MY honor, <PENGDI XIA>, this programming assignment is MY own work
 * and I have not provided this code to any other student.
 *
 * Student name: Pengdi Xia
 * UTEID:px353
 * email address: xiapengdi@yahoo.com
 * Number of slip days used on this assignment:0
 * 
 */
public class Hippo extends Critter{
    private Direction move;
    private int count = 0;
    private int hunger;
    public Hippo(int hunger){
        this.hunger= hunger;
    }
    public boolean eat(){
       if (hunger >0) {
           hunger--;
           return true;
       }
       else {
           return false;
        }
    }
    public Attack fight(String opponent) {
        if (eat()){
            return Attack.SCRATCH;
        }
        else{
            return Attack.POUNCE;
        }
    }
    public Color getColor() {
        if (eat()){
            return Color.GRAY;
        }
        else{
            return Color.WHITE;
        }
    }    
    public Direction getMove(){
       if (count == 5){
            count = 0;
       }
       if (count == 0) {
           Random rand = new Random();
           move = Direction.values()[rand.nextInt()];
       } 
       count++;
       return move;
    }    
    
    
    public String toString() {
        return ""+ hunger;
    }
}