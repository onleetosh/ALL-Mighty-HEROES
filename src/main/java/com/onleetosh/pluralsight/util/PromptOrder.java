package com.onleetosh.pluralsight.util;

import com.onleetosh.pluralsight.addon.Beverage;
import com.onleetosh.pluralsight.addon.Chips;
import com.onleetosh.pluralsight.addon.Cookie;
import com.onleetosh.pluralsight.hero.Bread;
import com.onleetosh.pluralsight.hero.Hero;
import com.onleetosh.pluralsight.hero.topping.Topping;
import com.onleetosh.pluralsight.hero.topping.*;

import java.util.ArrayList;

public class PromptOrder {


    private static Bread selectedBread;
    private static ArrayList<Topping> selectedToppings;
    private static ArrayList<Beverage> drinkOrder;
    private static ArrayList<Chips> chipOrder;
    private static ArrayList<Hero> sandwichOrder;
    private static ArrayList<Cookie> cookieOrder;




    /**
     *  Prompt user to create a sandwich object and add the result to Sandwich orders ArrayList
     */

    public static ArrayList<Hero> promptForSandwich() {
        ArrayList<Hero> sandwichOrder = new ArrayList<>();
        int request = -1;

        // Prompt for the number of heroes
        while (request < 0) {
            try {
                request = Console.PromptForInt("How many heroes are you ordering? ");
                if (request < 1) throw new IllegalArgumentException("You must order at least 1 hero.");
            } catch (Exception e) {
                System.out.println("Please enter a valid number (1 or more).");
                request = -1;
            }
        }

        // Output the requested number of sandwiches
        System.out.println("You are ordering " + request + " heroes.\n");

        // Loop through to build each sandwich
        for (int i = 1; i <= request; i++) {
            System.out.println("Building Hero " + i + ":");

            // Get bread choice
            Bread selectedBread = getBreadSelection();

            // Get sandwich size
            int sandwichSize = selectedBread.getSizeOfBread();

            // Get toppings
            ArrayList<Topping> selectedToppings = getToppingForPrompt(sandwichSize);

            // Ask if user wants the sandwich toasted
            boolean wantToasted = Console.PromptForYesNo("Do you want to toast this hero? ");

            // Create a new Hero sandwich object
            Hero newSandwich = new Hero(sandwichSize, selectedBread, selectedToppings, wantToasted);
            sandwichOrder.add(newSandwich);

            // Confirm sandwich creation
            System.out.println("\nHero " + i + " confirmed:");
            System.out.println("Bread: " + selectedBread.getTypeOfBread() +
                    " | Size: " + sandwichSize + "\"" +
                    " | $" + String.format("%.2f", selectedBread.getPrice(sandwichSize)));

            // Display selected toppings
            System.out.println("Toppings:");
            for (Topping topping : selectedToppings) {
                System.out.println("- " + topping.getTopping() +
                        (topping.isExtra() ? " (extra)" : "") +
                        " | $" + String.format("%.2f", topping.getPrice()));
            }

            // Toast status
            System.out.println("Toasted: " + (wantToasted ? "Yes" : "No"));

            // Display total cost of the sandwich
            System.out.printf("Total Cost: $%.2f\n\n", newSandwich.getTotalCostOfSandwich());
        }

        return sandwichOrder;
    }

