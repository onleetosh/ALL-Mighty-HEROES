package com.onleetosh.pluralsight.hero.topping;

public class Cheese extends Topping{


    /**
     *  Value amounts for cheese based on size and extra
     */
    private final double fourInchCheeseCost = 0.75;
    private final double eightInchCheeseCost = 1.50;
    private final double footLongCheeseCost = 2.25;
    private final double fourInchExtraCheeseCost = 0.30;
    private final double eightInchExtraCheeseCost = 0.60;
    private final double footLongExtraCheeseCost = 0.90 ;


    /**
     * Constructor used to initialize topping object
     *
     * @param topping
     * @param type
     * @param isPremium
     * @param price
     */
    public Cheese(String topping,
                  String type,
                  boolean isPremium,
                  double price) {
        super(topping, type, isPremium, price);
    }


    public String toString(){
        return super.toString();
    }


}

