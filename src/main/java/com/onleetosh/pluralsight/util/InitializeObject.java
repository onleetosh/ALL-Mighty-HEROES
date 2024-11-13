package com.onleetosh.pluralsight.util;

import com.onleetosh.pluralsight.order.Beverage;
import com.onleetosh.pluralsight.order.sandwich.Bread;
import com.onleetosh.pluralsight.order.Chips;
import com.onleetosh.pluralsight.order.sandwich.Topping;

import java.util.ArrayList;

public class InitializeObject {

    public static ArrayList<Beverage> listOfBeverageObjects(){

        UI.listOfBeverages = new ArrayList<Beverage>();
        UI.listOfBeverages.add(new Beverage("----"));
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
        UI.listOfChips.add(new Chips("------"));
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
    public static ArrayList<Bread> listOfBreadObjects() {
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
    public static ArrayList<Topping> listOfToppingObjects() {
        UI.listOfSandwichTopping = new ArrayList<>();

        // Regular toppings
        UI.listOfSandwichTopping.add(new Topping(" "," " ));
        UI.listOfSandwichTopping.add(new Topping("lettuce", "veggie",  false, 0.0)); //0
        UI.listOfSandwichTopping.add(new Topping("peppers", "veggie", false, 0.0)); //1
        UI.listOfSandwichTopping.add(new Topping("red onions", "veggie", false, 0.0)); //2
        UI.listOfSandwichTopping.add(new Topping("jalapenos", "veggie", false, 0.0)); //3
        UI.listOfSandwichTopping.add(new Topping("cucumber", "veggie", false, 0.0)); //4
        UI.listOfSandwichTopping.add(new Topping("pickles", "veggie", false, 0.0)); //5

        // Sauces
        UI.listOfSandwichTopping.add(new Topping("honey mustard", "sauce", false, 0.0)); //5
        UI.listOfSandwichTopping.add(new Topping("ranch", "sauce", false, 0.0)); //7
        UI.listOfSandwichTopping.add(new Topping("mayo", "sauce", false, 0.0)); //8
        UI.listOfSandwichTopping.add(new Topping("mustard", "sauce", false, 0.0)); //9
        UI.listOfSandwichTopping.add(new Topping("ketchup", "sauce", false, 0.0)); //10

        // Premium toppings (Meats and Cheese)
        UI.listOfSandwichTopping.add(new Topping("grill chicken", "meat", true, 1.00)); //11
        UI.listOfSandwichTopping.add(new Topping("bacon", "meat", true, 1.00)); //12
        UI.listOfSandwichTopping.add(new Topping("roast beef", "meat", true, 1.00)); //13
        UI.listOfSandwichTopping.add(new Topping("salami", "meat",true, 1.00)); //14
        UI.listOfSandwichTopping.add(new Topping("ham", "meat",true, 1.00)); //15
        UI.listOfSandwichTopping.add(new Topping("steak", "meat",true, 1.00)); //16
        UI.listOfSandwichTopping.add(new Topping("provolone", "cheese", true, 0.70)); //17
        UI.listOfSandwichTopping.add(new Topping("cheddar", "cheese",true, 0.70)); //18
        UI.listOfSandwichTopping.add(new Topping("swiss", "cheese", true, 0.70)); //19
        UI.listOfSandwichTopping.add(new Topping("american", "cheese",true, 0.70)); //20

        return UI.listOfSandwichTopping;
    }


}
