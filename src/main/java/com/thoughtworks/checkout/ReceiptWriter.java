package com.thoughtworks.checkout;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class ReceiptWriter {
  public void write(AccessibleBasket basket, Writer output) throws IOException {
    try (PrintWriter printWriter = new PrintWriter(output)) {
      printWriter.println("*************** RECEIPT ****************");
      printWriter.println();
      for (Item item : basket.getItems()) {
        printWriter.println(String.format("%-32s%8.2f", item.getProduct(), item.getPrice()));
      }
      printWriter.println(String.format("%-32s%s", "", "--------"));
      printWriter.println(String.format("%-32s%8.2f", "Total", basket.getTotal()));
      printWriter.println(String.format("%-32s%s", "", "========"));
      if (basket.getMessage() != null) {
        printWriter.println(basket.getMessage());
      }
    }
  }
}
