package com.pillartechnology.unexpectedtiger.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name = "Item")
public class ItemEntity {

    @Id
    private Long id;

    @Column
    private String content;

    public ItemEntity() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
