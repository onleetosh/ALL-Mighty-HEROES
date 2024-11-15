package com.onleetosh.pluralsight.hero.topping;

public class Meat extends Topping{

    /**
     *  Value amounts for meat based on size and extra
     */
    private final double fourInchMeatCost = 1.00;
    private final double eightInchMeatCost = 2.00;
    private final double footLongMeatCost = 3.00;
    private final double fourInchExtraMeatCost = 0.50;
    private final double eightInchExtraMeatCost = 1.00;
    private final double footLongExtraMeatCost = 1.50 ;


    /**
     * Constructor used to initialize topping object
     *
     * @param topping
     * @param type
     * @param isPremium
     * @param price
     */
    public Meat(String topping,
                String type,
                boolean isPremium,
                double price) {
        super(topping, type, isPremium, price);
    }

    public String toString(){
        return super.toString();
    }

}
