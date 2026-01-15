package com.alanalves.serieservice.queue;


import com.alanalves.serieservice.model.Serie;
import com.alanalves.serieservice.service.impl.SerieServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SerieListener {

    private final SerieServiceImpl serieService;

    @RabbitListener(queues = {"${queue.serie-service.name}"})
    public void receiveMessage(Serie serie){
        serieService.saveSerie(serie);
    }
}
