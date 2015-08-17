package com.thoughtworks.checkout;

import java.math.BigDecimal;

public class SaleBasket extends Basket {
    @Override
    public BigDecimal getTotal() {
        return super.getTotal().multiply(new BigDecimal("0.9")).setScale(2);
    }
    
    @Override
    public String getMessage() {
        return "Includes discount of 10%";
    }
}
