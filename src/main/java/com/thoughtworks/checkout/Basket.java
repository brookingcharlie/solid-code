package com.thoughtworks.checkout;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Basket implements MutatableBasket, AccessibleBasket {
  private final ArrayList<Item> items;

  public Basket() {
    this.items = new ArrayList<Item>();
  }

  @Override
  public void addItem(Item item) {
    items.add(item);
  }

  @Override
  public final List<Item> getItems() {
    List<Item> result = new ArrayList<Item>(items);
    result.addAll(getExtraItems());
    return result;
  }

  protected List<Item> getExtraItems() {
    return Collections.emptyList();
  }

  @Override
  public BigDecimal getTotal() {
    return items.stream()
      .map(i -> i.getPrice())
      .reduce((a, b) -> a.add(b))
      .orElse(new BigDecimal("0.00"));
  }

  @Override
  public String getMessage() {
    return null;
  }
}
