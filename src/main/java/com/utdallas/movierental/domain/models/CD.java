package com.utdallas.movierental.domain.models;

import com.utdallas.movierental.domain.CategoryType;

public class CD extends RegularItem {

    public CD(String title, CategoryType categoryType) {
        super(title, categoryType);
    }

}