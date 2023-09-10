package com.gildedrose.items;

import lombok.experimental.UtilityClass;

import static com.gildedrose.items.customs.SulfurasItem.SULFURAS;

@UtilityClass
public class ItemUtils {

    public static final int LOWEST_QUALITY = 0;
    public static final int HIGHEST_QUALITY = 50;
    public static final int HIGHEST_QUALITY_LEGENDARY = 80;

    static boolean nameMatch(Item item, String name) {
        return item.name.equals(name);
    }

    static boolean namesNotMatch(Item item, String name) {
        return !nameMatch(item, name);
    }

    static int highestQualityPossible(Item item) {
        if (nameMatch(item, SULFURAS)) {
            return HIGHEST_QUALITY_LEGENDARY;
        }
        return HIGHEST_QUALITY;
    }

    static boolean hasQualityUnderLowestValuePossible(Item item) {
        return item.quality < LOWEST_QUALITY;
    }
}
