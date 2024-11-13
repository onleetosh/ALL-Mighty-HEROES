/**
 *  UI encapsulates a User Interface that handle user request and display options
 */
package com.onleetosh.pluralsight.util;


import com.onleetosh.pluralsight.Receipt;
import com.onleetosh.pluralsight.order.*;
import com.onleetosh.pluralsight.topping.Topping;

import java.util.ArrayList;

public class UI {

    public static ArrayList<Beverage> drinkOrder;
    public static ArrayList<Chips> chipOrder;
    public static ArrayList<Sandwich> sandwichOrder;
    public static ArrayList<Topping> listOfSandwichTopping;
    public static ArrayList<Bread> listOfBread;
    public static ArrayList<Chips> listOfChips;
    public static ArrayList<Beverage> listOfBeverages;

    public static ArrayList<Order> orderPlace;  // Keep track of placed orders


    private Order currentOrder; // Track the current order being built


    //TODO : move declared ArrayList to UI class


        public UI() {
            UI.listOfBread = InitializeObject.initializeBread();
            UI.listOfChips = InitializeObject.listOfChipObjects();
            UI.listOfBeverages = InitializeObject.listOfBeverageObjects();
            UI.listOfSandwichTopping = InitializeObject.initializeToppings();
            UI.orderPlace = new ArrayList<>();
            // default to null and wait for order details
            currentOrder = new Order(null, null, null);

        }

        public void displayHomeScreen() {
            while (true) {
                try {
                    System.out.println("----------------------------");
                    System.out.println("Welcome to the ALL-Mighty HEROES");
                    System.out.println("----------------------------");
                    int startOrder = Console.PromptForInt(" 1 - New Order \n 2 - Quit ");
                    switch (startOrder) {
                        case 1 -> displayOrderScreen();
                        case 2 -> {
                            return;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid number. ");
                }
            }
        }

        public void displayOrderScreen() {
            while (true) {
                try {
                    System.out.println("----------------------------");
                    System.out.println("        Place Order ");
                    System.out.println("----------------------------");
                    System.out.println(" 1) Sandwich \n 2) Drink \n 3) Chips \n 4) Checkout\n 5) Cancel Order\n 6) Go Back");
                    System.out.println("----------------------------");

                    int command = Console.PromptForInt(" Enter [1 - 6] to continue: ");
                    switch (command) {
                        case 1 -> processAddSandwich();
                        case 2 -> processAddBeverage();
                        case 3 -> processAddChip();
                        case 4 -> processOrderCheckout();
                        case 5 -> processCancelOrder();

                        case 6 -> {
                            return;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }
        }

        public void processAddSandwich() {
            ArrayList<Sandwich> sandwiches = PromptOrder.promptForSandwich();
            for (Sandwich sandwich : sandwiches) {
                currentOrder.addSandwich(sandwich);
            }
        }

        public void processAddBeverage() {
            ArrayList<Beverage> beverages = PromptOrder.promptForBeverage();
            for (Beverage beverage : beverages) {
                currentOrder.addBeverage(beverage);
            }
        }

        public void processAddChip() {
            ArrayList<Chips> chips = PromptOrder.promptForChips();
            for (Chips chip : chips) {
                currentOrder.addChip(chip);
            }
        }

        public void processOrderCheckout() {
            displayOrderSummary(currentOrder.getSandwiches(), currentOrder.getBeverages(), currentOrder.getChips());
            Receipt.recordOrderTransaction(currentOrder);
        }

        public void processCancelOrder() {
            System.out.println("----------------------------");
            if (Console.PromptForYesNo("Are you sure you want to cancel the order?")) {
                currentOrder = new Order(null, null, null);  // Reset the order
                System.out.println("Order canceled.");
            }

        }

        public void displayOrderSummary(ArrayList<Sandwich> sandwiches, ArrayList<Beverage> drinks, ArrayList<Chips> chips) {
            double totalCost = 0.0;

            System.out.println("----------------------------");
            System.out.println("       Order Summary");
            System.out.println("----------------------------");
            // Display sandwiches
            System.out.println("\n--- Sandwiches ---");
            for (Sandwich sandwich : sandwiches) {
                System.out.println(sandwich);
                totalCost += sandwich.getTotalCost();
            }

            // Display drinks
            System.out.println("\n--- Drinks ---");
            for (Beverage drink : drinks) {
                System.out.println(drink);
                totalCost += drink.getPriceOfBeverage();
            }

            // Display chips
            System.out.println("\n--- Chips ---");
            for (Chips chip : chips) {
                System.out.println(chip);
                totalCost += chip.getPriceOfChips();
            }

            System.out.println("----------------------------");

            // Display total cost
            System.out.println("\nTotal Price: $" + totalCost);

        }
    }


