package com.example.myTGbot.controller;

import com.example.myTGbot.model.Item;

public interface ItemController {
    Long create(String name, Double price);
    Item get(Long id);
    Item update(Long id, String name, Double price);
    void delete(Long id);
}
