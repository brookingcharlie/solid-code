package com.thoughtworks.checkout;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class ItemTest {
    @Test
    public void test() {
        Item item = new Item("Pizza - Pepperoni", new BigDecimal("12.99"));
        assertThat(item.getProduct(), is(equalTo("Pizza - Pepperoni")));
        assertThat(item.getPrice(), is(equalTo(new BigDecimal("12.99"))));
    }
}