package com.thoughtworks.checkout;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class DecimalTest {
  @Test
  public void testIncorrectDoubles() {
    double result = 0.1 + 0.2;
    assertThat(result).isEqualTo(0.30000000000000004);
  }

  @Test
  public void testCorrectBigDecimal() {
    BigDecimal result = new BigDecimal("0.1").add(new BigDecimal("0.2"));
    assertThat(result).isEqualTo(new BigDecimal("0.3"));
  }
}
