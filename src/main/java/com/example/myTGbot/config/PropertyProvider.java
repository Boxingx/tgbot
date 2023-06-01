package com.example.myTGbot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
@Data
public class PropertyProvider {
    @Value("${bot.name}")
    String botName;

    @Value("${bot.token}")
    String botToken;

}
