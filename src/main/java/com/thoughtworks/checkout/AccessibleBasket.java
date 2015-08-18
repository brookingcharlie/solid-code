package com.thoughtworks.checkout;

import java.math.BigDecimal;
import java.util.List;

public interface AccessibleBasket {
  Item getItem(int i);
  int getCount();
  BigDecimal getTotal();
  List<Item> getExtraItems();
  String getMessage();
}
