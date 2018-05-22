import java.util.Scanner;
/**
 * CS312 Assignment 9.
 *
 * On my honor, <PENGDI XIA>, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 *  email address:xiapengdi@yahoo.com
 *  UTEID:px353
 *  Section 5 digit ID:51265
 *  Number of slip days used on this assignment:0
 *  
 * Program to decrypt a message that has been
 * encrypted with a substitution cipher.
 * We assume only characters with ASCII codes
 * from 32 to 126 inclusive have been encrypted.
 */

public class Decrypt {
    // CS312 students, add your constants here
    public static void main(String[] arg) {
        // CS312 Students, do not create any other Scanners connected to System.in
        Scanner keyboard = new Scanner(System.in); 
        String fileName = getFileName(keyboard);
        String encryptedText = DecryptUtilities.convertFileToString(fileName);
        // The other method from DecryptUtilities you will have to use is
        // DecryptUtilities.getDecryptionKey(int[]), but first you need to
        // create an array with the frequency of all the ASCII characters in the 
        // encrypted text. Count ALL characters from ASCII code 0 to ASCII code 127
        // CS312 students, add you code here.
        int[] count = new int[128];
        char[] decrypt = new char[128];
        decrypt = read(encryptedText, count, decrypt);
        repeat (decrypt, keyboard, encryptedText);
        conclusion(decrypt, encryptedText);
        keyboard.close();
    }
    // CS312 students, add your methods here
    public static char[] read(String encryptedText, int[] count,char[] decrypt){
        System.out.println("The encrypted text is:");
        System.out.println(encryptedText);
        for (int i =0; i <encryptedText.length(); i ++){
            for (int j = 32; j < 127; j++){
                char ch = (char)j;
                if (encryptedText.charAt(i) == ch){
                    count[j]++;
                }
            }
        }
        decrypt = DecryptUtilities.getDecryptionKey(count);
        System.out.println("Frequencies of characters.");
        System.out.println("Character - Frequency");
        for (int k = 32 ; k < 127; k++){
            System.out.println((char)k+ " - " + count[k]);
        }
        System.out.println();
        key(decrypt);
        return decrypt;
    }
    public static void replace(char[] decrypt, String text){
        Scanner input = new Scanner(text);
        while(input.hasNextLine()){
            String output = "";
            String line = input.nextLine();
            for (int i =0; i <line.length(); i ++){
                for (int j = 32; j < 127; j++){
                    char ch = (char)j;
                    if (line.charAt(i) == ch){
                        output += decrypt[j];
                    }
                }
            }
            System.out.println(output);
        }
        System.out.println();
    }
    public static void repeat(char[] decrypt, Scanner keyboard, String encryptedText){
        System.out.println("The current version of the decrypted text is: \n");
        replace(decrypt,encryptedText);
        System.out.println("Do you want to make a change to the key?");
        System.out.print("Enter 'Y' or 'y' to make change: ");
        String answer = keyboard.nextLine();
        while(answer.equals("y")|| answer.equals("Y")){
            System.out.print("Enter the decrypt character you want to change: ");
            String change = keyboard.nextLine();
            System.out.print("Enter what the character "+ change + " should decrypt to instead: ");
            String changeto = keyboard.nextLine();
            System.out.println(change + "'s will now decrypt to " + changeto + "'s and vice versa.");
            for (int i = 32; i < 127; i++){
                if (decrypt[i] == changeto.charAt(0)){
                    decrypt[i] = change.charAt(0);
                }
                else if (decrypt[i] == change.charAt(0)){
                    decrypt[i] = changeto.charAt(0);
                }
            }
            System.out.println();
            System.out.println("The current version of the decrypted text is: \n");
            replace(decrypt,encryptedText);
            System.out.println("Do you want to make a change to the key?");
            System.out.print("Enter 'Y' or 'y' to make change: ");
            answer = keyboard.nextLine();
        }
    }
    public static void conclusion(char[] decrypt, String encryptedText){
        System.out.println();
        key(decrypt);
        System.out.println("The final version of the decrypted text is: \n");
        replace(decrypt,encryptedText);
    }
    public static void key(char[] decrypt){
        System.out.println("The current version of the key for ASCII characters 32 to 126 is: ");
        for (int i= 32; i <127;i++){
            System.out.println("Encrypt character: " + (char)i + ", decrypt character: " + decrypt[i] );
        }
        System.out.println();
    }
    // get the name of file to use
    public static String getFileName(Scanner kbScanner) {
        System.out.print("Enter the name of the encrypted file: ");
        String fileName = kbScanner.nextLine().trim();
        System.out.println();
        return fileName;
    }
}
