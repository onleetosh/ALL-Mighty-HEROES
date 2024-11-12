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
import com.onleetosh.pluralsight.util.UI;

import java.util.ArrayList;

public class Main {

    static ArrayList<Topping> sandwichTopping;
    static ArrayList<Bread> bread;
    static ArrayList<Sandwich> sandwichOrders;
    static ArrayList<Beverage> beverages;
    static ArrayList<Chips> chips;

    public static void main(String[] args) {

         sandwichTopping = initializeToppings();
        bread = initializeBread();
        beverages = initializeBeverages();
        chips = initializeChip();


        sandwichOrders = new ArrayList<Sandwich>();

        ArrayList<Topping> selectedToppings;
        ArrayList<Beverage> drinkList = new ArrayList<>();


        System.out.println("Welcome to the sandwich shop \nLet's make an order");

        //prompt for number of sandwiches to make
        int sandwiches = Console.PromptForInt("How many sandwiches are you ordering?");
        int breadChoice, sandwichSize;
        double totalCost = 0.0;
        Bread selectedBread;
        boolean wantToasted;

        //output the number of sandwiches being made
        System.out.println("You are ordering " + sandwiches + " sandwiches.");


        for ( int i = 1 ; i <= sandwiches; i++) {

            //prompt for type bread and size
            breadChoice = promptForBread();
            selectedBread = bread.get(breadChoice);
            sandwichSize = selectedBread.getSizeOfBread();

            selectedToppings = promptForToppings(sandwichSize);

            wantToasted = Console.PromptForYesNo("Do you want to toast?");
            sandwichOrders.add(new Sandwich(sandwichSize, selectedBread, selectedToppings, wantToasted));


           System.out.println("Adding sandwich " + i);
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
            // Step 4: Prompt for beverages
            ArrayList<Beverage> wantsDrink = promptForBeverage();
            if (wantsDrink.equals("Yes")) {
                String selectedDrink = selectedBeverage();// Implement a method to select a beverage
                drinkList.add(new Beverage(selectedDrink));
                totalCost += drinkList.get(i).getPriceOfBeverage();
            }

            // Calculate total sandwich cost
            totalCost += totalOrderPrice(selectedBread, selectedToppings);
        }




        displaySandwiches(sandwichOrders);

        //totalOrderPrice(selectedBread, selectedToppings, sandwiches);
        //System.out.println("Total cost of sandwich : " + totalCostOfSandwich(selectedBread, selectedToppings) );

    }


    /**
     * Initialize drink objects and add them to an ArrayList of Beverage
     */

