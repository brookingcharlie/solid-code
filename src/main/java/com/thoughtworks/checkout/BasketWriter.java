package com.thoughtworks.checkout;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class BasketWriter {
  public void write(AccessibleBasket basket, Writer output) throws IOException {
    try (PrintWriter printWriter = new PrintWriter(output)) {
      printWriter.println("*************** RECEIPT ****************");
      printWriter.println();
      for (Item item : basket.getItems()) {
        printWriter.println(String.format("%-32s%8.2f", item.getProduct(), item.getPrice()));
      }
      printWriter.println(String.format("%-32s%8s", "", "--------"));
      String totalDescription = String.format("Total", basket.getItems().size());
      printWriter.println(String.format("%-32s%8.2f", totalDescription, basket.getTotal()));
      printWriter.println(String.format("%-32s%8s", "", "========"));
      if (basket.getMessage() != null) {
        printWriter.println(basket.getMessage());
      }
    }
  }
}
