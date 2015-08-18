package com.thoughtworks.checkout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;

public class BasketReader {
  public void read(MutatableBasket basket, Reader input) throws IOException {
    try (
      BufferedReader bufferedReader = new BufferedReader(input);
    ) {
      bufferedReader.lines()
        .map(line -> line.split(","))
        .map(parts -> new Item(parts[0], new BigDecimal(parts[1])))
        .forEach(item -> basket.addItem(item));
    }
  }
}
