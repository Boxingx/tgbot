package com.example.myTGbot.validation;

import com.example.myTGbot.model.enums.AdminStatus;
import org.springframework.stereotype.Component;

@Component
public class Validation {

    public boolean validateName(String name) {
       if (name.length() > 0 && name.length() < 255) {
           return true;
       } else
           return false;
    }

    public boolean validatePrice(Double price) {
        if (price > 0) {
            return true;
        } else
            return false;
    }

    public boolean validateId(Long id) {
        if (id > 0) {
            return true;
        } else
            return false;
    }

    public boolean validateRating(Double rating) {
        if (rating >= 0.0 && rating <= 5.0) {
            return true;
        } else
            return false;
    }

    public boolean validateAdminStatus(AdminStatus adminStatus) {
        if (adminStatus.equals(AdminStatus.ACTIVE) || adminStatus.equals(adminStatus.INACTIVE)) {
            return true;
        } else
            return false;
    }


}
