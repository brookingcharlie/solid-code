package com.thoughtworks.checkout;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

public class ItemsReaderTest {
  @Test
  public void testZeroItems() throws IOException {
    Basket basket = mock(Basket.class);
    StringReader input = new StringReader("");
    new ItemsReader().read(basket, input);

    ArgumentCaptor<Item> item = ArgumentCaptor.forClass(Item.class);
    verify(basket, never()).addItem(item.capture());
  }

  @Test
  public void testSingleItem() throws IOException {
    Basket basket = mock(Basket.class);
    StringReader input = new StringReader("Pizza - Pepperoni,12.99\n");
    new ItemsReader().read(basket, input);

    ArgumentCaptor<Item> item = ArgumentCaptor.forClass(Item.class);
    verify(basket, times(1)).addItem(item.capture());
    assertThat(item.getValue().getProduct()).isEqualTo("Pizza - Pepperoni");
    assertThat(item.getValue().getPrice()).isEqualTo(new BigDecimal("12.99"));
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
    new ItemsReader().read(basket, input);

    ArgumentCaptor<Item> item = ArgumentCaptor.forClass(Item.class);
    verify(basket, times(4)).addItem(item.capture());
    assertThat(item.getAllValues().get(0).getProduct()).isEqualTo("Pizza - Pepperoni");
    assertThat(item.getAllValues().get(2).getPrice()).isEqualTo(new BigDecimal("8.50"));
    assertThat(item.getAllValues().get(3).getProduct()).isEqualTo("Chianti");
    assertThat(item.getAllValues().get(3).getPrice()).isEqualTo(new BigDecimal("21.00"));
  }
}
