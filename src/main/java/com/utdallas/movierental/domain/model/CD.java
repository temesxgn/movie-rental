package com.utdallas.movierental.domain.model;

import com.utdallas.movierental.domain.type.CategoryType;
import com.utdallas.movierental.domain.type.ModelType;

public class CD extends BaseItem {

    public CD(String title, CategoryType categoryType, double price) {
        super(title, categoryType, ModelType.CD, price);
    }

}
