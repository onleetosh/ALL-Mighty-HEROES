package com.onleetosh.pluralsight;

public class Order {

    // 4", 8", or 12"
    private int sizeOfBread;
    // bread price 4"($5.50), 8"(7.00), or 12" (8.50)
    // white, wheat, rye, wrap
    private String typeOfBread;
    //lettuce, peppers, onions, tomatoes, jalapenos, cucumber, pickles, banana peppers, mushrooms, guacamole
    // topping price - included
    private String regularTopping;
    // Meats(steak, ham, salami, roast beef, chicken, bacon)  Cheese(american, provolone, cheddar, swiss)
    // premium price - 4"($1.00 extra meat .50), 8"(2.00 extra meat 1.00), or 12" (3.00 extra meat 1.50); e
    private String premiumTopping; //
    // Sauce ( Mayo, Mustard, Honey Mustard, Buffalo, Spicy Chiplote, Ketchup, Ranch, vinaigrette, thousand islands
    private String sauce;

    private String drink;     // Small ($2.00) Medium(2.50) Large(3.00)
    private String chips;  // $1.50

}
