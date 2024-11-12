package com.onleetosh.pluralsight.util;


import com.onleetosh.pluralsight.order.*;
import com.onleetosh.pluralsight.topping.Topping;

import java.util.ArrayList;

public class UI {

    public static ArrayList<Beverage> drinkOrder;
    public static ArrayList<Chips> chipOrder;
    public static ArrayList<Topping> listOfSandwichTopping;

    public static ArrayList<Bread> listOfBread;
    public static ArrayList<Chips> listOfChips;
    public static ArrayList<Beverage> listOfBeverages;

    private static ArrayList<Order> orderPlace;  // Keep track of placed orders



    //TODO : move declared ArrayList to UI class

    public UI(){
        listOfBread = InitializeObject.initializeBread();
        listOfChips = InitializeObject.listOfChipObjects();
        listOfBeverages = InitializeObject.listOfBeverageObjects();
        listOfSandwichTopping = InitializeObject.initializeToppings();
        orderPlace = new ArrayList<>();
    }

    /**
     * Home screen display options and runs until the user decides to exit
     */
    public void displayHomeScreen(){

        while (true){
            try {
                System.out.println("Welcome to the Sandwich Shop");
                int startOrder = Console.PromptForInt(" 1 - Start an order \n 2 - Quit " );
                switch (startOrder){
                    case 1:
                        displayOrderScreen();
                    case 2:
                        return;
                }
            }
            catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number between 0 and 5.");
            }
        }
    }

    /**
     * Add sandwich screen walks the user through several options to create a sandwich
     */

    public void displayOrderScreen(){
        while (true){
            try {
                System.out.println("---- Place Order ----");
                System.out.println(" 1) Sandwich\n " +
                        "2) Drink\n " +
                        "3) Chips\n " +
                        "4) Checkout\n " +  //display order
                        "5) Cancel Order\n" +
                        "6) Exit");

                int command = Console.PromptForInt(" Enter [1 - 5] to continue or 6 to exit");
                switch (command) {
                    case 1:
                        processAddSandwich();
                        break;
                    case 2:
                        processAddBeverage();
                        break;
                    case 3:
                        processAddChip();
                        break;
                    case 4:
                        processOrderCheckout();
                        break;
                    case 5:
                        processCancelOrder();
                        break;
                    case 6:
                        return; //exit program
                }
            }
            catch (Exception e){
                System.out.println("Invalid input. Please enter a valid number between 0 and 5.");
            }
        }
    }

    public void processAddSandwich() {
        ArrayList<Sandwich> addSandwich = PromptOrder.promptForSandwich();
        Order order = new Order(addSandwich.get(0), null, null);
        moveObjectForOrderCheckout(order);

    }

    public void processAddBeverage(){
        ArrayList<Beverage> addBeverage = PromptOrder.promptForBeverage();

        Order order = new Order(null, addBeverage.get(0), null);
        moveObjectForOrderCheckout(order);

    }

    public void processAddChip() {
        ArrayList<Chips> addChip = PromptOrder.promptForChips();
        Order order = new Order(null, null, addChip.get(0));
        moveObjectForOrderCheckout(order);
    }

    public void processCancelOrder(){
        if (Console.PromptForYesNo("Are you sure you want to cancel the order?")) {
            if (!orderPlace.isEmpty()) {
                orderPlace.remove(orderPlace.size() - 1);  // Remove the last order
                System.out.println("Order canceled.");
            } else {
                System.out.println("No order to cancel.");
            }
        }
    }

    /**
     * When the order is complete, display the order details, including the list of sandwiches that were ordered
     * with all the toppings so that the user can verify the order is correct and display the total cost.
     */
    public void processOrderCheckout(){

        System.out.println("Your current order:");
        viewObjectInOrderCheckout();

        double totalPrice = 0;
        for (Order order : orderPlace) {
            totalPrice += order.getTotalPrice();
        }
        System.out.println("Total Cost: $" + totalPrice);
    }

    // Add an order to the list of placed orders
    private void moveObjectForOrderCheckout(Order order) {
        if (order != null && order.getSandwich() != null ||
                order != null && order.getBeverage() != null ||
                order != null && order.getChips() != null) {
            orderPlace.add(order);
        }
        else {
            System.out.println("Cannot place an empty or incomplete order.");
        }
    }

    // View all placed orders
    private void viewObjectInOrderCheckout() {
        for (Order order : orderPlace) {
            System.out.println(order);
        }
    }

    public static void displaySandwiches(ArrayList<Sandwich> sandwiches){
        for (Sandwich sandwich : sandwiches) {
            System.out.println(sandwich);
        }
    }

    public void displayCheckoutScreen() {
        //display order details

        System.out.println("1) Checkout\n " +
                "2) Cancel \n ");
        int decision = Console.PromptForInt("Select an option");

    }


}

