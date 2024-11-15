package com.onleetosh.pluralsight.hero.topping;

public class Topping {

    private String type;
    private String topping;

    private double price;
    private boolean isPremium;
    private boolean isExtra;

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
     *  Value amounts for cheese based on size and extra
     */
    private final double fourInchCheeseCost = 0.75;
    private final double eightInchCheeseCost = 1.50;
    private final double footLongCheeseCost = 2.25;
    private final double fourInchExtraCheeseCost = 0.30;
    private final double eightInchExtraCheeseCost = 0.60;
    private final double footLongExtraCheeseCost = 0.90 ;




    public Topping(String topping, String type, double price){
        this.topping = topping;
        this.type = type;
        this.price = price;
    }


    /**
     * Constructor used to initialize premium object
     */
    public Topping(String topping,
                   String type,
                   boolean isPremium,
                   double price) {
        this.topping = topping;
        this.type = type;
        this.isPremium = isPremium;
        this.price = price;
    }


    /**
     * Getter methods to get a value
     */
    public double getPrice() {
        return price;
    }
    public String getTopping() {
        return topping;
    }
    public boolean isPremium() {
        return isPremium;
    }
    public String getType() {
        return type;
    }
    public boolean isExtra(){
        return isExtra;
    }


    /**
     * Setter methods to set a value
     */
    public void setTopping(String topping) {
        this.topping = topping;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }

    public void setType(String type) {
        this.type = type;
    }


    /**
     * This method is used to adjust the price based on size (4", 8", 12") and premium topping
     * with or without if extra after @param (size of bread) is filled
     */
    public void adjustPriceIfPremiumToppingAdd(int sizeOfBread,
                                               boolean isExtra) {
        price = 0.0;
        if(isPremium) {
            if (type.equalsIgnoreCase("meat")) {
                switch (sizeOfBread) {
                    case 4:
                        price = fourInchMeatCost;
                        if (isExtra) price += fourInchExtraMeatCost;
                        break;
                    case 8:
                        price = eightInchMeatCost;
                        if (isExtra) price += eightInchExtraMeatCost;
                        break;
                    case 12:
                        price = footLongMeatCost;
                        if (isExtra) price += footLongExtraMeatCost;
                        break;
                    default:
                        price = fourInchMeatCost;
                }
            }
            else if (type.equalsIgnoreCase("cheese")) {
                switch (sizeOfBread) {
                    case 4:
                        price = fourInchCheeseCost;
                        if (isExtra) price += fourInchExtraCheeseCost;
                        break;
                    case 8:
                        price = eightInchCheeseCost;
                        if (isExtra) price += eightInchExtraCheeseCost;
                        break;
                    case 12:
                        price = footLongCheeseCost;
                        if (isExtra) price += footLongExtraCheeseCost;
                        break;
                    default:
                        price = fourInchCheeseCost;
                }
            }
        }
    }


    /**
     * displayTopping() is used to display topping list without the labeled "extra ++" that is applied
     * to topping objects when promptForTopping after selectedTopping is to yes for extra
     */
    public String displayToppings() {
        String ifPremium = this.isPremium ? "(PREMIUM)" : " ";
        return " ["+type+"] " + topping + " " + ifPremium + " ";
    }


    /**
     * Use toString() return a String format for topping when displayed
     */
    @Override
    public String toString() {
        //if add extra is true mark as ++ else " REGUlAR AMOUNT "
        String ifExtra = this.isExtra ? "++" : " ";
        //if premium then mark as Premium else " NOT PREMIUM "
        String ifPremium = this.isPremium ? "(PREMIUM)" : " ";
        return " " + this.topping + //topping name
                " " + ifPremium + // Premium or Included
                " " + ifExtra + // Extra or regular amount
                " $" + String.format("%.2f", this.price);  //format price
    }

}
