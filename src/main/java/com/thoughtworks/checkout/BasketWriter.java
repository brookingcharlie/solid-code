package com.thoughtworks.checkout;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class BasketWriter {
    public void write(Basket basket, Writer output) throws IOException {
      try (PrintWriter printWriter = new PrintWriter(output)) {
          printWriter.println("*************** RECEIPT ****************");
          printWriter.println();
          for (int i = 0; i < basket.getCount(); i++) {
              printWriter.println(String.format("%-32s%8.2f", basket.getItem(i).getProduct(), basket.getItem(i).getPrice()));
          }
          printWriter.println(String.format("%-32s%8s", "", "--------"));
          String totalDescription = String.format("Total for %d items", basket.getCount());
          printWriter.println(String.format("%-32s%8.2f", totalDescription, basket.getTotal()));
          printWriter.println(String.format("%-32s%8s", "", "========"));
      }
    }
}
