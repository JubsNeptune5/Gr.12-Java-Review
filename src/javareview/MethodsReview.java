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
public class MethodsReview {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Initalize scanner
        Scanner in = new Scanner(System.in);
        //Create an object to run methods
        MethodsReview test = new MethodsReview();
        test.helloWorld();
        String name = in.next();
        test.helloWorld(name);
        int total = test.sumRange(5,10);
    }
    public void helloWorld(String name){
        System.out.println("hello, "+name);
    }
    
    public void helloWorld(){
        System.out.println("hello world");
    }
    
    public int sumRange(int Start, int end){
        int sum =0;
        for (int i = 0; i < 10; i++) {
            sum+=1;
        }
        return sum;
    }
}
