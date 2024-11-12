package com.onleetosh.pluralsight.util;


import com.onleetosh.pluralsight.order.Beverage;
import com.onleetosh.pluralsight.order.Bread;
import com.onleetosh.pluralsight.order.Chips;
import com.onleetosh.pluralsight.order.Sandwich;
import com.onleetosh.pluralsight.topping.Topping;

import java.util.ArrayList;

public class UI {

    public static ArrayList<Beverage> drinkOrder;
    public static ArrayList<Chips> chipOrder;
    public static ArrayList<Topping> listOfSandwichTopping;

    public static ArrayList<Bread> listOfBread;
    public static ArrayList<Chips> listOfChips;
    public static ArrayList<Beverage> listOfBeverages;


    //TODO : move declared ArrayList to UI class

    public UI(){
        listOfBread = InitializeObject.initializeBread();
        listOfChips = InitializeObject.listOfChipObjects();
        listOfBeverages = InitializeObject.listOfBeverageObjects();
        listOfSandwichTopping = InitializeObject.initializeToppings();
    }

    /**
     * Home screen display options and runs until the user decides to exit
     */
    public void displayHomeScreen(){

        while (true){
            try {
                System.out.println("Welcome to the Sandwich Shop");
                int startOrder = Console.PromptForInt("1 - Start an order \n 2 - Quit");
                switch (startOrder){
                    case 1:
                        displayOrderScreen();
                    case 2:
                        return;
                    default:
                        System.out.println("Invalid entry. Please enter a number between 0 and 5.");
                }
            }
            catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number between 0 and 5.");

            }

        }
    }


    public void displayOrderScreen(){
        while (true){
            try {
                System.out.println(" 1) Add Sandwich\n " +
                        "2) Add Drink\n " +
                        "3) Add Chips\n " +
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
                    default:
                        System.out.println("Invalid entry. Please enter a number between 0 and 5.");
                }
            }
            catch (Exception e){
                System.out.println("Invalid input. Please enter a valid number between 0 and 5.");
            }
        }
    }

    /**
     * Add sandwich screen walks the user through several options to create a sandwich
     */



    public void processAddSandwich() {
        PromptOrder.promptForSandwich();

    }

    public void processAddBeverage(){
        //PromptOrder.promptForBeverage();

    }

    public void processAddChip() {
        //PromptOrder.promptForChips();

    }

    public void processOrderCheckout(){

    }



    public void processCancelOrder(){

    }

    /**
     * When the order is complete, display the order details, including the list of sandwiches that were ordered
     * with all the toppings so that the user can verify the order is correct and display the total cost.
     */
    public void displayOrderDetails(){


    }



    public static void displaySandwiches(ArrayList<Sandwich> sandwiches){
        for (Sandwich sandwich : sandwiches) {
            System.out.println(sandwich);
        }
    }

    public static  double getTotalBeverageAmount(){

        return  0;
    }


    public void displayCheckoutScreen() {
        //display order details

        System.out.println("1) Checkout\n " +
                "2) Cancel \n ");
        int decision = Console.PromptForInt("Select an option");

    }






}

