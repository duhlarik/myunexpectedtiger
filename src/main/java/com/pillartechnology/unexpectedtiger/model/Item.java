package com.pillartechnology.unexpectedtiger.model;

import org.springframework.stereotype.Component;

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

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}
