package com.gildedrose.items.rules;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

@UtilityClass
public class RuleEngine {

    public static final int DEFAULT_SELL_IN = 1;

    public int getUpdateSellInValue(Class<?> clazz) {
        return Optional.ofNullable(clazz.getAnnotation(SellInRule.class))
                .map(SellInRule::by)
                .orElse(DEFAULT_SELL_IN);
    }

    public Optional<Integer> getUpdateQualityValue(Class<?> clazz, int sellIn) {
        QualityRule[] rules = clazz.getAnnotationsByType(QualityRule.class);
        return Arrays.stream(rules)
                .sorted(Comparator.comparingInt(QualityRule::order))
                .filter(rule -> qualityRuleIsApplicable(rule, sellIn))
                .findFirst()
                .map(QualityRule::by);
    }

    private boolean qualityRuleIsApplicable(QualityRule rule, int sellIn) {
        if (SellInCriteria.OVER.equals(rule.sellInCriteria())) {
            return sellIn > rule.whenSellInIs();
        }
        return sellIn <= rule.whenSellInIs();
    }

    public boolean canBeReset(Class<?> clazz, int sellInOver) {
        return Optional.ofNullable(clazz.getAnnotation(ResetQualitySellInOverRule.class))
                .map(ResetQualitySellInOverRule::sellInOver)
                .map(annotatedSellInOver -> sellInOver <= annotatedSellInOver)
                .orElse(false);

    }
}
