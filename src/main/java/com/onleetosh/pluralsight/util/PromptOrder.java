package com.onleetosh.pluralsight.util;

import com.onleetosh.pluralsight.order.*;
import com.onleetosh.pluralsight.order.sandwich.Bread;
import com.onleetosh.pluralsight.order.sandwich.Topping;
import com.onleetosh.pluralsight.order.sandwich.Sandwich;

import java.util.ArrayList;

public class PromptOrder {

    private static Bread selectedBread;
    private static ArrayList<Topping> selectedToppings;


    /**
     *  Prompt user to create a sandwich object and add the result to Sandwich orders ArrayList
     */
    public static ArrayList<Sandwich> promptForSandwich() {

        UI.sandwichOrder = new ArrayList<>();

        //ArrayList<Topping> selectedToppings;

        double total = 0.0;

        //prompt for number of sandwiches to make
        int sandwiches = Console.PromptForInt("How many sandwiches are you ordering?");
        int breadChoice, sandwichSize;
       // Bread selectedBread;
        boolean wantToasted;

        //output the number of sandwiches being made
        System.out.println("You are ordering " + sandwiches + " sandwiches.");


        for (int i = 1; i <= sandwiches; i++) {

            //prompt for type bread and size
            breadChoice = promptForBread();
            selectedBread = UI.breadList.get(breadChoice);
            sandwichSize = selectedBread.getSizeOfBread();
            selectedToppings = promptForToppings(sandwichSize);

            wantToasted = Console.PromptForYesNo("Do you want to toast?");

            // Create a new Sandwich object that calculates and stores the total cost
            Sandwich newSandwich = new Sandwich(sandwichSize, selectedBread, selectedToppings, wantToasted);
            UI.sandwichOrder.add(newSandwich);
            System.out.println("Adding sandwich " + i);

            // display sandwich(es) ordered
            System.out.println("Bread: " + selectedBread.getTypeOfBread() + " | Size: " + sandwichSize + "\"");
            System.out.println("Sandwich" + i  +" " + newSandwich.calculateTotalCost());
            for (Topping topping : selectedToppings) {
                System.out.println(topping);
            }
            System.out.println("Toast: " + (wantToasted ? "Yes" : "No"));

            if (i == sandwiches) {
                break; // Exit the loop after creating the requested number of sandwiches
            }
        }
        return UI.sandwichOrder;
    }

    /**
     * Loop through an ArrayList of objects to display a list of bread options
     * then prompt user to select a bread and return the result
     */
    public static int promptForBread() {

        //loop to prompt a valid input
        while(true) {
            try {
                System.out.println("Select a bread:");
                //loop through  and display bread as a list # 1 - 12 (size of the ArrayList)
                for (int i = 1; i < UI.breadList.size(); i++) {
                    System.out.println(i + ": " + UI.breadList.get(i).getTypeOfBread() + " (" + UI.breadList.get(i).getSizeOfBread() + "\")");
                }

                int bread = Console.PromptForInt("Enter bread choice (1-" + (UI.breadList.size() - 1) + ")");

                System.out.println("Confirmation: " + UI.breadList.get(bread));

                return bread;
            }
            catch (Exception e){
                System.out.println("Please try again... \n");
            }

        }


        //return Console.PromptForInt("Enter bread choice (1-" + (UI.listOfBread.size() - 1) + "): ");
    }

    /**
     * Loop through an ArrayList of objects to display a list of toppings  available
     * then prompt user for toppings to add and return the result
     */
    public static ArrayList<Topping> promptForToppings(int more) {
        ArrayList<Topping> selectedToppings = new ArrayList<>();
        boolean addMore = true;

        while (addMore) {
            try {
                System.out.println("Select a topping:");

                //loop through  and display toppings as a list # 1 - (size of the ArrayList)
                for (int i = 1; i < UI.heroToppingList.size(); i++) {  // Changed to start at 0
                    Topping addTopping = UI.heroToppingList.get(i);
                    System.out.println(i + ": " + addTopping.getTopping() + " " + addTopping);
                }

                // Prompt user for topping to add
                int toppingChoice = Console.PromptForInt("Enter topping choice (0-" + (UI.heroToppingList.size() - 1) + "): ");
                Topping selectedTopping = UI.heroToppingList.get(toppingChoice);
                System.out.println("Adding " + selectedTopping.getTopping());

                // Always prompt for extra topping
                boolean isExtra = Console.PromptForYesNo("Do you want extra " + selectedTopping.getTopping() + "?");

                // Adjust the price if necessary (based on your business logic)
                selectedTopping.adjustPriceIfPremiumToppingAdd(more, isExtra);

                // Add the selected topping to the list
                selectedToppings.add(selectedTopping);

                System.out.println("Topping: " + selectedTopping.getTopping() + ", Current Price: " + selectedTopping.getPrice());

                // Ask if the user wants to add more toppings
                addMore = Console.PromptForYesNo("Add more toppings?");
            }
            catch (Exception e) {
                System.out.println("\nEntry not valid. Please Try again...");
            }
        }

        return selectedToppings;
    }

    /**
     * Loop through an ArrayList of objects to display a list of chips options
     * then prompt user for chips and add the result to chipOrder ArrayList.
     */

