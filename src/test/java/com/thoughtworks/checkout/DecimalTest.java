package com.thoughtworks.checkout;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class DecimalTest {
  @Test
  public void testIncorrectDoubles() {
    double result = 0.1 + 0.2;
    assertThat(result, is(equalTo(0.30000000000000004)));
  }
  
  @Test
  public void testCorrectBigDecimal() {
    BigDecimal result = new BigDecimal("0.1").add(new BigDecimal("0.2"));
    assertThat(result, is(equalTo(new BigDecimal("0.3"))));
  }
}
