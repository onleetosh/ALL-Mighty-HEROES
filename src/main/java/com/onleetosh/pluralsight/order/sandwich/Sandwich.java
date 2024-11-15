/***
 * Sandwich encapsulates the data required to initialize a sandwich object.
 */

package com.onleetosh.pluralsight.order.sandwich;

import java.util.ArrayList;

public class Sandwich {

    /**
     * Information need to create bread object
     */
    private int sizeOfBread;
    private Bread typeOfBread;
    private ArrayList<Topping> toppings;
    private double totalCostOfSandwich;
    private boolean isToast;

    /**
     * Constructor for sandwich object
     */
    public Sandwich(int sizeOfBread,
                    Bread typeOfBread,
                    ArrayList<Topping> toppings,
                    boolean isToast) {
        this.sizeOfBread = sizeOfBread;
        this.typeOfBread = typeOfBread;
        this.toppings = toppings;
        this.isToast = isToast;
        this.totalCostOfSandwich = calculateTotalCost();
    }

    /**
     * Getter methods to get a value
     */
    public int getSizeOfBread() {
        return sizeOfBread;
    }

    public Bread getTypeOfBread() {
        return typeOfBread;
    }


    public double getTotalCostOfSandwich() {
        return this.totalCostOfSandwich; // Return stored total cost
    }

    public void setTotalCostOfSandwich(double totalCostOfSandwich) {
        this.totalCostOfSandwich = totalCostOfSandwich;
    }


    /**
     * @return the total cost of a single hero by adding
     * the base price of select bread + the total cost of selected toppings
     */
    public double calculateTotalCost() {
        double basePrice = 0.0;
        double toppingCost = 0.0;

        // Calculate base price based on bread size
        switch (sizeOfBread) {
            case 4:
                basePrice = 5.50;
                break;
            case 8:
                basePrice = 7.00;
                break;
            case 12:
                basePrice = 8.50;
                break;
            default:
                System.out.println("Invalid size.");
                return 0;
        }

        // loop through and increment toppings to get a total
        for (Topping topping : toppings) {
            toppingCost += topping.getPrice();
        }

        return basePrice + toppingCost;
    }


    /**
     * Use a StringBuilder to append toppings selected into a list @return a String format to display sandwich
     */
    @Override
    public String toString() {
        StringBuilder listTopping = new StringBuilder();

        for (Topping topping : toppings) {
            // Add each topping on a new line
            listTopping.append(topping).append("\n");
        }
        String isToasted = this.isToast ? "YES" : "NO";

        return "Sandwich: " + typeOfBread + "\n" +
                "Toppings:\n" + listTopping +
                "Toast: " + isToasted + "\n" +
                "Total Cost: $" + String.format("%.2f", totalCostOfSandwich);
    }
}
