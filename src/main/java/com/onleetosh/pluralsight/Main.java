package com.onleetosh.pluralsight;

import com.onleetosh.pluralsight.order.Beverage;
import com.onleetosh.pluralsight.order.Bread;
import com.onleetosh.pluralsight.order.Chips;
import com.onleetosh.pluralsight.order.Sandwich;
import com.onleetosh.pluralsight.topping.PremiumTopping;
import com.onleetosh.pluralsight.topping.Topping;
import com.onleetosh.pluralsight.util.Console;
import com.onleetosh.pluralsight.util.InitializeObject;
import com.onleetosh.pluralsight.util.UI;

import java.util.ArrayList;

public class Main {

    static ArrayList<Topping> sandwichTopping;
    static ArrayList<Bread> bread;
    static ArrayList<Beverage> beverages;
    static ArrayList<Chips> chips;

    public static void main(String[] args) {
        // Initialize the ingredients
        bread = initializeBread();
        beverages = initializeBeverage();
        chips = initializeChips();
        sandwichTopping = InitializeObject.initializeToppings();

        // Containers for the full order
        ArrayList<Sandwich> sandwichOrders = new ArrayList<>();
        ArrayList<Beverage> drinkOrders = new ArrayList<>();
        ArrayList<Chips> chipOrders = new ArrayList<>();

        // Prompt the user for sandwiches
        int numSandwiches = Console.PromptForInt("How many sandwiches would you like to order?");
        for (int i = 0; i < numSandwiches; i++) {
            System.out.println("Order sandwich #" + (i + 1));

            // Step 1: Select bread
            int selectBread = promptForBread();
            Bread breadChoice = bread.get(selectBread);

            // Step 2: Select size
            int sandwichSize = breadChoice.getSizeOfBread();

            // Step 3: Select toppings
            ArrayList<Topping> addToppings = promptForToppings(sandwichSize);

            // Step 4: Toast option
            boolean wantToast = Console.PromptForYesNo("Do you want to toast?");

            // Add the sandwich to the order
            sandwichOrders.add(new Sandwich(sandwichSize, breadChoice, addToppings, wantToast));
        }

        // Prompt the user for drinks
        int numDrinks = Console.PromptForInt("How many drinks would you like to order?");
        for (int i = 0; i < numDrinks; i++) {
            boolean drinkAdded = promptForDrink();
            if (drinkAdded) {
                System.out.println("Drink #" + (i + 1) + " added.");
            }
        }

        // Prompt the user for chips
        int numChips = Console.PromptForInt("How many chips would you like to order?");
        for (int i = 0; i < numChips; i++) {
            Chips selectedChips = promptForChips();
            chipOrders.add(selectedChips);
        }

        // Display full order summary
        displayOrderSummary(sandwichOrders, drinkOrders, chipOrders);
    }


    // Initialize bread options
    public static ArrayList<Bread> initializeBread() {
        UI.listOfBread = new ArrayList<>();
        UI.listOfBread .add(new Bread(" ",4));
        UI.listOfBread .add(new Bread("white", 4));
        UI.listOfBread .add(new Bread("white", 8));
        UI.listOfBread .add(new Bread("white", 12));
        UI.listOfBread .add(new Bread("wheat", 4));
        UI.listOfBread .add(new Bread("wheat", 8));
        UI.listOfBread .add(new Bread("wheat", 12));
        UI.listOfBread .add(new Bread("wrap", 4));
        UI.listOfBread .add(new Bread("wrap", 8));
        UI.listOfBread .add(new Bread("wrap", 12));
        UI.listOfBread .add(new Bread("rye", 4));
        UI.listOfBread .add(new Bread("rye", 8));
        UI.listOfBread .add(new Bread("rye", 12));

        return UI.listOfBread ;
    }

    /**
     * Initialize drink objects and add them to an ArrayList of Beverage
     */
    public static ArrayList<Beverage> initializeBeverage() {
        beverages = new ArrayList<>();
        beverages.add(new Beverage(" HOLD POSITION 0 "));
        beverages.add(new Beverage("Spirit"));
        beverages.add(new Beverage("Lemonade"));
        beverages.add(new Beverage("Iced Tea"));
        beverages.add(new Beverage("Coke"));
        beverages.add(new Beverage("Ginger Ale"));
        beverages.add(new Beverage("Seltzer"));
        return beverages;
    }

