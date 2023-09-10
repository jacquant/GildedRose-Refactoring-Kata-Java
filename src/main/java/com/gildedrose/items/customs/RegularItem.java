package com.gildedrose.items.customs;

import com.gildedrose.items.GildedRoseItem;
import com.gildedrose.items.Item;
import com.gildedrose.items.rules.QualityRule;
import com.gildedrose.items.rules.SellInDirection;
import com.gildedrose.items.rules.SellInRule;

@SellInRule(by = RegularItem.SELL_IN_VALUE)
@QualityRule(by = RegularItem.DECREASE_VALUE, whenSellInIs = 0, sellInDirection = SellInDirection.OVER, order = 0)
@QualityRule(by = RegularItem.DECREASE_VALUE *2 , whenSellInIs = 0, sellInDirection = SellInDirection.UNDER_AND_EQUALS, order = 1)
public record RegularItem(Item item) implements GildedRoseItem {
    public static final int DECREASE_VALUE = -1;
    public static final int SELL_IN_VALUE = 1;
}
