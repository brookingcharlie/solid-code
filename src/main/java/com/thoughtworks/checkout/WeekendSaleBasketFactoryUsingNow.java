package com.thoughtworks.checkout;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

import java.time.LocalDate;

// To illustrate testing problem when using LocalDate.now()
public class WeekendSaleBasketFactoryUsingNow implements BasketFactory {
  @Override
  public Basket createBasket() {
    LocalDate date = LocalDate.now();
    if (date.getDayOfWeek() == SATURDAY || date.getDayOfWeek() == SUNDAY) {
      return new SaleBasket();
    }
    else {
      return new Basket();
    }
  }
}
