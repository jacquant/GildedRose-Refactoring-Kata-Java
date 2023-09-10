package com.gildedrose.items.customs;

import com.gildedrose.items.GildedRoseItem;
import com.gildedrose.items.Item;
import com.gildedrose.items.rules.QualityRule;
import com.gildedrose.items.rules.SellInDirection;
import com.gildedrose.items.rules.SellInRule;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@SellInRule(by = 1)
@QualityRule(by = -1, whenSellInIs = 0, sellInDirection = SellInDirection.OVER, order = 0)
@QualityRule(by = -2, whenSellInIs = 0, sellInDirection = SellInDirection.UNDER_AND_EQUALS, order = 1)
public record RegularItem(Item item) implements GildedRoseItem {
}
