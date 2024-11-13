/**
 *  UI encapsulates a User Interface that handle user request and display options
 */
package com.onleetosh.pluralsight.util;


import com.onleetosh.pluralsight.order.Receipt;
import com.onleetosh.pluralsight.order.*;
import com.onleetosh.pluralsight.order.sandwich.Bread;
import com.onleetosh.pluralsight.order.sandwich.Topping;
import com.onleetosh.pluralsight.order.sandwich.Sandwich;

import java.util.ArrayList;

public class UI {

    public static ArrayList<Beverage> drinkOrder;
    public static ArrayList<Chips> chipOrder;
    public static ArrayList<Sandwich> sandwichOrder;
    public static ArrayList<Topping> heroToppingList;
    public static ArrayList<Bread> breadList;
    public static ArrayList<Chips> chipsList;
    public static ArrayList<Beverage> beveragesList;

    public static ArrayList<Order> orderPlace;  // Keep track of placed orders
    public Order currentOrder; // Track the current order being built


        public UI() {
            UI.breadList = InitializeObject.listOfBreadObjects();
            UI.chipsList = InitializeObject.listOfChipObjects();
            UI.beveragesList = InitializeObject.listOfBeverageObjects();
            UI.heroToppingList = InitializeObject.listOfToppingObjects();
            UI.orderPlace = new ArrayList<>();
            // default to null and wait for order details
            currentOrder = new Order(null, null, null);

        }
    /**
     * displayHomeScreen() provides the main screen for starting a new order or exiting.
     */
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
                            System.out.println("Returning to the previous menu.");
                            return;
                        }
                        default -> System.out.println("Invalid input. Please enter a number between 0 and 4.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid number. ");
                }
            }
        }
    /**
     * displayOrderScreen() allows the user to place an order by selecting options to add items or view the order.
     */
        public void displayOrderScreen() {
            while (true) {
                try {
                    System.out.println("----------------------------");
                    System.out.println("        Place Order ");
                    System.out.println("----------------------------");
                    System.out.println(" 1) Sandwich \n 2) Drink \n 3) Chips \n 4) Order \n \n 0) Go Back");
                    System.out.println("----------------------------");

                    int command = Console.PromptForInt(" Enter [1 - 6] to continue: ");
                    switch (command) {
                        case 1 -> processAddSandwich();
                        case 2 -> processAddBeverage();
                        case 3 -> processAddChip();
                        case 4 -> viewOrder();
                        case 0 -> {
                            System.out.println("Returning to the previous menu.");
                            return;
                        }
                        default -> System.out.println("Invalid input. Please enter a number between 0 and 4.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }
        }

    /**
     * processAddSandwich() used to collect sandwiches from the user and adds them to the current order.
     */
        public void processAddSandwich() {
            ArrayList<Sandwich> sandwiches = PromptOrder.promptForSandwich();
            for (Sandwich sandwich : sandwiches) {
                currentOrder.addSandwich(sandwich);
            }
        }

    /**
     * processAddBev() used to collect beverages from the user and adds them to the current order.
     */
        public void processAddBeverage() {
            ArrayList<Beverage> beverages = PromptOrder.promptForBeverage();
            for (Beverage beverage : beverages) {
                currentOrder.addBeverage(beverage);
            }
        }

    /**
     * processAddChip() used to collect chips from the user and adds them to the current order.
     */
    public void processAddChip() {
            ArrayList<Chips> chips = PromptOrder.promptForChips();
            for (Chips chip : chips) {
                currentOrder.addChip(chip);
            }
        }


    public void processAddChipUpdate() {
        ArrayList<Chips> chips = PromptOrder.promptForChips();

        // Null check in case the user cancels or no chips are added
        if (chips == null || chips.isEmpty()) {
            System.out.println("No chips were added to the order.");
            return;  // Exit method if no chips are provided
        }

        // Add each chip to the current order
        for (Chips chip : chips) {
            currentOrder.addChip(chip);
        }

        System.out.println("Chips successfully added to your order.");
    }

    /**
     * viewOrder() uses displayOrderSummary() to show a order created and prompts user to
     * either confirm and checkout, cancel or add more to order
     */
        public void viewOrder(){

            displayOrderSummary(currentOrder.getSandwiches(), currentOrder.getBeverages(), currentOrder.getChips());
            while(true) {
                try {
                    int command = Console.PromptForInt("\n 1) [Confirm] " +
                                                       "\n 2) [Cancel] " +
                                                       "\n 3) [Add More] " );

                    switch (command) {
                        case 1 -> processConfirmOrder();
                        case 2 -> processCancelOrder();
                        case 3 -> displayOrderScreen();
                    }
                }
                catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }
        }


        public void processConfirmOrder() {

            Receipt.recordOrderTransaction(currentOrder);
            currentOrder = new Order(null, null, null); // start a new order

            System.out.println("Enjoy the Almighty Hero!");

        }

    /**
     * processCancelOrder() used remove all objects and reset an order
     */
        public void processCancelOrder() {
            System.out.println("----------------------------");
            if (Console.PromptForYesNo("Are you sure you want to cancel the order?")) {
                currentOrder = new Order(null, null, null);  // Reset the order
                System.out.println("Order canceled.");
            }
        }


    /**
     * displayOrderSummary() used to outputs a confirmation of an order created
     */

    public void displayOrderSummary(ArrayList<Sandwich> sandwiches, ArrayList<Beverage> drinks, ArrayList<Chips> chips) {

        double totalCost = 0.0;

            System.out.println("----------------------------");
            System.out.println("       Order Summary");
            System.out.println("----------------------------");
            // Display sandwiches
        System.out.println(" --- Confirm Sandwich----");
        for (Sandwich sandwich : sandwiches) {
                System.out.println(sandwich);
                totalCost += sandwich.getTotalCostOfSandwich(); //add and get sandwich total
            }
            // Display drinks
        System.out.println(" --- Confirm Beverage----");
        for (Beverage drink : drinks) {
                System.out.println(drink);
                totalCost += drink.getPriceOfBeverage(); //add and get beverage total
            }
            // Display chips
        System.out.println(" --- Confirm Chips----");
        for (Chips chip : chips) {
                System.out.println(chip);
                totalCost += chip.getPriceOfChips(); //add and get total chip total
            }
            System.out.println("----------------------------");
            // Display the amount due
            System.out.printf("\nAmount due: $%.2f", totalCost);


        }
    }


