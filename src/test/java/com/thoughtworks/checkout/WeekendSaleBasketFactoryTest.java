package com.thoughtworks.checkout;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WeekendSaleBasketFactoryTest {
  @ParameterizedTest
  @MethodSource("getTestArguments")
  public void test(LocalDate date, Class basketClass) {
    DateSource dateSource = mock(DateSource.class);
    when(dateSource.get()).thenReturn(date);
    WeekendSaleBasketFactory factory = new WeekendSaleBasketFactory(dateSource);
    assertThat(factory.createBasket()).isInstanceOf(basketClass);
  }

  public static Stream<Arguments> getTestArguments() {
    return Stream.of(
      arguments(LocalDate.of(2015, 8, 17), Basket.class),
      arguments(LocalDate.of(2015, 8, 18), Basket.class),
      arguments(LocalDate.of(2015, 8, 19), Basket.class),
      arguments(LocalDate.of(2015, 8, 20), Basket.class),
      arguments(LocalDate.of(2015, 8, 21), Basket.class),
      arguments(LocalDate.of(2015, 8, 22), SaleBasket.class),
      arguments(LocalDate.of(2015, 8, 23), SaleBasket.class)
    );
  }
}
