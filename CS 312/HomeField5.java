import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/**
 * CS312 Assignment 7.
 * 
 * On my honor, <Peijie Yang>, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 * A program to play determine the extend of home field advantage in sports.
 *
 *  email address: loarek1996@hotmail.com
 *  UTEID: py2554
 *  Section 5 digit ID: 51260
 *  Number of slip days used on this assignment: 0 
 */
public class HomeField5 {
    // Ask the user for the name of a data file and process
    // it until they want to quit.
    public static void main(String[] args) throws IOException{
        System.out.println("A program to analyze home field advantage in sports.");
        System.out.println();
        // CS312 students. Do not create any other Scanners connected to System.in.
        // Pass keyboard as a parameter to all the methods that need it. 
        Scanner keyboard = new Scanner(System.in);
        String filename = "";
        // CS312 students - Add your code here
        results(keyboard,filename);
        keyboard.close();
    }
    // CS312 Students - Add your methods here.
        public static String existence( Scanner keyboard,String filename) throws IOException {
        keyboard = new Scanner(System.in);
        System.out.print("Enter the file name: ");
        filename = keyboard.nextLine();
        File file = new File (filename);
        while (!file.exists()){
            System.out.println("Sorry, that file does not exist");
            System.out.print("Enter the file name: ");
            filename = keyboard.nextLine();
            file = new File (filename);
        }   
        System.out.println();
        keyboard.close();
        return filename;   
    }

    public static void results(Scanner keyboard,String filename)throws IOException {
        String good = existence(keyboard,filename);
        Scanner input = new Scanner (new File(good));
        String title = input.nextLine();
        String date = input.nextLine();
        System.out.println("**********   "+ title +" --- "+ date + "   **********");
        System.out.println("\nHOME FIELD ADVANTAGE RESULTS\n");
        totalnumber(input,keyboard,filename);
        input.close();
    }
    
    public static void totalnumber(Scanner input,Scanner keyboard,String filename)throws IOException{
        int total = 0;
        int hometeam = 0;
        int team1score = 0;
        int team2score = 0;
        int homewon = 0;
        int sum1 = 0;
        int difference = 0;
        int s=0;
        while (input.hasNextLine()){
            total++;
            String line = input.nextLine();
            if (line.contains("@")) {
                hometeam++;
                Scanner lineScan = new Scanner(line);
                while(!lineScan.hasNextInt()){
                    String date = lineScan.next();
                    if (date.contains("@")) {
                        homewon++;
                        s= 1;
                    }
                }
                team1score = lineScan.nextInt();
                while(!lineScan.hasNextInt()){
                   String date = lineScan.next();
                   if (date.contains("@")) {
                       s = 2;
                    }
                }
                team2score = lineScan.nextInt();
                if(s==1) {
                    difference= team1score-team2score;
                }
               
                else if(s==2){
                    difference = team2score-team1score;
                }
                sum1=sum1+difference;
            }

        }
        double percentage = (double)hometeam/(double)(total);
        double hometeamwin = (double) homewon/ (double) hometeam; 
        double margin = ((double)(sum1))/(hometeam);
        printout(total, hometeam, percentage, homewon, hometeamwin, margin);
        playagain(keyboard,filename);
    }

    public static void printout(int total, int hometeam, double percentage,int homewon,double hometeamwin, double margin ){
        System.out.printf("Total number of games: %,d\n" , total);   
        System.out.printf("Number of games with a home team: %,d\n", hometeam);
        System.out.printf("Percentage of games with a home team: %.1f%%\n", percentage*100);
        System.out.printf("Number of games the home team won: %,d\n", homewon);
        System.out.printf("Home team win percentage: %.1f%%\n", hometeamwin*100);
        System.out.printf("Home team average margin: %.2f\n", margin);
        System.out.println();
    }
    
     public static void playagain(Scanner keyboard,String filename)throws IOException{
        System.out.println("Do you want to check another data set?");
        System.out.print("Enter Y or y for to analyze another file, anything else to quit: ");
        String again = keyboard.next();
        System.out.println();
        if (again.toUpperCase().equals("Y")) {
            results(keyboard,filename);
        }
    }
    
}