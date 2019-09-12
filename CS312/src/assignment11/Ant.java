package assignment11;
import java.awt.*;
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
public class Ant extends Critter{
    private Direction premove = null;
    private boolean walkSouth;
    public Ant(boolean walkSouth) {
        this.walkSouth = walkSouth;
    }
    public boolean eat(){
        return true;
    }
    public Attack fight(String opponent) {
        return Attack.SCRATCH;
    }
    public Color getColor() {
        return Color.RED;
    }
    public Direction getMove(){
        if( walkSouth){
            if(premove == Direction.SOUTH){
                premove = Direction.EAST;
                return Direction.EAST;
            }
            else{
                premove = Direction.SOUTH;
                return Direction.SOUTH;
            }
        } 
        else{
            if(premove == Direction.NORTH){
                premove = Direction.EAST;
                return Direction.EAST;
            }
            else{
                premove = Direction.NORTH;
                return Direction.NORTH;
            }
        }
    }
    public String toString() {
        return "%";
    }
}
