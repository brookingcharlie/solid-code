package com.thoughtworks.checkout;

import java.math.BigDecimal;

public interface AccessibleBasket {
    Item getItem(int i);
    int getCount();
    BigDecimal getTotal();
}
