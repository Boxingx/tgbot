package com.example.myTGbot.controller.impl;

import com.example.myTGbot.controller.AdminController;
import com.example.myTGbot.exceptions.ValidationException;
import com.example.myTGbot.model.Admin;
import com.example.myTGbot.model.enums.AdminStatus;
import com.example.myTGbot.service.AdminService;
import com.example.myTGbot.validation.Validation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.Timestamp;

@Controller
@Slf4j
@RequiredArgsConstructor
public class AdminControllerImpl implements AdminController {
    @Autowired
    private final AdminService adminService;
    @Autowired
    private final Validation validation;

    @Override
    public void create(Long id, String firstName, String secondName, AdminStatus adminStatus, Double rating) {
        if (!(validation.validateId(id) &&
                validation.validateName(firstName) &&
                validation.validateName(secondName) &&
                validation.validateAdminStatus(adminStatus) &&
                validation.validateRating(rating))) {
            throw new ValidationException("Ошибка создания админа");
        }
        Admin admin = new Admin(id, firstName, secondName, new Timestamp(System.currentTimeMillis()), adminStatus, rating);
        adminService.create(admin);
    }

    @Override
    public Admin get(Long id) {
        if (!(validation.validateId(id))) {
            throw new RuntimeException();
        }
        return adminService.get(id);
    }

    @Override
    public Admin update(Long id, String firstName, String secondName, AdminStatus adminStatus, Double rating) {
        if (!(validation.validateId(id) &&
                validation.validateName(firstName) &&
                validation.validateName(secondName) &&
                validation.validateAdminStatus(adminStatus) &&
                validation.validateRating(rating))) {
            throw new RuntimeException();
        }
        Admin admin = new Admin(id, firstName, secondName, new Timestamp(System.currentTimeMillis()), adminStatus, rating);
        return adminService.update(admin);
    }

    @Override
    public void delete(Long id) {
        if (!(validation.validateId(id))) {
            throw new RuntimeException();
        }
        adminService.delete(id);
    }
}
