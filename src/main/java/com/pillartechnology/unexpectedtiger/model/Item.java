package com.pillartechnology.unexpectedtiger.model;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class Item {

    private String content;
    public int itemId;

    public Item() {
    }

    public Item(String content) {
        this.content = content;
    }

    public Item(int itemId) {
        this.itemId = itemId;
    }
    public Item(String content, int itemId) {
        this.content = content;
        this.itemId = itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getItemId() {
        return itemId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        return itemId == item.itemId;
    }

    @Override
    public int hashCode() {
        return itemId;
    }
}
