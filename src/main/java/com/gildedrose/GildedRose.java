package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            // CHECK NORMAL ITEM
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                // QUALITY CANNOT BE NEGATIVE
                if (items[i].quality > 0) {
                    // EXCLUDE SULFURAS AS LEGENDARY ITEM
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else { // SPECIAL ITEM ==> QUALITY INCREASES

                // QUALITY CANNOT BE MORE THAN 50
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        // QUALITY INCREASE BY 2 WHEN THERE ARE 10 DAYS OR LESS
                        if (items[i].sellIn < 11) {
                            // QUALITY CANNOT BE MORE THAN 50
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                        // QUALITY INCREASE BY 3 WHEN THERE ARE 5 DAYS OR LESS
                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            // DECREASE SELLIN FOR ALL ITEM EXCEPT SULFURAS
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                // QUALITY CAN BE NEGATIVE FOR COMMON ITEM
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        // BACKSTAGE ITEM QUALITY BECOME 0 AFTER CONCERT
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    // QUALITY OF AGED BRIE INCREASES EVEN AFTER SELLIN DATE
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}
