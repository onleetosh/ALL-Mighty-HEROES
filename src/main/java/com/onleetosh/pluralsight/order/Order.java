package com.onleetosh.pluralsight.order;

import java.util.ArrayList;

public class Order {

    Sandwich sandwich;
    Beverage beverage;
    Chips chips;

   // public static ArrayList<Sandwich> sandwichOrders;

    public static ArrayList<Sandwich> sandwichesList;
    public static ArrayList<Chips> chipList;
    public static ArrayList<Beverage> beveragesList;

    public Order(ArrayList<Beverage> beveragesList,
                 ArrayList<Chips> chipList,
                 ArrayList<Sandwich> sandwichesList) {
        this.beveragesList = beveragesList;
        this.chipList = chipList;
        this.sandwichesList = sandwichesList;
    }

    public ArrayList<Beverage> getBeveragesList() {
        return beveragesList;
    }

    public void setBeveragesList(ArrayList<Beverage> beveragesList) {
        this.beveragesList = beveragesList;
    }

    public ArrayList<Sandwich> getSandwichesList() {
        return sandwichesList;
    }

    public void setSandwichesList(ArrayList<Sandwich> sandwichesList) {
        this.sandwichesList = sandwichesList;
    }

    public ArrayList<Chips> getChipList() {
        return chipList;
    }

    public void setChipList(ArrayList<Chips> chipList) {
        this.chipList = chipList;
    }


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

    public double getTotalPrice() {
        return (sandwich != null ? sandwich.getTotalCost() : 0) +
                (beverage != null ? beverage.getPriceOfBeverage() : 0) +
                (chips != null ? chips.getPriceOfChips() : 0);    }

    @Override
    public String toString(){
        //return "Order place: Sandwich " + this.sandwich + " with " + this.beverage + " and a side of " + this.chips;

        return "Order placed: " +
                "\nSandwich: " + (sandwich != null ? sandwich : "No sandwich") +
                "\nBeverage: " + (beverage != null ? beverage : "No beverage") +
                "\nChips: " + (chips != null ? chips : "No chips");

    }

}
