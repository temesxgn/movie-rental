package com.utdallas.movierental.domain.models;

import com.utdallas.movierental.domain.CategoryType;

public class Movie extends RegularItem {

    public Movie(String title, CategoryType categoryType) {
        super(title, categoryType);
    }

}