/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javareview;

/**
 *
 * @author laveh2107
 */
public class RecursionExamples {

    /**
     * Euclidean Algorithm find the GDC of any two numbers
     *
     * @param a
     * @param b
     * @return
     */
    public int gcd(int a, int b) {
        //swap numebr if a is lower than b
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        //Check if we are done
        if (b == 0) {
            return a;
        } else {
            //find new variables for a and b
            int r = a % b;
            //Calculate new gcd
            return gcd(b, r);
        }
    }

    //Returns the nth fibbonacci number 
    //n -  the nth number we want
    public int fibLoop(int n) {

        //array to store sequence
        int[] numbers = new int[n + 1];
        numbers[0] = 1;
        //Boundary condition fixing
        if (n > 0) {
            numbers[1] = 1;
        }
        //building the sequence
        for (int i = 2; i < n + 1; i++) {
            numbers[i] = numbers[i - 1] + numbers[i - 2];
        }

        //returning the numbers
        return numbers[n];
    }

    /**
     *
     * @param n
     * @return
     */
    public int fibR(int n) {
        //BASE CASE
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return fibR(n - 1) + fibR(n - 2);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RecursionExamples test = new RecursionExamples();
        int bound1 = test.fibLoop(0);
        System.out.println("0th: " + bound1);
        int bound2 = test.fibLoop(1);
        System.out.println("1th: " + bound2);
        int norm = test.fibLoop(5);
        System.out.println("5th: " + norm);
        System.out.println("-------");
        int boundR1 = test.fibR(0);
        System.out.println("0th: " + boundR1);
        int boundR2 = test.fibR(1);
        System.out.println("1th: " + boundR2);
        int normR = test.fibR(5);
        System.out.println("5th: " + normR);
        System.out.println("------- GCD ");
        int boundgcd1 = test.gcd(1378, 24);
        System.out.println("gcd(1378,24): " + boundgcd1);
    }
}
