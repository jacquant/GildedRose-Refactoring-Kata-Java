package com.gildedrose.items.rules;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(QualityRules.class)
public @interface QualityRule {

    int by();
    int whenSellInIs();
    SellInCriteria sellInCriteria();
    int order() default 0;
}
