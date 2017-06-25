package com.example.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RefreshScope
@EnableEurekaClient
//@EnableFeignClients
public class UserApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserApplication.class);

    @Value("${user.role}")
    private String role;

    @Value("${user.password}")
    private String password;

    @Autowired
    private RestTemplate restTemplate;

/*    @Autowired
    ProductClient client;*/

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @RequestMapping("/")
    public String getHome() {
        return "Welcome to User Application";
    }

    // @FeignClient(name = "product-application", url = "http://localhost:7070")
/*    @FeignClient(name = "product-application")
    interface ProductClient {
        @RequestMapping(value = "/products", method = GET)
        String getProducts();

    }*/

    @RequestMapping("/users/products")
    public ResponseEntity<String> getProducts() {
        //return "Products";
        LOGGER.info("\n\n\n\nInside user application");
        return restTemplate.getForEntity("http://product-application/products", String.class);
        //return client.getProducts();
    }

/*    @RequestMapping("/users/products")
    public String getProdiucts() {
        //return "Products";
        LOGGER.info("\n\n\n\nInside user application");
        return client.getProducts();
    }*/
}
