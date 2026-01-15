package com.alanalves.catalogservice.controller;

import com.alanalves.catalogservice.service.impl.CatalogServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/catalog")
@RequiredArgsConstructor
public class CatalogController {

    private final CatalogServiceImpl catalogService;

    @GetMapping("/{genre}")
    public ResponseEntity<?> getCatalogByGenre(@PathVariable String genre) {
        return ResponseEntity.status(HttpStatus.OK).body(catalogService.getCatalogByGenre(genre));
    }
}
