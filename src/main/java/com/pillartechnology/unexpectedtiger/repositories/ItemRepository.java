package com.pillartechnology.unexpectedtiger.repositories;

import com.pillartechnology.unexpectedtiger.model.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepository {

    private List<Item> items = new ArrayList<>();

    public List<Item> retrieveAll() {
        return items;
    }

    public void add(Item item) {
        items.add(item);
    }

    void clearAll() {
        items.clear();
    }

    void removeItem() {
        items.remove(items.size()-1);
    }
}
