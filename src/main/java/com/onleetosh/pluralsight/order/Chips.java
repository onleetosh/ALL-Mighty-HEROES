/**
 *  Chips encapsulates the data required to initialize a chip object.
 */

package com.onleetosh.pluralsight.order;

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

    public String getBagOfChips() {
        return bagOfChips;
    }

    public double getPriceOfChips() {
        return priceOfChips;
    }

    @Override
    public String toString() {
        return  bagOfChips + " $" + String.format("%.2f", priceOfChips);
    }
}
