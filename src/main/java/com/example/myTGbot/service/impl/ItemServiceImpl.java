package com.example.myTGbot.service.impl;

import com.example.myTGbot.model.Item;
import com.example.myTGbot.repo.ItemRepo;
import com.example.myTGbot.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepo itemRepo;


    @Override
    public Long create(Item item) {
        return itemRepo.save(item).getId();
    }

    @Override
    public Item get(Long id) {
        return itemRepo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public Item update(Item item) {
        return itemRepo.save(item);
    }

    @Override
    public void delete(Long id) {
        Item item = get(id); // Что это за гет? ВОПРОС!!!
        item.setAvailable(false);
        itemRepo.save(item);
    }
}
