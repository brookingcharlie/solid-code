package com.thoughtworks.checkout;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class App {
  private final BasketReader inputReader;
  private final BasketWriter outputWriter;

  public App(BasketReader inputReader, BasketWriter outputWriter) {
    this.inputReader = inputReader;
    this.outputWriter = outputWriter;
  }

//  public static void main(String[] args) throws Exception {
//    try (
//      Reader reader = new InputStreamReader(System.in);
//      Writer writer = new PrintWriter(System.out);
//    )
//    {
//      run(reader, writer);
//    }
//  }

  public void run(Reader input, Writer output) throws IOException {
    Basket basket = new Basket();
    inputReader.read(basket, input);
    outputWriter.write(basket, output);
  }
}
