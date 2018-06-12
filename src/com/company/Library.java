package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Library {

    private Scanner input = new Scanner(System.in);
    private List<Game> gamesLibrary = new ArrayList<>();
    private List<Game> checkedOutGames = new ArrayList<>();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
    private Menu menu;

    public Library(Menu menu) {
        this.menu = menu;
    }

    public void addGame() {

        System.out.println("What is the title of your game?");
        String title = input.nextLine();
        System.out.println("What type of game is this?");
        String type = input.nextLine();
        System.out.println("What is the ID number of this game?");
        int idNumber = input.nextInt();
        input.nextLine();

        Game game = new Game(title, type, idNumber);
        gamesLibrary.add(game);
        System.out.println("You have added " + game.getTitle() + " to your library, this game can now be checked out. \n");

        menu.startMenu();

    }

    public void removeGame(int index) {

        if (gamesLibrary.isEmpty()) {
            System.out.println("There are no games in your library, add a game to be able to remove");
        } else {
            gamesLibrary.remove(index);
            System.out.println("This game has been removed from your library");
        }

        menu.startMenu();
    }

    public void listGamesInLibrary(String location) {
        if (gamesLibrary.isEmpty()) {
            System.out.println("There are no games in your library");
        } else {

            int index = 1;
            for (Game inLibrary : gamesLibrary) {
                System.out.println(index++ + ": " + inLibrary.getTitle());

            }
        }
        if (location.equals("inLibrary")) {
            menu.startMenu();
        }

    }

    public void checkOutGame(int index) {
        if (gamesLibrary.isEmpty()) {
            System.out.println("There are no games in your library, add games to be able to checkout");
        } else {
            Game game = gamesLibrary.get(index);

            //Create an instance of the calendar object
            Calendar calendar = Calendar.getInstance();
            //add 7 days to current date
            calendar.add(Calendar.DAY_OF_YEAR, 7);
            //uses the line above to set a due date in the future to a variable
            String dueDate = dateFormat.format(calendar.getTime());
            //tell user what their due date is
            System.out.println(String.format(game.getTitle() + " is due on " + dateFormat.format(calendar.getTime())));
            //Set dueDate for this game
            game.setDueDate(dueDate);
            //add game to checked out list
            checkedOutGames.add(game);
            //Remove game form library
            gamesLibrary.remove(game);
        }
        menu.startMenu();
    }

    public void checkInGame(int index) {
        //get game using index from checkedOutGames
        Game game = checkedOutGames.get(index);
        gamesLibrary.add(game);

        try {

            Calendar calendar = Calendar.getInstance();
            if (dateFormat.parse(dateFormat.format(calendar.getTime())).before(dateFormat.parse(game.getDueDate()))) {
                System.out.println("Thanks for turning your game in on time!");

            } else {
                System.out.println("Shame on you! You were late returning your game..smh");
            }
        } catch (ParseException pe) {
            //We will leave this empty cuz it ain't the users fault
        }
        checkedOutGames.remove(game);
        menu.startMenu();
    }
        public void listCheckOut (String location){

            //Checks to see if our arrayList is empty
            if (checkedOutGames.isEmpty()) {
                System.out.println("There are no games currently checked out");
            } else {
                int index = 1;
                //iterate through checkedOutGames list
                for (Game game : checkedOutGames) {
                    System.out.println(index++ + ": " + game.getTitle());
                }
            }
            if (location.equals("viewCheckedOut")) {
                menu.startMenu();
            }

        }

}

