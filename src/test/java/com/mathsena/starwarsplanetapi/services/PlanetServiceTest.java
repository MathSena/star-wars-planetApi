package com.mathsena.starwarsplanetapi.services;

import com.mathsena.starwarsplanetapi.models.Planet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class PlanetServiceTest {

    @Autowired
    private PlanetService planetService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Given a planet, when create is called, then it should return a planet")
    void testCreatePlanet_WithValidData_returnsPlanet() {
        Planet result = planetService.create(new Planet(1L, "name", "climate", "terrain"));
        Assertions.assertEquals(new Planet(1L, "name", "climate", "terrain"), result);
    }
}
