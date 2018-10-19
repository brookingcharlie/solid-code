package com.thoughtworks.checkout;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.StringReader;
import java.io.StringWriter;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class AppTest {
  @Test
  public void testSingle() throws Exception {
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
      DateSource dateSource = mock(DateSource.class);
      when(dateSource.get()).thenReturn(LocalDate.of(2015, 8, 20));
      WeekendSaleBasketFactory basketFactory = new WeekendSaleBasketFactory(dateSource);
      App app = new App(basketFactory, new ItemsReader(), new ReceiptWriter());
      app.run(reader, writer);
      assertThat(writer.toString()).isEqualTo(expectedOutput);
    }
  }
}
