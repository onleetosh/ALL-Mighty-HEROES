package com.onleetosh.pluralsight.topping;

import com.onleetosh.pluralsight.order.Sandwich;

public class Topping {


    private final double fourInchMeatCost = 1.00;
    private final double eightInchMeatCost = 2.00;
    private final double footLongMeatCost = 3.00;
    private final double fourInchExtraMeatCost = 0.50;
    private final double eightInchExtraMeatCost = 1.00;
    private final double footLongExtraMeatCost = 1.50 ;


    private final double fourInchCheeseCost = 0.75;
    private final double eightInchCheeseCost = 1.50;
    private final double footLongCheeseCost = 2.25;
    private final double fourInchExtraCheeseCost = 0.30;
    private final double eightInchExtraCheeseCost = 0.60;
    private final double footLongExtraCheeseCost = 0.90 ;
    private String topping; // chicken / american / lettuce / presto
    private String type; //meat / cheese / fresh veg / condiments (sauce)
    private double price; // meat or cheese are consider premium and price based on sandwich size (4", 8", 12") . all other toppings are free
    private double extra;

    // Constructor
    public Topping(String topping, String type, double price) {
        this.topping = topping;
        this.type = type;
        this.price = price;
        this.extra = 0;  // Default extra to 0
    }

    // Constructor with extra
    public Topping(String topping, String type, double price, double extra) {
        this.topping = topping;
        this.type = type;
        this.price = price;
        this.extra = extra;
    }

    // Getters and setters
    public double getPrice() {
        return price;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Method to adjust the price based on topping type and bread size
    public void adjustPriceIfPremiumToppingAdd(int sizeOfBread, boolean isExtra) {
        if (type.equalsIgnoreCase("meat")) {
            switch (sizeOfBread) {
                case 4:
                    price = fourInchMeatCost;
                    if (isExtra) price += fourInchExtraMeatCost;
                    break;
                case 8:
                    price = eightInchMeatCost;
                    if (isExtra) price += eightInchExtraMeatCost;
                    break;
                case 12:
                    price = footLongMeatCost;
                    if (isExtra) price += footLongExtraMeatCost;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid bread size: " + sizeOfBread);
            }
        } else if (type.equalsIgnoreCase("cheese")) {
            switch (sizeOfBread) {
                case 4:
                    price = fourInchCheeseCost;
                    if (isExtra) price += fourInchExtraCheeseCost;
                    break;
                case 8:
                    price = eightInchCheeseCost;
                    if (isExtra) price += eightInchExtraCheeseCost;
                    break;
                case 12:
                    price = footLongCheeseCost;
                    if (isExtra) price += footLongExtraCheeseCost;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid bread size: " + sizeOfBread);
            }
        } else {
            // Other toppings (fresh veg and condiments) are free
            price = 0;
        }

        // Add extra cost if present
        if (isExtra && extra > 0) {
            price += extra;
        }
    }

    @Override
    public String toString() {
        return "Topping: " + topping + " | Type: " + type + " | Price: $" + price;
    }
}