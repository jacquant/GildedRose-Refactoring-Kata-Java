package com.gildedrose.items.customs;

import com.gildedrose.items.GildedRoseItem;
import com.gildedrose.items.Item;
import com.gildedrose.items.rules.QualityRule;
import com.gildedrose.items.rules.SellInCriteria;
import com.gildedrose.items.rules.SellInRule;

@SellInRule(by = 1)
@QualityRule(by = RegularItem.DECREASE_VALUE *2,  whenSellInIs = 0, sellInCriteria = SellInCriteria.OVER)
@QualityRule(by = RegularItem.DECREASE_VALUE *4, whenSellInIs = 0, sellInCriteria = SellInCriteria.UNDER_AND_EQUALS, order = 1)
public record ConjuredItem(Item item) implements GildedRoseItem {

    public static final String CONJURED = "Conjured Mana Cake";
}
