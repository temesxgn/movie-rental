package com.utdallas.movierental.domain.models;

import com.utdallas.movierental.domain.CategoryType;
import com.utdallas.movierental.domain.Item;

//TODO Figure out better name
public abstract class RegularItem implements Item {

    private String title;
    private CategoryType categoryType;

    public RegularItem(String title, CategoryType categoryType) {
        this.title = title;
        this.categoryType = categoryType;
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
}
