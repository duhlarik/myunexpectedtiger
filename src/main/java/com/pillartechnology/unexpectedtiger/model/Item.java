package com.pillartechnology.unexpectedtiger.model;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class Item {

    private String content;
    public String itemId;

    public Item() {
    }

    public Item(String content, String itemId) {
        this.content = content;
        this.itemId = itemId;
    }

    public Item(String content) {
        this(content, "");
    }


    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemId() {
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

        return itemId != null ? itemId.equals(item.itemId) : item.itemId == null;
    }

    @Override
    public int hashCode() {
        return itemId != null ? itemId.hashCode() : 0;
    }
}
