import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * CS312 Assignment 7.
 * 
 * On my honor, <PENGDI XIA>, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 * A program to play determine the extend of home field advantage in sports.
 *
 *  email address:xiapengdi@yahoo.com
 *  UTEID:px353
 *  Section 5 digit ID:51265
 *  Number of slip days used on this assignment:0
 */
public class HomeField {

    // Ask the user for the name of a data file and process
    // it until they want to quit.
    public static void main(String[] args) throws IOException {
        System.out.println("A program to analyze home field advantage in sports.");
        System.out.println();
        // CS312 students. Do not create any other Scanners connected to System.in.
        // Pass keyboard as a parameter to all the methods that need it. 
        Scanner keyboard = new Scanner(System.in);
        // CS312 students - Add your code here
        String choose = "y";
        while(choose.equalsIgnoreCase("Y")){
            String file = inputfile( keyboard);
            Scanner input = new Scanner(new File(file));
            System.out.println();
            data(file, input);
            System.out.println();
            System.out.println("Do you want to check another data set?");
            System.out.print("Enter Y or y for to analyze another file, anything else to quit: ");
            choose = keyboard.nextLine();
            System.out.println();
        }
        keyboard.close();
    }
    // CS312 Students - Add your methods here.
    public static String inputfile( Scanner keyboard){
        System.out.print("Enter the file name: ");
        String filename = keyboard.nextLine();
        while ( !filename (filename)){
            System.out.println("Sorry, that file does not exist");
            System.out.print("Enter the file name: ");
            filename = keyboard.nextLine();
        }
        return filename;
    }
    public static boolean filename( String filename){
        File file = new File( filename);
        return file.exists();
    }
    public static void data ( String file, Scanner input){
        star();
        space();
        String title = input.nextLine();
        String year = input.nextLine();
        System.out.print( title + " --- " + year);
        space();
        star();
        System.out.println("\n");
        System.out.println("HOME FIELD ADVANTAGE RESULTS");
        System.out.println();
        int numofgames = 0;
        int homegame =0;
        int homewin = 0;
        int hometeampoint = 0;
        int awayteampoint = 0;
        int teamA = 0;
        int teamB = 0;
        while( input.hasNextLine()){
            numofgames++;
            String line = input.nextLine();
            if ( line.contains("@")){
                Scanner lineScan = new Scanner(line);
                homegame++;
                String date = lineScan.next();
                String TeamA =lineScan.next();
                while (!lineScan.hasNextInt()){
                    TeamA += " " + lineScan.next();
                }
                teamA = lineScan.nextInt();
                String TeamB =lineScan.next();
                while (!lineScan.hasNextInt()){
                    TeamB += " " + lineScan.next();
                }
                teamB = lineScan.nextInt();
                if (teamA >teamB && TeamA.contains("@")){
                   homewin++;
                }
                if (teamB >teamA && TeamB.contains("@")){
                   homewin++;
                }
                if (TeamA.contains("@")){
                    hometeampoint += teamA;
                    awayteampoint += teamB;
                }
                if (TeamB.contains("@")){
                    hometeampoint += teamB;
                    awayteampoint += teamA;
                }
            }            
        }
        double perhome = 100.0*homegame/numofgames;
        double perhomewin = 100.0*homewin/homegame;
        double margin = 1.00*(hometeampoint - awayteampoint)/homegame;
        System.out.printf("Total number of games: %,d\n" , numofgames);
        System.out.printf("Number of games with a home team: %,d\n" , homegame);
        System.out.printf("Percentage of games with a home team: %.1f%%\n" , perhome);
        System.out.printf("Number of games the home team won: %,d\n" , homewin);
        System.out.printf("Home team win percentage: %.1f%%\n" , perhomewin);
        System.out.printf("Home team average margin: %.2f\n" , margin);
    }
    public static void star(){
        for( int i = 0; i <10; i ++){
            System.out.print("*");
        }
    }
    public static void space(){
        for (int i = 0; i < 3; i ++){
            System.out.print(" ");
        }
    }
}

