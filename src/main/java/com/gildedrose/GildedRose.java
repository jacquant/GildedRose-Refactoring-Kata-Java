package com.gildedrose;

import java.util.function.Function;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            // CHECK NORMAL ITEM
            if (namesNotMatch(item, AGED_BRIE)
                    && namesNotMatch(item, BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                // QUALITY CANNOT BE NEGATIVE
                decreaseQuality(item);
            } else { // SPECIAL ITEM ==> QUALITY INCREASES
                // QUALITY CANNOT BE MORE THAN 50
                increaseQuality(item, (itemToIncreaseMore) -> {
                    if (nameMatch(itemToIncreaseMore, BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                        // QUALITY INCREASE BY 2 WHEN THERE ARE 10 DAYS OR LESS
                        if (itemToIncreaseMore.sellIn < 11) {
                            // QUALITY CANNOT BE MORE THAN 50
                            increaseQuality(item);
                        }
                        // QUALITY INCREASE BY 3 WHEN THERE ARE 5 DAYS OR LESS
                        if (itemToIncreaseMore.sellIn < 6) {
                            increaseQuality(item);
                        }
                    }
                    return itemToIncreaseMore;
                });
            }

            // DECREASE SELLIN FOR ALL ITEM EXCEPT SULFURAS
            if (namesNotMatch(item, SULFURAS_HAND_OF_RAGNAROS)) {
                decreaseSellIn(item);
            }

            if (item.sellIn < 0) {
                if (namesNotMatch(item, AGED_BRIE)) {
                    if (namesNotMatch(item, BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                        decreaseQuality(item);
                    } else {
                        // BACKSTAGE ITEM QUALITY BECOME 0 AFTER CONCERT
                        resetQuality(item);
                    }
                } else {
                    // QUALITY OF AGED BRIE INCREASES EVEN AFTER SELLIN DATE
                    increaseQuality(item);
                }
            }
        }
    }

    private static void decreaseSellIn(Item item) {
        item.sellIn -= 1;
    }

    private static void decreaseQuality(Item item) {
        if (item.quality > 0) {
            // EXCLUDE SULFURAS AS LEGENDARY ITEM
            if (!item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                updateQualityBy(item, -1);
            }
        }
    }

    private static void resetQuality(Item item) {
        item.quality = 0;
    }

    private static void increaseQuality(Item item) {
        if (item.quality < 50) {
            updateQualityBy(item, 1);
        }
    }

    private static void updateQualityBy(Item item, int value) {
        // QUALITY never negative is currently asserted by upper checks
        item.quality += value;
    }

    private static void increaseQuality(Item item, Function<Item, Item> ifQualityLessThan50) {
        if (item.quality < 50) {
            updateQualityBy(item, 1);
            ifQualityLessThan50.apply(item);
        }
    }

    private static boolean nameMatch(Item item, String name) {
        return item.name.equals(name);
    }

    private static boolean namesNotMatch(Item item, String name) {
        return !nameMatch(item, name);
    }
}
