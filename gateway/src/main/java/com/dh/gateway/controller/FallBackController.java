package com.dh.gateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallBackController {

    @GetMapping("/movieServiceFallBack")
    public ResponseEntity<?> movieServiceFallBack(){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Something went wrong with MovieService. Please try again later.");
    }

    @GetMapping("/seriesServiceFallBack")
    public ResponseEntity<?> seriesServiceFallBack() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Something went wrong with SeriesService. Please try again later.");
    }

    @GetMapping("/catalogServiceFallBack")
    public ResponseEntity<?> catalogServiceFallBack() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Something went wrong with CatalogService. Please try again later.");
    }
}
