package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private Scanner input = new Scanner(System.in);
    private Library library = new Library(this);

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
                   input.nextLine();
                   //handles Adding a game
                   System.out.println("You have chosen to add a game");
                   library.addGame();
                   break;
               case 2:
                   input.nextLine();
                   //handles Removing a game
                   System.out.println("Which number would you like to remove?");
                   library.listGamesInLibrary("forRemoval");
                   library.removeGame(input.nextInt() - 1);
                   break;
               case 3:
                   input.nextLine();
                   //handles Viewing current games
                   library.listGamesInLibrary("inLibrary");

                   break;
               case 4:
                   input.nextLine();
                   //handles checking out a game
                   System.out.println("You have chose to check out a game" +
                           "\nHere is a list of all games available to checkout:");
                   library.listGamesInLibrary("CheckOut");
                   System.out.println("Choose a number for the game you would like");
                   library.checkOutGame(input.nextInt() - 1);
                   break;
               case 5:
                   input.nextLine();
                   //handles checking in a game
                   System.out.println("What game are you checking in?");
                   library.listCheckOut("checkIn");
                   library.checkInGame(input.nextInt() - 1);
                   System.out.println();
                   break;
               case 6:
                   //handles Viewing checked out games
                   library.listCheckOut("viewCheckedOut");
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
       } catch (IndexOutOfBoundsException ioobe) {
           input.nextLine();
           System.out.println("This number is invalid. Taking you back to main menu");
           startMenu();
       }

   }


}
