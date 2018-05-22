import java.util.Scanner;

/**
 * CS312 Assignment 4.
 *
 * On my honor, <PENGDI XIA>, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 * A program to play Rock Paper Scissors
 *
 *  Name:Pengdi Xia
 *  email address:xiapengdi@yahoo.com
 *  UTEID:px353
 *  Section 5 digit ID:51265
 *  Number of slip days used on this assignment:0
 */

public class RockPaperScissors {

    /* A program to allow a human player to play rock - paper - scissors
     * against the computer. If args.length != 0 then we assume
     * the first element of args can be converted to an int
     */
    public static void main(String[] args) {
        // CS312 Students. Do not change the following line.
        RandomPlayer computerPlayer = buildRandomPlayer(args);
        
        // CS312 students do no change the following line. Do not create any other Scanners.
        Scanner keyboard = new Scanner(System.in);
        String namev= name(keyboard);
        int rounds = rounds(keyboard);
        int comp= 0;//# of computer wins
        int player= 0;//# of player wins
        int draw= 0;//# of draw
        loop(keyboard, namev, rounds,computerPlayer,comp,player,draw);
        keyboard.close();
        
    }
    public static String name(Scanner keyboard){
        System.out.println("Welcome to ROCK PAPER SCISSORS. I, Computer, will be your opponent.");
        System.out.print("Please type in your name and press return: ");
        String namev= keyboard.nextLine();
        System.out.println();
        System.out.println("Welcome " + namev + ".\n");
        System.out.println("All right " + namev + ". How many rounds would you like to play?");
        return namev;
    }
    public static int rounds(Scanner keyboard){   
        System.out.print("Enter the number of rounds you want to play and press return: ");
        int rounds = keyboard.nextInt();
        System.out.println();
        return rounds;
    }
    public static void loop(Scanner keyboard, String name, int rounds, RandomPlayer computerPlayer,int comp,int player,int draw){
        for(int i=1; i <= rounds; i++){
            System.out.println("Round "+ i+ ".");
            System.out.println(name+ ", please enter your choice for this round.");
            System.out.print("1 for ROCK, 2 for PAPER, and 3 for SCISSORS: ");
            int choice = keyboard.nextInt();
            int computerchoice = computerPlayer.getComputerChoice();
            String cpicked = choicename(computerchoice);
            String picked= choicename(choice);
            System.out.println("Computer picked "+ cpicked +", "+name+" picked "+ picked+".\n");              
            if ( choice == computerchoice){
                System.out.println("We picked the same thing! This round is a draw.");
                draw++;
            }
            else {
                if( computerchoice==1){
                    if (choice==2){
                        System.out.println("PAPER covers ROCK. You win.");
                        player++;
                    }
                    else{
                        System.out.println("ROCK breaks SCISSORS. I win.");
                        comp++;
                    }
                }
                else if (computerchoice==2){
                    if(choice==1){
                        System.out.println("PAPER covers ROCK. I win.");
                        comp++;
                    }
                    else{
                        System.out.println("SCISSORS cut PAPER. You win.");
                        player++;
                    }
                }
                else if (computerchoice==3){
                    if (choice==1){
                        System.out.println("ROCK breaks SCISSORS. You win.");
                        player++;
                    }
                    else{
                        System.out.println("SCISSORS cut PAPER. I win.");
                        comp++;
                    }
                }
            }
            System.out.println();
        } 
        summary(comp,player,draw,rounds,name);
    }
    public static String choicename(int numberchosen){
        String choicename= " ";
        if (numberchosen ==1){
         choicename = "ROCK";
        }
        if(numberchosen ==2){
         choicename = "PAPER";
        }
        if(numberchosen ==3){
         choicename = "SCISSORS";
        }
        return choicename;
       }
    public static void summary(int comp, int player, int draw, int rounds, String name){            
        System.out.println("Number of games of ROCK PAPER SCISSORS: "+ rounds);
        System.out.println("Number of times Computer won: "+ comp);
        System.out.println("Number of times "+name+" won: "+ player);    
        System.out.println("Number of draws: "+ draw);    
        if( comp>player){
            System.out.print("I, Computer, am a master at ROCK, PAPER, SCISSORS.");
        }
        else if(comp<player){
            System.out.print("You,"+name+" , are a master at ROCK, PAPER, SCISSORS.");
        }
        else{
            System.out.print("We are evenly matched.");
        }
    }            
    //public static void winner(){
       // if( choice = 1 && computerchoice=1){
         //   System.out.print
        //}
    /*
     * Build the random player. If args is length 0 then the
     * default RandomPlayer is built that follows a predictable
     * sequence. If args.length > 0 then we assume we can
     * convert the first element to an int and build the
     * RandomPlayer with that initial value.
     */
    public static RandomPlayer buildRandomPlayer(String[] args) {
        if(args.length == 0) {
            return new RandomPlayer();
        } else {
            int seed = Integer.parseInt(args[0]);
            return new RandomPlayer(seed);
        }
    }
}
