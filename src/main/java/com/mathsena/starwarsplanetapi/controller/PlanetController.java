package com.mathsena.starwarsplanetapi.controller;

import com.mathsena.starwarsplanetapi.models.Planet;
import com.mathsena.starwarsplanetapi.services.PlanetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/planets")
public class PlanetController {

    private final PlanetService planetService;

    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @PostMapping
    public ResponseEntity<Planet> create(Planet planet) {
        Planet planetCreated = planetService.create(planet);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(planetCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Planet> findById(Long id) {
        Planet planet = planetService.findById(id);
        return ResponseEntity.ok(planet);
    }

    @GetMapping("/name")
    public ResponseEntity<Planet> findByName(String name) {
        Planet planet = planetService.findByName(name);
        return ResponseEntity.ok(planet);
    }

    @GetMapping
    public ResponseEntity<Planet> findAll() {
        Planet planet = (Planet) planetService.findAll();
        return ResponseEntity.ok(planet);
    }

    @DeleteMapping
    public ResponseEntity<Planet> delete(Long id) {
        planetService.delete(id);
        return ResponseEntity.ok()
                .build();
    }
    
}