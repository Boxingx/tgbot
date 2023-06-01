package com.example.myTGbot.service;

import com.example.myTGbot.model.Admin;

public interface AdminService {
    void create(Admin admin);
    Admin get(Long id);
    Admin update(Admin admin);
    void delete(Long id);
}
