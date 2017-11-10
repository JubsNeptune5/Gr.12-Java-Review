/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lists;

import Lists.IntNode;

/**
 *
 * @author laveh2107
 */
public class MyLinkedList {

    private IntNode head;
    private int numItems;

    public MyLinkedList() {
        head = null;
        numItems = 0;
    }

    public void add(int num) {
        //Statr at beginning of the list
        IntNode node = head;
        //See if first item is at the start
        if (node == null) {
            IntNode temp = new IntNode(num);
            head = temp;
        } else {
            //travel to the end
            while (node.getNext() != null) {
                //travel to the next node
                node = node.getNext();
            }
            // Node is the last node on the list
            IntNode temp = new IntNode(num);
            //Insert it into the list
            node.setNext(temp);
        }
        //Increase the size counter
        numItems++;
    }

    public void add(int pos, int num) {
        //at the front
        if (pos == 0) {
            //Create the node
            IntNode temp = new IntNode(num);
            //The new node points tot he start
            temp.setNext(head);
            //reassign the head mode
            head = temp;
            //adding at the end of the list
        } else if (pos == numItems) {
            add(num);
            //Anywhre else.....
        } else {
            //Start at the beginning
            IntNode node = head;
            //move to the node bnefore the insert
            for (int i = 0; i < pos - 1; i++) {
                node = node.getNext();
            }
            //  @ node just before the insert'
            IntNode temp  =  new IntNode(num);
            //Create the after libnk first!
            temp.setNext(node.getNext());
            //Change node pointer
            node.setNext(temp);
        }
        //increase item counter
        numItems++;
    }
    
    public int size(){
        return numItems;
    }
    
    public boolean isEmpty(){
        return numItems == 0;
    }
    
    public int get(int pos){
        IntNode node =  head;
        //move the number of times 
        for (int i = 0; i < pos; i++) {
            node = node.getNext();
        }
        return node.getNum();
    }
    
    public void remove(int pos){
        //Removing from the start
        if(pos == 0){
            head = head.getNext();
        } else if(pos == numItems -1){
            //Removing from the end
            IntNode node = head;
            for (int i = 0; i < numItems-1; i++) {
                node =  node.getNext();
            }
            //Sever the linkk
        node.setNext(null);
        }else{
            IntNode node = head;
            for (int i = 0; i < pos - 1; i++) {
                node =  node.getNext();
            }
            //the nod to remove
            IntNode toRemove = node.getNext();
            //It's next node
            IntNode next = toRemove.getNext();
            //Set all the link
            node.setNext(next);
            toRemove.setNext(null);
        }
        numItems--;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(2);
        list.add(-5);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.remove(1);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
