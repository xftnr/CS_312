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
public class Vulture extends Bird{
    private Direction premove = null;
    private int count = 0;
    private boolean hungry = true;
    public Vulture(){
    }
    public boolean eat(){
        if (hungry){
            hungry = false;
            return true;
        }
        else{
            return false;
        }
    }
    public Attack fight(String opponent) {
        hungry = true;
        if (opponent == "%"){
            return Attack.ROAR;
        }
        else{
            return Attack.POUNCE;
        }
    }
    public Color getColor() {
        return Color.BLACK;
    }
}