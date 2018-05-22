
/**
 * Write a description of class Bake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bake
{
    public static void main(String[] args) {
        makeBatter();
        System.out.println("lalalla.");
        bake(); // 1st batch
        bake(); // 2nd batch
        decorate();
    }

    // Step 1: Make the cake batter.
    public static void makeBatter() {
        System.out.println("Mix the dry ingredients.");
        System.out.println("Cream the butter and sugar.");
        System.out.println("Beat in the eggs.");
        System.out.println("Stir in the dry ingredients.");
    }
    // Step 2: Bake a batch of cookies.
    public static void bake() {
        System.out.println("Set the oven temperature.");
        System.out.println("Set the timer.");
        System.out.println("Place a batch of cookies into the oven.");
        System.out.println("Allow the cookies to bake.");
    }

    // Step 3: Decorate the cookies.
    public static void decorate() {
        int x=5;
        int y= 7;
        System.out.println(m(x,y)+" "+x+" "+m(y,x));
    }
    public static int m(int x, int y){
        x+= 2;
        System.out.print(x+ " ");
        y -= 2;
        return x*y;
    }
}


