package com.utdallas.movierental.domain;

import com.utdallas.movierental.domain.CategoryType;
import com.utdallas.movierental.domain.Rentable;
import com.utdallas.movierental.domain.RentalItem;

public class Movie extends RentalItem {

    public Movie(String title, CategoryType categoryType) {
        super(title, categoryType);
    }

}