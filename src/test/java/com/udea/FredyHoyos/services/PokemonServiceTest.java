package com.udea.FredyHoyos.services;

import com.udea.FredyHoyos.entities.PokemonDTO;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PokemonServiceTest {

    @Test
    public void testGetPokemonById_ReturnsPokemonDTO() {
        // Mocks
        WebClient webClientMock = mock(WebClient.class);
        WebClient.RequestHeadersUriSpec uriSpecMock = mock(WebClient.RequestHeadersUriSpec.class);
        WebClient.RequestHeadersSpec headersSpecMock = mock(WebClient.RequestHeadersSpec.class);
        WebClient.ResponseSpec responseSpecMock = mock(WebClient.ResponseSpec.class);

        // Respuesta simulada
        PokemonDTO mockPokemon = new PokemonDTO();
        mockPokemon.setName("bulbasaur");

        // Cadena de mocks
        when(webClientMock.get()).thenReturn(uriSpecMock);
        when(uriSpecMock.uri("pokemon/{id}", 1)).thenReturn(headersSpecMock);
        when(headersSpecMock.retrieve()).thenReturn(responseSpecMock);
        when(responseSpecMock.bodyToMono(PokemonDTO.class)).thenReturn(Mono.just(mockPokemon));

        // Servicio con WebClient simulado
        PokemonService service = new PokemonService(webClientMock);

        // Act
        PokemonDTO result = service.getPokemonById(1);

        // Assert
        assertNotNull(result);
        assertEquals("bulbasaur", result.getName());
    }
    
    
}
