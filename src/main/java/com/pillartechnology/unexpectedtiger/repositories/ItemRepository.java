package com.pillartechnology.unexpectedtiger.repositories;

import com.pillartechnology.unexpectedtiger.model.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class ItemRepository {

    private List<Item> items = new ArrayList<>();
    public static final Random RANDOM = new Random();

    public List<Item> retrieveAll() {
        return items;
    }

    public Item add(Item item) {
        item.setItemId(RANDOM.nextInt());
        items.add(item);
        System.out.println("******** ADD ITEM " + item.getItemId() + " " + item.getContent() +"********");
        return item;
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
        System.out.println("******** REMOVE ITEM " + item.getItemId() + " " + item.getContent() +"********");
    }
}
