package com.utdallas.movierental.domain.model;

import com.utdallas.movierental.domain.type.CategoryType;
import com.utdallas.movierental.domain.type.ModelType;

public class DVD extends BaseItem {

    public DVD(String title, CategoryType categoryType, double price) {
        super(title, categoryType, ModelType.DVD, price);
    }

}
