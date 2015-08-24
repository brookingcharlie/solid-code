package com.thoughtworks.checkout;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class WeekendSaleBasketFactoryTest {
  @Parameter(0)
  public LocalDate date;

  @Parameter(1)
  public Class<? extends Basket> basketClass;

  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
      {LocalDate.of(2015, 8, 17), Basket.class},
      {LocalDate.of(2015, 8, 18), Basket.class},
      {LocalDate.of(2015, 8, 19), Basket.class},
      {LocalDate.of(2015, 8, 20), Basket.class},
      {LocalDate.of(2015, 8, 21), Basket.class},
      {LocalDate.of(2015, 8, 22), SaleBasket.class},
      {LocalDate.of(2015, 8, 23), SaleBasket.class}
    });
  }

  @Test
  public void test() {
    DateSource dateSource = mock(DateSource.class);
    when(dateSource.get()).thenReturn(date);
    WeekendSaleBasketFactory factory = new WeekendSaleBasketFactory(dateSource);
    assertThat(factory.createBasket(), is(instanceOf(basketClass)));
  }
}
