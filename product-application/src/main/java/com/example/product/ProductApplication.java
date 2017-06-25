package com.example.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
@RefreshScope
@EnableEurekaClient
public class ProductApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

    @RequestMapping("/")
    public String getHome() {
        return "Welcome to product Application";
    }

    @RequestMapping("/products")
    public List<String> getProducts() {
        LOGGER.info("\n\n\n\nInside Prouct application");
        return Arrays.asList("Shampoo", "Vegetable", "Soap", "Chocolate");
    }
}
