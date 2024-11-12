package com.onleetosh.pluralsight.util;

import com.onleetosh.pluralsight.Main;
import com.onleetosh.pluralsight.order.*;
import com.onleetosh.pluralsight.topping.PremiumTopping;
import com.onleetosh.pluralsight.topping.Topping;

import java.util.ArrayList;

public class PromptOrder {

    public static ArrayList<Sandwich> promptForSandwich() {

        Order.sandwichesList = new ArrayList<>();

        ArrayList<Topping> selectedToppings;

        //prompt for number of sandwiches to make
        int sandwiches = Console.PromptForInt("How many sandwiches are you ordering?");
        int breadChoice, sandwichSize;
        double totalCost = 0.0;
        Bread selectedBread;
        boolean wantToasted;

        //output the number of sandwiches being made
        System.out.println("You are ordering " + sandwiches + " sandwiches.");


        for (int i = 1; i <= sandwiches; i++) {

            //prompt for type bread and size
            breadChoice = promptForBread();
            selectedBread = UI.listOfBread.get(breadChoice);
            sandwichSize = selectedBread.getSizeOfBread();

            selectedToppings = promptForToppings(sandwichSize);

            wantToasted = Console.PromptForYesNo("Do you want to toast?");
            Order.sandwichesList.add(new Sandwich(sandwichSize, selectedBread, selectedToppings, wantToasted));


            System.out.println("Adding " + i + "sandwich");

            // Print the final order
            System.out.println("Your order:");
            System.out.println("Bread: " + selectedBread.getTypeOfBread() + " | Size: " + sandwichSize + "\"");

            for (Topping topping : selectedToppings) {
                System.out.println(topping);
            }
            System.out.println("Toast: " + (wantToasted ? "Yes" : "No"));


            if (i == sandwiches) {
                break; // Exit the loop after creating the requested number of sandwiches
            }
        }

        return Order.sandwichesList;
    }

    // Helper method to prompt for bread selection
    public static int promptForBread() {
        System.out.println("Select a bread:");
        for (int i = 1; i < UI.listOfBread.size(); i++) {
            System.out.println(i + ": " + UI.listOfBread.get(i).getTypeOfBread() + " (" + UI.listOfBread.get(i).getSizeOfBread() + "\")");
        }

        int bread = Console.PromptForInt("Enter bread choice (1-" + (UI.listOfBread.size() - 1) + ")");
        System.out.println("Bread selected : " + UI.listOfBread.get(bread));
        return bread;

        //return Console.PromptForInt("Enter bread choice (1-" + (UI.listOfBread.size() - 1) + "): ");
    }


    // Helper method to prompt for toppings
    public static ArrayList<Topping> promptForToppings(int more) {
        ArrayList<Topping> selectedToppings = new ArrayList<>();
        boolean addMore = true;
        while (addMore) {
            System.out.println("Select a topping:");
            for (int i = 1; i < UI.listOfSandwichTopping.size(); i++) {
                Topping addTopping = UI.listOfSandwichTopping.get(i);
                System.out.println(i + ": " + addTopping);
            }

            int toppingChoice = Console.PromptForInt("Enter topping choice (0-" + (UI.listOfSandwichTopping.size() - 1) + "): ");
            System.out.println("Adding " + UI.listOfSandwichTopping.get(toppingChoice));
            Topping selectedTopping = UI.listOfSandwichTopping.get(toppingChoice);

            if (selectedTopping instanceof PremiumTopping) {
                boolean isExtra = Console.PromptForYesNo("Do you want extra " + selectedTopping.getTopping() + "?");
                selectedTopping.adjustPriceIfPremiumToppingAdd(more, isExtra);
            }

            selectedToppings.add(selectedTopping);
            addMore = Console.PromptForYesNo("Add more toppings?");
        }
        return selectedToppings;
    }
    // Helper method to prompt for toppings
    public static ArrayList<Topping> promptForToppings2(int size) {
        ArrayList<Topping> selectedToppings = new ArrayList<>();
        boolean addMore = true;
        while (addMore) {
            System.out.println("Select a topping:");
            for (int i = 1; i < UI.listOfSandwichTopping.size(); i++) {
                System.out.println(i + ": " + UI.listOfSandwichTopping.get(i));
            }

            int toppingChoice = Console.PromptForInt("Enter topping choice (1-" + (UI.listOfSandwichTopping.size()) + "): ");

            Topping selectedTopping = UI.listOfSandwichTopping.get(toppingChoice - 1);  // Adjust for 0-index

            // Inside promptForToppings method
            if (selectedTopping instanceof PremiumTopping) {
                PremiumTopping selectedCondiment = (PremiumTopping) selectedTopping;

                // Only adjust price if the topping is premium
                if (selectedCondiment.equals("meat") || selectedCondiment.equals("cheese")) {
                    boolean isExtra = Console.PromptForYesNo("Do you want extra " + selectedCondiment.getTopping() + "?");
                    selectedCondiment.adjustPriceIfPremiumToppingAdd(size, isExtra);
                }
            }
            selectedToppings.add(selectedTopping);
            addMore = Console.PromptForYesNo("Add more toppings?");
        }
        return selectedToppings;
    }


