package com.atakanbasol.sayitahminoyunu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


// Mongo aktif etmek icin
// @EnableMongoRepositories

// Aspect aktif etmek icin
// @EnableAspectJAutoProxy(proxyTargetClass = true)
//
// Asenkron açmak icin
// @EnableAsync

// Spring Boot Cache mekanizmasını aktif ediyorum
// @EnableCaching

@SpringBootApplication(exclude = {
        SecurityAutoConfiguration.class,
        //org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        //org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class
}
)
//@SpringBootApplication
public class SayiTahminOyunu {

    public static void main(String[] args) {

        //Disables headless JOptionPane
        System.setProperty("java.awt.headless", "false");

        SpringApplication.run(SayiTahminOyunu.class, args);
    }
}
