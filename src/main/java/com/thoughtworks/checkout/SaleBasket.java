package com.thoughtworks.checkout;

import static java.util.Arrays.asList;

import java.math.BigDecimal;
import java.util.List;

public class SaleBasket extends Basket {
  @Override
  public BigDecimal getTotal() {
    return super.getTotal().multiply(new BigDecimal("0.9")).setScale(2);
  }

  @Override
  public List<Item> getExtraItems() {
    BigDecimal discount = super.getTotal().multiply(new BigDecimal("-0.1")).setScale(2);
    return asList(new Item("Discount", discount));
  }

  @Override
  public String getMessage() {
    return "Includes discount of 10%";
  }
}
