package com.gildedrose.items;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SulfurasItem implements GildedRoseItem {

    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    private final Item item;

    @Override
    public void updateItem() {
        // Nothing to do as Legendary items never change
    }
}
