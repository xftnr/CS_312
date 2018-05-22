import java.util.Scanner;
/**
 * CS312 Assignment 10.
 *
 * On my honor, <PENGDI XIA>, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 *  email address:xiapengdi@yahoo.com
 *  UTEID:px353
 *  Section 5 digit ID:51265
 *  Number of slip days used on this assignment:1
 *
 * Program that allows two people to play Connect Four.
 */
public class ConnectFour {
    // CS312 Students, add you constants here
    public static String[][] board = new String[6][7];
    final static int WIDTH = 7;
    final static int HEIGHT = 6;
    final static String turnone = "r ";
    final static String turntwo = "b ";
    final static String turn1 = "r";
    final static String turn2 = "b";
    public static int column;
    public static void main(String[] args) {
        intro();
        Scanner key = new Scanner(System.in);
        System.out.print("Player 1 enter your name: ");
        String player1 = key.nextLine();
        System.out.println();
        System.out.print("Player 2 enter your name: ");
        String player2 = key.nextLine();
        System.out.println();
        CreateBoard();
        System.out.println("Current Board");
        board();
        gameprocessing(key, player1, player2);
        // complete this method
        // Recall make and use one Scanner coonected to System.in
    }
    // CS312 Students, add your methods
    // gameprocessing
    public static void gameprocessing(Scanner key, String player1, String player2){
    	while(winnercondition(turnone) == false && winnercondition(turntwo)== false && draw()==false){
    		
    		if (winnercondition(turnone) == false && winnercondition(turntwo)== false && draw()==false){
    			column = input(key, player1,turnone,turn1);
    			if (winnercondition(turnone) == false && draw()==false){
    				System.out.println("Current Board");
    				board();
    			}
    		}
    		if (winnercondition(turnone) == false && winnercondition(turntwo)== false && draw()==false){
    			column = input(key, player2,turntwo,turn2);
    			if (winnercondition(turntwo) == false && draw()==false){
    				System.out.println("Current Board");
    				board();
    			}
    		}
    	}
    	if (draw()==false){
    		winner(player1, player2);
    	}
    	if (draw()==true){
    		System.out.println("The game is a draw.");
            System.out.println();
            System.out.println("Final Board");
            board();
    	}
    }
    //Creating the board
    public static void CreateBoard(){
        for(int i = 0; i<HEIGHT; i++){
            for(int j = 0; j<WIDTH; j++){
                board[i][j] = ". ";
            }
        }
    }
    // show the board
    public static void board(){
        System.out.println("1 2 3 4 5 6 7  column numbers");
        for(int i= 0; i<HEIGHT;i++){
            for (int j = 0; j <WIDTH; j ++){
                System.out.print(board[i][j]);
            }
             System.out.println();
        }
        System.out.println();
    }
    //input
    public static int input(Scanner key, String player,String turn, String turnnumber){
        System.out.println(player+ " it is your turn.\nYour pieces are the " + turnnumber +"'s.");
        String prompt = player + ", enter the column to drop your checker: ";
        int inputInt = 0;
        boolean condition = true;
        while(condition){
            System.out.print(prompt);
            inputInt = getInt(key, prompt);
            System.out.println();
            if (inputInt > 7 || inputInt <1){
                System.out.println(inputInt + " is not a valid column.");
            }
            else if (playturn(inputInt, turn) < 0){
            	System.out.println(inputInt + " is not a legal column. That column is full");
            }
            else{
            condition = false;
            }
        }
        return inputInt;
    }
    //check full and change
    public static int playturn(int inputInt, String turn){
    	int flag = 0;
        int j = HEIGHT - 1;
        while(flag == 0){
            if(board[j][inputInt - 1]==". "){
                board[j][inputInt - 1] = turn;
                flag ++;
            }
            if((j == 0) && (flag == 0)){
                return -1;
            }
            j--;
        }
        return j+1;
    } 
    // winning condition
    public static boolean winnercondition(String turn){
        for(int i = 0; i<HEIGHT; i++){
            for(int j = 0; j<WIDTH; j++){
                    //row
                    if (j<=3 && board[i][j+1] == turn && board[i][j+2] == turn && board[i][j+3] == turn && board[i][j] == turn){
                        return true;
                    }
                    //column
                    if (i>=3 && board[i-1][j] == turn && board[i-2][j] == turn && board[i-3][j] == turn && board[i][j] == turn){
                        return true;
                    }
                    //slop up
                    if (j<=3 && i>=3 && board[i-1][j+1] == turn && board[i-2][j+2] == turn && board[i-3][j+3] == turn && board[i][j] == turn){
                        return true;
                    }
                    //slop down
                    if (j<=3 && i<= 2 && board[i+1][j+1] == turn && board[i+2][j+2] == turn && board[i+3][j+3] == turn && board[i][j] == turn){
                    	return true;
                    }
            }
        }
        return false;
    }
    //winner 
    public static void winner(String player1, String player2){
        if(winnercondition(turnone) == true){
            System.out.println(player1 + " wins!!");
        }
        else if(winnercondition(turntwo) == true){
            System.out.println(player2 + " wins!!");
        }
        System.out.println();
        System.out.println("Final Board");
        board();
    }
    //draw
    public static boolean draw (){
    	int count = 0;
    	for (int i = 0; i< HEIGHT; i++) {
    		for (int j = 0; j<WIDTH;j++){
    			if(board[i][j]!=". "){
    				count++;
    			}
    		}
    	}
    	if(count== HEIGHT * WIDTH){
    		return true;
    	}
    	return false;
    }
    // show the intro
    public static void intro() {
        System.out.println("This program allows two people to play the");
        System.out.println("game of Connect four. Each player takes turns");
        System.out.println("dropping a checker in one of the open columns");
        System.out.println("on the board. The columns are numbered 1 to 7.");
        System.out.println("The first player to get four checkers in a row");
        System.out.println("horizontally, vertically, or diagonally wins");
        System.out.println("the game. If no player gets fours in a row and");
        System.out.println("and all spots are taken the game is a draw.");
        System.out.println("Player one's checkers will appear as r's and");
        System.out.println("player two's checkers will appear as b's.");
        System.out.println("Open spaces on the board will appear as .'s.\n");
    }
    // prompt the user for an int. The String prompt will
    // be printed out. I expect key is connected to System.in.
    public static int getInt(Scanner key, String prompt) {
        while(!key.hasNextInt()) {
            String notAnInt = key.nextLine();
            System.out.println();
            System.out.println(notAnInt + " is not an integer.");
            System.out.print(prompt);
        }
        int result = key.nextInt();
        key.nextLine();
        return result;
    }
}