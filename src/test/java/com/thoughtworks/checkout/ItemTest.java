package com.thoughtworks.checkout;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemTest {
  @Test
  public void test() {
    Item item = new Item("Pizza - Pepperoni", new BigDecimal("12.99"));
    assertThat(item.getProduct()).isEqualTo("Pizza - Pepperoni");
    assertThat(item.getPrice()).isEqualTo(new BigDecimal("12.99"));
  }
}