package assignment3;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author  <Your name here>
 * @version <Date>
 * CS312 Assignment 3.
 * 
 * On my honor, <PENGDI XIA>, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 * A program to print out various scintillation grids and a student designed drawing. 
 *
 *  Name:Pengdi Xia
 *  email address:xiapengdi@yahoo.com
 *  UTEID:px353
 *  Section 5 digit ID:51265
 *  Number of slip days used on this assignment:0
 */

public class ScintillationGrid {
    // Main method that creates the DrawingPanel with scintillation grids.
    // Restricted to chapters 1 - 3 of Building Java Programs
    public static void main(String[] args) {
        /* In the final version of the program DO NOT call method drawingOne 
           from main or anywhere else in the program */
       DrawingPanel panel = new DrawingPanel(900, 650);
       panel.setBackground(Color.CYAN);
       Graphics g = panel.getGraphics();
       
       loop(g, 348, 75, 4, 16, 0, 0);//top left
       loop(g, 422, 50, 7, 12, 400, 50);// top right
       loop(g, 220, 100, 2, 20, 50, 400);// bottom left
       loop(g, 148, 15, 8, 4, 500, 500);// bottem right
//       drawingOne();
    }
    public static void loop (Graphics g, int bigsize,int size,int level,int line, int x, int y){
      // gray line
      g.setColor(Color.GRAY);
      g.fillRect( x, y, bigsize, bigsize);
      // black block
      for( int j=0; j<level; j++){
          for(int i=0; i<level; i++){
           g.setColor(Color.BLACK);
           g.fillRect(i*(size+line)+x, j * (size+line) +y, size, size);
         }    
      }
      // white dots
      int circle= Math.max (line*7/5,line+2);
      for (int j=1; j< level; j++){
           for( int i=1; i< level; i++){
            g.setColor(Color.WHITE);
            g.fillOval(size*i-(circle-line)/2+line*(i-1)+x , size*j-(circle-line)/2+line*(j-1)+y , circle , circle);   
          }
      }
    }
    // method for the student designed drawing
    // NOT restricted to chapters 1 - 3 of Building Java Programs
    public static void drawingOne() {
        DrawingPanel panel = new DrawingPanel(500, 500);    
         Graphics g = panel.getGraphics();
         Color brown = new Color(255, 237, 144);
         Color top = new Color(219, 192, 95);
         Color side = new Color(162, 132, 153);
         Color eye = new Color(149, 241, 255);
         Color kuang = new Color(218, 210, 233);
         Color bian = new Color(135, 123, 113);
         g.setColor(bian);     
         g.fillRect(100, 125, 25, 50);//1
         g.fillRect(375, 125, 25, 50);//3
         g.setColor(top);   
         g.fillRect(125, 125, 250, 50);//2
         g.setColor(side);       
         g.fillRect(100,175, 25, 275);//5
         g.fillRect(375, 175, 25, 275);//7
         g.setColor(brown);       
         g.fillRect(125, 175, 250, 275);//6     
         g.setColor(kuang);      
         g.fillRect(200, 175, 100, 175);//8
         g.fillRect(200, 150, 100, 25);//4
         g.setColor(eye);//9       
         g.fillRect(225, 175, 50, 150);
         g.setColor(Color.GREEN);
         g.drawLine(325, 75, 325, 125);//10
         g.setColor(Color.PINK);
         g.fillOval(300, 25, 50, 50);//11
    }
}

