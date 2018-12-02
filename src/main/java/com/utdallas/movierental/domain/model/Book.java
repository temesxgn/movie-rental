package com.utdallas.movierental.domain.model;

import com.utdallas.movierental.domain.type.CategoryType;
import com.utdallas.movierental.domain.type.ModelType;

public class Book extends BaseItem {

    public Book(String title, CategoryType categoryType, double price) {
        super(title, categoryType, ModelType.BOOK, price);
    }

}
