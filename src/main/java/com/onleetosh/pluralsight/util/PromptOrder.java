package com.onleetosh.pluralsight.util;

import com.onleetosh.pluralsight.order.*;
import com.onleetosh.pluralsight.order.sandwich.Topping;
import com.onleetosh.pluralsight.order.sandwich.Bread;
import com.onleetosh.pluralsight.order.sandwich.Sandwich;

import java.util.ArrayList;

public class PromptOrder {


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
            Order.selectedBread = UI.listOfBread.get(breadChoice);
            sandwichSize = Order.selectedBread.getSizeOfBread();

            Order.selectedToppings = promptForToppings(sandwichSize);

            wantToasted = Console.PromptForYesNo("Do you want to toast?");
            UI.sandwichOrder.add(new Sandwich(sandwichSize, Order.selectedBread, Order.selectedToppings, wantToasted));



            System.out.println("Adding sandwich " + i);

            double price = Sandwich.totalCostOfSandwich(Order.selectedBread, Order.selectedToppings);

            System.out.println("COST OF SANDWICH: " + price );

            // display sandwich(es) ordered
            System.out.println("Your order:");
            System.out.println("Bread: " + Order.selectedBread.getTypeOfBread() + " | Size: " + sandwichSize + "\"");

            for (Topping topping : Order.selectedToppings) {
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

        System.out.println("Select a bread:");

        //loop through array
        for (int i = 1; i < UI.listOfBread.size(); i++) {
            System.out.println(i + ": " + UI.listOfBread.get(i).getTypeOfBread() + " (" + UI.listOfBread.get(i).getSizeOfBread() + "\")");
        }

        int bread = Console.PromptForInt("Enter bread choice (1-" + (UI.listOfBread.size() - 1) + ")");
        System.out.println("Bread selected : " + UI.listOfBread.get(bread));
        return bread;

        //return Console.PromptForInt("Enter bread choice (1-" + (UI.listOfBread.size() - 1) + "): ");
    }



    //TODO: ADD EXTRA OPTION TO SAUCE AND REGULAR TOPPING
    /**
     * Loop through an ArrayList of objects to display a list of toppings  available
     * then prompt user for toppings to add and return the result
     */
    public static ArrayList<Topping> promptForToppings(int more) {
        ArrayList<Topping> selectedToppings = new ArrayList<>();
        boolean addMore = true;


        while (addMore) {
            System.out.println("Select a topping:");

            // Display all toppings
            for (int i = 1; i < UI.listOfSandwichTopping.size(); i++) {  // Changed to start at 0
                Topping addTopping = UI.listOfSandwichTopping.get(i);
                System.out.println(i + ": " + addTopping.getTopping() + " " + addTopping);
            }

            // Prompt user to select a topping
            int toppingChoice = Console.PromptForInt("Enter topping choice (0-" + (UI.listOfSandwichTopping.size() - 1) + "): ");
            Topping selectedTopping = UI.listOfSandwichTopping.get(toppingChoice);
            System.out.println("Adding " + selectedTopping.getTopping());

            // Always prompt if the user wants extra
            boolean isExtra = Console.PromptForYesNo("Do you want extra " + selectedTopping.getTopping() + "?");

            // Adjust the price if necessary (based on your business logic)
            selectedTopping.adjustPriceIfPremiumToppingAdd(more, isExtra);

            // Add the selected topping to the list
            selectedToppings.add(selectedTopping);

            // Debug print to check if prices are being adjusted correctly
            System.out.println("Topping: " + selectedTopping.getTopping() + ", Current Price: " + selectedTopping.getPrice());

            // Ask if the user wants to add more toppings
            addMore = Console.PromptForYesNo("Add more toppings?");
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

            for (int i = 1; i <= numberOfChips; i++) {
                // Loop through the arraylist and display chips options
                for (int j = 1; j < UI.listOfChips.size(); j++) {
                    System.out.println(j + ": " + UI.listOfChips.get(j).getBagOfChips());
                }

                int chipChoice;
                boolean validChoice = false;

                // Prompt user for chip selection and validate input
                while (!validChoice) {
                    chipChoice = Console.PromptForInt("Select a Chip (0-" + (UI.listOfChips.size() - 1) + "): ");

                    // Check if the input is within the valid range
                    if (chipChoice >= 0 && chipChoice < UI.listOfChips.size()) {
                        Chips selectedChip = UI.listOfChips.get(chipChoice);
                        System.out.println("Added: " + selectedChip);
                        UI.chipOrder.add(selectedChip);
                        validChoice = true;  // Exit loop after valid selection
                    } else {
                        System.out.println("Invalid selection. Please enter a valid number between 0 and " + (UI.listOfChips.size() - 1) + ".");
                    }
                }
            }

        return UI.chipOrder;
    }

    /**
     * Loop through an ArrayList of objects to display a list of beverages options
     * then prompt user for a beverage  and add the result to drinkOrder ArrayList
     */

    public static ArrayList<Beverage> promptForBeverage(){

        UI.drinkOrder = new ArrayList<>();
        int numberOfDrinks = Console.PromptForInt("How many drinks are you adding?");

        for (int i = 1; i <= numberOfDrinks; i++) {
            // Loop through the arraylist and display beverage options
            for (int j = 1; j < UI.listOfBeverages.size(); j++) {
                System.out.println(j + ": " + UI.listOfBeverages.get(j).getTypeOfBeverage());
            }

            // Get user selection for beverage
            int beverageChoice = Console.PromptForInt("Select a beverage (1 -" + (UI.listOfBeverages.size() - 1) + "): ");
            Beverage selectedBeverage = UI.listOfBeverages.get(beverageChoice);

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

            System.out.println(" Adding " + selectedBeverage.getTypeOfBeverage() + " (" + cupSize + ") " + selectedBeverage.getPriceOfBeverage());
        }
        return UI.drinkOrder;
    }


}

