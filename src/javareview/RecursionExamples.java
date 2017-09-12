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
    //Returns the nth fibbonacci number 
    //n -  the nth number we want

    public int fibLoop(int n) {

        //array to store sequence
        int[] numbers = new int[n + 1];
        numbers[0] = 1;
        numbers[1] = 1;

        //building the sequence
        for (int i = 2; i < n + 1; i++) {
            numbers[i] = numbers[i - 1] + numbers[i - 2];
        }

        //returning the numbers
        return numbers[n];
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RecursionExamples test = new RecursionExamples();
    }
}
