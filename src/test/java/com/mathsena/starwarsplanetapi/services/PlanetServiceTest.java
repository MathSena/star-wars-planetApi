package com.mathsena.starwarsplanetapi.services;

import com.mathsena.starwarsplanetapi.models.Planet;
import com.mathsena.starwarsplanetapi.repository.PlanetRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class PlanetServiceTest {

    @InjectMocks
    private PlanetService planetService;

    @Mock
    private PlanetRepository planetRepository;

    @Test
    @DisplayName("Given a planet, when create is called, then it should return a planet")
    void testCreatePlanet_WithValidData_returnsPlanet() {
        when(planetRepository.save(new Planet(1L, "name", "climate", "terrain"))).thenReturn(new Planet(1L, "name", "climate", "terrain"));
        Planet sut = planetService.create(new Planet(1L, "name", "climate", "terrain"));
        assertThat(sut).isEqualTo(new Planet(1L, "name", "climate", "terrain"));

    }


    @Test
    @DisplayName("Given a planet with invalid data, when create is called, then it should throw an exception")
    public void createPlanet_withInvalidData_throwsException() {
        when(planetRepository.save(new Planet(1L, "", "", ""))).thenThrow(IllegalArgumentException.class);

        assertThatThrownBy(() -> planetService.create(new Planet(1L, "", "", "")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
