package com.gildedrose.items;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AgedBrieItem implements QualityIncreasableGildedRoseItem {

    public static final String AGED_BRIE = "Aged Brie";

    private final Item item;

    @Override
    public void updateItem() {
        decreaseSellIn();
        increaseQualityBy(1);
    }
}
