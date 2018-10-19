package com.thoughtworks.checkout;

import java.io.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class App {
  public void run(Reader reader, Writer writer) throws IOException {
    try (
      BufferedReader bufferedReader = new BufferedReader(reader);
      PrintWriter printWriter = new PrintWriter(writer);
    ) {
      List<Item> items = bufferedReader.lines()
        .map(line -> line.split(","))
        .map(parts -> new Item(parts[0], new BigDecimal(parts[1])))
        .collect(Collectors.toList());

      printWriter.println("*************** RECEIPT ****************");
      printWriter.println();
      for (Item item : items) {
        printWriter.println(String.format("%-32s%8.2f", item.getProduct(), item.getPrice()));
      }

      BigDecimal total = items.stream()
        .map(item -> item.getPrice())
        .reduce(new BigDecimal("0.00"), (a, b) -> a.add(b));
      printWriter.println(String.format("%-32s%s", "", "--------"));
      printWriter.println(String.format("%-32s%8.2f", "Total", total));
      printWriter.println(String.format("%-32s%s", "", "========"));
    }
  }

  private static class Item {
    private final String product;
    private final BigDecimal price;

    public Item(String product, BigDecimal price) {
      this.product = product;
      this.price = price;
    }

    public String getProduct() {
      return product;
    }

    public BigDecimal getPrice() {
      return price;
    }
  }
}
