package com.thoughtworks.checkout;

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

    public static void run(Reader input, Writer output) throws IOException {
        Basket basket = new Basket();
        BasketReader inputReader = new BasketReader();
        inputReader.read(basket, input);

        try (PrintWriter printWriter = new PrintWriter(output)) {
            String product = basket.getItem(0).getProduct();
            BigDecimal price = basket.getItem(0).getPrice();
            printWriter.println("*************** RECEIPT ****************");
            printWriter.println();
            printWriter.println(String.format("%-32s%8.2f", product, price));
            printWriter.println(String.format("%-32s%8s", "", "--------"));
            printWriter.println(String.format("%-32s%8.2f", "Total for 1 items", price));
            printWriter.println(String.format("%-32s%8s", "", "========"));
        }
    }
}
