package com.onleetosh.pluralsight.util;

public class UI {

    public UI(){

    }

    /**
     * Home screen display options and runs until the user decides to exit
     */
    public void displayHomeScreen(){

        do {

        }
        while(true);
    }


    public void displayOrderScreen(){

        System.out.println(" 1) Add Sandwich\n " +
                            "2) Add Drink\n " +
                            "3) Add Chips\n " +
                            "4) Checkout\n " +
                            "5) Cancel Order\n" +
                            "0) Exit");

        int command = Console.PromptForInt(" Enter [1 - 5] to continue or 0 to exit");

    }

    /**
     * Add sandwich screen walks the user through several options to create a sandwich
     */
    public void displayAddSandwichScreen() {

        //select bread

        //select bread size

        //select topping

        //toast or non toast?

    }


    public void displayAddDrinkScreen() {

        //pick a size
        System.out.println("1) Small\n " +
                           "2) Medium\n " +
                           "3) Large ");
        int size = Console.PromptForInt("Pick a drink size ");

        //pick a flavor
        System.out.println("1) Coke\n " +
                           "2) Iced Tea\n " +
                           "3) Lemonade\n " +
                           "4) Ginger Ale\n " +
                           "5) Seltzer\n" +
                           "6) Spirit");
        int flavor = Console.PromptForInt("Pick a flavor");


    }

    public void displayAddChipsScreen() {
        //pick a chip
        System.out.println("1) Rap Snacks Cheddar\n " +
                "2) Ranch Doritos\n " +
                "3) Sun Chip\n " +
                "4) Takis\n " +
                "5) Original Lays\n" +
                "6) Rap Snacks BBQ");
        int chip = Console.PromptForInt("Pick a chip");
    }

    public void displayCheckoutScreen() {
        //display order details

        System.out.println("1) Checkout\n " +
                "2) Cancel \n ");
        int decision = Console.PromptForInt("Select an option");

    }
}
