package assignment2;
/*
 *  CS312 Assignment 2.
 *  On my honor, <PENGDI XIA>, this programming assignment is my own work.
 *
 *  A program to print out the UT Tower in ASCII art form.
 *
 *  Name:Pengdi Xia
 *  email address:xiapengdi@yahoo.com
 *  UTEID:px353
 *  Section 5 digit ID:51265
 *  Number of slip days used on this assignment:0
 */

public class Tower {
    
    // CS312 students, DO NOT ALTER THE FOLLOWING LINE except for the literal int.
    // You may change the literal int assigned to SIZE to any value from 2 to 100.
    // In the final version of the program you submit set the SIZE to 3.
    public static final int SIZE = 3;
    public static void main(String[] args) {
        top();
        topcolumn();
        top();
        body();
        bottomlean();
        bottom();
    }
    // #######
    public static void top() 
    {    
        for (int space = 1; space <= (4 * SIZE + 2); space++){
                System.out.print(" ");
            }
        for (int top=1; top <= (2 * SIZE - 1); top++){
                System.out.print("*");
            }
        System.out.println();
    }
    // |||||||
    public static void topcolumn() {
        for (int line = 1; line <= SIZE * 2 - 2; line++){    
            for (int space = 1; space <= (4 * SIZE + 2); space++){
                System.out.print(" ");
            }
            for (int top=1; top <= (2 * SIZE - 1); top++){
                System.out.print("|");
            }
            System.out.println();
        }
    }
    // ~~~~~~~~~
    // |-O-O-O-|
    public static void body() {
        for (int line = 1; line <= SIZE * SIZE; line++){    
            floor();
            System.out.println();
            window();
        }
        floor();
        System.out.println();
    }
    // ~~~~~~~~
    public static void floor(){
        for (int space = 1; space <= (4 * SIZE); space++){
                System.out.print(" ");
            }
        for (int wave=1; wave <= (2 * SIZE + 3); wave++){
                System.out.print("~");
            }
    }
    // |-O-O-O-|
    public static void window() {
        for (int space = 1; space <= (4 * SIZE); space++){
                System.out.print(" ");
            }
        System.out.print("|");
        for (int window=1; window <= (SIZE); window++){
                System.out.print("-O");
            }
        System.out.print("-|");
        System.out.println();
    }
    // /"'"'"'"'"'"'"'"'\
    public static void bottomlean() {
        for (int line =1; line <= (SIZE / 2 + 1); line++){
            for (int space = 1; space <= ((SIZE / 2 - line + 1) * 3); space++){
                System.out.print(" ");
            }
            System.out.print("/");
            for (int quotation=1; quotation <= (5 * SIZE - SIZE / 2 * 3 + (line - 1) * 3); quotation++){
                System.out.print("\"'");
            }
            System.out.print("\"\\");
            System.out.println();
            }
    }
    // /"O"O"O"O"O"O"O"O"O"O"O"O"O"O\
    public static void bottom() {
        for (int line = 1; line <= (SIZE); line++) {
            System.out.print("/");
            for (int row = 1; row <= (SIZE * 5); row++) {
                System.out.print("\"O");
            }
            System.out.print("\"\\");
            System.out.println();  
            }
    }
}