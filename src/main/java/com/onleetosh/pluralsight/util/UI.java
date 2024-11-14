/**
 *  UI encapsulates a User Interface that handle user request and display options
 */
package com.onleetosh.pluralsight.util;


import com.onleetosh.pluralsight.order.Receipt;
import com.onleetosh.pluralsight.order.*;
import com.onleetosh.pluralsight.order.sandwich.Bread;
import com.onleetosh.pluralsight.order.sandwich.SignatureSandwich;
import com.onleetosh.pluralsight.order.sandwich.Topping;
import com.onleetosh.pluralsight.order.sandwich.Sandwich;

import java.util.ArrayList;

public class UI {

    public static ArrayList<Topping> heroToppingList;
    public static ArrayList<Bread> breadList;
    public static ArrayList<Chips> chipsList;
    public static ArrayList<Beverage> beveragesList;
    public static ArrayList<Cookie> cookieList;


    public Order currentOrder; // Track the current order being built


    public UI() {
            UI.breadList = InitializeObject.listOfBreadObjects();
            UI.chipsList = InitializeObject.listOfChipObjects();
            UI.beveragesList = InitializeObject.listOfBeverageObjects();
            UI.heroToppingList = InitializeObject.listOfToppingObjects();
            // default to null and wait for order details
            currentOrder = new Order(null, null, null);

        }
    /**
     * displayHomeScreen() provides the main screen for starting a new order or exiting.
     */
    public void displayHomeScreen() {
            while (true) {
                try {

                    System.out.println("---------------------------------------------------------------");
                    System.out.println("          Welcome to the ALL-Mighty HEROES \n");
                    printMenu();
                    int startOrder = Console.PromptForInt("\n 1 - New Order \n 2 - Quit ");
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
                    System.out.println("----------------------------------");
                    System.out.println("        Place Order ");
                    System.out.println("----------------------------------");
                    System.out.println(" 1) Sandwich \n " +
                                        "2) Drink \n " +
                                        "3) Chips \n " +
                                        "4) Try a Signature Sandwich \n " +
                                        "5) View Order \n \n " +
                                        "0) Go Back");
                    System.out.println("---------------------------------");

                    int command = Console.PromptForInt(" Enter [1 - 6] to continue: ");
                    switch (command) {
                        case 1 -> processAddSandwich();
                        case 2 -> processAddBeverage();
                        case 3 -> processAddChip();
                        case 4 -> viewSignatureSandwiches();
                        case 5 -> viewOrder();
                        case 0 -> {
                            System.out.println("Returning to the menu pricing.");
                            return;
                        }
                        default -> System.out.println("Invalid input. Please enter a number between 0 and 4.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }
        }

    private void printMenu() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("                           MENU PRICING ");
        System.out.println("---------------------------------------------------------------");
        System.out.println("           4\" Hero $5.50     8\" Hero $7.00     12\" Hero $8.50");
        System.out.println("\nPremium Meat:      $1.00             $2.00              $3.00");
        System.out.println("Extra Meat:        $0.50             $1.00              $1.50");
        System.out.println("Premium Cheese:    $0.75             $1.50              $2.25");
        System.out.println("Extra Cheese:      $0.30             $0.60              $0.90");
        System.out.println("\nBeverage:          Small             Medium             Large");
        System.out.println("Drinks:            $2.00             $2.50              $3.00");
        System.out.println("Chips:             $1.50");
        System.out.println("---------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------");
    }

    /**
     * processAddSandwich() used to collect sandwiches from the user and adds them to the current order.
     */
        private void processAddSandwich() {
            ArrayList<Sandwich> sandwiches = PromptOrder.promptForSandwich();
            for (Sandwich sandwich : sandwiches) {
                currentOrder.addSandwich(sandwich);
            }
        }

    /**
     * processAddBev() used to collect beverages from the user and adds them to the current order.
     */
        private void processAddBeverage() {
            ArrayList<Beverage> beverages = PromptOrder.promptForBeverage();
            for (Beverage beverage : beverages) {
                currentOrder.addBeverage(beverage);
            }
        }

    /**
     * processAddChip() used to collect chips from the user and adds them to the current order.
     */
    private void processAddChip() {
            ArrayList<Chips> chips = PromptOrder.promptForChips();
            for (Chips chip : chips) {
                currentOrder.addChip(chip);
            }
        }


    private void processConfirmOrder() {

            Receipt.recordOrderTransaction(currentOrder);
            currentOrder = new Order(null, null, null); // start a new order

            System.out.println("Enjoy the Almighty Hero!");

        }

    /**
     * processCancelOrder() used remove all objects and reset an order
     */
    private void processCancelOrder() {
            System.out.println("----------------------------");
            if (Console.PromptForYesNo("Are you sure you want to cancel the order?")) {
                currentOrder = new Order(null, null, null);  // Reset the order
                System.out.println("Order canceled.");
            }
        }

    /**
     * viewOrder() uses displayOrderSummary() to show a order created and prompts user to
     * either confirm and checkout, cancel or add more to order
     */
    private void viewOrder(){
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

    /**
     * displayOrderSummary() used to outputs a confirmation of an order created
     */

    private void displayOrderSummary(ArrayList<Sandwich> sandwiches, ArrayList<Beverage> drinks, ArrayList<Chips> chips) {

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

    //TODO : FINISH BONUS
    public void viewSignatureSandwiches(){

        System.out.println("----------------------------");
        System.out.println("      Signature Sandwich ");
        System.out.println("----------------------------");
        System.out.println(" 1) BLT \n " +
                "2) PHILLY CHEESE \n " +
                "3) ALL FOR ONE \n " +
                "4) FLAT BUSH \n " +
                "5) UPTOWN \n \n " +
                "0) Go Back");
        System.out.println("----------------------------");

        int command = Console.PromptForInt(" Enter [1 - 6] to continue: ");
        switch (command) {
            //case 1 -> SignatureSandwich.requestBLT();
//                case 2 -> SignatureSandwich.requestPhillyCheese();
//                case 3 -> processAddChip();
//                case 4 -> viewSignatureSandwiches();
//                case 5 -> viewOrder();
            case 0 -> {
                System.out.println("Returning to the previous menu.");
                return;
            }
            default -> System.out.println("Invalid input. Please enter a number between 0 and 4.");
        }
    }

    }


