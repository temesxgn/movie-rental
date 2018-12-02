package com.utdallas.movierental.database;

import com.utdallas.movierental.domain.Item;
import com.utdallas.movierental.util.ApplicationUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Database {

    private List<Entry> availableItems;
    private AtomicInteger atomicInteger;

    public Database() {
        availableItems = new ArrayList<>();
        atomicInteger = new AtomicInteger(1);
    }

    public void addItem(Entry entry) {
        availableItems.add(entry);
    }

    public List<Entry> getAvailableItems() {
        return availableItems;
    }

    public void addItems(List<Item> items) {
        items.forEach(item -> {
            Entry entry = new Entry(atomicInteger.getAndIncrement(), item, new Random().nextInt(10) + 1);
            addItem(entry);
        });
    }

    public Optional<Entry> findById(int id) {
        return availableItems.stream().filter(entry -> entry.getId() == id).findFirst();
    }

    public Optional<Entry> findByTitle(String title) {
        return availableItems.stream().filter(entry -> entry.getItem().getTitle().equals(title)).findFirst();
    }

    public void printAvailableItems() {
        printHeader();
        getAvailableItems().forEach(entry -> ApplicationUtil.println(entry.toString()));
    }

    private static void printHeader() {
        ApplicationUtil.println(String.format("%3s %5s %20s %25s %10s %17s %10s", "ID", ApplicationUtil.PIPE, "Item", ApplicationUtil.PIPE, "Purchase Price ($)", ApplicationUtil.PIPE, "Qty"));
        ApplicationUtil.println(String.format("%s", ApplicationUtil.HEADER));
    }

    public void deductAvailabilityAmount(int id, int selectedQuantity) {
        findById(id).ifPresent(entry -> {
            int avail = entry.getAvailableQuantity() - selectedQuantity;
            entry.setAvailableQuantity(avail);
        });

    }

    public void addAvailabilityAmount(int id, int selectedQuantity) {
        findById(id).ifPresent(entry -> {
            int avail = entry.getAvailableQuantity() + selectedQuantity;
            entry.setAvailableQuantity(avail);
        });
    }
}
