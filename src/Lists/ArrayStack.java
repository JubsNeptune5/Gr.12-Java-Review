/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lists;

/**
 *
 * @author laveh2107
 */
public class ArrayStack {

    //Store all of the integers on the stack
    private int[] stack;
    //Keeps track of how many items
    private int numItems;

    public ArrayStack() {
        stack = new int[10];
        numItems = 0;
    }

    public void push(int item) {
        //Is there room in the stack
        if (numItems < stack.length) {
            //Put the item on the stack
            stack[numItems] = item;
            numItems++;
        } else {
            //Make more room
            int[] temp = new int[stack.length * 2];
            //copy items over
            for (int i = 0; i < stack.length; i++) {
                temp[i] = stack[i];
            }
            //Stack becomes the new array
            stack = temp;
            //Add in the new item
            stack[numItems] = item;
            numItems++;
        }
    }

    public int pop() {
        //Get the top item on the stack
        int item = stack[numItems - 1];
        //ojne less item
        numItems--;
        //give back item
        return item;
    }

    public int size() {
        return numItems;
    }

    public int peek() {
        return stack[numItems - 1];
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Create empty stack
        ArrayStack stack = new ArrayStack();
        System.out.println("Empty: " + stack.isEmpty());
        stack.push(12);
        System.out.println("Empty: " + stack.isEmpty());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());
        int item = stack.pop();
        System.out.println("Popped item: "+ item);
        System.out.println("Empty :" + stack.isEmpty());
        //Test adding lots of items
        for (int i = 0; i < 100; i++) {
            stack.push(i);
        }
        System.out.println("size: " + stack.size());
        
        System.out.println("Peek: " + stack.peek());
    }
}
