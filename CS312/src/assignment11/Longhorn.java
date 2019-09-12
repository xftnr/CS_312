package assignment11;

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
public class Longhorn extends Critter{
    private Direction move;
    private int count = 0;
    Random rand = new Random();
    public Longhorn(){
    }
    public boolean eat(){
        if (count < 7 ){
            return false;
        }
        else{
            return true;
        }
    }
    public Attack fight(String opponent) {
        if (eat()){
            count = 0;
            if (opponent == "%"){
                return Attack.ROAR;
            }
            else if(opponent == "S"){
                return Attack.POUNCE;
            }
            else {
                return Attack.SCRATCH;
            }
        }
        else{
            if (opponent == "%"){
                return Attack.ROAR;
            }
            else if(opponent == "S"){
                return Attack.POUNCE;
            }
            else {
                return Attack.SCRATCH;
            }
        }
    }
    public Color getColor() {
        return Color.ORANGE;
    }    
    public Direction getMove(){
        count++;
        move = Direction.values()[rand.nextInt(5)];
        return move;
    }    
    public String toString() {
        return "L";
    }
}