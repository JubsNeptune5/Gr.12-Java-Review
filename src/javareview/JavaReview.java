/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javareview;

import java.util.Scanner;

/**
 *
 * @author laveh2107
 */
public class JavaReview {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //  Initalizing all the variables 
        //Type of variable name [= value];
        int age = 10;
        double length =25.73;
        
        //Math opperatiions 
        //+addition
        //-subtraction
        //*multipication
        // / divvison
        // % modulus (The remainder after the division)
        age = age + 10;
        
        length = length * 2;
        //add one to age
        age++;
        //minus one from age
        age--;
        
        // conditions 
        //CHeck if the lenght is greater than 100
        if(length>100){
            System.out.println("Length is bigger than 100");
        //If not true, then check if the length is between 100-50
        }else if(length>50 && length <=100){
            System.out.println("Length is between 50 and one hundred");
        //If that isn't true, then the length is less than or equal to 50
        }else{
            System.out.println("The Length is less than or equal to 50");
        }
        
        
        //While loops
        int count = 0;
        while(count<10){
            count++;
            System.out.println(count);
        }
         
        for ( int i = 0; i<10; i++){
            System.out.println("i:" + i);
        }
        
        //array
        String[] words = new String[5];
        words [0] = "cat";
        
        //Input 
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < words.length; i++) {
            System.out.println("Enter a word");
            words[i] = input.nextLine();
        }
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }
        
    }
}
