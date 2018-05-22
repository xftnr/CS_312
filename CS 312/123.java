import java.util.Scanner;

/**
 * CS312 Assignment 4.
 *
 * On my honor, <Peijie Yang>, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 * A program to play Rock Paper Scissors
 *
 *  Name: Peijie Yang
 *  email address: loarek1996@hotmail.com
 *  UTEID: py2554
 *  Section 5 digit ID: 51260
 *  Number of slip days used on this assignment:0
 */

public class RockPaperScissors {
    
    /* A program to allow a human player to play rock - paper - scissors
     * against the computer. If args.length != 0 then we assume
     * the first element of args can be converted to an int
     */
  public static void main (String[] args){
		     // CS312 Students. Do not change the following line.      
      RandomPlayer computerPlayer = buildRandomPlayer(args);
      
      // CS312 students do no change the following line. Do not create any other Scanners.
      Scanner keyboard = new Scanner(System.in);
      String Name = getUsersName(keyboard);
      int round = NumberOfRounds(keyboard, Name);
      playRounds(keyboard,computerPlayer, Name, round);

      keyboard.close();
  }

  public static String getUsersName(Scanner keyboard)
  {
     System.out.println("Welcome to ROCK PAPER SCISSORS. I, Computer, will be your opponent.");
     System.out.print("Please type in your name and press return: ");
     String usersName = keyboard.nextLine();
     System.out.println();
     return usersName;
  }    
  
  public static int NumberOfRounds(Scanner keyboard, String Name)
  {
      System.out.println("Welcome " + Name + ".");
      System.out.println();
      System.out.println("All right " + Name + ". How many rounds would you like to play?");
      System.out.print("Enter the number of rounds you want to play and press return: ");
      int roundsNum = keyboard.nextInt();
      System.out.println();
      return roundsNum;
  } 
  
  public static void playRounds(Scanner keyboard,RandomPlayer computerPlayer, String Name, int round)
  {   
      int userWins = 0;
      int computerWins = 0;
      int draws = 0;
      String userWordPick;
      String compWordPick;
      for(int i = 1; i <= round ; i++)
      {
          System.out.println("Round " + i + ".");
          System.out.println(Name + ", please enter your choice for this round.");
          System.out.print("1 for ROCK, 2 for PAPER, and 3 for SCISSORS: ");
          
          int userChoice = keyboard.nextInt();
          int computerChoice = computerPlayer.getComputerChoice();
          
          userWordPick = getWordChoice(userChoice);
          compWordPick = getWordChoice(computerChoice);
          System.out.println("Computer picked " + compWordPick + ", " +Name + " picked " + userWordPick + ".");
          System.out.println();
          if( userChoice== computerChoice)
          {
              System.out.println("We picked the same thing! This round is a draw.");
              draws++;
          }
          else if(userChoice == 1)
          {
              if(computerChoice == 2)
              {
                  System.out.println("PAPER covers ROCK. I win.");
                  computerWins++;
              }    
              else
              {
                  System.out.println("ROCK breaks SCISSORS. You win.");
                  userWins++;
              }    
          } 
          else if(userChoice == 2)
          {
              if(computerChoice == 1)
              {
                  System.out.println("PAPER covers ROCK. You win.");
                  userWins++;
              }    
              else
              {
                  System.out.println("SCISSORS cut PAPER. I win.");
                  computerWins++;
              }    
          } 
          else if(userChoice == 3)
          {
              if(computerChoice == 1)
              {
                  System.out.println("ROCK breaks SCISSORS. I win.");
                  computerWins++;
              }    
              else
              {
                  System.out.println("SCISSORS cut PAPER. You win.");
                  userWins++;
              }    
          } 
          System.out.println();  
     }
     System.out.println();
     Result(computerWins, userWins, draws, Name);
  }      
  
  public static String getWordChoice (int numberchoice) 
  {
      String wordChoice = "";
      if (numberchoice == 1 ) {
          wordChoice = "ROCK";
        }
      else if (numberchoice == 2) {
          wordChoice = "PAPER";
        }
      else {
          wordChoice = "SCISSORS";
        }
      return wordChoice;
    }
    
  public static void Result(int computerWins, int userWins, int draws, String Name)
  {
      System.out.println("Number of games of ROCK PAPER SCISSORS: " + (computerWins + userWins + draws));
      System.out.println("Number of times Computer won: " + computerWins);
      System.out.println("Number of times " + Name + " won: " + userWins);
      System.out.println("Number of draws: " + draws );
      
      if(computerWins == userWins)
      {
          System.out.println("We are evenly matched.");
      }    
      else if(computerWins > userWins)
      {
          System.out.println("I, Computer, am a master at ROCK, PAPER, SCISSORS.");
      }    
      else
      {
          System.out.println("You, " + Name + ", are a master at ROCK, PAPER, SCISSORS.");
      }    
  } 
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
