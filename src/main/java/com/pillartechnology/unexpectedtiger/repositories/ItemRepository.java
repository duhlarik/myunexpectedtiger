package com.pillartechnology.unexpectedtiger.repositories;

import com.pillartechnology.unexpectedtiger.entities.ItemEntity;
import com.pillartechnology.unexpectedtiger.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepository {

    @Autowired
    private ItemDBService itemService;

    public Item createItem(String content) throws IOException {
        ItemEntity entity = new ItemEntity();
        entity.setContent(content);
        entity = itemService.save(entity);
        return new Item(entity.getContent(), String.valueOf(entity.getId()));
    }

    Item retrieveItem(String itemId) throws IOException {
        ItemEntity entity = itemService.findOne(Integer.valueOf(itemId));
        return new Item(entity.getContent(), String.valueOf(entity.getId()));
    }

    public List<Item> retrieveAllItems() throws IOException {
        Iterable<ItemEntity> entities = itemService.findAll();
        ArrayList<Item> items = new ArrayList<>();
        for (ItemEntity entity : entities) {
            Item item = new Item(entity.getContent(), String.valueOf(entity.getId()));
            items.add(item);
        }
        return items;
    }

    public void deleteItem(String itemId) {
        itemService.delete(Integer.valueOf(itemId));
    }

    public void deleteAllItems() throws IOException {
        itemService.deleteAll();
    }
}

