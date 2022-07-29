package com.dh.catalogservice.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQSenderConfig {

    @Value("${queue.movie-service.name}")
    private String movieServiceQueue;

    @Value("${queue.series-service.name}")
    private String seriesServiceQueue;

    @Bean
    public Queue movieQueue() {
        return new Queue(this.movieServiceQueue,false);
    }

    @Bean
    public Queue serieQueue() {
        return new Queue(this.seriesServiceQueue, false);
    }
}
