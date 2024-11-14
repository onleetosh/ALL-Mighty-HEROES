/***
 * Sandwich encapsulates the data required to initialize a sandwich object.
 */

package com.onleetosh.pluralsight.order.sandwich;

import java.util.ArrayList;

public class Sandwich {

    // 4", 8", or 12"
    private int sizeOfBread;
    // bread price 4"($5.50), 8"(7.00), or 12" (8.50)
    // white, wheat, rye, wrap
    private Bread typeOfBread;

    //lettuce, peppers, onions, tomatoes, jalapenos, cucumber, pickles, banana peppers, mushrooms, guacamole
    // topping price - included
    private ArrayList<Topping> toppings;
    // Meats(steak, ham, salami, roast beef, chicken, bacon)  Cheese(american, provolone, cheddar, swiss)
    // premium price - 4"($1.00 extra meat .50), 8"(2.00 extra meat 1.00), or 12" (3.00 extra meat 1.50);
    private ArrayList<Topping> premiumTopping; //
    // Sauce ( Mayo, Mustard, Honey Mustard, Buffalo, Spicy Chiplote, Ketchup, Ranch, vinaigrette, thousand islands

    private double totalCostOfSandwich;

    private boolean isToast;

    /**
     * Constructor for regular sandwich object
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
     * Getter
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
     * return the total cost of a single sandwich
     * @return
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

    // format string so that the toppings are printed on separate lines
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
