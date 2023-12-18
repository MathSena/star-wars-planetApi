package com.mathsena.starwarsplanetapi.services;

import com.mathsena.starwarsplanetapi.models.Planet;
import com.mathsena.starwarsplanetapi.repository.PlanetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetService {

    private final PlanetRepository planetRepository;

    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public Planet create(Planet planet) {
        return planetRepository.save(planet);
    }


    public Planet findById(Long id) {
        return planetRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    public Planet findByName(String name) {
        return planetRepository.findByName(name);
    }

    public List<Planet> findAll() {
        return planetRepository.findAll();
    }

    public void delete(Long id) {
        planetRepository.deleteById(id);
    }

}