    public static ArrayList<Beverage> initializeBeverages(){
        beverages = new ArrayList<Beverage>();
        beverages.add(new Beverage("Spirit"));
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
    public static ArrayList<Chips> initializeChip(){
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
     *
     * @return
     */

    public static String selectBeverage(){
        System.out.println("Select a bevarage:");
        for (int i = 1; i < beverages.size(); i++) {
            System.out.println(i + ": " + beverages.get(i).getTypeOfBeverage());
        }
        return Console.PromptForString("Enter Drink choice (1-" + (beverages.size() - 1) + "): ");
    }

    public static String selectedBeverage(){
        return selectBeverage() + selectBeverageSize();
    }


    public static String selectBeverageSize(){
        System.out.println("Select a size:");
        for (int i = 1; i < beverages.size(); i++) {
            System.out.println(i + ": " + beverages.get(i).getSizeOfCup());
        }

        return Console.PromptForString("Enter cup size choice (1-" + (beverages.size() - 1) + "): ");

    }
    public static ArrayList<Beverage> promptForBeverage(){

        ArrayList<Beverage> drinkOrder = new ArrayList<>();
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
            drinkOrder.add(selectedBeverage);
        }
        return drinkOrder;
    }


    public static void displaySandwiches(ArrayList<Sandwich> sandwiches){
        for (Sandwich sandwich : sandwiches) {
            System.out.println(sandwich);
        }
    }

    public static double totalOrderPrice(Bread selectedBread, ArrayList<Topping> toppings){
        return totalCostOfSingleSandwich(selectedBread, toppings);

    }
    // Calculate the total cost of the sandwich, including bread and toppings
    public static double totalCostOfSingleSandwich(Bread selectedBread, ArrayList<Topping> toppings) {
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
        for (int i = 0; i < UI.listOfBread.size(); i++) {
            System.out.println(i + ": " + bread.get(i).getTypeOfBread() + " (" + bread.get(i).getSizeOfBread() + "\")");
        }
        return Console.PromptForInt("Enter bread choice (1-" + (UI.listOfBread.size() - 1) + "): ");
    }

    // Helper method to prompt for toppings
    public static ArrayList<Topping> promptForToppings(int more) {
        ArrayList<Topping> selectedToppings = new ArrayList<>();
        boolean addMore = true;
        while (addMore) {
            System.out.println("Select a topping:");
            for (int i = 1; i < sandwichTopping.size(); i++) {
                Topping addTopping = sandwichTopping.get(i);
                System.out.println(i + ": " + addTopping);
            }

            int toppingChoice = Console.PromptForInt("Enter topping choice (0-" + (sandwichTopping.size() - 1) + "): ");
            Topping selectedTopping = sandwichTopping.get(toppingChoice);

            if (selectedTopping instanceof PremiumTopping) {
                boolean isExtra = Console.PromptForYesNo("Do you want extra " + selectedTopping.getTopping() + "?");
                selectedTopping.adjustPriceIfPremiumToppingAdd(more, isExtra);
            }

            selectedToppings.add(selectedTopping);
            addMore = Console.PromptForYesNo("Add more toppings?");
        }
        return selectedToppings;
    }

    // Initialize bread options
    public static ArrayList<Bread> initializeBread() {
        bread = new ArrayList<>();
        bread.add(new Bread(" ",4));
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

    // Initialize topping options
    public static ArrayList<Topping> initializeToppings() {
        sandwichTopping = new ArrayList<>();

        // Regular toppings
        sandwichTopping.add(new Topping(" "," ", 0 ));
        sandwichTopping.add(new RegularTopping("lettuce", "regular", 0.0)); //0
        sandwichTopping.add(new RegularTopping("peppers", "regular", 0.0)); //1
        sandwichTopping.add(new RegularTopping("red onions", "regular", 0.0)); //2
        sandwichTopping.add(new RegularTopping("jalapenos", "regular", 0.0)); //3
        sandwichTopping.add(new RegularTopping("cucumber", "regular", 0.0)); //4
        sandwichTopping.add(new RegularTopping("pickles", "regular", 0.0)); //5

        // Sauces
        sandwichTopping.add(new Sauce("honey mustard", "sauce", 0.0)); //5
        sandwichTopping.add(new Sauce("ranch", "sauce", 0.0)); //7
        sandwichTopping.add(new Sauce("mayo", "sauce", 0.0)); //8
        sandwichTopping.add(new Sauce("mustard", "sauce", 0.0)); //9
        sandwichTopping.add(new Sauce("ketchup", "sauce", 0.0)); //10

        // Premium toppings (Meats and Cheese)
        sandwichTopping.add(new PremiumTopping("grill chicken", "meat", 1.00)); //11
        sandwichTopping.add(new PremiumTopping("bacon", "meat", 1.00)); //12
        sandwichTopping.add(new PremiumTopping("roast beef", "meat", 1.00)); //13
        sandwichTopping.add(new PremiumTopping("salami", "meat", 1.00)); //14
        sandwichTopping.add(new PremiumTopping("ham", "meat", 1.00)); //15
        sandwichTopping.add(new PremiumTopping("steak", "meat", 1.00)); //16
        sandwichTopping.add(new PremiumTopping("provolone", "cheese", 1.00)); //17
        sandwichTopping.add(new PremiumTopping("cheddar", "cheese", 1.00)); //18
        sandwichTopping.add(new PremiumTopping("swiss", "cheese", 1.00)); //19
        sandwichTopping.add(new PremiumTopping("american", "cheese", 1.00)); //20

        return sandwichTopping;
    }
}
