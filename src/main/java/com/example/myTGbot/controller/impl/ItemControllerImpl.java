package com.example.myTGbot.controller.impl;

import com.example.myTGbot.controller.ItemController;
import com.example.myTGbot.model.Item;
import com.example.myTGbot.service.ItemService;
import com.example.myTGbot.validation.Validation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ItemControllerImpl implements ItemController {

    @Autowired
    private final ItemService itemService;

    @Autowired
    private final Validation validation;


    @Override
    public Long create(String name, Double price) {
        if (!(validation.validateName(name) && validation.validatePrice(price))) {
            throw new RuntimeException();
        }
        Item item = new Item(name, price);
        return itemService.create(item);
    }

    @Override
    public Item get(Long id) {
        if (!validation.validateId(id)) {
            throw new RuntimeException();
        }
        return itemService.get(id);
    }

    @Override
    public Item update(Long id, String name, Double price) {
        if (!(validation.validateId(id) && validation.validateName(name) && validation.validatePrice(price))) {
            throw new RuntimeException();
        }
        Item item = new Item(name, price);
        return itemService.update(item);
    }

    @Override
    public void delete(Long id) {
        if (!validation.validateId(id)) {
            throw new RuntimeException();
        }
        itemService.delete(id);
    }
}
