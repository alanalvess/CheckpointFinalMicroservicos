package com.dh.catalogservice.queue;

import com.dh.catalogservice.service.impl.CatalogServiceImpl;
import com.dh.catalogservice.model.Serie;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SerieListener {

    private final CatalogServiceImpl catalogService;

    @RabbitListener(queues = {"${queue.series-service.name}"})
    public void receiveMessage(Serie serie) {
        catalogService.addNewSerie(serie);
    }
}
