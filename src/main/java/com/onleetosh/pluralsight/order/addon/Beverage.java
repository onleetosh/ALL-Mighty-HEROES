package com.onleetosh.pluralsight.order.addon;

public class Beverage {

    /**
     * Information needed to create chip object
     */
    private String typeOfBeverage;
    private String sizeOfCup;
    private double priceOfBeverage;

    /**
     * Value amounts for the size of beverage
     */
    private final double priceOfSmallBeverage = 2.00;
    private final double priceOfMediumBeverage = 2.50;
    private final double priceOfLargeBeverage = 3.00;

    /***
     * Constructors used to create beverage object
     */
    public Beverage(String typeOfBeverage) {
        this.typeOfBeverage = typeOfBeverage;
        this.sizeOfCup = "Small";
        this.priceOfBeverage = adjustPriceOfCup(this.sizeOfCup);
    }

    /***
     * Getter method used to get a value
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
     * Setters methods used to set a value
     */
    public void setTypeOfBeverage(String typeOfBeverage) {
        this.typeOfBeverage = typeOfBeverage;
    }

    public void setSizeOfCup(String sizeOfCup) {
        this.sizeOfCup = sizeOfCup;
        this.priceOfBeverage = adjustPriceOfCup(sizeOfCup); // update price
    }

    /***
     * Adjust the price of cup based on size
     */
    private double adjustPriceOfCup(String size) {
        if(size.equalsIgnoreCase("Small")){
            return  priceOfSmallBeverage;
        }
        else if (size.equalsIgnoreCase("Medium")){
            return priceOfMediumBeverage;
        }
        else if (size.equalsIgnoreCase("Large")) {
            return priceOfLargeBeverage;
        }
        else {
            return priceOfSmallBeverage;
        }
    }

    /**
     * Use toString() return a String format for beverage when displayed
     */
    @Override
    public String toString(){

        return  this.sizeOfCup +
                "  " + this.typeOfBeverage +
                "  $" + String.format("%.2f", priceOfBeverage);
    }
}