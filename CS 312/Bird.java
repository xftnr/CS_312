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
public class Bird extends Critter{
    private Direction premove = null;
    private int count = 0;
    public Bird(){
    }
    public boolean eat(){
        return false;
    }
    public Attack fight(String opponent) {
        if (opponent == "%"){
            return Attack.ROAR;
        }
        else{
            return Attack.POUNCE;
        }
    }
    public Color getColor() {
        return Color.BLUE;
    }    
    public Direction getMove(){
        if (premove == null || premove == Direction.WEST){
            if (count == 3){
                count = 1;
                premove = Direction.NORTH;
                return Direction.EAST;
            }
            else {
                count++;
                return Direction.NORTH;
            }
        }
        else if (premove == Direction.NORTH){
            if (count == 3){
                count = 1;
                premove = Direction.EAST;
                return Direction.SOUTH;
            }
            else {
                count++;
                return Direction.EAST;
            }
        }
        else if (premove == Direction.EAST){
            if (count == 3){
                count = 1;
                premove = Direction.SOUTH;
                return Direction.WEST;
            }
            else {
                count++;
                return Direction.SOUTH;
            }
        }
        else if (premove == Direction.SOUTH){
            if (count == 3){
                count = 1;
                premove = Direction.WEST;
                return Direction.NORTH;
            }
            else {
                count++;
                return Direction.WEST;
            }
        }
        else {
            return Direction.CENTER;
        }
    }    
    public String toString() {
        if (premove == null || premove == Direction.WEST){
            return "^";
        }
        else if (premove == Direction.NORTH){
            return ">";
        }
        else if (premove == Direction.EAST){
            return "V";
        }
        else if (premove == Direction.SOUTH){
            return "<";
        }
        else{
            return " ";
        }
    }
}