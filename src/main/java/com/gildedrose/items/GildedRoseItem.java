package com.gildedrose.items;

import com.gildedrose.items.rules.RuleEngine;

import static com.gildedrose.items.ItemUtils.LOWEST_QUALITY;

public interface GildedRoseItem {

    default void updateItem() {
        updateSellIn();
        updateQuality();
        resetQualitySellInOver();
    }

    Item item();

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
        if (ItemUtils.hasQualityUnderLowestValuePossible(item())) {
            item().quality = LOWEST_QUALITY;
        }
    }

}
