/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CardGame;

/**
 *
 * @author laveh2107
 */
public class Human {

    //Define instance variables
    private String name;
    private int age;
    private char gender;

    //Constructor: Used to create individual humans
    //"Setup" a human to use
    public Human(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    //Accessor method
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    
    
    public void setName(String name) {
        this.name = name;
    }

    public void celebrateBirthday() {
        //increase human age
        this.age++;
        //Wish them a happy birthday
        System.out.println("Happy Birthday " + name + "!!!!!!!!!!");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Human bob = new Human("Bob", 19, 'M');
        System.out.println(bob.getName());
        System.out.println(bob.getAge());
        bob.celebrateBirthday();
        System.out.println(bob.getAge());
    }
}
