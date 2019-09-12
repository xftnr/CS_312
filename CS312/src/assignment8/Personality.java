/**
 * CS312 Assignment 8.
 * 
 * On my honor, <PENGDI XIA>, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 * A program to read a file with raw data from a Keirsey personality test
 * and print out the results.
 *
 *  email address:xiapengdi@yahoo.com
 *  UTEID:px353
 *  Section 5 digit ID:51265
 *  Number of slip days used on this assignment:0
 */
package assignment8;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Personality { 
    // CS312 Student: Add your constants here.
    // The main method to process the data from the personality tests
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in); // do not make any other Scanners connected to System.in
        Scanner fileScanner = getFileScanner(keyboard);
        // CS312 students - your code and methods calls go here
        String records = fileScanner.nextLine();
        while (fileScanner.hasNextLine()){
            String name = fileScanner.nextLine();
            name(name);
            String data = fileScanner.nextLine();
            int[] EI = new int[2];
            int[] SN = new int[2];
            int[] TF = new int[2];
            int[] JP = new int[2];
            data( data,EI,SN,TF,JP);   
            result(EI,SN,TF,JP);
            System.out.println();
        }
        fileScanner.close();
        keyboard.close();
    }
    // CS312 Students add you methods here
    public static void name( String name){
        if (name.length() <= 29){
            System.out.printf("%28s:",name);
        }
        else{
            System.out.print(name+":");
        }
    }
    public static void data( String data, int[] EI, int[] SN, int[] TF, int[] JP){
        char[] letters = data.toCharArray();
        for(int i= 0; i < (data.length()/7); i++){
            int count = 0;
            if (letters[i*7]== 'A'){
                EI[0] +=1; 
            }
            else if (letters[i*7]=='B'){
                EI[1] +=1;
            }
        }
        data2(SN,1,letters,data);
        data2(TF,3,letters,data);
        data2(JP,5,letters,data);
    }
    public static void data2 ( int[] name, int number, char[] letters, String data){
        for(int i= 0; i < (data.length()/7); i++){
            if (letters[i*7+number]=='A'){
                name[0] +=1; 
            }
            else if (letters[i*7+number]=='B'){
                name[1] +=1;
            }
            if (letters[i*7+number+1]=='A'){
                name[0] +=1; 
            }
            else if (letters[i*7+number+1]=='B'){
                name[1] +=1;
            }
        }
    }
    public static void result ( int[] EI, int[] SN, int[] TF, int[] JP){
        char ei = analysis(EI,"EI");
        char sn = analysis(SN,"SN");
        char tf = analysis(TF,"TF");
        char jp = analysis(JP,"JP");
        System.out.print(" = "+ ei + sn + tf + jp);
    }
    public static char analysis(int[] name,String character){
        char situation = 'f';
        int percent = 0;
        if ( name[0] == 0 && name[1]==0 ){
            System.out.print(" NO ANSWERS");
        }
        else{
            double percentage = 100.0*name[1]/(name[1]+name[0]);
            percent = (int)Math.round(percentage);
            System.out.printf(" %10d" ,percent);
        }
        if ( name[0] == 0 && name[1]==0 ){
            return situation = '-';
        }
        else if (percent >50){
            return situation = character.charAt(1);
        }
        else if (percent ==50){
            return situation = 'X';
        }
        else{
            return situation = character.charAt(0);
        }
    }
    // Method to choose a file.
    // Asks user for name of file. 
    // If file not found create a Scanner hooked up to a dummy set of data
    // Example use: 
    public static Scanner getFileScanner(Scanner keyboard){
        Scanner result = null;
        try {
            System.out.print("Enter the name of the file with the personality data: ");
            String fileName = keyboard.nextLine().trim();
            System.out.println();
            result = new Scanner(new File(fileName));
        }
        catch(FileNotFoundException e) {
            System.out.println("Problem creating Scanner: " + e);
            System.out.println("Creating Scanner hooked up to default data " + e);
            String defaultData = "1\nDEFAULT DATA\n"
                + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
            result = new Scanner(defaultData);
        }
        return result;
    }
}
