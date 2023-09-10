package com.gildedrose.items;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class BackstagePassesItem implements QualityIncreasableGildedRoseItem {

    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    private final Item item;

    @Override
    public void updateItem() {
        decreaseSellIn();
        if (sellInIsOver(10)) {
            increaseQualityBy(1);
        } else if (sellInIsOver(5)) {
            increaseQualityBy(2);
        } else if (sellInIsOver(0)) {
            increaseQualityBy(3);
        } else {
            setQualityToZero();
        }
    }

    private void setQualityToZero() {
        getItem().quality = 0;
    }
}
