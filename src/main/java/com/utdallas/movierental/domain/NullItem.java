package com.utdallas.movierental.domain;

public class NullItem implements Item {
    @Override
    public String getTitle() {
        return "";
    }

    @Override
    public void setTitle(String title) {

    }

    @Override
    public CategoryType getCategoryType() {
        return null;
    }

    @Override
    public void setCategoryType(CategoryType categoryType) {

    }
}
