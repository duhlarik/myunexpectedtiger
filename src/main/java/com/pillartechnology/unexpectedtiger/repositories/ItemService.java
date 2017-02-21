package com.pillartechnology.unexpectedtiger.repositories;

import com.pillartechnology.unexpectedtiger.model.Item;
import org.apache.tomcat.util.http.fileupload.FileUtils;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemService {
    public static Random RANDOM = new Random();
    private String path = "/Users/duhlarik/Development/unexpectedtiger/src/main/resources/todos";

    public ItemService(String data_path) {
        this.path = data_path;
    }

    public ItemService() {
    }

    public Item createItem(String content) throws IOException {
        final int itemId = RANDOM.nextInt(9000000) + 1000000;
        String itemIdString = Integer.toString(itemId);
        File item_file = new File(path, itemIdString);
        try (FileWriter writer = new FileWriter(item_file)) {
            writer.append(content);
        }
        return new Item(content, itemIdString);
    }

    public Item retrieveItem(String itemId) throws IOException {
        File item_file = new File(path, itemId);
        String content = readContent(item_file);
        return new Item(content, itemId);
    }

    private String readContent(File item_file) throws IOException {
        BufferedReader itemReader = new BufferedReader(new FileReader(item_file));
        return itemReader.readLine();
    }

    public void deleteItem(String itemId) {
        File item_file = new File(path + File.separator + itemId);
        if (!item_file.exists()) {
            throw new RuntimeException();
        }
        item_file.delete();
    }

    public List<Item> retrieveAllItems() throws IOException {
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

    public void deleteAllItems() throws IOException {
        FileUtils.cleanDirectory(new File(path));
    }
}
