package com.dh.serieservice;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class SerieServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SerieServiceApplication.class, args);
    }

}
