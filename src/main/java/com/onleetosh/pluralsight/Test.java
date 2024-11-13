package com.onleetosh.pluralsight;

import com.onleetosh.pluralsight.order.sandwich.Bread;
import com.onleetosh.pluralsight.order.sandwich.Sandwich;
import com.onleetosh.pluralsight.order.sandwich.Topping;
import com.onleetosh.pluralsight.util.Console;
import com.onleetosh.pluralsight.util.UI;

import java.util.ArrayList;

public class Test {

        private static ArrayList<Sandwich> sandwichOrders2;
        private static ArrayList<Bread> bread2;
        private static ArrayList<Topping> sandwichTopping2;

        public static void main(String[] args) {
            sandwichTopping2 = initializeToppings();  // Assuming this initializes available toppings
            bread2 = initializeBread();  // Assuming this initializes available bread options
            sandwichOrders2 = new ArrayList<>();

            System.out.println("Welcome to the sandwich shop \nLet's make an order");

            // Step 1: Get the number of sandwiches from the user
            int sandwiches = Console.PromptForInt("How many sandwiches are you ordering?");
            System.out.println("You are ordering " + sandwiches + " sandwiches.");

            double totalOrderCost = 0.0; // Variable to store the total order price

            for (int i = 0; i <= sandwiches; i++) {
                System.out.println("\n--- Sandwich " + i + " ---");

                // Step 2: Select bread
                int breadChoice = promptForBread2();
                Bread selectedBread = bread2.get(breadChoice);

                // Step 3: Get size of bread
                int size = selectedBread.getSizeOfBread();

                // Step 4: Select toppings
                ArrayList<Topping> selectedToppings = promptForToppings2(size);

                // Step 5: Ask if the user wants their sandwich toasted
                boolean wantToast = Console.PromptForYesNo("Do you want to toast your sandwich?");

                // Step 6: Add sandwich to the order
                Sandwich sandwich = new Sandwich(size, selectedBread, selectedToppings, wantToast);
                sandwichOrders2.add(sandwich);

                // Step 7: Calculate the price of the current sandwich
                double sandwichCost = totalCostOfSingleSandwich(selectedBread, selectedToppings);
                System.out.println("Cost of this sandwich: $" + sandwichCost);

                // Step 8: Add the sandwich cost to the total order cost
                totalOrderCost += sandwichCost;
            }

            // Step 9: Display the total cost of all sandwiches
            System.out.println("\n--- Order Summary ---");
            displaySandwiches(sandwichOrders2);  // This method should display the details of all sandwiches ordered

            System.out.println("Total cost of the order: $" + totalOrderCost);
        }

        // Calculate the total price of a single sandwich
        public static double totalCostOfSingleSandwich(Bread selectedBread, ArrayList<Topping> toppings) {
            double totalCost = selectedBread.getPrice();  // Start with the price of the bread

            // Add the price of each topping (regular or premium)
            for (Topping topping : toppings) {
                totalCost += topping.getPrice();
            }

            return totalCost;
        }

