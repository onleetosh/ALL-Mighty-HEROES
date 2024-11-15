package com.onleetosh.pluralsight.order.addon;

public class Chips {

    /**
     * Information needed to create chip object
     */
    private String bagOfChips;
    private double priceOfChips;

    /**
     * Value amount for chips
     */
    private final double valueAmountForChips = 1.50;

    /**
     * Constructor used to initialize chip object
     */
    public Chips(String bagOfChips) {
        this.bagOfChips = bagOfChips;
        this.priceOfChips = valueAmountForChips;
    }

    /**
     * Getter methods to get a value
     */
    public String getBagOfChips() {
        return bagOfChips;
    }

    public double getPriceOfChips() {
        return priceOfChips;
    }

    /**
     * Use toString() return a String format for chip when displayed
     */
    @Override
    public String toString() {
        return " " + bagOfChips + " $" + String.format("%.2f", priceOfChips);
    }
}
