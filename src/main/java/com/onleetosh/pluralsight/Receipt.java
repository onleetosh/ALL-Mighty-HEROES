package com.onleetosh.pluralsight;

import com.onleetosh.pluralsight.order.Order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Receipt {

    private static final LocalDateTime current = LocalDateTime.now();
    private static final DateTimeFormatter fmtDT = DateTimeFormatter.ofPattern("yyyyMMDD-HHmmss");


    /**
     * Method designed to write a receipt file with a single order summary
     */
    public static void recordOrderTransaction(Order order){

        try {
            // Format the date and time for the receipt file name
            String date = current.format(fmtDT);

            // Create a file with the date as part of the name
            BufferedWriter wtr = new BufferedWriter(new FileWriter("Receipt-" + date + ".txt"));

            // Write the order details into the file
            wtr.write("Receipt Date: " + current.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n");
            wtr.write("=================================\n");
            wtr.write(order.toString());  // Assuming Order has a proper toString method
            wtr.write("\nTotal Price: $" + order.getTotalCost());  // Write total price
            wtr.write("\n=================================\n");

            wtr.close();  // Close the file writer

            System.out.println("Receipt created successfully: " + date + ".txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the receipt: " + e.getMessage());
        }

    }

}