        // Initialize available toppings (assuming you have this method)
        public static ArrayList<Topping> initializeToppings() {
            sandwichTopping2 = new ArrayList<>();

            // Regular toppings
            sandwichTopping2.add(new Topping(" "," " ));
            sandwichTopping2.add(new Topping("lettuce", "veggie",  false, 0.0)); //0
            sandwichTopping2.add(new Topping("peppers", "veggie", false, 0.0)); //1
            sandwichTopping2.add(new Topping("red onions", "veggie", false, 0.0)); //2
            sandwichTopping2.add(new Topping("jalapenos", "veggie", false, 0.0)); //3
            sandwichTopping2.add(new Topping("cucumber", "veggie", false, 0.0)); //4
            sandwichTopping2.add(new Topping("pickles", "veggie", false, 0.0)); //5

            // Sauces
            sandwichTopping2.add(new Topping("honey mustard", "sauce", false, 0.0)); //5
            sandwichTopping2.add(new Topping("ranch", "sauce", false, 0.0)); //7
            sandwichTopping2.add(new Topping("mayo", "sauce", false, 0.0)); //8
            sandwichTopping2.add(new Topping("mustard", "sauce", false, 0.0)); //9
            sandwichTopping2.add(new Topping("ketchup", "sauce", false, 0.0)); //10

            // Premium toppings (Meats and Cheese)
            sandwichTopping2.add(new Topping("grill chicken", "meat", true, 1.00)); //11
            sandwichTopping2.add(new Topping("bacon", "meat", true, 1.00)); //12
            sandwichTopping2.add(new Topping("roast beef", "meat", true, 1.00)); //13
            sandwichTopping2.add(new Topping("salami", "meat",true, 1.00)); //14
            sandwichTopping2.add(new Topping("ham", "meat",true, 1.00)); //15
            sandwichTopping2.add(new Topping("steak", "meat",true, 1.00)); //16
            sandwichTopping2.add(new Topping("provolone", "cheese", true, 0.70)); //17
            sandwichTopping2.add(new Topping("cheddar", "cheese",true, 0.70)); //18
            sandwichTopping2.add(new Topping("swiss", "cheese", true, 0.70)); //19
            sandwichTopping2.add(new Topping("american", "cheese",true, 0.70)); //20

            return sandwichTopping2;
        }

        // Initialize available bread options (assuming you have this method)
        public static ArrayList<Bread> initializeBread() {
            bread2 = new ArrayList<>();
            bread2 .add(new Bread(" ",4));
            bread2  .add(new Bread("white", 4));
            bread2  .add(new Bread("white", 8));
            bread2  .add(new Bread("white", 12));
            bread2 .add(new Bread("wheat", 4));
            bread2  .add(new Bread("wheat", 8));
            bread2  .add(new Bread("wheat", 12));
            bread2 .add(new Bread("wrap", 4));
            bread2 .add(new Bread("wrap", 8));
            bread2  .add(new Bread("wrap", 12));
            bread2  .add(new Bread("rye", 4));
            bread2 .add(new Bread("rye", 8));
            bread2  .add(new Bread("rye", 12));

            return bread2  ;
        }

        // Method to display the sandwiches ordered (you'll need to define this)
        public static void displaySandwiches(ArrayList<Sandwich> sandwichOrders) {
            for (int i = 0; i < sandwichOrders.size(); i++) {
                Sandwich sandwich = sandwichOrders.get(i);
                System.out.println("Sandwich " + (i) + ": " + sandwich.toString());
            }
        }

        // Prompt for bread selection (assuming you have this method)
        public static int promptForBread2() {
            System.out.println("Select a bread:");

            //loop through array
            for (int i = 1; i < bread2.size(); i++) {
                System.out.println(i + ": " + bread2.get(i).getTypeOfBread() + " (" + bread2.get(i).getSizeOfBread() + "\")");
            }

            int breadChoice = Console.PromptForInt("Enter bread choice (1-" + (bread2.size() - 1) + ")");
            System.out.println("Bread selected : " + bread2.get(breadChoice));
            return breadChoice;
        }

        // Prompt for toppings (assuming you have this method)
        public static ArrayList<Topping> promptForToppings2(int more) {
            ArrayList<Topping> selectedToppings = new ArrayList<>();
            boolean addMore = true;

            while (addMore) {
                System.out.println("Select a topping:");

                // Display all toppings
                for (int i = 0; i < sandwichTopping2.size(); i++) {  // Changed to start at 0
                    Topping addTopping = sandwichTopping2.get(i);
                    System.out.println(i + ": " + addTopping.getTopping() + " " + addTopping);
                }

                // Prompt user to select a topping
                int toppingChoice = Console.PromptForInt("Enter topping choice (0-" + (sandwichTopping2.size() - 1) + "): ");
                Topping selectedTopping = sandwichTopping2.get(toppingChoice);
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
    }

