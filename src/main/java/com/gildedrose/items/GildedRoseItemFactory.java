package com.gildedrose.items;

import com.gildedrose.items.customs.*;

import static com.gildedrose.items.ItemUtils.highestQualityPossible;
import static com.gildedrose.items.customs.AgedBrieItem.AGED_BRIE;
import static com.gildedrose.items.customs.BackstagePassesItem.BACKSTAGE_PASSES;
import static com.gildedrose.items.customs.ConjuredItem.CONJURED;
import static com.gildedrose.items.customs.SulfurasItem.SULFURAS;

public class GildedRoseItemFactory {

    public static GildedRoseItem createGildedRoseItem(Item item) {
        checkLowestQuality(item);
        checkHighestQuality(item);
        return switch (item.name) {
            case AGED_BRIE -> new AgedBrieItem(item);
            case BACKSTAGE_PASSES -> new BackstagePassesItem(item);
            case SULFURAS -> new SulfurasItem(item);
            case CONJURED -> new ConjuredItem(item);
            default -> new RegularItem(item);
        };
    }

    private static void checkLowestQuality(Item item) {
        if (item.quality < ItemUtils.LOWEST_QUALITY) {
            throw new IllegalArgumentException("Quality cannot be lower than " + ItemUtils.LOWEST_QUALITY);
        }
    }

    private static void checkHighestQuality(Item item) {
        int highestQuality = highestQualityPossible(item);
        if (item.quality > highestQuality) {
            throw new IllegalArgumentException("Quality cannot be higher than " + highestQuality);
        }
    }
}
