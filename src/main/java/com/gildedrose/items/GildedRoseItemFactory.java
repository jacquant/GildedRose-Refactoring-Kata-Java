package com.gildedrose.items;

import com.gildedrose.items.customs.AgedBrieItem;
import com.gildedrose.items.customs.BackstagePassesItem;
import com.gildedrose.items.customs.RegularItem;
import com.gildedrose.items.customs.SulfurasItem;

import static com.gildedrose.items.customs.AgedBrieItem.AGED_BRIE;
import static com.gildedrose.items.customs.BackstagePassesItem.BACKSTAGE_PASSES;
import static com.gildedrose.items.ItemUtils.highestQualityPossible;
import static com.gildedrose.items.ItemUtils.nameMatch;
import static com.gildedrose.items.customs.SulfurasItem.SULFURAS;

public class GildedRoseItemFactory {

    public static GildedRoseItem createGildedRoseItem(Item item) {
        checkLowestQuality(item);
        checkHighestQuality(item);
        if (nameMatch(item, AGED_BRIE)) {
            return new AgedBrieItem(item);
        } else if (nameMatch(item, BACKSTAGE_PASSES)) {
            return new BackstagePassesItem(item);
        } else if (nameMatch(item, SULFURAS)) {
            return new SulfurasItem(item);
        }
        return new RegularItem(item);
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
