package com.onleetosh.pluralsight.util;

import com.onleetosh.pluralsight.order.Beverage;
import com.onleetosh.pluralsight.order.Bread;
import com.onleetosh.pluralsight.order.Chips;
import com.onleetosh.pluralsight.topping.PremiumTopping;
import com.onleetosh.pluralsight.topping.RegularTopping;
import com.onleetosh.pluralsight.topping.Sauce;
import com.onleetosh.pluralsight.topping.Topping;

import java.util.ArrayList;

public class InitializeObject {

    public static ArrayList<Beverage> listOfBeverageObjects(){

        UI.listOfBeverages = new ArrayList<Beverage>();

        UI.listOfBeverages.add(new Beverage("Spirit"));
        UI.listOfBeverages.add(new Beverage("Coke"));
        UI.listOfBeverages.add(new Beverage("Fruit Punch"));
        UI.listOfBeverages.add(new Beverage("Ginger Ale"));
        UI.listOfBeverages.add(new Beverage("Lemonade"));
        UI.listOfBeverages.add(new Beverage("Iced Tea"));
        UI.listOfBeverages.add(new Beverage("Spirit"));

        return UI.listOfBeverages;
    }



    /**
     * Initialize chip objects and add them to an ArrayList of Chips
     */
    public static ArrayList<Chips> listOfChipObjects(){
        UI.listOfChips = new ArrayList<Chips>();
        UI.listOfChips.add(new Chips("BQQ Rap Snacks"));
        UI.listOfChips.add(new Chips("Cheetos"));
        UI.listOfChips.add(new Chips("Original Lay's" ));
        UI.listOfChips.add(new Chips("Ranch Doritos"));
        UI.listOfChips.add(new Chips("Cheddar Sunchips"));
        UI.listOfChips.add(new Chips("Fritos"));
        UI.listOfChips.add(new Chips("Nacho Cheese Doritos" ));

        return  UI.listOfChips;


    }


    // Initialize bread options
    public static ArrayList<Bread> initializeBread() {
        UI.listOfBread = new ArrayList<>();
        UI.listOfBread .add(new Bread(" ",4));
        UI.listOfBread .add(new Bread("white", 4));
        UI.listOfBread .add(new Bread("white", 8));
        UI.listOfBread .add(new Bread("white", 12));
        UI.listOfBread .add(new Bread("wheat", 4));
        UI.listOfBread .add(new Bread("wheat", 8));
        UI.listOfBread .add(new Bread("wheat", 12));
        UI.listOfBread .add(new Bread("wrap", 4));
        UI.listOfBread .add(new Bread("wrap", 8));
        UI.listOfBread .add(new Bread("wrap", 12));
        UI.listOfBread .add(new Bread("rye", 4));
        UI.listOfBread .add(new Bread("rye", 8));
        UI.listOfBread .add(new Bread("rye", 12));

        return UI.listOfBread ;
    }

    // Initialize topping options
    public static ArrayList<Topping> initializeToppings() {
        UI.listOfSandwichTopping = new ArrayList<>();

        // Regular toppings
        UI.listOfSandwichTopping.add(new Topping(" "," ", 0 ));
        UI.listOfSandwichTopping.add(new RegularTopping("lettuce", "regular", 0.0)); //0
        UI.listOfSandwichTopping.add(new RegularTopping("peppers", "regular", 0.0)); //1
        UI.listOfSandwichTopping.add(new RegularTopping("red onions", "regular", 0.0)); //2
        UI.listOfSandwichTopping.add(new RegularTopping("jalapenos", "regular", 0.0)); //3
        UI.listOfSandwichTopping.add(new RegularTopping("cucumber", "regular", 0.0)); //4
        UI.listOfSandwichTopping.add(new RegularTopping("pickles", "regular", 0.0)); //5

        // Sauces
        UI.listOfSandwichTopping.add(new Sauce("honey mustard", "sauce", 0.0)); //5
        UI.listOfSandwichTopping.add(new Sauce("ranch", "sauce", 0.0)); //7
        UI.listOfSandwichTopping.add(new Sauce("mayo", "sauce", 0.0)); //8
        UI.listOfSandwichTopping.add(new Sauce("mustard", "sauce", 0.0)); //9
        UI.listOfSandwichTopping.add(new Sauce("ketchup", "sauce", 0.0)); //10

        // Premium toppings (Meats and Cheese)
        UI.listOfSandwichTopping.add(new PremiumTopping("grill chicken", "meat", 1.00)); //11
        UI.listOfSandwichTopping.add(new PremiumTopping("bacon", "meat", 1.00)); //12
        UI.listOfSandwichTopping.add(new PremiumTopping("roast beef", "meat", 1.00)); //13
        UI.listOfSandwichTopping.add(new PremiumTopping("salami", "meat", 1.00)); //14
        UI.listOfSandwichTopping.add(new PremiumTopping("ham", "meat", 1.00)); //15
        UI.listOfSandwichTopping.add(new PremiumTopping("steak", "meat", 1.00)); //16
        UI.listOfSandwichTopping.add(new PremiumTopping("provolone", "cheese", 1.00)); //17
        UI.listOfSandwichTopping.add(new PremiumTopping("cheddar", "cheese", 1.00)); //18
        UI.listOfSandwichTopping.add(new PremiumTopping("swiss", "cheese", 1.00)); //19
        UI.listOfSandwichTopping.add(new PremiumTopping("american", "cheese", 1.00)); //20

        return UI.listOfSandwichTopping;
    }


}
