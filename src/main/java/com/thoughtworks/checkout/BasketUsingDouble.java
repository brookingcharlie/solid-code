package com.thoughtworks.checkout;

import java.util.ArrayList;
import java.util.List;

public class BasketUsingDouble {
  private final ArrayList<ItemUsingDouble> items;

  public BasketUsingDouble() {
    this.items = new ArrayList<ItemUsingDouble>();
  }

  public void addItem(ItemUsingDouble item) {
    items.add(item);
  }

  public final List<ItemUsingDouble> getItems() {
    return items;
  }

  public double getTotal() {
    return items.stream()
      .map(i -> i.getPrice())
      .reduce((a, b) -> a + b)
      .orElse(0.00);
  }
}
