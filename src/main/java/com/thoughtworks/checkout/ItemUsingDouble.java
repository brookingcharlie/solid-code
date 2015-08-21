package com.thoughtworks.checkout;

public class ItemUsingDouble {
  private final String product;
  private final double price;

  public ItemUsingDouble(String product, double price) {
    this.product = product;
    this.price = price;
  }

  public String getProduct() {
    return product;
  }

  public double getPrice() {
    return price;
  }
}
