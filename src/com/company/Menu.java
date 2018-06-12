package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private Scanner input = new Scanner(System.in);

    //Menu to prompt user for Library options.
   public void startMenu() {

       System.out.println("What would you like to do?" +
               "\n1. Add a game to the library" +
               "\n2. Remove a game from the Library" +
               "\n3. View what is currently in the library" +
               "\n4. Check out a game" +
               "\n5. Check in a game" +
               "\n6. View Checked out games" +
               "\n7. Exit the program");
       try {
           switch(input.nextInt()) {
               case 1:
                   //handles Adding a game
                   break;
               case 2:
                   //handles Removing a game
                   break;
               case 3:
                   //handles Viewing current games
                   break;
               case 4:
                   //handles checking out a game
                   break;
               case 5:
                   //handles checking in a game
                   break;
               case 6:
                   //handles Viewing checked out games
                   break;
               case 7:
                   //handles Exiting the program
                   System.out.println("Thank you for using the Video Game Library");
                   System.exit(0);
                   break;
               default:
                   //handles wrong input
                   System.out.println("That is not a valid entry.  Please enter a number between 1 and 7.");
                   startMenu();
                   break;

           }
       } catch (InputMismatchException ime) {
           input.nextLine();
           System.out.println("That is not a valid entry.  Please enter a number between 1 and 7.");
           startMenu();
       }

   }


}
