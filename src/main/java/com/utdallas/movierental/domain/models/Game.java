package com.utdallas.movierental.domain.models;

import com.utdallas.movierental.domain.CategoryType;

public class Game extends RegularItem {

    public Game(String title, CategoryType categoryType) {
        super(title, categoryType);
    }

}
