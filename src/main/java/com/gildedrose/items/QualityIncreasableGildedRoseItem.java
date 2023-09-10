package com.gildedrose.items;

public interface QualityIncreasableGildedRoseItem extends GildedRoseItem{

    default void increaseQualityBy(int qualityValue) {
        getItem().quality += qualityValue;
        int highestQualityPossible = ItemUtils.highestQualityPossible(getItem());
        if (getItem().quality > highestQualityPossible) {
            getItem().quality = highestQualityPossible;
        }
    }
}
