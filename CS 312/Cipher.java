import java.util.Scanner;

/**
 * CS312 Assignment 5.
 *
 * On my honor, <PENGDI XIA>, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 * A program to encrypt and decrypt messages using a columnar transposition cipher.
 *
 *  email address:xiapengdi@yahoo.com
 *  UTEID:px353
 *  Unique 5 digit course ID:51265
 *  Number of slip days used on this assignment:0
 */

public class Cipher {
    // CS312 Students: This constant must be set to 10 in the
    // final version of your program that you turn in.
    public static final int MAX_ROWS = 10;
    // main method to demonstrate various encryptions and
    // decryptions using a columnar transposition cipher
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        showIntro();
        // CS312 students, add your code here.
        String word = nopadding(keyboard); 
        encrypt( word, MAX_ROWS);
        encryptpadding( word, MAX_ROWS);
        decrypted(keyboard,MAX_ROWS);
        keyboard.close();
    }
    public static String nopadding(Scanner keyboard){
        System.out.println();
        System.out.println();
        System.out.println("A demonstration of encrypting with a columnar transposition cipher:\n");
        System.out.print("Enter the message to encrypt: ");
        String word = keyboard.nextLine();
        System.out.println();
        System.out.println("Message encrypted with columnar transposition cipher and no padding.");
        return word;
    }
    public static void encrypt(String word, int n){
        for(int k=2; k<=n; k++){
            System.out.print("Encrypted with "+k+ " rows: ");
            for (int i= 0; i < k; i ++){
                for (int j = 0; i +j *k< word.length(); j++){
                    System.out.print(word.charAt(i+j*k));
                }
            }
            System.out.print("\n");
        }
        System.out.println();
    }
    public static void encryptpadding(String word, int n){
        System.out.println("Message encrypted with columnar transposition cipher and padding.\n");
        for (int k=2;k<= n; k++){
            System.out.print("Clear text padded for "+k+" rows: "+ word);
            String padding = word;
            while(padding.length()%k !=0){
                padding +="X";
                System.out.print("X");
            }
            System.out.print("\n");
            System.out.print("Encrypted with "+k+ " rows: ");
            for (int i= 0; i < k; i ++){
                for (int j = 0; i +j *k< padding.length(); j++){
                    System.out.print(padding.charAt(i+j*k));
                }
            }
            System.out.println("\n");
        }
    }
    public static void decrypted(Scanner keyboard, int n){
        System.out.println();
        System.out.println("A demonstration of decrypting with a columnar transposition cipher:");
        System.out.println("If the length of the message is not a multiple of the number of rows");
        System.out.println("it will be padded which may throw off the decryption.\n");
        System.out.print("Enter the message to decrypt: ");
        String dewords = keyboard.nextLine();
        System.out.println();
        System.out.println("Messages Decrypted with a Columnar Transposition Cipher\n");
        for (int k=2;k<= n; k++){
            System.out.print("Decrypted text padded for "+k+" rows: "+ dewords);
            String depadding = dewords;
            while(depadding.length()%k !=0){
                depadding +="X";
                System.out.print("X");
            }
            System.out.print("\n");
            System.out.print("Decrypted with "+k+ " rows: ");
            int g = depadding.length()/k;
            for (int i= 0; i <g; i++){
                for (int j = 0; i+j *g< depadding.length(); j++){
                    System.out.print( depadding.charAt(i +j*g));
                }
            }
            System.out.println("\n");
        }
    }     
    // show the introduction to the program
    public static void showIntro() {
        System.out.println("This program demonstrates a transposition cipher.");
        System.out.println("A cipher is an algorithm to encrypt or decrypt a message.");
        System.out.println();
        System.out.println("This program will demonstrate encrypting a message with");
        System.out.println("a columnar transposition cipher both with and without");
        System.out.println("padding characters. The program will then decrypt a message");
        System.out.println("assuming it was encrypted with a columnar transposition cipher");
        System.out.println("with padding.");
        System.out.println("After accepting user input, the program displays some tests.");
    }
}