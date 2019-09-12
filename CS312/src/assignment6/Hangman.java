/**
 * CS312 Assignment 6.
 *
 * On my honor, <PENGDI XIA>, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 * A program to play Hangman.
 *
 *  email address:xiapengdi@yahoo.com
 *  UTEID:px353
 *  Unique 5 digit course ID:51265
 *  Number of slip days used on this assignment:0
 */
package assignment6;
import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) {
        intro();
        PhraseBank phrases = buildPhraseBank(args);
        // CS312 Students -- Do not create any additional Scanners.
        Scanner keyboard = new Scanner(System.in);
        // CS12 students: add your code here
        int n = 1995;
        String topic = phrases.getTopic();
        while( n != 0){
             String star = "";
             String phrase = phrases.getNextPhrase();
             phrase = phrase.toUpperCase();
             star = secretphrase ( phrase,star,topic );
             n = gameplay(phrase, keyboard, star,n);
        }
        keyboard.close();
   }
    // CS12 students: add your methods here.
        public static String secretphrase ( String phrase, String star, String topic){
        System.out.println();
        System.out.println("I am thinking of a "+ topic+ " ...\n");
        String space = "_";
        for (int i=0; i < phrase.length(); i ++){
            if (phrase.charAt(i) == (space.charAt(0))){
                star += "_";
            }
            else{
                star += "*";
            }
        }
        return star;
   }
    public static int gameplay (String phrase, Scanner keyboard, String star,int n){
        String alphabet = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z ";
        int chance = 5;
        star = guess( star, alphabet,chance, keyboard,phrase);
        System.out.println("Do you want to play again?");
        System.out.print("Enter 'Y' or 'y' to play again: ");
        String playagain = keyboard.next();
        if (playagain.equals("y")||playagain.equals("Y")){
            n = 1;
        }
        else{
            n = 0;
        }
        return n;
   }
   public static String guess ( String star, String alphabet, int chance, Scanner keyboard, String phrase){
        tricky (star,alphabet);
            while( chance > 0 && star.contains("*")){
            System.out.print("Enter your next guess: ");
            String select = keyboard.next();
            System.out.println();
            select = select.toUpperCase();
            if ( !alphabet.contains(select) || select.equals(" ")){
                alphabet = updated(alphabet, select);
                System.out.println( select+ " is not a valid guess.");
                System.out.println("The letters you have not guessed yet are: ");
                System.out.println(alphabet);
            }
            else if( phrase.contains(select)){
                alphabet = updated(alphabet, select);
                System.out.println("You guessed "+ select+ ".\n");
                System.out.println("That is present in the secret phrase.\n");
                for(int i = 0; i < phrase.length(); i++){
                    if( select.charAt(0) == phrase.charAt(i)){
                        star = star.substring(0,i)+phrase.charAt(i)+star.substring(i+1);
                    }
                }
                System.out.println("Number of wrong guesses so far: "+ (5 - chance));
                if ( !star.contains("*")){
                    System.out.println("The phrase is "+ phrase + ".");
                    System.out.println("You win!!");
                }
                else{
                    tricky (star,alphabet);
                }
            }
            else{
                alphabet = updated(alphabet, select);
                System.out.println("You guessed "+ select+ ".\n");
                System.out.println("That is not present in the secret phrase.\n"); 
                chance--;
                System.out.println("Number of wrong guesses so far: "+ (5 - chance));
                if ( star.contains("*") && chance > 0){
                    tricky (star,alphabet);
                }
                else{
                    System.out.println("You lose. The secret phrase was "+ phrase);
                }
            }
        }
        return star;
   }
   public static void tricky (String star, String alphabet){
       System.out.println("The current phrase is "+ star);
       System.out.println();
       System.out.println("The letters you have not guessed yet are: ");
       System.out.println(alphabet);
       System.out.println();
   }
   public static String updated ( String old, String todelete){
        String updated = "";
        for (int i = 1; i <= (old.length()/2); i ++){
            if( todelete.charAt(0) != old.charAt(2*i-2)){
                updated += old.charAt(2*i-2 )+ " ";
            }
        }
        return updated;
    }
    public static String select(String old, String todelete){
        String updated ="";
        for (int i = 0; i< old.length(); i++){
            if (todelete.charAt(i) != old.charAt(i)){
                updated += old.charAt(i);
            }
        }
        return updated;
    }
    // Build the PhraseBank.
    // If args is empty or null, build the default phrase bank.
    // If args is not null and has a length greater than 0
    // then the first elements is assumed to be the name of the
    // file to build the PhraseBank from.
    public static PhraseBank buildPhraseBank(String[] args) {
        PhraseBank result;
        if(args == null || args.length == 0
                || args[0] == null || args[0].length() == 0)
            result =  new PhraseBank();
        else
            result = new PhraseBank(args[0]);
        return result;
    }
    // show the intro to the program
    public static void intro() {
        System.out.println("This program plays the game of hangman.");
        System.out.println();
        System.out.println("The computer will pick a random phrase.");
        System.out.println("Enter letters for your guess.");
        System.out.println("After 5 wrong guesses you lose.");
    }
}
