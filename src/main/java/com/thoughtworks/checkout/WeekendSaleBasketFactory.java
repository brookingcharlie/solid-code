package com.thoughtworks.checkout;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

import java.time.LocalDate;

public class WeekendSaleBasketFactory implements BasketFactory {
  private LocalDate date;

  public WeekendSaleBasketFactory(LocalDate date) {
    this.date = date;
  }

  @Override
  public Basket createBasket() {
    if (date.getDayOfWeek() == SATURDAY || date.getDayOfWeek() == SUNDAY) {
      return new SaleBasket();
    }
    else {
      return new Basket();
    }
  }
}
