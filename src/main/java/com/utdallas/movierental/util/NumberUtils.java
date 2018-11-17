package com.utdallas.movierental.util;

import java.math.BigDecimal;

public final class NumberUtils {

    private static final BigDecimal ONE_HUNDRED = BigDecimal.valueOf(100);

    public static BigDecimal formatTwoDecimalPlaces(BigDecimal reduce) {
        return reduce.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal getPercentage(BigDecimal totalChargeAmount, BigDecimal percentage) {
        BigDecimal percent = totalChargeAmount
                .multiply(percentage)
                .divide(ONE_HUNDRED, BigDecimal.ROUND_HALF_UP);

        return formatTwoDecimalPlaces(percent);
    }
}
