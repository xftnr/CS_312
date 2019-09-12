package assignment1;

/*
 * CS312 Assignment 1.
 * On my honor, <Pengdi Xia>, this programming assignment is my own work.
 *
 * A program to print out the lyrics to the
 * children's song, "There was an old woman".
 *
 *  Name: Pengdi Xia
 *  email address:xiapengdi@yahoo.com
 *  UTEID:px353
 *  Section 5 digit ID:51265
 *  Number of slip days used on this assignment:0
 */

public class Song{
    public static void main (String [] args)
    {
         System.out.println("There was an old woman who swallowed a fly.");
         paragraph1();
         System.out.println("There was an old woman who swallowed a spider,");
         System.out.println("That wriggled and iggled and jiggled inside her.");
         paragraph2();
         System.out.println("There was an old woman who swallowed a bird,");
         System.out.println("How absurd to swallow a bird.");
         paragraph3();
         System.out.println("There was an old woman who swallowed a cat,");
         System.out.println("Imagine that to swallow a cat.");
         paragraph4();
         System.out.println("There was an old woman who swallowed a dog,");
         System.out.println("What a hog to swallow a dog.");
         paragraph5();
         System.out.println("There was an old woman who swallowed a goat,");
         System.out.println("She just opened her throat to swallow a goat.");
         paragraph6();
         System.out.println("There was an old woman who swallowed a cow,");
         System.out.println("I don't know how she swallowed a cow.");
         paragraph7();
         System.out.println("There was an old woman who swallowed a horse,");
         System.out.println("She died of course.");
        }
    public static void paragraph1()
    {
        System.out.println("I don't know why she swallowed that fly,");
        System.out.println("Perhaps she'll die.\n");
    }
    public static void paragraph2()
    {
        System.out.println("She swallowed the spider to catch the fly,");
        paragraph1();
    }
    public static void paragraph3()
    {
        System.out.println("She swallowed the bird to catch the spider,");
        paragraph2();
    }
    public static void paragraph4()
    {
        System.out.println("She swallowed the cat to catch the bird,");
        paragraph3();
    }
    public static void paragraph5()
    {
        System.out.println("She swallowed the dog to catch the cat,");
        paragraph4();
    }
    public static void paragraph6()
    {
        System.out.println("She swallowed the goat to catch the dog,");
        paragraph5();
    }
    public static void paragraph7()
    {
        System.out.println("She swallowed the cow to catch the goat,");
        paragraph6();
    }
}
