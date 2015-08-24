package com.thoughtworks.checkout;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class App {
  private final BasketFactory basketFactory;
  private final ItemsReader inputReader;
  private final ReceiptWriter outputWriter;

  public App(BasketFactory basketFactory, ItemsReader inputReader, ReceiptWriter outputWriter) {
    this.basketFactory = basketFactory;
    this.inputReader = inputReader;
    this.outputWriter = outputWriter;
  }

  public void run(Reader input, Writer output) throws IOException {
    Basket basket = basketFactory.createBasket();
    inputReader.read(basket, input);
    outputWriter.write(basket, output);
  }
}
