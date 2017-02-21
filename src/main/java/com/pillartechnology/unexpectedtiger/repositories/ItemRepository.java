package com.pillartechnology.unexpectedtiger.repositories;

import com.pillartechnology.unexpectedtiger.model.Item;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepository {

    private List<Item> items = new ArrayList<>();
    private ItemService itemService = new ItemService();


    public ItemRepository(ItemService itemService) {
        this.itemService = itemService;
    }

    public Item add(String content) throws IOException {
        return itemService.createItem(content);
    }

    public Item retrieveItem(String itemId) throws IOException {
        return itemService.retrieveItem(itemId);
    }

    public void removeItem(String itemId) {
        itemService.deleteItem(itemId);
    }

    public List<Item> retrieveAll() throws IOException {
        return itemService.retrieveAllItems();
    }

    public void clearAll() throws IOException {
        itemService.deleteAllItems();
    }

    public void removeLastItem() {
        if (items.size() > 0) {
            items.remove(items.size() - 1);
        }
    }
}
