/**
 * This class encapsulates a sandwich
 */

package com.onleetosh.pluralsight.order;

public class Sandwich {


    // 4", 8", or 12"
    private int sizeOfBread;
    // bread price 4"($5.50), 8"(7.00), or 12" (8.50)
    // white, wheat, rye, wrap
    private String typeOfBread;
    //lettuce, peppers, onions, tomatoes, jalapenos, cucumber, pickles, banana peppers, mushrooms, guacamole
    // topping price - included
    private String regularTopping;
    // Meats(steak, ham, salami, roast beef, chicken, bacon)  Cheese(american, provolone, cheddar, swiss)
    // premium price - 4"($1.00 extra meat .50), 8"(2.00 extra meat 1.00), or 12" (3.00 extra meat 1.50);
    private String premiumTopping; //
    // Sauce ( Mayo, Mustard, Honey Mustard, Buffalo, Spicy Chiplote, Ketchup, Ranch, vinaigrette, thousand islands
    private String sauce;

    private boolean isToast;

    /**
     * Constructor for regular sandwich object
     */
    public Sandwich(int sizeOfBread,
                    String typeOfBread,
                    String regularTopping,
                    String sauce,
                    boolean isToast) {
        this.sizeOfBread = sizeOfBread;
        this.typeOfBread = typeOfBread;
        this.regularTopping = regularTopping;
        this.sauce = sauce;
        this.isToast = isToast;
    }

    /**
     * Constructor for premium sandwich object
     */
    public Sandwich(int sizeOfBread,
                    String sauce,
                    String regularTopping,
                    String premiumTopping,
                    String typeOfBread,
                    boolean isToast) {
        this.sizeOfBread = sizeOfBread;
        this.sauce = sauce;
        this.regularTopping = regularTopping;
        this.premiumTopping = premiumTopping;
        this.typeOfBread = typeOfBread;
        this.isToast = isToast;
    }


    public int getSizeOfBread() {

        return sizeOfBread;
    }

    public void setSizeOfBread(int sizeOfBread) {
        this.sizeOfBread = sizeOfBread;
    }

    public String getTypeOfBread() {
        return typeOfBread;
    }

    public void setTypeOfBread(String typeOfBread) {
        this.typeOfBread = typeOfBread;
    }

    public String getRegularTopping() {
        return regularTopping;
    }

    public void setRegularTopping(String regularTopping) {
        this.regularTopping = regularTopping;
    }

    public String getPremiumTopping() {
        return premiumTopping;
    }

    public void setPremiumTopping(String premiumTopping) {
        this.premiumTopping = premiumTopping;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }


    public double getTotalCost(){
        double basePrice = 0.0;
        double premiumCost = 0.0;
        //
        switch (sizeOfBread) {
            case 4: basePrice = 5.50;
                    premiumCost = 1.00;
                    break;
            case 8: basePrice = 7.00;
                    premiumCost = 2.00;
                    break;
            case 12: basePrice = 8.50;
                    premiumCost = 3.00;
                    break;
            default:
                System.out.println("Invalid size.");
                return 0;
        }

        if(premiumTopping != null && !premiumTopping.isEmpty()) {
            basePrice += premiumCost;
        }
        return basePrice;
    }

    public String toString() {
        return "Sandwich [Size: " + sizeOfBread + "\" Bread (" + typeOfBread + "), Regular Topping: "
                + regularTopping + ", Premium Topping: " + premiumTopping
                + ", Sauce: " + sauce + ", Price: $" + getTotalCost() + "]";
    }
}
