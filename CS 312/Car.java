
/**
 * Write a description of class p here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.Color;
import java.awt.Graphics;
public class Car {
    public static void main(String[] args) {
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
         g.fillRect(100,175, 25, 300);//5
         g.fillRect(375, 175, 25, 300);//7
         g.setColor(brown);       
         g.fillRect(125, 175, 250, 300);//6     
         g.setColor(kuang);      
         g.fillRect(200, 175, 100, 175);//8
         g.fillRect(200, 150, 100, 25);//4
         g.setColor(eye);//9       
         g.fillRect(225, 175, 50, 150);
         g.setColor(Color.GREEN);
         g.drawLine(325, 75, 325, 125);//10
         g.setColor(Color.PINK);
         g.fillOval(300, 25, 50, 50);//11
         // inner red fill        
                  
         // black outline         
         
}
public static void p(){
    DrawingPanel panel = new DrawingPanel(500, 500);    
         Graphics g = panel.getGraphics();
        int SIZE=20;
         for (int i =0; i <5; i++){
        
         g.fillRect(i*20+100, -i*20+100,SIZE, SIZE);
         g.fillRect(i*20+100, i*20+100,SIZE,SIZE);
    
}
 for (int i =0; i <5; i++){
        
         g.fillRect(-i*20+100, -i*20+100,SIZE, SIZE);
         g.fillRect(-i*20+100, i*20+100,SIZE,SIZE);
    
}
}
public static void a(){
    DrawingPanel panel = new DrawingPanel(500, 500);
    Graphics g = panel.getGraphics();
    int size =3;
    for ( int i = 1; i <=size; i++){
        for (int j = 1; j<=size ; j++){
            if ((i+j)%2==0){
            g.fillRect( j*50,i*50, 50,50);
            }
            else{
            g.drawRect( j*50, i*50, 50, 50);
            }
        }
        System.out.println();
    }
}

}


