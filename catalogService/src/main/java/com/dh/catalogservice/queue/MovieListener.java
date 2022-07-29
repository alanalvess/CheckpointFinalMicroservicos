package com.dh.catalogservice.queue;

import com.dh.catalogservice.service.impl.CatalogServiceImpl;
import com.dh.catalogservice.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MovieListener {

    private final CatalogServiceImpl catalogService;

    @RabbitListener(queues = {"${queue.movie-service.name}"})
    public void receiveMessage(Movie movie) {
        catalogService.addNewMovie(movie);
    }
}