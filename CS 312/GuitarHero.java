import java.lang.*;
/**
 * CS312 Assignment 12.
 *
 * On MY honor, <PENGDI XIA>, this programming assignment is MY own work
 * and I have not provided this code to any other student.
 *
 * Student name: Pengdi Xia
 * UTEID:px353
 * email address: xiapengdi@yahoo.com
 * Number of slip days used on this assignment:0
 * 
 */
public class GuitarHero {
    public static void main(String[] args) {
        GuitarString[] gs = new GuitarString[37];
        for (int i = 0; i< 37; i++){
            gs[i] = new GuitarString(Math.round(440 * Math.pow(1.05946, i-24)));
        }

        final double TEXT_POS_X = .5;
        final double TEXT_POS_Y = .5;
        
        StdDraw.text(TEXT_POS_X, TEXT_POS_Y, "Type anything you see on the keyboard!");
        
        play(gs);
    }
    private static void play(GuitarString[] gs) {        // the main input loop
        while (true) {
            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) {
                // the user types this character
                char key = StdDraw.nextKeyTyped();
                String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' "; // String ends with a space
                for(int i=0; i< 37;i++){
                    if(key == keyboard.charAt(i)){
                        gs[i].pluck();
                        break;
                    }
                }
            }
            double sample= 0;
            for(int i=0; i< 37;i++){
                sample += gs[i].sample();
            }
            StdAudio.play(sample);
            for(int i=0; i< 37;i++){
                gs[i].tic();
            }
        }
    }
}
