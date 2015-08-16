package com.thoughtworks.checkout;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class BasketTest {
    @Test
    public void testZeroItems() {
        Basket basket = new Basket();
        assertThat(basket.getCount(), is(equalTo(0)));
        assertThat(basket.getTotal(), is(equalTo(new BigDecimal("0.00"))));
    }

    @Test
    public void testSingleItem() {
        Basket basket = new Basket();
        basket.addItem(new Item("Pizza - Pepperoni", new BigDecimal("12.99")));
        assertThat(basket.getCount(), is(equalTo(1)));
        assertThat(basket.getItem(0).getProduct(), is(equalTo("Pizza - Pepperoni")));
        assertThat(basket.getItem(0).getPrice(), is(equalTo(new BigDecimal("12.99"))));
        assertThat(basket.getTotal(), is(equalTo(new BigDecimal("12.99"))));
    }

    @Test
    public void testMultipleItems() {
        Basket basket = new Basket();
        basket.addItem(new Item("Pizza - Pepperoni", new BigDecimal("12.99")));
        basket.addItem(new Item("Pizza - Supreme", new BigDecimal("12.99")));
        basket.addItem(new Item("Garlic bread", new BigDecimal("8.50")));
        basket.addItem(new Item("Chianti", new BigDecimal("21.00")));
        assertThat(basket.getCount(), is(equalTo(4)));
        assertThat(basket.getItem(0).getProduct(), is(equalTo("Pizza - Pepperoni")));
        assertThat(basket.getItem(3).getPrice(), is(equalTo(new BigDecimal("21.00"))));
        assertThat(basket.getTotal(), is(equalTo(new BigDecimal("55.48"))));
    }
}
