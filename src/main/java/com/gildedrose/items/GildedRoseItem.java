package com.gildedrose.items;

import com.gildedrose.items.rules.RuleEngine;

import static com.gildedrose.items.ItemUtils.LOWEST_QUALITY;
import static com.gildedrose.items.ItemUtils.hasQualityUnderLowestValuePossible;

public interface GildedRoseItem {

    default void updateItem() {
        updateSellIn();
        updateQuality();
        resetQualitySellInOver();
    }

    Item item();

    default String getName() {
        return item().name;
    }

    private void updateQuality() {
        RuleEngine.getUpdateQualityValue(getClass(), item().sellIn).ifPresent(this::updateQualityBy);
    }

    private void resetQualitySellInOver() {
        if (RuleEngine.canBeReset(this.getClass(), item().sellIn)) {
            item().quality = LOWEST_QUALITY;
        }
    }

    private void updateSellIn() {
        item().sellIn -= RuleEngine.getUpdateSellInValue(this.getClass());
    }

    private void updateQualityBy(int qualityValue) {
        item().quality += qualityValue;

        int highestQualityPossible = ItemUtils.highestQualityPossible(item());
        if (item().quality > highestQualityPossible) {
            item().quality = highestQualityPossible;
        }
        if (hasQualityUnderLowestValuePossible(item())) {
            item().quality = LOWEST_QUALITY;
        }
    }

}
