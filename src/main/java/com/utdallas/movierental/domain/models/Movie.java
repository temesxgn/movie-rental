package com.utdallas.movierental.domain.models;

import com.utdallas.movierental.domain.type.CategoryType;
import com.utdallas.movierental.domain.type.ModelType;

public class Movie extends BaseItem {

    public Movie(String title, CategoryType categoryType) {
        super(title, categoryType, ModelType.MOVIE);
    }

}