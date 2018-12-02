package com.utdallas.movierental.domain.model;

import com.utdallas.movierental.domain.type.CategoryType;
import com.utdallas.movierental.domain.type.ModelType;

public class Game extends BaseItem {

    public Game(String title, CategoryType categoryType, double price) {
        super(title, categoryType, ModelType.GAME, price);
    }

}
