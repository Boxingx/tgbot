package com.example.myTGbot.controller;

import com.example.myTGbot.model.Admin;
import com.example.myTGbot.model.enums.AdminStatus;

public interface AdminController {
    void create(Long id, String firstName, String secondName, AdminStatus adminStatus, Double rating);
    Admin get(Long id);
    Admin update(Long id, String firstName, String secondName, AdminStatus adminStatus, Double rating);
    void delete(Long id);
}
