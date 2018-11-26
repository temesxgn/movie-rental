package com.utdallas.movierental.domain.models;

import com.utdallas.movierental.domain.CategoryType;

public class DVD extends BaseItem {

    public DVD(String title, CategoryType categoryType) {
        super(title, categoryType);
    }

}
