package com.onleetosh.pluralsight.util;


import com.onleetosh.pluralsight.order.*;
import com.onleetosh.pluralsight.order.addon.*;
import com.onleetosh.pluralsight.order.sandwich.*;

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
            UI.cookieList = InitializeObject.listOfCookieObjects();
            // default to null and wait for order details
            currentOrder = new Order();
        }
    /**
     * Method used to display the main screen and prompts the user for a command
     */
    public void displayHomeScreen() {
            while (true) {
                try {
                    System.out.println("---------------------------------------------------------------\n");
                    System.out.println("               Welcome to the ALL-Mighty HEROES \n");
                    printMenu();
                    int startOrder = Console.PromptForInt("\n 1 - New Order " +
                                                          "\n 2 - Quit ");
                    switch (startOrder) {
                        case 1 -> displayOrderScreen();
                        case 2 -> System.exit(0);
                        default -> System.out.println("Please enter a valid number");
                    }
                }
                catch (Exception e) {
                    System.out.println("Please enter a valid number. ");
                }
            }
        }

    /**
     * Method used to display request and prompts for order input
     */
    public void displayOrderScreen() {
            while (true) {
                try {
                    System.out.println("-----------------------------------------------");
                    System.out.println("                Place Order ");
                    System.out.println("-----------------------------------------------");
                    System.out.println(" 1 - [Sandwich] \n " +
                                        "2 - [Beverage] \n " +
                                        "3 - [Add On] \n " +
                                        "4 - [View Order] \n \n" +
                                        "5 - [Exit] " );
                    System.out.println("-----------------------------------------------");
                    int command = Console.PromptForInt(" Enter [1 - 5] to continue: ");
                    switch (command) {
                        case 1 -> processAddSandwich();
                        case 2 -> processAddBeverage();
                        case 3 -> viewAddOn();
                        case 4 -> viewOrder();
                        case 5 -> System.exit(0);
                        default -> System.out.println("Invalid entry. Please enter [0 and 5]");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }
        }

    private void printMenu() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("                        MENU PRICING ");
        System.out.println("---------------------------------------------------------------");
        System.out.println("           4\" Hero $5.50     8\" Hero $7.00     12\" Hero $8.50");
        System.out.println("\nPremium Meat:      $1.00             $2.00              $3.00");
        System.out.println("Extra Meat:        $0.50             $1.00              $1.50");
        System.out.println("Premium Cheese:    $0.75             $1.50              $2.25");
        System.out.println("Extra Cheese:      $0.30             $0.60              $0.90");
        System.out.println("\nBeverage:          Small             Medium             Large");
        System.out.println("Drinks:            $2.00             $2.50              $3.00");
        System.out.println("\nChips:             $1.50");
        System.out.println("Cookie:            $1.50");
        System.out.println("---------------------------------------------------------------");
        System.out.println("              Enter # when prompted to process order ");
        System.out.println("---------------------------------------------------------------");
    }

    /**
     * This method uses displayOrderSummary() to display order details and prompts user to
     * either confirm, cancel, or add more to order
     */
    private void viewOrder(){
        displayOrderSummary(currentOrder.getSandwiches(),
                currentOrder.getBeverages(),
                currentOrder.getChips(),
                currentOrder.getCookies());

        while(true) {
            try {
                int command = Console.PromptForInt("\n 1 - [Confirm] " +
                        "\n 2 - [Cancel] " +
                        "\n 3 - [Update Order] " );

                switch (command) {
                    case 1 -> processConfirmOrder();
                    case 2 -> processCancelOrder();
                    case 3 -> displayOrderScreen();
                    default -> System.out.println("Please enter [1-3]");
                }
            }
            catch (Exception e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    /**
     * Method used to display a confirmation for an order created with added items
     */
    private void displayOrderSummary(ArrayList<Sandwich> sandwiches,
                                     ArrayList<Beverage> drinks,
                                     ArrayList<Chips> chips,
                                     ArrayList<Cookie> cookies) {

        double totalCost = 0.0;
        System.out.println("-----------------------------------------------");
        System.out.println("                  Order Summary");
        System.out.println("-----------------------------------------------");
        // Display sandwiches
        System.out.println(" --- Sandwiches ----");
        if (sandwiches.isEmpty()) {
            System.out.println("No sandwiches added.");
        } else {
            for (Sandwich sandwich : sandwiches) {
                System.out.println(sandwich);
                totalCost += sandwich.getTotalCostOfSandwich(); // Add and get sandwich total
            }
        }
        // Display drinks
        System.out.println(" --- Beverages ----");
        if (drinks.isEmpty()) {
            System.out.println("No beverages added.");
        } else {
            for (Beverage drink : drinks) {
                System.out.println(drink);
                totalCost += drink.getPriceOfBeverage(); // Add and get beverage total
            }
        }

        // Display chips
        System.out.println(" --- Add-Ons (Chips) ----");
        if (chips.isEmpty()) {
            System.out.println("No chips added.");
        } else {
            for (Chips chip : chips) {
                System.out.println(chip);
                totalCost += chip.getPriceOfChips(); // Add and get chips total
            }
        }

        // Display cookies
        System.out.println(" --- Add-Ons (Cookies) ----");
        if (cookies.isEmpty()) {
            System.out.println("No cookies added.");
        } else {
            for (Cookie cookie : cookies) {
                System.out.println(cookie);
                totalCost += cookie.getPriceOfCookie(); // Add and get cookies total
            }
        }

        System.out.println("-----------------------------------------------");
        // Display the amount due
        System.out.printf("\nAmount due: $%.2f \n", totalCost);
    }

    private void viewAddOn(){
        while (true) {
            try {
                System.out.println("-----------------------------------------------");
                System.out.println("                    Add-Ons");
                System.out.println("-----------------------------------------------");
                System.out.println(" 1 - [Chip] \n " +
                                    "2 - [Cookie] \n " +
                                    "3 - [View Order] \n \n " +
                                    "4 - [Go Back]");
                System.out.println("-----------------------------------------------");
                int command = Console.PromptForInt(" Enter [0 - 3] to continue: ");
                switch (command) {
                    case 1 -> processAddChip();
                    case 2 -> processAddCookie();
                    case 3 -> viewOrder();
                    case 4 -> displayOrderScreen();
                    default -> System.out.println("Please enter [1 - 4]");
                }
            } catch (Exception e) {
                System.out.println("Please enter [1 - 4]");
            }
        }
    }

    /**
     * Method used to process the request of adding an item to the current order by using the PromptOrder method to
     * prompt for heroes then loops through the item or items requested and adds them to the current order
     */
    private void processAddSandwich() {
            ArrayList<Sandwich> request = PromptOrder.promptForSandwich();
            for (Sandwich sandwich : request) {
                currentOrder.addSandwich(sandwich);
            }
        }

    /**
     * Method used to process the request of adding an item to the current order by using the PromptOrder method to
     * prompt for beverage then loops through the item or items requested and adds them to the current order
     */
    private void processAddBeverage() {
            ArrayList<Beverage> request = PromptOrder.promptForBeverage();
            for (Beverage beverage : request) {
                currentOrder.addBeverage(beverage);
            }
        }

    /**
     * Method used to process the request to add an item to the current order by using a PromptOrder class method to
     * prompt for chips then loops through the item or items requested and adds them to the current order
     */
    private void processAddChip() {
            ArrayList<Chips> request = PromptOrder.promptForChips();
            for (Chips chip : request) {
                currentOrder.addChip(chip);
            }
        }

    /**
     * Method used to process the request to add an item to the current order by using a PromptOrder class method to
     * prompt for chips then loops through the item or items requested and adds them to the current order
     */
    private void processAddCookie() {
        ArrayList<Cookie> request = PromptOrder.promptForCookie();
        for (Cookie cookie : request) {
            currentOrder.addCookie(cookie);
        }
    }


    /**
     * This method is used confirms and generates a receipt for the object and prompts user to exit or start new order
     */
    private void processConfirmOrder() {
        //process a receipt for order made
        Receipt.recordOrderTransaction(currentOrder);
        //remove previous order to create new order
        currentOrder = new Order();
        System.out.println("Enjoy your Almighty Hero!");
        //prompt user for a new order and loop for valid input
        boolean newOrder;
        while (true){
            try {
                newOrder = Console.PromptForYesNo("\nWould you like to start a new order?");
                if (newOrder) {
                    displayOrderScreen();  // Start a new order process
                } else {
                    System.out.println("Thank you for using our service!");
                    System.exit(0); //end program
                }
            }
            catch (Exception e) {
                System.out.println("Answer Y or N");
            }
        }
    }

    /**
     * This method is used clear all item from an order and prompts user to exit or start new order
     */
    private void processCancelOrder() {
        System.out.println("---------------------------------------------------------------");
        if (Console.PromptForYesNo("Are you sure you want to cancel the current order?")) {
            currentOrder = new Order();
            System.out.println("Order has been canceled.");
        }
        //prompt user for a new order and loop for valid input
        while (true) {
            try {
                boolean newOrder = Console.PromptForYesNo("\nWould you like to start a new order?");
                if (newOrder) {
                    displayOrderScreen();  // Start a new order process
                } else {
                    System.out.println("Have a Mighty Day!");
                    System.exit(0); //end program
                }
            }
            catch (Exception e) {
                System.out.println("Answer Y or N");
            }
        }
    }

}


