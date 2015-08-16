package com.thoughtworks.checkout;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class BasketReaderTest {
    @Test
    public void testZeroItems() throws IOException {
        Basket basket = mock(Basket.class);
        StringReader input = new StringReader("");
        new BasketReader().read(basket, input);

        ArgumentCaptor<Item> item = ArgumentCaptor.forClass(Item.class);
        verify(basket, never()).addItem(item.capture());
    }

    @Test
    public void testSingleItem() throws IOException {
        Basket basket = mock(Basket.class);
        StringReader input = new StringReader("Pizza - Pepperoni,12.99\n");
        new BasketReader().read(basket, input);

        ArgumentCaptor<Item> item = ArgumentCaptor.forClass(Item.class);
        verify(basket, times(1)).addItem(item.capture());
        assertThat(item.getAllValues().get(0).getProduct(), is(equalTo("Pizza - Pepperoni")));
        assertThat(item.getAllValues().get(0).getPrice(), is(equalTo(new BigDecimal("12.99"))));
    }

    @Test
    public void testMultipleItems() throws IOException {
        Basket basket = mock(Basket.class);
        StringReader input = new StringReader(
            "Pizza - Pepperoni,12.99\n" +
            "Pizza - Supreme,12.99\n" +
            "Garlic bread,8.50\n" +
            "Chianti,21.00\n"
        );
        new BasketReader().read(basket, input);

        ArgumentCaptor<Item> item = ArgumentCaptor.forClass(Item.class);
        verify(basket, times(4)).addItem(item.capture());
        assertThat(item.getAllValues().get(0).getProduct(), is(equalTo("Pizza - Pepperoni")));
        assertThat(item.getAllValues().get(2).getPrice(), is(equalTo(new BigDecimal("8.50"))));
        assertThat(item.getAllValues().get(3).getProduct(), is(equalTo("Chianti")));
        assertThat(item.getAllValues().get(3).getPrice(), is(equalTo(new BigDecimal("21.00"))));
    }
}
