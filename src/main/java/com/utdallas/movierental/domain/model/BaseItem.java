package com.utdallas.movierental.domain.model;

import com.utdallas.movierental.domain.Item;
import com.utdallas.movierental.domain.type.CategoryType;
import com.utdallas.movierental.domain.type.ModelType;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.Date;

public abstract class BaseItem implements Item {

    private String title;
    private CategoryType categoryType;
    private ModelType modelType;
    private BigDecimal price;
    private Date availableDate;

    //TODO Figure better way to pass category and model types
    public BaseItem(String title, CategoryType categoryType, ModelType modelType, double price) {
        this.title = title;
        this.categoryType = categoryType;
        this.modelType = modelType;
        this.price = BigDecimal.valueOf(price);
        this.availableDate = new Date();
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
    public Date getAvailableDate() {
        return availableDate;
    }

    @Override
    public CategoryType getCategoryType() {
        return categoryType;
    }

    @Override
    public ModelType getModelType() {
        return modelType;
    }

    @Override
    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    public void updatePrice(BigDecimal newPrice) {
        this.price = newPrice;
    }
}
