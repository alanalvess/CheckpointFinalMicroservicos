package com.dh.serieservice.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQSenderConfig {

    @Value("${queue.series-service.name}")
    private String seriesServiceQueue;

    @Bean Queue queue () {
        return new Queue(this.seriesServiceQueue, false);
    }
}
