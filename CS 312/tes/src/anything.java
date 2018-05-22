import java.util.Scanner;

/**
 * CS312 Assignment 10.
 *
 * On my honor, <Peijie Yang>, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 *  email address: loarek1996@hotmail.com
 *  UTEID:py2554
 *  Section 5 digit ID:51260
 *  Number of slip days used on this assignment:0
 *
 * Program that allows two people to play Connect Four.
 */
public class anything {
    // CS312 Students, add you constants here
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        intro();
        System.out.print("Player 1 enter your name: ");
        String name1 = key.next();
        System.out.println();
        System.out.print("Player 2 enter your name: ");
        String name2 = key.next();
        System.out.println();
        char[][] board = new char[6][7];
        System.out.println("Current Board");
        initialboard(board);
        showboard(board);
        showgame(name1,name2,key,board);
        // complete this method
        // Recall make and use one Scanner coonected to System.in
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
    // CS312 Students, add your methods
    public static void initialboard(char[][]board){
        for (int i= 0; i < 6; i++) {
            for (int j= 0; j< 7; j++) {
                board[i][j] = '.';
            }
        }
    }
    //the whole process
    public static void showgame(String name1,String name2,Scanner key,char[][]board){
        while(winConditions(board,'r') == false && winConditions(board,'b') == false){
            gameprocess(board,name1,'r',key);
            gameprocess(board,name2,'b',key);
        }
        if(draw(board)==false){
            winner(name1,name2,board);
        }
        if(draw(board)==true){
            System.out.println("The game is a draw.");
            System.out.println();
            System.out.println("Final Board");
            showboard(board);
        }
    }
    //gameprocess
    public static void gameprocess(char [][]board, String name, char piece,Scanner key){
        String prompt = name + ", enter the column to drop your checker: ";
        if(winConditions(board,'r') == false && winConditions(board,'b') == false){
            System.out.println(name + " it is your turn.");
            System.out.println("Your pieces are the "+ piece+"'s.");
            System.out.print(prompt);
            int column1 = number(key,name,prompt,board,piece);
            System.out.println();
            if(winConditions(board,piece) == false){
                System.out.println("Current Board");
                showboard(board);
            }
            }
    }
    //find out winner 
    public static void winner(String name1, String name2,char[][]board){
        if(winConditions(board,'r') == true){
            System.out.println(name1 + " wins!!");
        }
        else if(winConditions(board,'b') == true){
            System.out.println(name2 + " wins!!");
        }
        System.out.println();
        System.out.println("Final Board");
        showboard(board);
    }
    //find out draw condition
    public static boolean draw(char [][]board){
        int result = 0;
        for (int i = 0; i< 6; i++) {
            for (int j = 0; j<7;j++){
                if(board[i][j]!='.'){
                    result++;
                }
            }
        }
        if(result==42){
            return true;
        }
        return false;
    }
    //change the column
    public static boolean column(int column1,char[][]board,char piece){
        int i = 5;
        while(board[i][column1-1]!= '.'){
            i--;
            if(i<0) {
                return false;
            }
        }
        board[i][column1-1] = piece;
        return true;
    }
    //display board
    public static void showboard(char[][]board){
        for (int i = 1; i <= 7; i++) {
            System.out.print(i + " ");
        }
        System.out.print(" column numbers");
        System.out.println();
        for (int i = 0; i< 6; i++) {
            for (int j = 0; j< 7; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    //winning conditions
    public static boolean winConditions(char[][]board,char piece){
        for(int i = 5; i>=0; i--) {
            for(int j = 0; j <7;j++) {
                if(i>=3 && j>=4 && board[i][j]== piece&& board[i-1][j-1]== piece && board[i-2][j-2]==piece && board[i-3][j-3]==piece) {
                    return true;
                }
                if(i>=3 && j<4 &&board[i][j]== piece && board[i-1][j+1]== piece && board[i-2][j+2]==piece && board[i-3][j+3]==piece){
                    return true;
                }
                if(j<4 && board[i][j]== piece&& board[i][j+1]== piece && board[i][j+2]==piece && board[i][j+3]==piece) {
                    return true;
                }
                if(i>=3 && board[i][j]== piece && board[i-1][j]== piece && board[i-2][j]==piece && board[i-3][j]==piece) {
                    return true;
                }
            }
        }
        if(draw(board)== true){
            return true;
        }
        return false;
    }
    // prompt the user for an int. The String prompt will
    // be printed out. I expect key is connected to System.in.
    public static int getInt(Scanner key,String prompt) {
        while(!key.hasNextInt()) {
            String notAnInt = key.next();
            System.out.println();
            System.out.println(notAnInt + " is not an integer.");
            System.out.print(prompt); 
        }
        int result = key.nextInt();
        key.nextLine();
        return result;
    }
    // check out of bound 
    public static int number1(Scanner key,String prompt){
        int result = getInt(key,prompt);
        while(result < 1 || result >7) {
            System.out.println();
            System.out.println(result + " is not a valid column.");
            System.out.print(prompt);
            result = getInt(key,prompt);
        }
        return result;
    }
    //check full and provide number
     public static int number(Scanner key, String name,String prompt,char[][]board,char piece){
        int result = number1(key,prompt);
        while(column(result,board,piece) ==false){
            System.out.println();
            System.out.println(result + " is not a legal column. That column is full");
            System.out.print(prompt);
            result = number1(key,prompt);
        }
        return result;
    }
}