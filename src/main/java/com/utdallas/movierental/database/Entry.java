package com.utdallas.movierental.database;

import com.utdallas.movierental.domain.Item;
import com.utdallas.movierental.util.ApplicationUtil;

import java.math.BigDecimal;

public class Entry {

    private int id;
    private Item item;
    private int availableQuantity;

    public Entry() {

    }

    public Entry(int id, Item item, int availableQuantity) {
        this.id = id;
        this.item = item;
        this.availableQuantity = availableQuantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%3s %5s %20s %25s %10.2f %25s %10s", this.getId(),
                ApplicationUtil.PIPE, this.getItem().getTitle(), ApplicationUtil.PIPE,
                this.item.getPrice(), ApplicationUtil.PIPE, this.getAvailableQuantity());
    }

    public boolean isNull() {
        return this instanceof NullEntry;
    }
}
