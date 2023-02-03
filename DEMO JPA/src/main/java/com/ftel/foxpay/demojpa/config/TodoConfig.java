package com.ftel.foxpay.demojpa.config;

import com.ftel.foxpay.demojpa.model.TodoValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TodoConfig {
    @Bean
    public TodoValidator validator() {
        return new TodoValidator();
    }
}
