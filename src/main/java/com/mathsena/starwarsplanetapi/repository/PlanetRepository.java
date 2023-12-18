package com.mathsena.starwarsplanetapi.repository;

import com.mathsena.starwarsplanetapi.models.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {

    Planet findByName(String name);
}

 