package com.onleetosh.pluralsight.util;

import com.onleetosh.pluralsight.order.addon.*;
import com.onleetosh.pluralsight.order.sandwich.*;
;

import java.util.ArrayList;

public class PromptOrder {

    private static Bread selectedBread;
    private static ArrayList<Topping> selectedToppings;
    private static ArrayList<Beverage> drinkOrder;
    private static ArrayList<Chips> chipOrder;
    private static ArrayList<Sandwich> sandwichOrder;
    private static ArrayList<Cookie> cookieOrder;


    /**
     *  Prompt user to create a sandwich object and add the result to Sandwich orders ArrayList
     */
    public static ArrayList<Sandwich> promptForSandwich() {

        sandwichOrder = new ArrayList<>();

        double total = 0.0;
        int request = -1, breadChoice, sandwichSize;
        boolean wantToasted;

        while (request < 0) {
            try {
                request = Console.PromptForInt("How many sandwiches are you ordering? ");
            } catch (Exception e) {
                System.out.println("Please enter valid number ");
            }
        }
        //output requested number of sandwiches to build
        System.out.println("You are ordering " + request + " sandwiches.");

        //loop through and build sandwich <= requested amount
        for (int i = 1; i <= request; i++) {

            //retrieve the information need to construct sandwich
            breadChoice = getBreadForPrompt();
            selectedBread = UI.breadList.get(breadChoice);
            sandwichSize = selectedBread.getSizeOfBread();
            selectedToppings = getToppingForPrompt(sandwichSize);

            wantToasted = Console.PromptForYesNo("Do you want to toast? ");

            // initialize new Sandwich and add to sandwich order
            Sandwich newSandwich = new Sandwich(sandwichSize, selectedBread, selectedToppings, wantToasted);
            sandwichOrder.add(newSandwich);

            //confirm sandwich was created
            System.out.println("\nSandwich " + i + " confirmed");
            System.out.println("Bread: " + selectedBread.getTypeOfBread() +
                            " | Size: " + sandwichSize + "\"" +
                            " $" + selectedBread.getPrice());
            for (Topping topping : selectedToppings) {
                System.out.println(topping);
            }
            System.out.println("Toast: " + (wantToasted ? "Yes" : "No"));
            System.out.printf("Amount: $%.2f\n",newSandwich.getTotalCostOfSandwich());

            if (i == request) {
                break; // Exit the loop after creating the requested number of sandwiches
            }
        }
        return sandwichOrder;
    }

    /**
     * Loop through an ArrayList of objects to display a list of bread options
     * then prompt user to select a bread and return the result
     */
    public static int getBreadForPrompt() {
        //loop to prompt a valid input
        while(true) {
            try {
                System.out.println("Select a bread:");
                //loop through  and display bread as a list # 1 - 12 (size of the ArrayList)
                for (int i = 1; i < UI.breadList.size(); i++) {
                    System.out.println(i + ": " + UI.breadList.get(i).getTypeOfBread() + " (" + UI.breadList.get(i).getSizeOfBread() + "\")");
                }
                int input = Console.PromptForInt("Enter bread choice (1-" + (UI.breadList.size() - 1) + ") ");
                System.out.println("Confirmation: " + UI.breadList.get(input));
                return input;
            }
            catch (Exception e){
                System.out.println("Enter a (1-" + (UI.breadList.size() - 1)+") \n");
            }
        }
    }
    /**
     * Loop through an ArrayList of objects to display a list of toppings  available
     * then prompt user for toppings to add and return the result
     */
    public static ArrayList<Topping> getToppingForPrompt(int more) {
        ArrayList<Topping> selectedToppings = new ArrayList<>();
        boolean addMore = true;

        while (addMore) {
            try {
                System.out.println("Select a topping:");

                //loop through  and display toppings as a list # 1 - (size of the ArrayList)
                for (int i = 1; i < UI.heroToppingList.size(); i++) {
                    Topping getToppings = UI.heroToppingList.get(i);
                    System.out.println( i + ": " + getToppings.displayToppings());
                }
                // Prompt user for  topping
                int input = Console.PromptForInt("Enter topping choice (1-" + (UI.heroToppingList.size() - 1) + "): ");
                Topping selectedTopping = UI.heroToppingList.get(input);

                boolean isExtra = false; //default extra topping to false
                try {
                    // Always prompt for extra topping
                     isExtra = Console.PromptForYesNo("Do you want extra " + selectedTopping.getTopping() + "? ");
                }
                catch (Exception e){
                    System.out.println("Please enter Y or N ");

                }
                // Adjust the price if topping is premium and extra
                selectedTopping.adjustPriceIfPremiumToppingAdd(more, isExtra);

                if(isExtra){
                    selectedTopping.setExtra(true);
                }
                // Add the selected topping to the list
                selectedToppings.add(selectedTopping);
                //confirm topping was added
                System.out.println(" Got it!  " + selectedTopping.getTopping() +
                        " has been added, $" + selectedTopping.getPrice());
                // prompt for more toppings
                addMore = Console.PromptForYesNo("Add more toppings?");
            }
            catch (Exception e) {
                System.out.println("Please Enter a (1-" + (UI.heroToppingList.size() - 1)+") \n");            }
        }
        return selectedToppings;
    }

    /**
     * Method used to loop through an ArrayList of objects to display a list of beverage options,
     * then prompt user for a beverage and add the result to drinkOrder ArrayList.
     */


