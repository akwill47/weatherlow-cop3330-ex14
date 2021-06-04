package ex14.base;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;
/*
Exercise 14 - Tax Calculator
You don’t always need a complex control structure to solve simple problems.
Sometimes a program requires an extra step in one case, but in all other cases there’s nothing to do.

Write a simple program to compute the tax on an order amount.
The program should prompt for the order amount and the state.
If the state is “WI,” then the order must be charged 5.5% tax.
The program should display the subtotal, tax, and total for Wisconsin residents but display just the total for non-residents.

Example Output
What is the order amount? 10
What is the state? WI
The subtotal is $10.00.
The tax is $0.55.
The total is $10.55.
Or

What is the order amount? 10
What is the state? MN
The total is $10.00

Constraints
Implement this program using only a simple if statement—don’t use an else clause.
Ensure that all money is rounded up to the nearest cent.
Use a single output statement at the end of the program to display the program results.
Challenges
Allow the user to enter a state abbreviation in upper, lower, or mixed case.
Also allow the user to enter the state’s full name in upper, lower, or mixed case.
 */
public class App {
    Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        App myApp = new App();
        System.out.print("What is the order amount? ");
        String orderAmount = myApp.readInput();
        System.out.print("What is the state? ");
        String state = myApp.readInput();

        String output = myApp.calculateBill(orderAmount,state);
        myApp.displayBill(output);

    }
    private String readInput(){
        return in.nextLine();
    }
    private String calculateBill(String stringAmount,String state){
        float floatAmount = Float.parseFloat(stringAmount);
        DecimalFormat output = new DecimalFormat("0.00");

        if(state.equals("WI")){
            double tax = (double)Math.round((floatAmount * 0.055)*100d)/100d;
            float total = (float)tax + floatAmount;
            return "The subtotal is $" + output.format(floatAmount) +".\nThe tax is $" + output.format(tax) + ".\nThe total is $" + output.format(total) + ".";
        }
        if(!state.equals("WI")){
            return "The total is $" + output.format(floatAmount) + ".";
        }

        return stringAmount;
    }
    private void displayBill(String output){
        System.out.println(output);
    }
}
