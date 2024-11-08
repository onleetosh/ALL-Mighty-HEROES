package com.onleetosh.pluralsight;

import com.onleetosh.pluralsight.order.Beverage;
import com.onleetosh.pluralsight.order.Chips;
import com.onleetosh.pluralsight.order.Sandwich;

public class Order {

    Sandwich sandwich;
    Beverage beverage;
    Chips chips;
    private double totalCost;

    public Order(Sandwich sandwich, Beverage beverage, Chips chips) {
        this.sandwich = sandwich;
        this.beverage = beverage;
        this.chips = chips;
    }

    public Sandwich getSandwich() {
        return sandwich;
    }

    public Beverage getBeverage() {
        return beverage;
    }

    public Chips getChips() {
        return chips;
    }

    public void setSandwich(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public void setBeverage(Beverage beverage) {
        this.beverage = beverage;
    }

    public void setChips(Chips chips) {
        this.chips = chips;
    }
}
