package com.utdallas.movierental.domain.models;

import com.utdallas.movierental.domain.type.CategoryType;
import com.utdallas.movierental.domain.type.ModelType;

public class DVD extends BaseItem {

    public DVD(String title, CategoryType categoryType) {
        super(title, categoryType, ModelType.DVD);
    }

}
