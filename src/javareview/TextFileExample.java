/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javareview;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author laveh2107
 */
public class TextFileExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a blank file reader
        FileReader file = null;
        try{
            //fix this proper loading later
            URL url = ClassLoader.getSystemClassLoader().getResource("input.txt");
            //Creating file reader
            file =  new FileReader("input.txt");
        }catch(Exception e){
            //handle any errors
            //Print out the lovelt red errors
            e.printStackTrace();
            //exit he program
            System.exit(0);
        }
        
        //use a scanner with a file
        Scanner in = new Scanner(file);
        // get the number of adresses
        int numAddresses = in.nextInt();
        
        //move tot he next line
        in.nextLine();
        
        //Create an empty roladex
        Contact[] contacts = new Contact[numAddresses];
        //go through the file
        for (int i = 0; i < numAddresses; i++) {
            String name = in.next();
            String phone =  in.next();
            String email = in.nextLine().trim();
            //Create the contact
            Contact c = new Contact (name);
            c.setEmail(email);
            c.setNumber(phone);
            //add contact to list
            contacts[i] = c;
        }
        
        //print out the rolodex
        for (int i = 0; i < contacts.length; i++) {
            System.out.println(contacts[i]);
        }
    }
}
