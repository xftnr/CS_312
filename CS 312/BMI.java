import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        introduction();
        Scanner console = new Scanner(System.in);
        double bmi1 = person(console);
        double bmi2 = person(console);
        
        // report overall results
        report(1, bmi1);
        report(2, bmi2);
        System.out.println("Difference   = " + Math.abs(bmi1 - bmi2));
    }
    
    // prints a welcome message explaining the program
    public static void introduction() {
        System.out.println("This program reads ...");
    }
    // reads information for one person, computes their BMI, and returns it
    public static double person(Scanner console) {
        System.out.println("Enter next person's information:");
        System.out.print("height (in inches)? ");
        double height = console.nextDouble();
        
        System.out.print("weight (in pounds)? ");
        double weight = console.nextDouble();
        System.out.println();
        
        return bmi(height, weight);
    }
    
    // Computes/returns a person's BMI based on their height and weight.
    public static double bmi(double height, double weight) {
        return weight * 703 / height / height;
    }

    // Outputs information about a person's BMI and weight status.
    public static void report(int number, double bmi) {
        System.out.printf("Subject%5dBMI = %.2f\n", number, bmi);
        if (bmi < 18.5) {
            System.out.println("underweight");
        } else if (bmi < 25) {
            System.out.println("normal");
        } else if (bmi < 30) {
            System.out.println("overweight");
        } else {
            System.out.println("obese");
        }
    }
}

