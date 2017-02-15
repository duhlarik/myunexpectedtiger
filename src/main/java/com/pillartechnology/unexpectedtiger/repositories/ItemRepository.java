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

    public void clearAll() {
        items.clear();
    }

    public void removeLastItem() {
        if(items.size()>0) {
            items.remove(items.size()-1);
        }
    }

    public void removeItem(Item item) {
        items.remove(item);
    }
}