    /**
     * Initialize chip objects and add them to an ArrayList of Chips
     */
    public static ArrayList<Chips> initializeChips() {
        chips = new ArrayList<>();
        chips.add(new Chips("---"));
        chips.add(new Chips("BQQ Rap Snacks"));
        chips.add(new Chips("Cheetos"));
        chips.add(new Chips("Original Lay's"));
        chips.add(new Chips("Ranch Doritos"));
        chips.add(new Chips("Chedder Sunchips"));
        chips.add(new Chips("Fritos"));
        chips.add(new Chips("Nacho Cheese Doritos"));
        return chips;
    }

    /**
     * Prompt for bread selection
     */
    public static int promptForBread() {
        System.out.println("Select a bread:");
        for (int i = 1; i < bread.size(); i++) {
            System.out.println(i + ": " + bread.get(i).getTypeOfBread() + " (" + bread.get(i).getSizeOfBread() + "\")");
        }
        return Console.PromptForInt("Enter bread choice (1-" + (bread.size() - 1) + "): ");
    }

    /**
     * Helper method to prompt for toppings
     */
    public static ArrayList<Topping> promptForToppings(int size) {
        ArrayList<Topping> selectedToppings = new ArrayList<>();
        boolean addMore = true;
        while (addMore) {
            System.out.println("Select a topping:");
            for (int i = 1; i < sandwichTopping.size(); i++) {
                System.out.println(i + ": " + sandwichTopping.get(i));
            }
            int toppingChoice = Console.PromptForInt("Enter topping choice (1-" + (sandwichTopping.size() - 1) + "): ");
            Topping selectedTopping = sandwichTopping.get(toppingChoice);

            // Check for extra premium toppings
            if (selectedTopping instanceof PremiumTopping) {
                boolean isExtra = Console.PromptForYesNo("Do you want extra " + selectedTopping.getTopping() + "?");
                selectedTopping.adjustPriceIfPremiumToppingAdd(size, isExtra);
            }
            selectedToppings.add(selectedTopping);
            addMore = Console.PromptForYesNo("Add more toppings?");
        }
        return selectedToppings;
    }

    /**
     * Prompt for a drink
     */
    public static boolean promptForDrink() {
        boolean wantsBeverage = Console.PromptForYesNo("Add a drink?");
        if (wantsBeverage) {
            // Loop through the arraylist and display beverage options
            for (int i = 0; i < beverages.size(); i++) {
                System.out.println(i + ": " + beverages.get(i).getTypeOfBeverage());
            }

            // Get user selection for beverage
            int beverageChoice = Console.PromptForInt("Select a beverage (0-" + (beverages.size() - 1) + "): ");
            Beverage selectedBeverage = beverages.get(beverageChoice);

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
            return true;
        }
        return false;
    }

    /**
     * Prompt for a chip
     */
    public static Chips promptForChips() {
        System.out.println("Select a chip:");
        for (int i = 1; i < chips.size(); i++) {
            System.out.println(i + ": " + chips.get(i).getBagOfChips());
        }
        int chipChoice = Console.PromptForInt("Enter chip choice (1-" + (chips.size() - 1) + "): ");
        return chips.get(chipChoice);
    }

    /**
     * Display full order summary
     */
    public static void displayOrderSummary(ArrayList<Sandwich> sandwiches, ArrayList<Beverage> drinks, ArrayList<Chips> chips) {
        double totalCost = 0.0;

        // Display sandwiches
        System.out.println("\n--- Your Sandwiches ---");
        for (Sandwich sandwich : sandwiches) {
            System.out.println(sandwich);
            totalCost += sandwich.getTotalCost();
        }

        // Display drinks
        System.out.println("\n--- Your Drinks ---");
        for (Beverage drink : drinks) {
            System.out.println(drink);
            totalCost += drink.getPriceOfBeverage();  // Assume Beverage has a getPrice() method
        }

        // Display chips
        System.out.println("\n--- Your Chips ---");
        for (Chips chip : chips) {
            System.out.println(chip);
            totalCost += chip.getPriceOfChips();  // Assume Chips has a getPrice() method
        }

        // Display total cost
        System.out.println("\nTotal Price: $" + totalCost);
    }

    // Other methods like totalCostOfSandwich() go here...
}