package com.onleetosh.pluralsight.order.sandwich;

public class Bread {
    /**
     * Information need to create bread object
     */
    private String typeOfBread;
    private int sizeOfBread;
    private double price;


    /**
     * Declared values for bread of size
     */
    private double fourInchBreadCost = 5.50;
    private double eightInchBreadCost = 7.00;
    private double footLongBreadCost = 8.50;


    /**
     * Constructor used to initiative bread object
     */
    public Bread(String typeOfBread,
                 int sizeOfBread) {
        this.typeOfBread = typeOfBread;
        this.sizeOfBread = sizeOfBread;
        this.price = getCostOfBread(sizeOfBread);
    }


    /***
     * Getter methods used to get a value
     */
    public String getTypeOfBread() {
        return typeOfBread;
    }

    public int getSizeOfBread() {
        return sizeOfBread;
    }

    public double getPrice() {
        return price;
    }

    public void setTypeOfBread(String typeOfBread) {
        this.typeOfBread = typeOfBread;
    }

    public void setSizeOfBread(int sizeOfBread) {
        this.sizeOfBread = sizeOfBread;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *  @return the amount for bread based on the size
     */
    // Determine cost of bread - 4"($5.50), 8"(7.00), or 12" (8.50)
    private double getCostOfBread(int size) {
        switch (size) {
            case 4:
                return fourInchBreadCost;
            case 8:
                return eightInchBreadCost;
            case 12:
                return footLongBreadCost;
            default:
               // throw new IllegalArgumentException("Invalid bread size: " + size + ". Allowed sizes are 4, 8, or 12 inches.");
                return fourInchBreadCost;
        }
    }

    /**
     * @return a String format for bread object is when displayed
     */
    @Override
    public String toString() {
        return sizeOfBread + "\" " + typeOfBread + " bread ($" + String.format("%.2f", price) +")";
    }
}