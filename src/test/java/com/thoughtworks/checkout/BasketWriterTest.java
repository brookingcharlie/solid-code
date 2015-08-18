package com.thoughtworks.checkout;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;

import org.junit.Test;

public class BasketWriterTest {
  @Test
  public void testZeroItems() throws IOException {
    Basket basket = new Basket();
    StringWriter output = new StringWriter();
    new BasketWriter().write(basket, output);

    String expectedOutput =
      "*************** RECEIPT ****************\n" +
      "\n" +
      "                                --------\n" +
      "Total for 0 items                   0.00\n" +
      "                                ========\n";
    assertThat(output.toString(), is(equalTo(expectedOutput)));
  }

  @Test
  public void testSingleItem() throws IOException {
    Basket basket = new Basket();
    basket.addItem(new Item("Pizza - Pepperoni", new BigDecimal("12.99")));
    StringWriter output = new StringWriter();
    new BasketWriter().write(basket, output);

    String expectedOutput =
      "*************** RECEIPT ****************\n" +
      "\n" +
      "Pizza - Pepperoni                  12.99\n" +
      "                                --------\n" +
      "Total for 1 items                  12.99\n" +
      "                                ========\n";
    assertThat(output.toString(), is(equalTo(expectedOutput)));
  }

  @Test
  public void testMultipleItems() throws IOException {
    Basket basket = new Basket();
    basket.addItem(new Item("Pizza - Pepperoni", new BigDecimal("12.99")));
    basket.addItem(new Item("Pizza - Supreme", new BigDecimal("12.99")));
    basket.addItem(new Item("Garlic bread", new BigDecimal("8.50")));
    basket.addItem(new Item("Chianti", new BigDecimal("21.00")));
    StringWriter output = new StringWriter();
    new BasketWriter().write(basket, output);

    String expectedOutput =
      "*************** RECEIPT ****************\n" +
      "\n" +
      "Pizza - Pepperoni                  12.99\n" +
      "Pizza - Supreme                    12.99\n" +
      "Garlic bread                        8.50\n" +
      "Chianti                            21.00\n" +
      "                                --------\n" +
      "Total for 4 items                  55.48\n" +
      "                                ========\n";
    assertThat(output.toString(), is(equalTo(expectedOutput)));
  }

  @Test
  public void testSingleItemOnSale() throws IOException {
    Basket basket = new SaleBasket();
    basket.addItem(new Item("Pizza - Pepperoni", new BigDecimal("10.00")));
    StringWriter output = new StringWriter();
    new BasketWriter().write(basket, output);

    String expectedOutput =
      "*************** RECEIPT ****************\n" +
      "\n" +
      "Pizza - Pepperoni                  10.00\n" +
      "Discount                           -1.00\n" +
      "                                --------\n" +
      "Total for 1 items                   9.00\n" +
      "                                ========\n" +
      "Includes discount of 10%\n";
    assertThat(output.toString(), is(equalTo(expectedOutput)));
  }
}
