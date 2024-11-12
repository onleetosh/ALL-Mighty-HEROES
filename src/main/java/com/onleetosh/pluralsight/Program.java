package com.onleetosh.pluralsight;

import com.onleetosh.pluralsight.order.Beverage;
import com.onleetosh.pluralsight.order.Bread;
import com.onleetosh.pluralsight.order.Chips;
import com.onleetosh.pluralsight.order.Sandwich;
import com.onleetosh.pluralsight.topping.PremiumTopping;
import com.onleetosh.pluralsight.topping.RegularTopping;
import com.onleetosh.pluralsight.topping.Sauce;
import com.onleetosh.pluralsight.topping.Topping;
import com.onleetosh.pluralsight.util.Console;

import java.util.ArrayList;

public class Program {


    static ArrayList<Topping> sandwichTopping;
    static ArrayList<Bread> bread;
    static ArrayList<Beverage> beverages;
    static ArrayList<Chips> chips;

    public static void main(String[] args) {

        sandwichTopping = initializeToppings();
        bread = initializeBread();
        beverages = initializeBeverage();
        chips = initializeChips();

        System.out.println("Welcome to the sandwich shop \nLet's make an order");

        // Step 1: Select bread
        int selectBread = promptForBread();
        Bread breadChoice = bread.get(selectBread);

        // Step 2: Select size
        int sandwichSize = breadChoice.getSizeOfBread();

        // Step 3: Select toppings
        ArrayList<Topping> addToppings = promptForToppings(sandwichSize);

        // Step 4: Toast option
        boolean wantToast = Console.PromptForYesNo("Do you want to toast?");

        // Print the final order
        System.out.println("Your order:");
        System.out.println("Bread: " + breadChoice.getTypeOfBread() + " | Size: " + sandwichSize + " $" + breadChoice.getPrice());
        for (Topping topping : addToppings) {
            System.out.println(topping);
        }
        System.out.println("Toast: " + (wantToast ? "Yes" : "No"));

        Sandwich newSandwich = new Sandwich(sandwichSize, breadChoice, addToppings, wantToast);
        //System.out.println("Total cost of sandwich : " + totalCostOfSandwich(breadChoice, addToppings) );
    }



    /**
     * Initialize drink objects and add them to an ArrayList of Beverage
     */

    public static ArrayList<Beverage> initializeBeverages(){
        beverages = new ArrayList<Beverage>();
        beverages.add(new Beverage("------"));
        beverages.add(new Beverage("Spirit"));
        beverages.add(new Beverage("Coke"));
        beverages.add(new Beverage("Fruit Punch"));
        beverages.add(new Beverage("Ginger Ale"));
        beverages.add(new Beverage("Lemonade"));
        beverages.add(new Beverage("Iced Tea"));
        beverages.add(new Beverage("Spirit"));

        return beverages;
    }


    /**
     * Initialize chip objects and add them to an ArrayList of Chips
     */
    public static ArrayList<Chips> initializeChips(){
        chips = new ArrayList<Chips>();
        chips.add(new Chips("---"));
        chips.add(new Chips("BQQ Rap Snacks"));
        chips.add(new Chips("Cheetos"));
        chips.add(new Chips("Original Lay's" ));
        chips.add(new Chips("Ranch Doritos"));
        chips.add(new Chips("Chedder Sunchips"));
        chips.add(new Chips("Fritos"));
        chips.add(new Chips("Nacho Cheese Doritos" ));

        return chips;


    }

    /**
     * BEVERAGES
     * @return
     */

