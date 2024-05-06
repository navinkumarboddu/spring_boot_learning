package com.in28minutes.springboot.web;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.in28minutes.springboot.web.converter.DateToStringConverter;
import com.in28minutes.springboot.web.converter.StringToDateConverter;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToDateConverter());
        registry.addConverter(new DateToStringConverter());
    }
}
