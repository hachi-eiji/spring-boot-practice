package com.hachiyae.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.hachiyae.boot.repository")
@EntityScan(basePackages = "com.hachiyae.boot.entity")
@SpringBootApplication(scanBasePackages = "com.hachiyae.boot")
public class Main {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
    }
}
