package com.gildedrose.items.customs;

import com.gildedrose.items.GildedRoseItem;
import com.gildedrose.items.Item;
import com.gildedrose.items.rules.SellInCriteria;
import com.gildedrose.items.rules.SellInRule;
import com.gildedrose.items.rules.QualityRule;

@SellInRule(by = RegularItem.SELL_IN_VALUE)
@QualityRule(by = AgedBrieItem.INCREASE_VALUE, whenSellInIs = 0, sellInCriteria = SellInCriteria.OVER)
@QualityRule(by = AgedBrieItem.INCREASE_VALUE, whenSellInIs = 0, sellInCriteria = SellInCriteria.UNDER_AND_EQUALS, order = 1)
public record AgedBrieItem(Item item) implements GildedRoseItem {

    public static final String AGED_BRIE = "Aged Brie";
    static final int INCREASE_VALUE = 1;
}
