package com.gildedrose.items.customs;

import com.gildedrose.items.GildedRoseItem;
import com.gildedrose.items.Item;
import com.gildedrose.items.rules.QualityRule;
import com.gildedrose.items.rules.SellInDirection;
import com.gildedrose.items.rules.SellInRule;

@SellInRule(by = 1)
@QualityRule(by = RegularItem.DECREASE_VALUE *2,  whenSellInIs = 0, sellInDirection = SellInDirection.OVER, order = 0)
@QualityRule(by = RegularItem.DECREASE_VALUE *4, whenSellInIs = 0, sellInDirection = SellInDirection.UNDER_AND_EQUALS, order = 1)
public record ConjuredItem(Item item) implements GildedRoseItem {

    public static final String CONJURED = "Conjured Mana Cake";
}