    public static Bread getBreadSelection() {
        while (true) {
            try {
                // Display available bread types
                System.out.println("Select a bread:");
                for (int i = 0; i < UI.breadList.size(); i++) {
                    System.out.println((i + 1) + ": " + UI.breadList.get(i).getTypeOfBread());
                }

                // Prompt user for bread type
                int breadChoice = Console.PromptForInt("Enter bread choice (1-" + UI.breadList.size() + "): ");
                if (breadChoice < 1 || breadChoice > UI.breadList.size()) {
                    throw new IllegalArgumentException("Invalid choice. Please select a valid bread option.");
                }
                Bread selectedBread = UI.breadList.get(breadChoice - 1);

                // Prompt user for bread size
                System.out.println("Available sizes: 4\" ($5.50), 8\" ($7.00), 12\" ($8.50)");
                int sizeChoice = Console.PromptForInt("Enter bread size (4, 8, or 12): ");
                if (sizeChoice != 4 && sizeChoice != 8 && sizeChoice != 12) {
                    throw new IllegalArgumentException("Invalid size. Allowed sizes are 4, 8, or 12 inches.");
                }

                // Set size and cost for the selected bread
                selectedBread.setSizeOfBread(sizeChoice);
                double cost = selectedBread.getPrice(sizeChoice);
                selectedBread.setPrice(cost);

                // Confirm selection
                System.out.println("You selected: " + selectedBread.getTypeOfBread() +
                        " (" + sizeChoice + "\"), $" + cost);

                return selectedBread;

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage() + " Please try again.");
            }
        }
    }

    public static ArrayList<Topping> getToppingForPrompt(int more) {
        selectedToppings = new ArrayList<>();

        // Filter the heroToppingList into categories
        ArrayList<Topping> meatToppings = new ArrayList<>();
        ArrayList<Topping> cheeseToppings = new ArrayList<>();
        ArrayList<Topping> veggieToppings = new ArrayList<>();
        ArrayList<Topping> sauceToppings = new ArrayList<>();


        for (Topping topping : UI.heroToppingList) {
            if (topping.getType().equalsIgnoreCase("meat")) {
                meatToppings.add(topping);
            } else if (topping.getType().equalsIgnoreCase("cheese")) {
                cheeseToppings.add(topping);
            } else if (topping.getType().equalsIgnoreCase("veggie")) {
                veggieToppings.add(topping);
            } else if (topping.getType().equalsIgnoreCase("sauce")) {
                // Create a separate category for sauces if needed
                sauceToppings.add(topping);
            }
        }

        // Prompt user for toppings in each category
        selectedToppings.addAll(promptForToppings("meat", meatToppings, more));
        selectedToppings.addAll(promptForToppings("cheese", cheeseToppings, more));
        selectedToppings.addAll(promptForToppings("veggie", veggieToppings, more));
        selectedToppings.addAll(promptForToppings("sauce", sauceToppings, more));

        return selectedToppings;
    }

    public static ArrayList<Topping> promptForToppings(String type, ArrayList<Topping> toppings, int more) {
        ArrayList<Topping> selectedToppings = new ArrayList<>();
        boolean addMore = true;

        System.out.println("Select All " + type + " Toppings:");

        while (addMore) {
            try {
                // Display the toppings for the given category
                for (int i = 0; i < toppings.size(); i++) {
                    Topping topping = toppings.get(i);
                    System.out.println((i + 1) + ": " + topping.displayToppings());
                }

                // Prompt user for topping choice
                int input = Console.PromptForInt("Enter topping choice (1-" + toppings.size() + "): ");
                Topping selectedTopping = toppings.get(input - 1);

                boolean isExtra = false;
                try {
                    // Always prompt for extra topping
                    isExtra = Console.PromptForYesNo("Do you want extra " + selectedTopping.getTopping() + "? ");
                } catch (Exception e) {
                    System.out.println("Please enter Y or N");
                }

                // Adjust the price if topping is premium and extra
                selectedTopping.adjustPriceIfPremiumToppingAdd(more, isExtra);

                if (isExtra) {
                    selectedTopping.setExtra(true);
                }

                // Add the selected topping to the list
                selectedToppings.add(selectedTopping);
                System.out.println("Got it! " + selectedTopping.getTopping() + " has been added, $" + selectedTopping.getPrice());

                // Prompt for more toppings from this category
                addMore = Console.PromptForYesNo("Add more " + type + " toppings?");
            } catch (Exception e) {
                System.out.println("Please enter a valid choice (1-" + toppings.size() + ")");
            }
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
