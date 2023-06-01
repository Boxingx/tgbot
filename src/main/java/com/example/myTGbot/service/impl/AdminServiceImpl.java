package com.example.myTGbot.service.impl;

import com.example.myTGbot.model.Admin;
import com.example.myTGbot.repo.AdminRepo;
import com.example.myTGbot.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepo adminRepo;

    public AdminServiceImpl(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    @Override
    public void create(Admin admin) {
        adminRepo.save(admin);
    }

    @Override
    public Admin get(Long id) {
        return adminRepo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public Admin update(Admin admin) {
        return adminRepo.save(admin);
    }

    @Override
    public void delete(Long id) {
        Admin admin = get(id); // Что это за гет? ВОПРОС!!!

    }
}
