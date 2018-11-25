package com.utdallas.movierental.domain.models;

import com.utdallas.movierental.domain.CategoryType;

public class Book extends RegularItem {

    public Book(String title, CategoryType categoryType) {
        super(title, categoryType);
    }

}