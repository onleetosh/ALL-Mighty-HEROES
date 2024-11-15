package com.onleetosh.pluralsight.addon;

public class Cookie {

    /**
     * Information needed to create chip object
     */
    private String typeOfCookie;
    private double priceOfCookie;

    /**
     * Value amount for cookie
     */
    private double valueAmountForCookie = 1.50;

    /**
     * Constructor used to initialize cookie object
     */
    public Cookie(String typeOfCookie, double priceOfCookie) {
        this.typeOfCookie = typeOfCookie;
        this.priceOfCookie = valueAmountForCookie;
    }

    /**
     * Getter methods to get a value
     */
    public String getTypeOfCookie() {
        return typeOfCookie;
    }

    public double getPriceOfCookie() {
        return priceOfCookie;
    }


    /**
     * Use toString() return a String format for cookie when displayed
     */
    @Override
    public String toString(){
        return " " + typeOfCookie +
                " $" + String.format("%.2f", priceOfCookie);
    }


}