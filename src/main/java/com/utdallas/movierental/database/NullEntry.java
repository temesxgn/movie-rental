package com.utdallas.movierental.database;

import com.utdallas.movierental.domain.Item;
import com.utdallas.movierental.domain.NullItem;

public class NullEntry extends Entry {

    public NullEntry() {
    }

    @Override
    public String toString() {
        return "";
    }
}
