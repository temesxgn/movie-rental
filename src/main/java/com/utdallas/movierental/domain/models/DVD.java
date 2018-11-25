package com.utdallas.movierental.domain.models;

import com.utdallas.movierental.domain.CategoryType;

public class DVD extends RegularItem {

    public DVD(String title, CategoryType categoryType) {
        super(title, categoryType);
    }

}
