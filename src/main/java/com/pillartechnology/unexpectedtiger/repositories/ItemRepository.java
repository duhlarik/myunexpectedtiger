package com.pillartechnology.unexpectedtiger.repositories;

import com.pillartechnology.unexpectedtiger.model.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepository {

    private List<Item> items = new ArrayList<>();

    List<Item> retrieveAll() {
        return items;
    }

    void add(Item item) {
        items.add(item);
    }

    void removeItem() {
        items.clear();
    }
}
