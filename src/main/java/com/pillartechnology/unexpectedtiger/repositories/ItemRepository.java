package com.pillartechnology.unexpectedtiger.repositories;

import com.pillartechnology.unexpectedtiger.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepository {

    private List<Item> items = new ArrayList<>();

    @Autowired
    private ItemService itemService = new ItemService();

    public Item createItem(String content) throws IOException {
        return itemService.createItem(content);
    }

    Item retrieveItem(String itemId) throws IOException {
        return itemService.retrieveItem(itemId);
    }

    public List<Item> retrieveAllItems() throws IOException {
        return itemService.retrieveAllItems();
    }

    public void deleteItem(String itemId) {
        itemService.deleteItem(itemId);
    }

    public void deleteAllItems() throws IOException {
        itemService.deleteAllItems();
    }
}
