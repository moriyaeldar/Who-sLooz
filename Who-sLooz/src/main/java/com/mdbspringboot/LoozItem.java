package com.mdbspringboot;

import org.springframework.data.annotation.Id;

public class LoozItem {
    @Id
    private String id;

    private String name;
    private int quantity;
    private String category;

    public LoozItem(String id, String name, int quantity, String category) {
        super();
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.category = category;
    }
}
