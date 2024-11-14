package com.onleetosh.pluralsight.order;

public class Cookie {

    /**
     * Information needed to create chip object
     */
    private String typeOfCookie;
    private double priceOfCookie;

    /**
     * Value amount for chips
     */
    private double valueAmountForCookie = 1.50;

    private double totalCookieAmount;

    /**
     * Constructor used to initialize cookie object
     */
    public Cookie(String typeOfCookie, double priceOfCookie) {
        this.typeOfCookie = typeOfCookie;
        this.priceOfCookie = valueAmountForCookie;
    }


    public String getTypeOfCookie() {
        return typeOfCookie;
    }

    public double getPriceOfCookie() {
        return priceOfCookie;
    }

    public double getTotalCookieAmount() {
        return totalCookieAmount;
    }




}
