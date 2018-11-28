package com.utdallas.movierental.domain.models;

import com.utdallas.movierental.domain.type.CategoryType;
import com.utdallas.movierental.domain.type.ModelType;

public class CD extends BaseItem {

    public CD(String title, CategoryType categoryType) {
        super(title, categoryType, ModelType.CD);
    }

}
