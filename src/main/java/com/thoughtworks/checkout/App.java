package com.thoughtworks.checkout;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

public class App {
  public static void main(String[] args) throws Exception {
    try (
      Reader reader = new InputStreamReader(System.in);
      Writer writer = new PrintWriter(System.out);
    )
    {
      run(reader, writer);
    }
  }

  public static void run(Reader input, Writer output) throws IOException {
    BasketReader inputReader = new BasketReader();
    BasketWriter outputWriter = new BasketWriter();

    Basket basket = new Basket();
    inputReader.read(basket, input);
    outputWriter.write(basket, output);
  }
}
