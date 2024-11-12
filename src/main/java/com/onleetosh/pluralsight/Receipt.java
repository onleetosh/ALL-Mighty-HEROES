package com.onleetosh.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Receipt {

        public static void main(String[] args) {
            try {
                // Create the first file
                BufferedWriter writer1 = new BufferedWriter(new FileWriter("file1.txt"));
                writer1.write("This is file 1.");
                writer1.close();

                // Create the second file
                BufferedWriter writer2 = new BufferedWriter(new FileWriter("file2.txt"));
                writer2.write("This is file 2.");
                writer2.close();

                System.out.println("Files created successfully.");
            }
            catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

}
