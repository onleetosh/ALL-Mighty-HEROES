package com.onleetosh.pluralsight.order;

import com.onleetosh.pluralsight.order.sandwich.Sandwich;

import java.util.ArrayList;

public class Order {

    private ArrayList<Sandwich> sandwiches;
    private ArrayList<Beverage> beverages;
    private ArrayList<Chips> chips;

    public Order(ArrayList<Sandwich> sandwiches, ArrayList<Beverage> beverages, ArrayList<Chips> chips) {
        this.sandwiches = new ArrayList<>();
        this.beverages = new ArrayList<>();
        this.chips = new ArrayList<>();
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
            totalCost += sandwich.getTotalCostOfSandwich();
        }
        for (Beverage beverage : beverages) {
            totalCost += beverage.getPriceOfBeverage();
        }
        for (Chips chip : chips) {
            totalCost += chip.getPriceOfChips();
        }
        return totalCost;
    }

    @Override
    public String toString() {
        StringBuilder formatOrder = new StringBuilder();
        formatOrder.append("=================================\n");
        formatOrder.append("        Order Summary:\n");
        formatOrder.append("=================================\n");
        // Display sandwiches
        if (sandwiches != null && !sandwiches.isEmpty()) {
            formatOrder.append("Sandwiches:\n");
            for (Sandwich sandwich : sandwiches) {
                formatOrder.append(sandwich.toString()).append("\n");
            }
        }
        // Display beverages
        if (beverages != null && !beverages.isEmpty()) {
            formatOrder.append("Beverages:\n");
            for (Beverage beverage : beverages) {
                formatOrder.append(beverage.toString()).append("\n");
            }
        }
        // Display chips
        if (chips != null && !chips.isEmpty()) {
            formatOrder.append("Chips:\n");
            for (Chips chip : chips) {
                formatOrder.append(chip.toString()).append("\n");
            }
        }

        // Display total cost
        formatOrder.append("=================================\n");
        formatOrder.append("Total Price: $").append(String.format("%.2f", getTotalCost())).append("\n");
        formatOrder.append("=================================\n");

        return formatOrder.toString();
    }
}
