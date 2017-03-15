package com.pillartechnology.unexpectedtiger.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import static java.util.UUID.randomUUID;

@Entity (name = "Item")
public class ItemEntity {

    @Id
    private String id;

    @Column
    private String content;

    public ItemEntity() {
        id = randomUUID().toString();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
