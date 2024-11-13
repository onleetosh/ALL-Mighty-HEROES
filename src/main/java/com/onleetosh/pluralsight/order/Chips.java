/**
 *  Chips encapsulates the data required to initialize a chip object.
 */

package com.onleetosh.pluralsight.order;

public class Chips {

    private String bagOfChips;
    private double priceOfChips;


    public Chips(String bagOfChips) {
        this.bagOfChips = bagOfChips;
        this.priceOfChips = 1.50;
    }
    public Chips(String bagOfChips, double priceOfChips) {
        this.bagOfChips = bagOfChips;
        this.priceOfChips = 1.50;
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
