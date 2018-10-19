package com.thoughtworks.checkout;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BasketUsingDoubleTest {
  @Test
  public void testInnaccurateBasket() {
    BasketUsingDouble basket = new BasketUsingDouble();
    basket.addItem(new ItemUsingDouble("Pizza", 0.10));
    basket.addItem(new ItemUsingDouble("Coke", 0.20));
    assertThat(basket.getTotal()).isEqualTo(0.30000000000000004);
  }
}
