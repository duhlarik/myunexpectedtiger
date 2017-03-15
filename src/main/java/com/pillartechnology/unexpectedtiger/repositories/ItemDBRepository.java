package com.pillartechnology.unexpectedtiger.repositories;

import com.pillartechnology.unexpectedtiger.entities.ItemEntity;
import com.pillartechnology.unexpectedtiger.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemDBRepository {

    @Autowired
    private ItemService itemService;

    public Item save(Item item) throws IOException {
        ItemEntity itemEntity = new ItemEntity();
        String content = item.getContent();
        System.out.println(content);
        String itemId = itemEntity.getId();
        System.out.println(itemId);
        itemEntity.setContent(content);
        itemService.save(itemEntity);
        return new Item(content, itemId);
    }

    Item findOne(String itemId) throws IOException {
        ItemEntity entity = itemService.findOne(itemId);
        return new Item(entity.getContent(), entity.getId());
    }

    public List<Item> findAll() throws IOException {
        Iterable<ItemEntity> entities = itemService.findAll();
        ArrayList<Item> items = new ArrayList<>();
        for (ItemEntity entity : entities) {
            Item item = new Item(entity.getContent(), entity.getId());
            items.add(item);
        }
        return items;
    }

    public void delete(String itemId) {
        itemService.delete(itemId);
    }

    public void deleteAll() throws IOException {
        itemService.deleteAll();
    }
}
