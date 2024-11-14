package com.onleetosh.pluralsight.order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Receipt {

    private static final LocalDateTime current = LocalDateTime.now();
    private static final DateTimeFormatter fmtDT = DateTimeFormatter.ofPattern("yyyyMMDD-HHmmss");

    /**
     * recorderOrderTransaction() is used to create a receipt file of ordering being placed
     */
    public static void recordOrderTransaction(Order order){

        try {
            // Format the date and time for the receipt file name
            String date = current.format(fmtDT);

            // Create a file with the date as part of the name
            BufferedWriter bwt = new BufferedWriter(new FileWriter("Receipt-" + date + ".txt"));

            // Write the order details into the file
            bwt.write("Receipt Date: " + current.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n");
            bwt.write("===================================\n");
            bwt.write("       >> ALL Mighty Hero <<");
            bwt.write("\n ");
            bwt.write("          \"DELI-cious! \"");
            bwt.write("\n ");
            bwt.write("        Egghead, New World");
            bwt.write("\n ");
            bwt.write("       Phone: (68) 1058-1125  ");
            bwt.write("\n ");
            bwt.write(order.toString());  // write order using toString()
            bwt.write("      *** MUNCH MUNCH MUNCH *** ");
            bwt.write("\n=================================\n");

            bwt.close();  // Close the file writer
            System.out.println("\n Receipt created successfully: " + date + ".txt");
        }
        catch (IOException e) {
            System.out.println("\nAn error occurred while writing the receipt: " + e.getMessage());
        }
    }
}
