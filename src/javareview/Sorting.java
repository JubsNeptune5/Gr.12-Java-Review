/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javareview;

import java.util.Arrays;

/**
 *
 * @author laveh2107
 */
public class Sorting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sorting test = new Sorting();
        int[] number = new int[100];//
        for (int i = 0; i < number.length; i++) {
            number[i] = (int) (Math.random() * (100 - 1) + 1);
        }


        System.out.println("Before sorting");
        for (int i = 0; i < number.length; i++) {
            System.out.println(number[i]);
        }

        test.mergeSort(number);

        System.out.println("After sorting");
        for (int i = 0; i < number.length; i++) {
            System.out.println(number[i]);
        }
        
        System.out.println(test.binarySearch(number, 36));
    }

    public void swap(int[] array, int p1, int p2) {
        int temp = array[p1];
        array[p1] = array[p2];
        array[p2] = temp;


    }

    public void selectionSort(int[] array) {
        for (int position = 0; position < array.length; position++) {
            for (int i = 0; i < array.length; i++) {
                //anything smaller 
                if (array[i] < array[position]) {
                    swap(array, i, position);
                }
            }
        }
    }

    public void bubbleSort(int[] array) {
        int last = array[9];
        boolean swap = false;
        while (swap) {
            swap = false;

            for (int i = 0; i < last - 1; i++) {
                //find a bigger value
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    swap = true;
                }
            }
            //move to last psoition
            last--;
        }
    }

    public void insersionSort(int[] array) {
        //start going through the array
        for (int i = 0; i < array.length; i++) {
            //store position
            int position = i;
            //check values beside each other
            while (position >= 0 && array[position] > array[position + 1]) {
                //if out of place, swap it downwards
                //until correct position is reached
                swap(array, position, position - 1);
                position--;
            }
        }

    }

    public void mergeSort(int[] array) {
        //If we are 1 item, done sorting
        if (array.length <= 1) {
            return;
        }
        //divid into 2 array
        int split = array.length / 2;
        //create two arrays                         up to that position
        int[] front = Arrays.copyOfRange(array, 0, split);
        int[] back = Arrays.copyOfRange(array, split, array.length);

        //Recursivly sort
        mergeSort(front);
        mergeSort(back);

        //put numbers in correct spot
        int fSpot = 0;
        int bSpot = 0;
        for (int i = 0; i < array.length; i++) {
            // no more items in front array
            if (fSpot == front.length) {
                array[i] = back[bSpot];
                bSpot++;
            } else if (bSpot == back.length) {
                array[i] = front[fSpot];
                fSpot++;
            } else if (front[fSpot] < back[bSpot]) {
                //put front irtem in
                array[i] = front[fSpot];
                fSpot++;
            } else {
                //put back item in
                array[i] = back[bSpot];
                bSpot++;
            }
        }
    }

    public int sequentialSearch(int[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            //did i find it?
            if (array[i] == number) {
                return i;
            }
        }
        //didnt find it
        return -1;

    }

    //binary search
    public int binarySearch(int[] array, int target) {
        int min = 0;
        int max = array.length - 1;
        while (max >= min) {
            int guess = (max + min) / 2;
            //find it?
            if (array[guess] == target) {
                return guess;
            } else if (target > array[guess]) {
                min = guess + 1;
            } else {
                max = guess - 1;
            }
        }
        //didn't find it
        return -1;

    }
}