    public static boolean promptForDrink(){

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
                }
                else {
                    System.out.println("Invalid size. Please choose [S], [M], or [L].");
                }
            } while (!validSize);

            // Assign cup size to the selected beverage
            selectedBeverage.setSizeOfCup(cupSize);
            return true;
        }

        // Return false if no beverage is selected
        return false;

    }


    /**
     * SANDWICH
     */


    // Calculate the total cost of the sandwich, including bread and toppings
    public static double totalCostOfSandwich(Bread selectedBread, ArrayList<Topping> toppings) {
        double totalCost = selectedBread.getPrice();  // Start with the price of the bread

        // Add the cost of each topping (regular or premium)
        for (Topping topping : toppings) {
            totalCost += topping.getPrice();
        }

        return totalCost;
    }

    // Helper method to prompt for bread selection
    public static int promptForBread() {
        System.out.println("Select a bread:");
        for (int i = 1; i < bread.size(); i++) {
            System.out.println(i + ": " + bread.get(i).getTypeOfBread() + " (" + bread.get(i).getSizeOfBread() + "\")");
        }
        return Console.PromptForInt("Enter bread choice (1-" + (bread.size() - 1) + "): ");
    }

    /**
     * TOPPINGS
     */

    // Helper method to prompt for toppings
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
     * Initialize bread objects and add them to an ArrayList of Bread
     */

    public static ArrayList<Bread> initializeBread() {
        bread = new ArrayList<Bread>();
        bread.add(new Bread(" ",4)); //hold position 0
        bread.add(new Bread("white", 4));
        bread.add(new Bread("white", 8));
        bread.add(new Bread("white", 12));
        bread.add(new Bread("wheat", 4));
        bread.add(new Bread("wheat", 8));
        bread.add(new Bread("wheat", 12));
        bread.add(new Bread("wrap", 4));
        bread.add(new Bread("wrap", 8));
        bread.add(new Bread("wrap", 12));
        bread.add(new Bread("rye", 4));
        bread.add(new Bread("rye", 8));
        bread.add(new Bread("rye", 12));

        return bread;
    }

    /**
     * Initialize condiment objects and add them to an ArrayList of Condiments
     */
    public static ArrayList<Topping> initializeToppings() {
        sandwichTopping = new ArrayList<>();
        sandwichTopping.add(new Topping(" "," ", 0 )); //hold position 0
        // Regular toppings
        sandwichTopping.add(new RegularTopping("lettuce", "regular", 0.0));
        sandwichTopping.add(new RegularTopping("peppers", "regular", 0.0));
        sandwichTopping.add(new RegularTopping("red onions", "regular", 0.0));
        sandwichTopping.add(new RegularTopping("jalapenos", "regular", 0.0));
        sandwichTopping.add(new RegularTopping("cucumber", "regular", 0.0));
        sandwichTopping.add(new RegularTopping("pickles", "regular", 0.0));

        //TODO: change name to condiments
        // Sauces
        sandwichTopping.add(new Sauce("honey mustard", "sauce", 0.0));
        sandwichTopping.add(new Sauce("ranch", "sauce", 0.0));
        sandwichTopping.add(new Sauce("mayo", "sauce", 0.0));
        sandwichTopping.add(new Sauce("mustard", "sauce", 0.0));
        sandwichTopping.add(new Sauce("ketchup", "sauce", 0.0));

        // Premium toppings (Meats and Cheese)
        sandwichTopping.add(new PremiumTopping("grill chicken", "meat", 1.00));
        sandwichTopping.add(new PremiumTopping("bacon", "meat", 1.00));
        sandwichTopping.add(new PremiumTopping("roast beef", "meat", 1.00));
        sandwichTopping.add(new PremiumTopping("salami", "meat", 1.00));
        sandwichTopping.add(new PremiumTopping("ham", "meat", 1.00));
        sandwichTopping.add(new PremiumTopping("steak", "meat", 1.00));
        sandwichTopping.add(new PremiumTopping("provolone", "cheese", 1.00));
        sandwichTopping.add(new PremiumTopping("cheddar", "cheese", 1.00));
        sandwichTopping.add(new PremiumTopping("swiss", "cheese", 1.00));
        sandwichTopping.add(new PremiumTopping("american", "cheese", 1.00));

        return sandwichTopping;
    }
    /**
     * Initialize beverage objects and add them to an ArrayList of Drinks
     */
    public static ArrayList<Beverage> initializeBeverage(){
        beverages = new ArrayList<Beverage>();
        beverages.add(new Beverage(" HOLD POSITION 0 "));
        beverages.add(new Beverage("Spirit"));
        beverages.add(new Beverage("Lemonade"));
        beverages.add(new Beverage("Iced Tea"));
        beverages.add(new Beverage("Coke"));
        beverages.add(new Beverage("Ginger Ale"));
        beverages.add(new Beverage("Seltzer"));

        return beverages;

    }
}
