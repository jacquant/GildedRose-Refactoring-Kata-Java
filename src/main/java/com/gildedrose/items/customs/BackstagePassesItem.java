package com.gildedrose.items.customs;

import com.gildedrose.items.GildedRoseItem;
import com.gildedrose.items.Item;
import com.gildedrose.items.rules.QualityRule;
import com.gildedrose.items.rules.ResetQualitySellInOverRule;
import com.gildedrose.items.rules.SellInDirection;
import com.gildedrose.items.rules.SellInRule;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@SellInRule(by = RegularItem.SELL_IN_VALUE)
@QualityRule(by = BackstagePassesItem.INCREASE_VALUE, whenSellInIs = 10, sellInDirection =  SellInDirection.OVER)
@QualityRule(by = BackstagePassesItem.INCREASE_VALUE * 2, whenSellInIs = 4, sellInDirection = SellInDirection.OVER, order = 1)
@QualityRule(by = BackstagePassesItem.INCREASE_VALUE * 3, whenSellInIs = 0, sellInDirection = SellInDirection.OVER, order = 2)
@ResetQualitySellInOverRule
public record BackstagePassesItem(Item item) implements GildedRoseItem {

    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    static final int INCREASE_VALUE = 1;
}
