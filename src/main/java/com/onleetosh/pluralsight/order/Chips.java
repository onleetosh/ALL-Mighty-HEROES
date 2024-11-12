package com.onleetosh.pluralsight.order;

import java.util.List;

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
        return "One bag of " + bagOfChips + " $" + String.format("%.2f", priceOfChips);
    }
}
