package com.gildedrose.items;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class RegularItem implements GildedRoseItem {

    private final Item item;

    @Override
    public void updateItem() {
        decreaseSellIn();
        if (sellInIsOver(0)) {
            decreaseQualityBy(1);
        } else {
            decreaseQualityBy(2);
        }
    }
}
