package com.thoughtworks.checkout;

import java.io.StringReader;
import java.io.StringWriter;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
  @Test
  public void testExample() throws Exception {
    String input =
      "Pizza - Pepperoni,12.99\n" +
      "Pizza - Supreme,12.99\n" +
      "Garlic bread,8.50\n" +
      "Chianti,21.00\n";
    String expectedOutput =
      "*************** RECEIPT ****************\n" +
      "\n" +
      "Pizza - Pepperoni                  12.99\n" +
      "Pizza - Supreme                    12.99\n" +
      "Garlic bread                        8.50\n" +
      "Chianti                            21.00\n" +
      "                                --------\n" +
      "Total                              55.48\n" +
      "                                ========\n";
    try (
      StringReader reader = new StringReader(input);
      StringWriter writer = new StringWriter();
    ) {
      App app = new App();
      app.run(reader, writer);
      assertThat(writer.toString()).isEqualTo(expectedOutput);
    }
  }
}
