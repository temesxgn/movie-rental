package com.utdallas.movierental.domain.decorator;

import com.utdallas.movierental.domain.type.CategoryType;
import com.utdallas.movierental.domain.Item;
import com.utdallas.movierental.domain.type.ModelType;

import java.math.BigDecimal;
import java.util.Date;

public abstract class ItemDecorator implements Item {

    protected Item item;

    public ItemDecorator(Item item) {
        this.item = item;
    }

    @Override
    public String getTitle() {
        return item.getTitle();
    }

    @Override
    public Date getAvailableDate() {
        return item.getAvailableDate();
    }

    @Override
    public void setTitle(String title) {
        item.setTitle(title);
    }

    @Override
    public CategoryType getCategoryType() {
        return item.getCategoryType();
    }

    @Override
    public ModelType getModelType() {
        return item.getModelType();
    }

    @Override
    public void setCategoryType(CategoryType categoryType) {
        item.setCategoryType(categoryType);
    }

    @Override
    public BigDecimal getPrice() {
        return item.getPrice();
    }
}
