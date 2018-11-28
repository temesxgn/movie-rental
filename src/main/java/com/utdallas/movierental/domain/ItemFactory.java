package com.utdallas.movierental.domain;

import com.utdallas.movierental.domain.models.*;
import com.utdallas.movierental.domain.type.CategoryType;

public final class ItemFactory {

    public static Book createBook(final String title, final CategoryType type) {
        return new Book(title, type);
    }

    public static CD createCD(final String title, final CategoryType type) {
        return new CD(title, type);
    }

    public static DVD createDVD(final String title, final CategoryType type) {
        return new DVD(title, type);
    }

    public static Game createGame(final String title, final CategoryType type) {
        return new Game(title, type);
    }

    public static Movie createMovie(final String title, final CategoryType type) {
        return new Movie(title, type);
    }
}
