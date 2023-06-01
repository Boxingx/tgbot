package com.example.myTGbot.service;

import com.example.myTGbot.model.Item;

public interface ItemService {
    Long create(Item item);
    Item get(Long id);
    Item update(Item item);
    void delete(Long id);
}
