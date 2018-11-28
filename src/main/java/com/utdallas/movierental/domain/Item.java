package com.utdallas.movierental.domain;

import com.utdallas.movierental.domain.type.CategoryType;

import java.math.BigDecimal;

public interface Item {

    String getTitle();

    void setTitle(String title);

    CategoryType getCategoryType();

    void setCategoryType(CategoryType categoryType);

    BigDecimal getPrice();
}
