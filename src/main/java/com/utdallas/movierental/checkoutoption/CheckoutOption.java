package com.utdallas.movierental.checkoutoption;

import com.utdallas.movierental.domain.type.CategoryType;

import java.math.BigDecimal;

public interface CheckoutOption {

    String getTitle();

    CategoryType getCategory();

    BigDecimal getChargeAmount();

    int getFrequentCustomerPoints();

}
