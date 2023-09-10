package com.gildedrose.items.customs;

import com.gildedrose.items.GildedRoseItem;
import com.gildedrose.items.Item;
import com.gildedrose.items.rules.SellInDirection;
import com.gildedrose.items.rules.SellInRule;
import com.gildedrose.items.rules.QualityRule;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@SellInRule(by = 1)
@QualityRule(by = 1, whenSellInIs = 0, sellInDirection = SellInDirection.OVER, order = 0)
@QualityRule(by = 1, whenSellInIs = 0, sellInDirection = SellInDirection.UNDER_AND_EQUALS, order = 1)
public record AgedBrieItem(Item item) implements GildedRoseItem {

    public static final String AGED_BRIE = "Aged Brie";

}
