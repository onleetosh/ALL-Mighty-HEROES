package com.onleetosh.pluralsight.order;

import com.onleetosh.pluralsight.util.Console;

import java.util.ArrayList;

public class Bread {

    //TODO : rename bread to type of heroes

    private String typeOfBread;    // white, wheat, rye, wrap
    private int sizeOfBread; // 4, 8, or 12 inches
    private double price;

    private double fourInchCost = 5.50;
    private double eightInchCost = 7.00;
    private double footLongCost = 8.50;

    // Constructor
    public Bread(String typeOfBread, int sizeOfBread) {
        this.typeOfBread = typeOfBread;
        this.sizeOfBread = sizeOfBread;
        this.price = adjustPriceForSizeOfBread(sizeOfBread);
    }

    // Determine cost of bread - 4"($5.50), 8"(7.00), or 12" (8.50)
    private double adjustPriceForSizeOfBread(int sizeOfBread) {
        switch (sizeOfBread) {
            case 4:
                return fourInchCost;
            case 8:
                return eightInchCost;
            case 12:
                return footLongCost;
            default:
                throw new IllegalArgumentException("Invalid bread size: " + sizeOfBread);
        }
    }

    public String getTypeOfBread() {
        return typeOfBread;
    }

    public void setTypeOfBread(String typeOfBread) {
        this.typeOfBread = typeOfBread;
    }

    public int getSizeOfBread() {
        return sizeOfBread;
    }

    public void setSizeOfBread(int sizeOfBread) {
        this.sizeOfBread = sizeOfBread;
        this.price = adjustPriceForSizeOfBread(sizeOfBread); // Recalculate price if the size changes
    }

    public double getPrice() {
        return price;
    }



//    // Helper method to prompt for bread selection
//    public static int promptForBread() {
//        System.out.println("Select a bread:");
//        for (int i = 1; i < bread.size(); i++) {
//            System.out.println(i + ": " + bread.get(i).getTypeOfBread() + " (" + bread.get(i).getSizeOfBread() + "\")");
//        }
//        return Console.PromptForInt("Enter bread choice (1-" + (bread.size() - 1) + "): ");
//    }


    @Override
    public String toString() {
        return sizeOfBread + "\" " + typeOfBread + " bread ($" + String.format("%.2f", price);
    }
}

