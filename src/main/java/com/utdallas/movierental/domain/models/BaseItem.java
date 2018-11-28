package com.utdallas.movierental.domain.models;

import com.utdallas.movierental.domain.type.CategoryType;
import com.utdallas.movierental.domain.Item;
import com.utdallas.movierental.domain.type.ModelType;
import com.utdallas.movierental.price.Price;
import com.utdallas.movierental.price.PriceFactory;

import java.math.BigDecimal;

//TODO Figure out better name
public abstract class BaseItem implements Item {

    private String title;
    private CategoryType categoryType;
    private Price price;

    //TODO Figure better way to pass category and model types
    public BaseItem(String title, CategoryType categoryType, ModelType modelType) {
        this.title = title;
        this.categoryType = categoryType;
        this.price = PriceFactory.getItemPriceFactory(categoryType, modelType).getPrice();
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public CategoryType getCategoryType() {
        return categoryType;
    }

    @Override
    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    @Override
    public BigDecimal getPrice() {
        return price.getChargeAmount();
    }
}
