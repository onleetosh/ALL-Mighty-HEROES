package com.onleetosh.pluralsight.util;

import com.onleetosh.pluralsight.addon.*;
import com.onleetosh.pluralsight.hero.Bread;
import com.onleetosh.pluralsight.hero.topping.*;

import java.util.ArrayList;

public class InitializeObject {

    /**
     * Initialize cookie objects and add them to an ArrayList
     */
    public static ArrayList<Cookie> listOfCookieObjects(){
        UI.cookieList = new ArrayList<Cookie>();
        UI.cookieList.add(new Cookie("Secret Cookie", 1.50));
        UI.cookieList.add(new Cookie("Chocolate Chuck", 1.50));
        UI.cookieList.add(new Cookie("Snickerdoodles", 1.50));
        UI.cookieList.add(new Cookie("Sugar Rush", 1.50));
        UI.cookieList.add(new Cookie("Oatmeal Raisin", 1.50));

        return  UI.cookieList;
    }
    /**
     * Initialize beverage objects and add them to an ArrayList
     */
    public static ArrayList<Beverage> listOfBeverageObjects(){

        UI.beveragesList = new ArrayList<Beverage>();
        UI.beveragesList.add(new Beverage("Secret Beverage"));
        UI.beveragesList.add(new Beverage("Seltzer"));
        UI.beveragesList.add(new Beverage("Coke"));
        UI.beveragesList.add(new Beverage("Spirit"));
        UI.beveragesList.add(new Beverage("Crush"));
        UI.beveragesList.add(new Beverage("Ginger Ale"));
        UI.beveragesList.add(new Beverage("Strawberry Lemonade"));
        UI.beveragesList.add(new Beverage("Mango Lemonade"));
        UI.beveragesList.add(new Beverage("Iced Tea"));
        UI.beveragesList.add(new Beverage("Green Tea"));
        UI.beveragesList.add(new Beverage("Fruit Punch"));
        UI.beveragesList.add(new Beverage("Passion Fruit"));

        return UI.beveragesList;
    }

    /**
     * Initialize chip objects and add them to an ArrayList
     */
    public static ArrayList<Chips> listOfChipObjects(){
        UI.chipsList = new ArrayList<Chips>();
        UI.chipsList.add(new Chips("Secret Chips"));
        UI.chipsList.add(new Chips("Rap Snacks, Bar-B-Que"));
        UI.chipsList.add(new Chips("Lay's Classic" ));
        UI.chipsList.add(new Chips("Frito Lay Baked, Classic  "));
        UI.chipsList.add(new Chips("Ruffles Baked, Cheddar & Sour Cream"));
        UI.chipsList.add(new Chips("Zapp's Kettle"));
        UI.chipsList.add(new Chips("Zapp's Voodoo"));
        UI.chipsList.add(new Chips("Doritos, Ranch" ));
        UI.chipsList.add(new Chips("Doritos, Nacho Cheese"));

        return  UI.chipsList;

    }

    /**
     * Initialize bread objects and add them to an ArrayList
     */
    public static ArrayList<Bread> listOfBreadObjects() {
        UI.breadList = new ArrayList<>();
        UI.breadList .add(new Bread("Special Roll"));
        UI.breadList .add(new Bread("italian"));
        UI.breadList .add(new Bread("honey wheat"));
        UI.breadList .add(new Bread("wrap"));
        UI.breadList .add(new Bread("rye"));

        return UI.breadList ;
    }

    /**
     * Initialize topping objects and add them to an ArrayList
     */
    public static ArrayList<Topping> listOfToppingObjects() {
        UI.heroToppingList = new ArrayList<>();

        UI.heroToppingList.add(new Veggie("spicy pepper ","veggie ", 0.0 ));
        UI.heroToppingList.add(new Veggie("lettuce", "veggie", 0.0));
        UI.heroToppingList.add(new Veggie("tomato", "veggie", 0.0));
        UI.heroToppingList.add(new Veggie("spinach", "veggie", 0.0));
        UI.heroToppingList.add(new Veggie("banana peppers", "veggie", 0.0));
        UI.heroToppingList.add(new Veggie("red onions", "veggie", 0.0));
        UI.heroToppingList.add(new Veggie("jalapenos", "veggie", 0.0));
        UI.heroToppingList.add(new Veggie("cucumber", "veggie", 0.0));
        UI.heroToppingList.add(new Veggie("pickles", "veggie", 0.0));


        UI.heroToppingList.add(new Sauce("honey mustard", "sauce",  0.0)); //5
        UI.heroToppingList.add(new Sauce("ranch", "sauce", 0.0)); //7
        UI.heroToppingList.add(new Sauce("mayo", "sauce",  0.0)); //8
        UI.heroToppingList.add(new Sauce("spicy mustard", "sauce",  0.0)); //9
        UI.heroToppingList.add(new Sauce("ketchup", "sauce",  0.0)); //10
        UI.heroToppingList.add(new Sauce("oil & vinegar", "sauce",  0.0)); //10
        UI.heroToppingList.add(new Sauce("ranch", "sauce",  0.0)); //7

        UI.heroToppingList.add(new Meat("prosciutto", "meat", true, 1.00)); //12
        UI.heroToppingList.add(new Meat("honey turkey", "meat", true, 1.00)); //12
        UI.heroToppingList.add(new Meat("grill chicken", "meat", true, 1.00)); //11
        UI.heroToppingList.add(new Meat("bacon", "meat", true, 1.00)); //12
        UI.heroToppingList.add(new Meat("roast beef", "meat", true, 1.00)); //13
        UI.heroToppingList.add(new Meat("salami", "meat",true, 1.00)); //14
        UI.heroToppingList.add(new Meat("ham", "meat",true, 1.00)); //15
        UI.heroToppingList.add(new Meat("steak", "meat",true, 1.00)); //16
        UI.heroToppingList.add(new Cheese("provolone", "cheese", true, 0.70)); //17
        UI.heroToppingList.add(new Cheese("cheddar", "cheese",true, 0.70)); //18
        UI.heroToppingList.add(new Cheese("swiss", "cheese", true, 0.70)); //19
        UI.heroToppingList.add(new Cheese("muenster", "cheese",true, 0.70)); //20
        UI.heroToppingList.add(new Cheese("white american", "cheese",true, 0.70)); //20
        UI.heroToppingList.add(new Cheese("chipotle gouda", "cheese",true, 0.70)); //18

        return UI.heroToppingList;
    }


}
