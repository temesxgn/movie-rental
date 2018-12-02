package com.utdallas.movierental.domain.model;

import com.utdallas.movierental.domain.type.CategoryType;
import com.utdallas.movierental.domain.type.ModelType;

public class Movie extends BaseItem {

    public Movie(String title, CategoryType categoryType, double price) {
        super(title, categoryType, ModelType.MOVIE, price);
    }

}