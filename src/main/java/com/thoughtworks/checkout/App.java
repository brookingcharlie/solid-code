package com.thoughtworks.checkout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.math.BigDecimal;

public class App {
    public static void main(String[] args) throws Exception {
        try (
            Reader reader = new InputStreamReader(System.in);
            Writer writer = new PrintWriter(System.out);
        )
        {
            run(reader, writer);
        }
    }

    public static void run(Reader reader, Writer writer) throws IOException {
        try (
            BufferedReader bufferedReader = new BufferedReader(reader);
            PrintWriter printWriter = new PrintWriter(writer);
        ) {
            String line = bufferedReader.readLine();
            String[] parts = line.split(",");
            String product = parts[0];
            BigDecimal price = new BigDecimal(parts[1]);

            printWriter.println("*************** RECEIPT ****************");
            printWriter.println();
            printWriter.println(String.format("%-32s%8.2f", product, price));
            printWriter.println(String.format("%-32s%8s", "", "--------"));
            printWriter.println(String.format("%-32s%8.2f", "Total for 1 items", price));
            printWriter.println(String.format("%-32s%8s", "", "========"));
        }
    }
}
