package com.thoughtworks.checkout;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;

public class App {
    public static void main(String[] args) throws Exception {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(System.out);
        )
        {
            String line = reader.readLine();
            String[] parts = line.split(",");
            String product = parts[0];
            BigDecimal price = new BigDecimal(parts[1]);
            
            writer.println("*************** RECEIPT ****************");
            writer.println();
            writer.println(String.format("%-32s%8.2f", product, price));
            writer.println(String.format("%-32s%8s", "", "--------"));
            writer.println(String.format("%-32s%8.2f", "Total for 1 items", price));
            writer.println(String.format("%-32s%8s", "", "========"));
        }
    }
}
