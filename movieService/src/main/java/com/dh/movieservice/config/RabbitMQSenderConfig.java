package com.dh.movieservice.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQSenderConfig {

    @Value("${queue.movie-service.name}")
    private String movieServiceQueue;

    @Bean
    public Queue queue() {
        return new Queue(this.movieServiceQueue,false);
    }
}
