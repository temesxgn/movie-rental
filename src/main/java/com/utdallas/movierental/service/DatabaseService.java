package com.utdallas.movierental.service;

import com.utdallas.movierental.database.Database;
import com.utdallas.movierental.database.Entry;
import com.utdallas.movierental.domain.decorator.ItemDecoratorPurchasable;
import com.utdallas.movierental.domain.decorator.ItemDecoratorRentable;
import com.utdallas.movierental.domain.type.CategoryType;
import com.utdallas.movierental.domain.Item;
import com.utdallas.movierental.domain.ItemFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public final class DatabaseService {

    private static Database database = init();

    public static Optional<Entry> findById(final int id) {
        return database.findById(id);
    }

    public static Optional<Entry> findByTitle(final String title) {
        return database.findByTitle(title);
    }

    public static void deductAvailabilityAmountForEntry(int entryId, int selectedQuantity) {
        database.deductAvailabilityAmount(entryId, selectedQuantity);
    }

    public static void addAvailabilityAmountForEntry(int entryId, int selectedQuantity) {
        database.addAvailabilityAmount(entryId, selectedQuantity);
    }

    public static void printAvailableItems() {
        database.printAvailableItems();
    }

    private static Database init() {
        Database database = new Database();
        Item spaceJam = ItemFactory.createMovie("Space Jam", CategoryType.CHILDRENS, 10);
        Item gladiator = ItemFactory.createBook("Gladiator", CategoryType.NEW_RELEASE, 14);
        Item oceans11 = ItemFactory.createCD("Oceans 11", CategoryType.REGULAR, 5);
        Item oceans13 = ItemFactory.createDVD("Oceans 13", CategoryType.NEW_RELEASE, 30.5);
        Item kingdomHearts = ItemFactory.createGame("Kingdom Hearts 3", CategoryType.NEW_RELEASE, 21.75);
        Item clearanceItem = ItemFactory.createMovie("Clearance Item", CategoryType.REGULAR, 30);

        spaceJam = ItemFactory.createPurchasableItem(spaceJam);
        oceans11 = ItemFactory.createPurchasableItem(oceans11);
        oceans13 = ItemFactory.createPurchasableItem(oceans13);
        gladiator = ItemFactory.createRentableItem(gladiator);
        kingdomHearts = ItemFactory.createRentableItem(kingdomHearts);
        clearanceItem = ItemFactory.createClearanceItem(clearanceItem);

        List<Item> items = Arrays.asList(spaceJam, gladiator, oceans11, oceans13, kingdomHearts, clearanceItem);
        database.addItems(items);
        return database;
    }
}
