package com.utdallas.movierental.domain;

import java.util.Comparator;

public abstract class RentalItem implements Rentable {

    private String title;
    private CategoryType categoryType;

    public RentalItem(String title, CategoryType categoryType) {
        this.title = title;
        this.categoryType = categoryType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }
}
