package com.thoughtworks.checkout;

import java.math.BigDecimal;

public class Item {
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
