package com.gildedrose.items.customs;

import com.gildedrose.items.GildedRoseItem;
import com.gildedrose.items.Item;
import com.gildedrose.items.rules.QualityRule;
import com.gildedrose.items.rules.SellInCriteria;
import com.gildedrose.items.rules.SellInRule;

@SellInRule(by = 0)
@QualityRule(by = 0, whenSellInIs = 0, sellInCriteria = SellInCriteria.OVER)
public record SulfurasItem(Item item) implements GildedRoseItem {

    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
}
