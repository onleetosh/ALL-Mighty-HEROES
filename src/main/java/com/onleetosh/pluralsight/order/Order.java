package com.onleetosh.pluralsight.order;

import com.onleetosh.pluralsight.addon.*;

import com.onleetosh.pluralsight.hero.Hero;

import java.util.ArrayList;

public class Order {

    /**
     * Information needed to create an Order object
     */
    private ArrayList<Hero> heroes;
    private ArrayList<Beverage> beverages;
    private ArrayList<Chips> chips;
    private ArrayList<Cookie> cookies;


    /**
     * Constructor for empty order
     */
    public Order(){
        this.heroes = new ArrayList<>();
        this.beverages = new ArrayList<>();
        this.chips = new ArrayList<>();
        this.cookies = new ArrayList<>();
    }


    /**
     * Constructor for initializing an order
     */
    public Order(ArrayList<Hero> heroes,
                 ArrayList<Beverage> beverages,
                 ArrayList<Chips> chips,
                 ArrayList<Cookie> cookies) {
        this.heroes = new ArrayList<>();
        this.beverages = new ArrayList<>();
        this.chips = new ArrayList<>();
        this.cookies = new ArrayList<>();

    }

    // Methods to add sandwiches, drinks, and chips
    public void addSandwich(Hero hero) {
        heroes.add(hero);
    }

    public void addBeverage(Beverage beverage) {
        beverages.add(beverage);
    }

    public void addChip(Chips chip) {
        chips.add(chip);
    }

    public void addCookie(Cookie cookie) {
        cookies.add(cookie);
    }

    /**
     * Getter methods used to get an value
     */
    public ArrayList<Hero> getSandwiches() {
        return heroes;
    }
    public ArrayList<Beverage> getBeverages() {
        return beverages;
    }
    public ArrayList<Chips> getChips() {
        return chips;
    }
    public ArrayList<Cookie> getCookies() {
        return cookies;
    }

    /**
     * @return the total amount of an order by incrementing all objects created
     */
    public double getTotalCost() {
        double totalCost = 0.0;
        for (Hero sandwich : heroes) {
            totalCost += sandwich.getTotalCostOfSandwich();
        }
        for (Beverage beverage : beverages) {
            totalCost += beverage.getPriceOfBeverage();
        }
        for (Chips chip : chips) {
            totalCost += chip.getPriceOfChips();
        }
        for (Cookie cookie : cookies) {
            totalCost += cookie.getPriceOfCookie();
        }
        return totalCost;
    }

    /**
     * Use a StringBuilder to append all objects created for an order and
     * @return the String format for a receipt
     */
    @Override
    public String toString() {
        StringBuilder formatOrder = new StringBuilder();
        formatOrder.append("===================================\n");
        formatOrder.append("        Order Summary:\n");
        formatOrder.append("===================================\n");
        // Display sandwiches
        if (heroes != null && !heroes.isEmpty()) {
            formatOrder.append("          Heroes:\n");
            for (Hero order : heroes) {
                formatOrder.append(order.toString()).append("\n");
            }
        }
        // Display beverages
        if (beverages != null && !beverages.isEmpty()) {
            formatOrder.append("          Beverages:\n");
            for (Beverage order : beverages) {
                formatOrder.append(order.toString()).append("\n");
            }
        }
        // Display chips
        if (chips != null && !chips.isEmpty()) {
            formatOrder.append("             Add on:\n");
            for (Chips order : chips) {
                formatOrder.append(order.toString()).append("\n");
            }
        }
        // Display cookie
        if (cookies != null && !cookies.isEmpty()) {
            for (Cookie order : cookies) {
                formatOrder.append(order.toString()).append("\n");
            }
        }

        // Display total cost
        formatOrder.append("===================================\n");
        formatOrder.append(  "Total Price: $").append(String.format("%.2f", getTotalCost())).append("\n");
        formatOrder.append("===================================\n");

        return formatOrder.toString();
    }
}

