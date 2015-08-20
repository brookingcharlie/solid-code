package com.thoughtworks.checkout;

import java.math.BigDecimal;
import java.util.List;

public interface AccessibleBasket {
  List<Item> getItems();
  BigDecimal getTotal();
  String getMessage();
}