    public static ArrayList<Beverage> promptForBeverage() {
        drinkOrder = new ArrayList<>();

        int request = -1;
        boolean validInput = false;
        // Prompt for how many drinks are being added, with validation
        while (!validInput) {
            try {
                request = Console.PromptForInt("How many drinks are you adding? ");
                if (request >= 0) {
                    validInput = true;
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
            }
        }
        // If user enters 0, return no beverage
        if (request == 0) {
            return drinkOrder;
        }


        for (int i = 1; i <= request; i++) {
            // Loop through the arraylist and display beverage options
            for (int j = 1; j < UI.beveragesList.size(); j++) {
                System.out.println(j + ": " + UI.beveragesList.get(j).getTypeOfBeverage());
            }

            // Get user selection for beverage, with validation
            Beverage selectedBeverage = null;
            boolean validChoice = false;
            while (!validChoice) {
                try {
                    int choice = Console.PromptForInt("Select a beverage (1-" + (UI.beveragesList.size() - 1) + "): ");
                    if (choice >= 0 && choice < UI.beveragesList.size()) {
                        selectedBeverage = UI.beveragesList.get(choice);
                        validChoice = true;
                    }
                } catch (Exception e) {
                    System.out.println("Please enter a (1-" + (UI.beveragesList.size() - 1) + ")");
                }
            }

            String cupSize = " ";
            boolean validSize = false;
            do {
                cupSize = Console.PromptForString("Select cup size: [S]mall, [M]edium, [L]arge ");
                if (cupSize.equalsIgnoreCase("S")) {
                    cupSize = "S";
                    validSize = true;
                } else if (cupSize.equalsIgnoreCase("M")) {
                    cupSize = "M";
                    validSize = true;
                } else if (cupSize.equalsIgnoreCase("L")) {
                    cupSize = "L";
                    validSize = true;
                } else {
                    System.out.println("Invalid size. Please choose [S], [M], or [L]. ");
                }
            } while (!validSize);


            // Assign cup size to the selected beverage
            selectedBeverage.setSizeOfCup(cupSize);
            drinkOrder.add(selectedBeverage);
            System.out.println("Update order: " + selectedBeverage);
        }

        return drinkOrder;
    }

    /**
     * Loop through an ArrayList of objects to display a list of chips options
     * then prompt user for chips and add the result to chipOrder ArrayList.
     */
    public static ArrayList<Chips> promptForChips() {
        chipOrder = new ArrayList<>();
        int prompt = -1; // user can enter 0 Chips
        // Prompt for the number of chips to add with error handling
        while (prompt < 0) {
            try {
                prompt = Console.PromptForInt("How many chips are you adding? ");
                if (prompt < 0) {
                    System.out.println("Please enter a valid number.");
                }
            } catch (Exception e) {
                System.out.println(" Please enter a valid number.");
            }
        }

        // Loop through and add the specified number of chips
        for (int i = 0; i < prompt; i++) {
            // Display available chip options
            System.out.println("Available chips:");
            // loop through ArrayList and display objects starting at position 1
            for (int j = 1; j < UI.chipsList.size(); j++) {
                System.out.println(j + ": " + UI.chipsList.get(j).getBagOfChips());
            }
            // Prompt for chip selection and check for valid input
            int choice = -1;  //ArrayList begins at index 1
            while (choice < 0 || choice >= UI.chipsList.size()) {
                try {
                    choice = Console.PromptForInt("Select a chip (0-" + (UI.chipsList.size() - 1) + "): ");
                    if (choice >= 0 && choice < UI.chipsList.size()) {
                        Chips selectedChip = UI.chipsList.get(choice);
                        chipOrder.add(selectedChip);
                        System.out.println("Added: " + selectedChip.getBagOfChips());
                    }
                } catch (Exception e) {
                    System.out.println(" Please enter [1 - " + (UI.chipsList.size() - 1) + "]");
                }
            }
        }
        return chipOrder;
    }
    /**
     * Method used to loop through an ArrayList of objects to display a list of cookie options,
     * then prompt user for item and add the result to order ArrayList.
     */

    public static ArrayList<Cookie> promptForCookie() {
        cookieOrder = new ArrayList<>();
        int prompt = -1; // user can enter 0 Chips
        // Prompt for the number of chips to add with error handling
        while (prompt < 0) {
            try {
                prompt = Console.PromptForInt("How many cookies are you adding? ");
                if (prompt < 0) {
                    System.out.println("Please enter a valid number.");
                }
            } catch (Exception e) {
                System.out.println(" Please enter a valid number.");
            }
        }
        // Loop through and add the specified number of chips
        for (int i = 0; i < prompt; i++) {
            // Display available cookie options
            System.out.println("Available cookie:");
            // loop through ArrayList and display objects starting at position 1
            for (int j = 1; j < UI.cookieList.size(); j++) {
                System.out.println(j + ": " + UI.cookieList.get(j).getTypeOfCookie());
            }
            // Prompt for cookie selection and check for valid input
            int choice = -1;  //ArrayList begins at index 1
            while (choice < 0 || choice >= UI.cookieList.size()) {
                try {
                    choice = Console.PromptForInt("Select (1-" + (UI.cookieList.size() - 1) + "): ");
                    if (choice >= 0 && choice < UI.cookieList.size()) {
                        Cookie selectedChip = UI.cookieList.get(choice);
                        cookieOrder.add(selectedChip);
                        System.out.println("Added: " + selectedChip.getTypeOfCookie());
                    }
                } catch (Exception e) {
                    System.out.println(" Please enter [1 - " + (UI.cookieList.size() - 1) + "]");
                }
            }
        }
        return cookieOrder;
    }



}

