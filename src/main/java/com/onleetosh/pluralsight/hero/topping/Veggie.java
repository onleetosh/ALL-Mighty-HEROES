package com.onleetosh.pluralsight.hero.topping;

public class Veggie extends Topping{
    /**
     * Constructor used to initialize topping object
     *
     * @param topping
     * @param type
     * @param price
     */
    public Veggie(String topping,
                  String type,
                  double price) {
        super(topping, type, price);
    }

    public String toString(){
        return super.toString();
    }
}
