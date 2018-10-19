package com.thoughtworks.checkout;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

public class SaleBasketTest {
  @Test
  public void shouldSumSingleItem() {
    SaleBasket basket = new SaleBasket();
    basket.addItem(new Item("Pizza - Pepperoni", new BigDecimal("10.00")));
    assertThat(basket.getTotal()).isEqualTo(new BigDecimal("9.00"));
    assertThat(basket.getMessage()).isEqualTo("Includes discount of 10%");
  }

  @Test
  public void shouldHandleValueGreaterThan10() {
    SaleBasket basket = new SaleBasket();
    basket.addItem(new Item("Item1", new BigDecimal("10000000.00")));
    assertThat(basket.getTotal()).isEqualTo(new BigDecimal("9000000.00"));
  }
}