    public static ArrayList<Chips> promptForChips(){
        UI.chipOrder = new ArrayList<>();

        //prompt for number of chips to add
        int numberOfChips = Console.PromptForInt("How many Chips are you adding?  ");

        //loop through and display a list of chips # 1 - (size of the ArrayList)
        for (int i = 1; i <= numberOfChips; i++) {
            // Loop through the arraylist and display chips options
            for (int j = 1; j < UI.chipsList.size(); j++) {
                System.out.println(j + ": " + UI.chipsList.get(j).getBagOfChips());
            }

            int chipChoice;
            boolean validChoice = false;

            // Prompt user for chip selection and validate input
            while (!validChoice) {
                chipChoice = Console.PromptForInt("Select a Chip (0-" + (UI.chipsList.size() - 1) + "): ");

                // Check if the input is within the valid range
                if (chipChoice >= 0 && chipChoice < UI.chipsList.size()) {
                    Chips selectedChip = UI.chipsList.get(chipChoice);
                    System.out.println("Added: " + selectedChip);
                    UI.chipOrder.add(selectedChip);
                    validChoice = true;  // Exit loop after valid selection
                } else {
                    System.out.println("Invalid selection. Please enter a valid number between 0 and " + (UI.chipsList.size() - 1) + ".");
                }
            }
        }

        return UI.chipOrder;
    }

    /**
     * Loop through an ArrayList of objects to display a list of beverages options
     * then prompt user for a beverage  and add the result to drinkOrder ArrayList
     */

    public static ArrayList<Beverage> promptForBeverageBeforeUpdate(){

        UI.drinkOrder = new ArrayList<>();
        int numberOfDrinks = Console.PromptForInt("How many drinks are you adding?");

        for (int i = 1; i <= numberOfDrinks; i++) {
            // Loop through the arraylist and display beverage options
            for (int j = 1; j < UI.beveragesList.size(); j++) {
                System.out.println(j + ": " + UI.beveragesList.get(j).getTypeOfBeverage());
            }

            // Get user selection for beverage
            int beverageChoice = Console.PromptForInt("Select a beverage (1 -" + (UI.beveragesList.size() - 1) + "): ");
            Beverage selectedBeverage = UI.beveragesList.get(beverageChoice);

            // Prompt for cup size
            String cupSize;
            boolean validSize = false;

            do {
                cupSize = Console.PromptForString("Select cup size: [S]mall, [M]edium, [L]arge ").toUpperCase();
                if (cupSize.equalsIgnoreCase("S") ||
                        cupSize.equalsIgnoreCase("M") ||
                        cupSize.equalsIgnoreCase("L")) {
                    validSize = true;
                } else {
                    System.out.println("Invalid size. Please choose [S], [M], or [L]. ");
                }
            } while (!validSize);

            // Assign cup size to the selected beverage
            selectedBeverage.setSizeOfCup(cupSize);
            UI.drinkOrder.add(selectedBeverage);

            System.out.println(" Adding: " + selectedBeverage.getTypeOfBeverage() + " (" + cupSize + ") " + selectedBeverage.getPriceOfBeverage());
        }
        return UI.drinkOrder;
    }


    /**
     * Loop through an ArrayList of objects to display a list of beverage options,
     * then prompt user for a beverage and add the result to drinkOrder ArrayList.
     */
    public static ArrayList<Beverage> promptForBeverage() {

        UI.drinkOrder = new ArrayList<>();

        // Prompt user for the number of drinks
        int numberOfDrinks;
        while (true) {
            try {
                numberOfDrinks = Console.PromptForInt("How many drinks are you adding?");
                if (numberOfDrinks < 1) {
                    System.out.println("Please enter a valid number of drinks (1 or more).");
                    continue;
                }
                break;  // Exit the loop if valid input is provided
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        // Loop for the number of drinks to be added
        for (int i = 1; i <= numberOfDrinks; i++) {
            try {
                // Loop through the ArrayList and display beverage options
                System.out.println("Select a beverage:");
                for (int j = 1; j < UI.beveragesList.size(); j++) {
                    System.out.println(j + ": " + UI.beveragesList.get(j).getTypeOfBeverage());
                }

                // Get user selection for the beverage
                int beverageChoice;
                while (true) {
                    try {
                        beverageChoice = Console.PromptForInt("Select a beverage (1 -" + (UI.beveragesList.size() - 1) + "): ");
                        if (beverageChoice >= 1 && beverageChoice < UI.beveragesList.size()) {
                            break;  // Exit the loop if valid selection is provided
                        } else {
                            System.out.println("Invalid choice. Please select a number between 1 and " + (UI.beveragesList.size() - 1));
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                    }
                }

                // Get the selected beverage
                Beverage selectedBeverage = UI.beveragesList.get(beverageChoice);

                // Prompt for cup size with error handling
                String cupSize;
                boolean validSize = false;
                do {
                    try {
                        cupSize = Console.PromptForString("Select cup size: [S]mall, [M]edium, [L]arge ").toUpperCase();
                        if (cupSize.equalsIgnoreCase("S") ||
                                cupSize.equalsIgnoreCase("M") ||
                                cupSize.equalsIgnoreCase("L")) {
                            validSize = true;
                        } else {
                            System.out.println("Invalid size. Please choose [S], [M], or [L].");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter a valid cup size (S, M, or L).");
                    }
                } while (!validSize);

                // Assign cup size to the selected beverage
                UI.drinkOrder.add(selectedBeverage);

                System.out.println("Adding: " + selectedBeverage.getTypeOfBeverage() + " (" + selectedBeverage + ") $" + selectedBeverage.getPriceOfBeverage());

            } catch (Exception e) {
                System.out.println("An error occurred while adding the beverage. Please try again.");
            }
        }

        return UI.drinkOrder;
    }



}

