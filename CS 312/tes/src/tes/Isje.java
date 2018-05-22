package connectfour;
import java.util.Scanner;

public class connectfour{
    
    final static int WIDTH = 7;
    final static int HEIGHT = 6;
    public static int input;
    public static int rowPos;
    public static int TOTAL;
    public static String[][] newboard = new String[HEIGHT][WIDTH];
    
    
    public static void main(String[] args){
    	while(true){
	    	TOTAL = 0;
	        Scanner s = new Scanner(System.in);
	        CreateBoard();
	        printBoard();
	        //tells player how to play
	        boolean winFlag;
	
	        while(true){
	            System.out.println("Player1: Enter 1-7 to choose what column you want");
	            input = s.nextInt();
	            while(input < 1 || input > 7){
	            	System.out.println("wrong entry, try again");
	            	input = s.nextInt();
	            }
	            rowPos = player1Turn();
	            while(rowPos == -1){
	                System.out.println("column is full, chose another");// column is full, chose another
	                input = s.nextInt();
	                while(input < 1 || input > 7){
	                	System.out.println("wrong entry, try again");
	                	input = s.nextInt();
	                }
	                rowPos = player1Turn();
	            }
	            winFlag = checkWin(input- 1, rowPos);
	            
	            if(winFlag == true){
	                System.out.println("--------------------------------------Player1 wins--------------------------------------");
	                System.out.println();
	                System.out.println();
	                break;
	            }
	            TOTAL ++;
	            if(TOTAL == WIDTH * HEIGHT){
	            	System.out.println("--------------------------------------No winners--------------------------------------");
	            	break;
	            }
	            	
	            System.out.println("Player2: Enter 1-7 to choose what column you want");
	            input = s.nextInt();
	            while(input < 1 || input > 7){
	            	System.out.println("wrong entry, try again");
	            	input = s.nextInt();
	            }
	            rowPos = player2Turn();
	            while(rowPos == -1){
	                System.out.println("column is full, chose another");// column is full, chose another
	                input = s.nextInt();
	                while(input < 1 || input > 7){
	                	System.out.println("wrong entry, try again");
	                	input = s.nextInt();
	                }
	                rowPos = player2Turn();
	            }
	            winFlag = checkWin(input- 1, rowPos);
	            
	            if(winFlag == true){
	                System.out.println("--------------------------------------Player2 wins------------------------------------");
	                System.out.println();
	                System.out.println();
	                break;
	            }
	            TOTAL ++;
	            if(TOTAL == WIDTH * HEIGHT){
	            	System.out.println("--------------------------------------No winners--------------------------------------");
	            	break;
	            }
	            
	        }
    	}
    }
    
    
    
    public static void CreateBoard(){
        for(int i = 0; i<HEIGHT; i++){
            for(int j = 0; j<WIDTH; j++){
                newboard[i][j] = ". ";
            }
        }
    }
    public static void printBoard(){
        System.out.println("Current Board\n1 2 3 4 5 6 7    column numbers");
        for(int i = 0; i<HEIGHT; i++){
            for(int j = 0; j<WIDTH; j++){
                System.out.print(newboard[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    public static int player1Turn(){
        Scanner s = new Scanner(System.in);
        int flag = 0;
        int j = HEIGHT - 1;
        while(flag == 0){
            if(newboard[j][input - 1]==". "){
                newboard[j][input - 1] = "r ";
                flag ++;
            }
            if((j == 0) && (flag == 0)){
                return -1;
            }
            j--;
        }
        return j+ 1;
    }
    public static int player2Turn(){
        Scanner s = new Scanner(System.in);
        int flag = 0;
        int j = HEIGHT - 1;
        while(flag == 0){
            if(newboard[j][input - 1]==". "){
                newboard[j][input - 1] = "b ";
                flag ++;
            }
            if(j == 0 && flag == 0){
                return -1;
            }
            j--;
        }
        return j + 1;
    }
    public static boolean checkWin(int col, int row){
        printBoard();
        int count = 1;
        int rowMoveR = WIDTH - 1 - col;;
        int colMoveD = HEIGHT - 1 - row;
        //checkrow;
        for(int i = 1; i < col+1 && i < 4; i++){
            if(newboard[row][col] == newboard[row][col-i]){
                count++;
                if(count == 4)
                    return true;
            }
            else
                break;
        }
        for(int i = 1; i < rowMoveR && i < 4; i++){
            if(newboard[row][col] == newboard[row][col+i]){
                count++;
                if(count == 4)
                    return true;
            }
            else
                break;
        }
        //check column;
        count = 1;
        for(int i = 1; i < colMoveD+1 && i < 4; i++){
            if(newboard[row][col] == newboard[row + i][col]){
                count++;
                if(count == 4)
                    return true;
            }
            else
                break;
        }
        //check"\"
        count = 1;
        for(int i = 1; (i < col+1 && i < row+1) && i < 4; i++){
            if(newboard[row][col] == newboard[row- i][col-i]){
                count++;
                if(count == 4)
                    return true;
            }
            else
                break;
        }
        for(int i = 1; (i < rowMoveR+1 && i < colMoveD+1) && i < 4; i++){
            if(newboard[row][col] == newboard[row + i][col+i]){
                count++;
                if(count == 4)
                    return true;
            }
            else
                break;
        }
        //check"/"
        count = 1;
        for(int i = 1; (i < col+1 && i < colMoveD+1) && i < 4; i++){
            if(newboard[row][col] == newboard[row+ i][col-i]){
                count++;
                if(count == 4)
                    return true;
            }
            else
                break;
        }
        for(int i = 1; (i < rowMoveR+1 && i < row+1) && i < 4; i++){
            if(newboard[row][col] == newboard[row - i][col+i]){
                count++;
                if(count == 4)
                    return true;
            }
            else
                break;
        }
        
        return false;
    }
}