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

    public void setBagOfChips(String bagOfChips) {
        this.bagOfChips = bagOfChips;
    }

    public double getPriceOfChips() {
        return priceOfChips;
    }


    public void setPriceOfChips(double priceOfChips) {
        this.priceOfChips = priceOfChips;
    }

    @Override
    public String toString() {
        return "Updating order .. " + bagOfChips + " $" + String.format("%.2f", priceOfChips);
    }
}
