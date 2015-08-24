package com.thoughtworks.checkout;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

import java.time.LocalDate;

public class WeekendSaleBasketFactory implements BasketFactory {
  private DateSource dateSource;

  public WeekendSaleBasketFactory(DateSource dateSource) {
    this.dateSource = dateSource;
  }

  @Override
  public Basket createBasket() {
    LocalDate date = dateSource.get();
    if (date.getDayOfWeek() == SATURDAY || date.getDayOfWeek() == SUNDAY) {
      return new SaleBasket();
    }
    else {
      return new Basket();
    }
  }
}
