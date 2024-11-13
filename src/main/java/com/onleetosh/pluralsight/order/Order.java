package com.onleetosh.pluralsight.order;

import com.onleetosh.pluralsight.order.sandwich.Bread;
import com.onleetosh.pluralsight.order.sandwich.Sandwich;
import com.onleetosh.pluralsight.order.sandwich.Topping;

import java.util.ArrayList;

public class Order {

    private ArrayList<Sandwich> sandwiches;
    private ArrayList<Beverage> beverages;
    private ArrayList<Chips> chips;

    public static Bread selectedBread;
    public static ArrayList<Topping> selectedToppings;



    public Order(ArrayList<Sandwich> sandwiches, ArrayList<Beverage> beverages, ArrayList<Chips> chips) {
        this.sandwiches = sandwiches != null ? sandwiches : new ArrayList<>();
        this.beverages = beverages != null ? beverages : new ArrayList<>();
        this.chips = chips != null ? chips : new ArrayList<>();
    }

    // Methods to add sandwiches, drinks, and chips
    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addBeverage(Beverage beverage) {
        beverages.add(beverage);
    }

    public void addChip(Chips chip) {
        chips.add(chip);
    }

    public ArrayList<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public ArrayList<Beverage> getBeverages() {
        return beverages;
    }

    public ArrayList<Chips> getChips() {
        return chips;
    }

    // Method to calculate the total cost
    public double getTotalCost() {
        double totalCost = 0.0;
        for (Sandwich sandwich : sandwiches) {
            totalCost += sandwich.getTotalCost();
        }
        for (Beverage beverage : beverages) {
            totalCost += beverage.getPriceOfBeverage();
        }
        for (Chips chip : chips) {
            totalCost += chip.getPriceOfChips();
        }
        return totalCost;
    }

}
