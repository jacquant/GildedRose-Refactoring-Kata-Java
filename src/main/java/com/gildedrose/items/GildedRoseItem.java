package com.gildedrose.items;

import static com.gildedrose.items.ItemUtils.hasLowestQualityValuePossible;

public interface GildedRoseItem {

    void updateItem();

    Item getItem();

    default String getName() {
        return getItem().name;
    }

    default void decreaseSellIn() {
        getItem().sellIn--;
    }

    default boolean sellInIsOver(int value) {
        return getItem().sellIn >= value;
    }

    default void decreaseQualityBy(int qualityValue) {
        if (!hasLowestQualityValuePossible(getItem())) {
            getItem().quality -= qualityValue;
        }
    }

}
