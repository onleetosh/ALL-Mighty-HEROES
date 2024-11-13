package com.onleetosh.pluralsight.util;

import com.onleetosh.pluralsight.order.sandwich.Bread;
import com.onleetosh.pluralsight.order.sandwich.Topping;

import java.util.ArrayList;

public class Calculation {

    // Calculate the total cost of the sandwich, including bread and toppings
    public static double totalCostOfSandwich(Bread selectedBread,
                                             ArrayList<Topping> toppings) {
        double totalCost = selectedBread.getPrice();  // Start with the price of the bread

        // Add the cost of each topping (regular or premium)
        for (Topping topping : toppings) {
            totalCost += topping.getPrice();
        }

        return totalCost;
    }

}
