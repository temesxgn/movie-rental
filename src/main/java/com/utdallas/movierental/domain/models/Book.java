package com.utdallas.movierental.domain.models;

import com.utdallas.movierental.domain.type.CategoryType;
import com.utdallas.movierental.domain.type.ModelType;

public class Book extends BaseItem {

    public Book(String title, CategoryType categoryType) {
        super(title, categoryType, ModelType.BOOK);
    }

}
