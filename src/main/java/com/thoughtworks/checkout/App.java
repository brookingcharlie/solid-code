package com.thoughtworks.checkout;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class App {
  private final BasketFactory basketFactory;
  private final ItemsReader inputReader;
  private final BasketWriter outputWriter;

  public App(BasketFactory basketFactory, ItemsReader inputReader, BasketWriter outputWriter) {
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
