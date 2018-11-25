package com.utdallas.movierental.domain;

public interface Item {

    String getTitle();

    void setTitle(String title);

    CategoryType getCategoryType();

    void setCategoryType(CategoryType categoryType);
}
