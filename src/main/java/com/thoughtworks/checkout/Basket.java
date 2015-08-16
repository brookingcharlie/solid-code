package com.thoughtworks.checkout;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Basket implements MutatableBasket, AccessibleBasket {
    private final ArrayList<Item> items;

    public Basket() {
        this.items = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item getItem(int i) {
        return items.get(i);
    }

    public int getCount() {
        return items.size();
    }

    public BigDecimal getTotal() {
        return items.stream()
            .map(i -> i.getPrice())
            .reduce((a, b) -> a.add(b))
            .orElse(new BigDecimal("0.00"));
    }
}