    public static ArrayList<Chips> promptForChips(){
        UI.chipOrder = new ArrayList<>();

        //prompt for number of chips to add
        int numberOfChips = Console.PromptForInt("How many Chips are you adding?");

        for (int i = 1; i <= numberOfChips; i++) {
            // Loop through the arraylist and display chips options
            for (int j = 1; j < UI.listOfChips.size(); j++) {
                System.out.println(j + ": " + UI.listOfChips.get(j).getBagOfChips());
            }

            //prompt user for chips to add
            int chipChoice = Console.PromptForInt("Select a Chip (0-" + (UI.listOfChips.size() - 1) + "): ");
            Chips selectedChip = UI.listOfChips.get(chipChoice);

            System.out.println("Order Update: Adding  " + selectedChip );

            UI.chipOrder.add(selectedChip);
        }
        return UI.chipOrder;
    }


    public static ArrayList<Beverage> promptForBeverage(){

        UI.drinkOrder = new ArrayList<>();
        int numberOfDrinks = Console.PromptForInt("How many drinks are you adding?");

        for (int i = 1; i <= numberOfDrinks; i++) {
            // Loop through the arraylist and display beverage options
            for (int j = 1; j < UI.listOfBeverages.size(); j++) {
                System.out.println(j + ": " + UI.listOfBeverages.get(j).getTypeOfBeverage());
            }

            // Get user selection for beverage
            int beverageChoice = Console.PromptForInt("Select a beverage (0-" + (UI.listOfBeverages.size() - 1) + "): ");
            Beverage selectedBeverage = UI.listOfBeverages.get(beverageChoice);

            // Prompt for cup size
            String cupSize;
            boolean validSize = false;

            do {
                cupSize = Console.PromptForString("Select cup size: [S]mall, [M]edium, [L]arge").toUpperCase();
                if (cupSize.equalsIgnoreCase("S") ||
                        cupSize.equalsIgnoreCase("M") ||
                        cupSize.equalsIgnoreCase("L")) {
                    validSize = true;
                } else {
                    System.out.println("Invalid size. Please choose [S], [M], or [L].");
                }
            } while (!validSize);

            // Assign cup size to the selected beverage
            selectedBeverage.setSizeOfCup(cupSize);
            UI.drinkOrder.add(selectedBeverage);

            System.out.println("Update order: Adding " + selectedBeverage.getTypeOfBeverage() + " (" + cupSize + ") " + selectedBeverage.getPriceOfBeverage());
        }
        return UI.drinkOrder;
    }




    public static String selectBeverageSize(){
        String cupSize;
        boolean validSize = false;

        do {
            cupSize = Console.PromptForString("Select cup size: [S]mall, [M]edium, [L]arge");
            if (cupSize.equalsIgnoreCase("S") ||
                    cupSize.equalsIgnoreCase("M") ||
                    cupSize.equalsIgnoreCase("L")) {
                validSize = true;
            } else {
                System.out.println("Invalid size. Please choose [S], [M], or [L].");
            }
        } while (!validSize);

        return cupSize;  // Return the valid size choice (S, M, or L)

    }




}

