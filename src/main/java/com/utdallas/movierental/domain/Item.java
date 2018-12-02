package com.utdallas.movierental.domain;

import com.utdallas.movierental.domain.type.CategoryType;
import com.utdallas.movierental.domain.type.ModelType;

import java.math.BigDecimal;
import java.util.Date;

public interface Item {

    String getTitle();

    void setTitle(String title);

    Date getAvailableDate();

    CategoryType getCategoryType();

    ModelType getModelType();

    void setCategoryType(CategoryType categoryType);

    BigDecimal getPrice();
}
