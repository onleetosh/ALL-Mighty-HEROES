package com.onleetosh.pluralsight.order;

import java.util.ArrayList;

public class Beverage {

    private String typeOfBeverage;
    private String sizeOfCup;
    private double priceOfBeverage;

    private ArrayList<Beverage> typesOfBeverages;

    private final double priceOfSmallBeverage = 2.00;
    private final double priceOfMediumBeverage = 2.50;
    private final double priceOfLargeBeverage = 3.00;

    public Beverage(ArrayList<Beverage> typesOfBeverages) {
        this.typesOfBeverages = typesOfBeverages;
    }

    /***
     * Constructors
     */
    public Beverage(String typeOfBeverage) {
        this.typeOfBeverage = typeOfBeverage;
        this.sizeOfCup = "s";
        this.priceOfBeverage = adjustPriceOfCup(this.sizeOfCup);
    }

    public Beverage(String typeOfBeverage, String sizeOfCup, int priceOfBeverage) {
        this.typeOfBeverage = typeOfBeverage;
        this.sizeOfCup = sizeOfCup;
        this.priceOfBeverage = adjustPriceOfCup(this.sizeOfCup);
    }

    /***
     * Getter
     */
    public String getTypeOfBeverage() {
        return typeOfBeverage;
    }

    public String getSizeOfCup() {
        return sizeOfCup;
    }

    public double getPriceOfBeverage() {
        return priceOfBeverage;
    }

    /***
     * Setters
     */
    public void setTypeOfBeverage(String typeOfBeverage) {
        this.typeOfBeverage = typeOfBeverage;
    }

    public void setSizeOfCup(String sizeOfCup) {
        this.sizeOfCup = sizeOfCup;
        this.priceOfBeverage = adjustPriceOfCup(sizeOfCup); // update price
    }

    public void setPriceOfBeverage(double priceOfBeverage) {
        this.priceOfBeverage = priceOfBeverage;
    }

    /***
     * Adjust the price of cup based on size
     */
    private double adjustPriceOfCup(String size) {
        if(size.equalsIgnoreCase("S")){
            return  priceOfSmallBeverage;
        }

        else if (size.equalsIgnoreCase("M")){
            return priceOfMediumBeverage;
        }
        else if (size.equalsIgnoreCase("L")) {
            return priceOfLargeBeverage;
        }
        else {
            return priceOfSmallBeverage;
        }
    }

    /***
     * Adjust the price of cup based on size
     */
    public double getPrice() {
        switch (this.sizeOfCup) {
            case "S": return priceOfSmallBeverage;
            case "M": return priceOfMediumBeverage; // Example price adjustment for Medium
            case "L": return priceOfLargeBeverage; // Example price adjustment for Large
            default: throw new IllegalArgumentException("Invalid size: " + sizeOfCup);

        }
    }

    @Override
    public String toString(){
        return "One " + this.sizeOfCup +
                " size, " + this.typeOfBeverage +
                " beverage. Total: $" + String.format("%.2f", priceOfBeverage);
    }
}
