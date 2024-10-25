package com.example.connection_pool_testing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "com.example.connection_pool_testing.*" })
@SpringBootApplication(scanBasePackages = { "com.example.connection_pool_testing.*" })
public class ConnectionPoolTestingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConnectionPoolTestingApplication.class, args);
    }

}
