package ex14.base;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;
/*
 *  UCF COP3330 Summer 2021 Assignment 14 Solution
 *  Copyright 2021 William Weatherlow
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
