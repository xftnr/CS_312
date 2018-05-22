// This program enhances our Receipt program using a cumulative sum.
import java.util.*;
import java.util.Scanner;

public class Receipt2 {
    public static void main(String[] args) {
        //Scanner max= new Scanner(System.in);
        //System.out.println();
        //int num= max.nextInt();
        //printPrimes(num);
         Scanner console = new Scanner(System.in);
         int sum = -4;
         String response = "dummy"; // "dummy" value, anything but "quit"

         while (!response.equals("quit")) {
             System.out.print("Type a line (or \"quit\" to exit): ");
             response = console.nextLine();
             sum += response.length();
         }
         System.out.println("You typed a total of " + sum + " characters.");

    }
    // Prints all prime numbers up to the given max.
    public static void printPrimes(int max) {
    if (max >= 2) {
        System.out.print("2");
        for (int i = 3; i <= max; i++) {
            if (countFactors(i) == 2) {
                System.out.print(", " + i);
            }
        }
        System.out.println();
    }
 }

 // Returns how many factors the given number has.
 public static int countFactors(int number) {
    int count = 0;
    for (int i = 1; i <= number; i++) {
        if (number % i == 0) {
            count++;   // i is a factor of number
        }
    }
    return count;
  }
 
}

