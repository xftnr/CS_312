import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/**
 * Write a description of class notes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class notes
{
    public static void main( String[] args){
        //Scanner input = new Scanner(new File("wbb08s.txt"));
        
        /* Scanner scan = new Scanner(System.in);
        scan.nextLine();
        
            while(scan.hasNextLine()) {
                String s = scan.nextLine();
                if (s.contains("@")) {
                    dostuff(s);
                }
                System.out.println(s);
            }
        
        
        
        
        
        
      /*  Scanner keyboard = new Scanner(System.in);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println(alphabet.contains("*"));
        
        String charToDelete = keyboard.nextLine();
       //System.out.println(update(alphabet,charToDelete ));
       String alphabet2= " ";
        for ( int i= 0; i < alphabet.length (); i++){
            String redef = alphabet.charAt(i)+"";
            if (! charToDelete.equals (redef)){
                alphabet2 += alphabet.charAt (i);
            }
        }
        System.out.println(alphabet2);
       /*while (true){
            String charToDelete = keyboard.nextLine();
            alphabet1 = update(alphabet, charToDelete);
            System.out.println(alphabet1);
        }
        
    }
    public static String update(String alphabet, String chartodelet){
        String updated= " ";
         for (int i= 0; i < alphabet.length (); i++){
            while (! chartodelet.equals(alphabet.charAt(i))){
                updated += alphabet.charAt (i);
            }
        }
        return updated;
    }*/

}
public static void dostuff(String line ){
        Scanner lineScanner = new Scanner(line);
    
        lineScanner.next();

        String teamA = "";
        
        while(lineScanner.hasNextInt()) {
            teamA += lineScanner.next() + " ";
        
        }
        int teamAPoints = lineScanner.nextInt();
        
        String teamB = "";
        
        while(lineScanner.hasNextInt()) {
            teamB += lineScanner.next() + " ";
        
        }
        int teamBPoints = lineScanner.nextInt();
        
        System.out.println("A");
        System.out.println(teamA);
        System.out.println(teamB);
    }
    public static void a (){
        String b="she did bad";
        System.out.println(b.charAt(3));
    }
/*public static void test(){
    String s1 = "Olivia Scott";
String s2 = "Isabelle Scott";
System.out.println(s2.length());   // 14
System.out.println(s1.indexOf("t"));  // -1
System.out.println(s2.indexOf("e"));  // 4
System.out.println(s1.substring(7, 10));// "Sco"
String s3 = s2.substring(4, 10);
System.out.println(s3.toLowerCase());// "elle s"
}
/*public static boolean matches( String line , int userID){
    //Scanner lineSecan = new Scanner(line)
    int id = etractUserID(line);
    return id == userID;
}
setractUserID( String line){
    Scanner lineScan = new Scanner();
    */
}
