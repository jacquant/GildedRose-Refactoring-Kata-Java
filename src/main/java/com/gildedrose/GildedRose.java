package com.gildedrose;

import com.gildedrose.items.GildedRoseItem;
import com.gildedrose.items.GildedRoseItemFactory;
import com.gildedrose.items.Item;

import java.util.Arrays;
import java.util.List;

class GildedRose {
    final List<GildedRoseItem> items;

    public Item getItems(int index) {
        return items.get(index).item();
    }

    public GildedRose(Item[] items) {
        this.items = Arrays.stream(items).map(GildedRoseItemFactory::createGildedRoseItem).toList();
    }

    public void updateQuality() {
        for (GildedRoseItem item : items) {
            item.updateItem();
        }
    }
}
