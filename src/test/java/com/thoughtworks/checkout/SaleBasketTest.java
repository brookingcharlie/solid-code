package com.thoughtworks.checkout;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class SaleBasketTest {
    @Test
    public void shouldSumSingleItem() {
        SaleBasket basket = new SaleBasket();
        basket.addItem(new Item("Pizza - Pepperoni", new BigDecimal("10.00")));
        assertThat(basket.getTotal(), is(equalTo(new BigDecimal("9.00"))));
        assertThat(basket.getMessage(), is(equalTo("Includes discount of 10%")));
    }

    @Test
    public void shouldHandleValueGreaterThan10() {
        SaleBasket basket = new SaleBasket();
        basket.addItem(new Item("Item1", new BigDecimal("10000000.00")));
        assertThat(basket.getTotal(), is(equalTo(new BigDecimal("9000000.00"))));
    }
}
