package com.onleetosh.pluralsight.order.sandwich;

import com.onleetosh.pluralsight.util.UI;

import java.util.ArrayList;

public class SignatureSandwich  {

     static ArrayList<Sandwich> signatureSandwiches;
     static ArrayList<Topping> signatureTopping;
     static Bread signatureBread;


    public static void requestBLT(){
        UI.sandwichOrder  = new ArrayList<>();
        UI.heroToppingList = new ArrayList<>();

        UI.heroToppingList.add(new Topping("bacon", "meat", true, 1.00));
        UI.heroToppingList.add(new Topping("lettuce", "veggie", false, 0.00));
        UI.heroToppingList.add(new Topping("tomato", "veggie", false, 0.00));

        signatureBread = new Bread("wheat", 8);
        //add
        UI.sandwichOrder.add(new Sandwich(signatureBread.getSizeOfBread(), signatureBread, UI.heroToppingList, true));

    }

}