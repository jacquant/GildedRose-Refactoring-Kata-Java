package com.gildedrose.items.rules;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(QualityRules.class)
public @interface QualityRule {

    int by() default 1;
    int whenSellInIs() default  0;
    SellInDirection sellInDirection() default SellInDirection.OVER;
    int order() default 0;
}
