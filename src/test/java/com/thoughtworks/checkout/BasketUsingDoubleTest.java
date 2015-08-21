package com.thoughtworks.checkout;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BasketUsingDoubleTest {
  @Test
  public void testInnaccurateBasket() {
    BasketUsingDouble basket = new BasketUsingDouble();
    basket.addItem(new ItemUsingDouble("Pizza", 0.10));
    basket.addItem(new ItemUsingDouble("Coke", 0.20));
    assertThat(basket.getTotal(), is(equalTo(0.30)));
  }
}
