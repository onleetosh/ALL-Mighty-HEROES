package com.onleetosh.pluralsight.order;

public class Cookie {

    private String typeOfCookie; //chocolate chip, oatmeal, etc..
    private double priceOfCookie;

    private double priceOfCookieAmount = 1.50;

    private double totalCookieAmount;

    public Cookie(String typeOfCookie, double priceOfCookie) {
        this.typeOfCookie = typeOfCookie;
        this.priceOfCookie = priceOfCookie;
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
