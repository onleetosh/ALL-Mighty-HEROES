package com.onleetosh.pluralsight;

import com.onleetosh.pluralsight.topping.PremiumTopping;
import com.onleetosh.pluralsight.topping.RegularTopping;
import com.onleetosh.pluralsight.topping.Sauce;
import com.onleetosh.pluralsight.topping.Topping;
import com.onleetosh.pluralsight.util.Console;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

/*    private String lettuce;
    private String peppers;
    private String onions;
    private String tomatoes;
    private String jalapenos;
    private String cucumber;
    private String pickles;
    private String mushrooms;
    private String guacamole;*/

        // white, wheat, rye, wrap
        //lettuce, peppers, onions, tomatoes, jalapenos, cucumber, pickles, banana peppers, mushrooms, guacamole
        // topping price - included
        // Meats(steak, ham, salami, roast beef, chicken, bacon)  Cheese(american, provolone, cheddar, swiss)
        // premium price - 4"($1.00 extra meat .50), 8"(2.00 extra meat 1.00), or 12" (3.00 extra meat 1.50);
        // Sauce ( Mayo, Mustard, Honey Mustard, Buffalo, Spicy Chiplote, Ketchup, Ranch, vinaigrette, thousand islands

        //add objects to a ArrayList of regular toppings
        ArrayList<Topping> sandwichTopping = new ArrayList<>();
        sandwichTopping.add(new RegularTopping( "lettuce", "regular", 0.0));
        sandwichTopping.add(new RegularTopping( "peppers", "regular", 0.0));
        sandwichTopping.add(new RegularTopping("red onions", "regular", 0.0));
        sandwichTopping.add(new RegularTopping( "jalapenos", "regular",0.0));
        sandwichTopping.add(new RegularTopping( "cucumber", "regular", 0.0));
        sandwichTopping.add(new RegularTopping( "pickles", "regular", 0.0));

        sandwichTopping.add(new Sauce( "honey mustard", "sauce", 0.0));
        sandwichTopping.add(new Sauce( "ranch", "sauce", 0.0));
        sandwichTopping.add(new Sauce("mayo", "sauce", 0.0));
        sandwichTopping.add(new Sauce( "mustard", "sauce", 0.0));
        sandwichTopping.add(new Sauce( "ketchup", "sauce", 0.0));
        sandwichTopping.add(new Sauce( "pickles", "sauce", 0.0));
        sandwichTopping.add(new Sauce( "banana peppers", "sauce", 0.0));

        //TODO: adjust cost - 4"($1.00 extra meat .50), 8"(2.00 extra meat 1.00), 12" (3.00 extra meat 1.50);
        sandwichTopping.add(new PremiumTopping( "grill chicken", "premium", 1.00)); // meats
        sandwichTopping.add(new PremiumTopping( "bacon", "premium",1.00 ));
        sandwichTopping.add(new PremiumTopping( "roast beef", "premium", 1.00));
        sandwichTopping.add(new PremiumTopping("salami", "premium", 1.00));
        sandwichTopping.add(new PremiumTopping( "ham", "premium", 1.00));
        sandwichTopping.add(new PremiumTopping( "steak", "premium", 1.00));
        sandwichTopping.add(new PremiumTopping( "provolone", "premium", 1.00)); // cheeses
        sandwichTopping.add(new PremiumTopping( "cheddar", "premium", 1.00));
        sandwichTopping.add(new PremiumTopping( "swiss", "premium", 1.00));
        sandwichTopping.add(new PremiumTopping( "american", "premium", 1.00));


    /*    //this will loop and display all toppings added
        for(Topping i : sandwichTopping) {
            System.out.println(i);
        }
*/
        for (int i = 0; i< sandwichTopping.size(); i++) {
            if ( sandwichTopping.get(i) instanceof PremiumTopping) {
              //  System.out.println(i); //outputs only the position
              PremiumTopping premiumTopping = (PremiumTopping) sandwichTopping.get(i); //get the positions
              System.out.println(premiumTopping.toString());

            }
        }



        //add objects to an ArrayList of premium toppings

        ArrayList<String> premiumMeat = new ArrayList<>();
        premiumMeat.add(0,"chicken");
        premiumMeat.add(1,"bacon");
        premiumMeat.add(2,"ham");
        premiumMeat.add(3,"steak");
        premiumMeat.add(4,"salami");
        premiumMeat.add(5,"roast beef");
        premiumMeat.add(6,"ham");
        premiumMeat.add(7,"chicken");




        System.out.println("Welcome to the a sandwich shop \n lets make a order");

        int bread = Console.PromptForInt("Select a bread." );

        int addTopping = Console.PromptForInt("Select topping ");


        int size = Console.PromptForInt("Select size");

        boolean wantToast = Console.PromptForYesNo("Do you want to toast");

    }

}