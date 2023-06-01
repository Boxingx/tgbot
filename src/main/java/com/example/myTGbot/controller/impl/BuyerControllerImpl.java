package com.example.myTGbot.controller.impl;

import com.example.myTGbot.controller.BuyerController;
import com.example.myTGbot.model.Buyer;
import com.example.myTGbot.model.Order;
import com.example.myTGbot.service.BuyerService;
import com.example.myTGbot.validation.Validation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.Timestamp;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class BuyerControllerImpl implements BuyerController {
    @Autowired
    private final BuyerService buyerService;
    @Autowired
    private final Validation validation;


    @Override
    public void create(Long id, String firstName, String secondName, List<Order> orderList, String address) {
        Buyer buyer = new Buyer(id, firstName, secondName, new Timestamp(System.currentTimeMillis()), orderList, address);
        buyerService.create(buyer);
    }

    @Override
    public Buyer get(Long id) {
        if (!(validation.validateId(id))) {
            throw new RuntimeException();
        }
        return buyerService.get(id);
    }

    @Override
    public Buyer update(Long id, String firstName, String secondName, List<Order> orderList, String address) {
        if (!(validation.validateId(id) && validation.validateName(firstName) && validation.validateName(secondName))) {
            throw new RuntimeException();
        }
        Buyer buyer = new Buyer(id, firstName, secondName, new Timestamp(System.currentTimeMillis()), orderList, address);
        return buyerService.update(buyer);
    }

    @Override
    public void delete(Long id) {
        if (!(validation.validateId(id))) {
            throw new RuntimeException();
        }
        buyerService.delete(id);
    }

    @Override
    public void registration(Long id, String firstName, String secondName, List<Order> orderList, String address) {
        System.out.println("registration controller method");
        Buyer buyer = new Buyer(id, firstName, secondName, new Timestamp(System.currentTimeMillis()), orderList, address);
        buyerService.registration(buyer);
        log.info("Вызвали метод регистрации сервиса");
    }
}
