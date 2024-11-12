package com.onleetosh.pluralsight.util;

import com.onleetosh.pluralsight.order.Beverage;
import com.onleetosh.pluralsight.order.Bread;
import com.onleetosh.pluralsight.order.Chips;
import com.onleetosh.pluralsight.topping.Topping;

import java.util.ArrayList;

public class Calculation {

    public static double totalSandwichOrderPrice(Bread selectedBread, ArrayList<Topping> toppings){
        return totalCostOfSingleSandwich(selectedBread, toppings);

    }
    public static double totalCostOfBeverage(Beverage selectedBeverage, ArrayList<Beverage> beverages){

        double totalCost =  selectedBeverage.getPriceOfBeverage();

        for (Beverage beverage: beverages){
            totalCost += beverage.getPriceOfBeverage();
        }

        return totalCost;

    }

    public static double totalCostOfChips(Chips selectedChips, ArrayList<Chips> chips){

        double totalCost =  selectedChips.getPriceOfChips();

        for (Chips chip: chips){
            totalCost += chip.getPriceOfChips();
        }

        return totalCost;

    }
    public static double totalCostOfSingleSandwich(Bread selectedBread, ArrayList<Topping> toppings) {
        double totalCost = selectedBread.getPrice();  // Start with the price of the bread

        // Add the cost of each topping (regular or premium)
        for (Topping topping : toppings) {
            totalCost += topping.getPrice();
        }
        return totalCost;
    }



}
