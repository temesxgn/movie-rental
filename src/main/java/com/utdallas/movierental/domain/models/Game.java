package com.utdallas.movierental.domain.models;

import com.utdallas.movierental.domain.type.CategoryType;
import com.utdallas.movierental.domain.type.ModelType;

public class Game extends BaseItem {

    public Game(String title, CategoryType categoryType) {
        super(title, categoryType, ModelType.GAME);
    }

}
