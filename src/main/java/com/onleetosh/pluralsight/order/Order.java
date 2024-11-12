package com.onleetosh.pluralsight.order;

import java.util.ArrayList;

public class Order {

    Sandwich sandwich;
    Beverage beverage;
    Chips chips;

    public static ArrayList<Order> orderPlace;
    public static ArrayList<Sandwich> sandwichOrders;
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

    @Override
    public String toString(){
        return "Order place: Sandwich " + this.sandwich + " with " + this.beverage + " and a side of " + this.chips;
    }

}
