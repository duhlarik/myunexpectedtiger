package com.pillartechnology.unexpectedtiger.repositories;

import com.pillartechnology.unexpectedtiger.model.Item;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemFileRepository {

    @Autowired
    private ItemService itemService;

    private String path = "/Users/duhlarik/Development/unexpectedtiger/src/main/resources/todos";

    ItemFileRepository(String data_path) {
        this.path = data_path;
    }

    public ItemFileRepository() {
    }

    Item save(Item item) throws IOException {
        String content = item.getContent();
        String itemId = item.getItemId();
        File item_file = new File(path, itemId);
        try (FileWriter writer = new FileWriter(item_file)) {
            writer.append(content);
        }
        return new Item(content, itemId);
    }

    Item findOne(String itemId) throws IOException {
        File item_file = new File(path, itemId);
        String content = readContent(item_file);
        return new Item(content, itemId);
    }

    List<Item> findAll() throws IOException {
        File itemsDir = new File(path);
        File[] files = itemsDir.listFiles();

        List<Item> items = new ArrayList<>();

        if (files != null) {
            for (File file : files) {
                String content = readContent(file);
                String item_id = file.getName();
                Item item = new Item(content, item_id);
                items.add(item);
            }
        }
        return items;
    }

    private String readContent(File item_file) throws IOException {
        BufferedReader itemReader = new BufferedReader(new FileReader(item_file));
        return itemReader.readLine();
    }

    void delete(String itemId) {
        File item_file = new File(path + File.separator + itemId);
        if (!item_file.exists()) {
            throw new RuntimeException();
        }
        item_file.delete();
    }

    void deleteAll() throws IOException {
        FileUtils.cleanDirectory(new File(path));
    }
}
