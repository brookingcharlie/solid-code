package com.thoughtworks.checkout;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BasketTest {
  @Test
  public void testZeroItems() {
    Basket basket = new Basket();
    assertThat(basket.getTotal()).isEqualTo(new BigDecimal("0.00"));
    assertThat(basket.getMessage()).isNull();
  }

  @Test
  public void testSingleItem() {
    Basket basket = new Basket();
    basket.addItem(new Item("Pizza - Pepperoni", new BigDecimal("12.99")));
    assertThat(basket.getItems().get(0).getProduct()).isEqualTo("Pizza - Pepperoni");
    assertThat(basket.getItems().get(0).getPrice()).isEqualTo(new BigDecimal("12.99"));
    assertThat(basket.getTotal()).isEqualTo(new BigDecimal("12.99"));
  }

  @Test
  public void testMultipleItems() {
    Basket basket = new Basket();
    basket.addItem(new Item("Pizza - Pepperoni", new BigDecimal("12.99")));
    basket.addItem(new Item("Pizza - Supreme", new BigDecimal("12.99")));
    basket.addItem(new Item("Garlic bread", new BigDecimal("8.50")));
    basket.addItem(new Item("Chianti", new BigDecimal("21.00")));
    assertThat(basket.getItems().get(0).getProduct()).isEqualTo("Pizza - Pepperoni");
    assertThat(basket.getItems().get(3).getPrice()).isEqualTo(new BigDecimal("21.00"));
    assertThat(basket.getTotal()).isEqualTo(new BigDecimal("55.48"));
  }
}
