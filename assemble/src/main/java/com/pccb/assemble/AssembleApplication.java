package com.pccb.assemble;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;

@SpringBootApplication()
@ComponentScan(basePackages = "com.pccb")
@ContextConfiguration
/*
@EnableJpaRepositories("com.pccb.customer.dao")
@EntityScan(basePackages = "com.pccb.customer.entity")*/
public class AssembleApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssembleApplication.class, args);
    }
}
