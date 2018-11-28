package com.utdallas.movierental.service;

import com.utdallas.movierental.database.Database;
import com.utdallas.movierental.database.Entry;
import com.utdallas.movierental.domain.type.CategoryType;
import com.utdallas.movierental.domain.Item;
import com.utdallas.movierental.domain.ItemFactory;

import java.util.Arrays;
import java.util.List;

public final class DatabaseService {

    private static Database database = init();

    public static Entry findById(final int id) {
        return database.findById(id);
    }

    public static void deductAvailabilityAmountForEntry(int entryId, int selectedQuantity) {
        database.deductAvailabilityAmount(entryId, selectedQuantity);
    }

    public static void printAvailableItems() {
        database.printAvailableItems();
    }

    private static Database init() {
        Database database = new Database();
        Item spaceJam = ItemFactory.createMovie("Space Jam", CategoryType.CHILDRENS);
        Item gladiator = ItemFactory.createBook("Gladiator", CategoryType.NEW_RELEASE);
        Item oceans11 = ItemFactory.createCD("Oceans 11", CategoryType.REGULAR);
        Item oceans13 = ItemFactory.createDVD("Oceans 13", CategoryType.NEW_RELEASE);
        Item kingdomHearts = ItemFactory.createGame("Kingdom Hearts 3", CategoryType.NEW_RELEASE);
        List<Item> items = Arrays.asList(spaceJam, gladiator, oceans11, oceans13, kingdomHearts);
        database.addItems(items);
        return database;
    }
}
