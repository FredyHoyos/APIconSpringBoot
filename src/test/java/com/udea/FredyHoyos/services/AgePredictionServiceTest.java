package com.udea.FredyHoyos.services;

import com.udea.FredyHoyos.entities.AgePredictionDTO;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AgePredictionServiceTest {

    @Test
    public void testGetAgePredictionByName_ReturnsDTO() {
        // Mocks
        WebClient webClientMock = mock(WebClient.class);
        WebClient.RequestHeadersUriSpec uriSpecMock = mock(WebClient.RequestHeadersUriSpec.class);
        WebClient.RequestHeadersSpec<?> headersSpecMock = mock(WebClient.RequestHeadersSpec.class);
        WebClient.ResponseSpec responseSpecMock = mock(WebClient.ResponseSpec.class);

        // DTO simulado
        AgePredictionDTO mockResponse = new AgePredictionDTO();
        mockResponse.setName("ash");
        mockResponse.setAge(18);
        mockResponse.setCount(999);

        // Cadena de mocks
        when(webClientMock.get()).thenReturn(uriSpecMock);
        when(uriSpecMock.uri("/?name={name}", "ash")).thenReturn(headersSpecMock);
        when(headersSpecMock.retrieve()).thenReturn(responseSpecMock);
        when(responseSpecMock.bodyToMono(AgePredictionDTO.class)).thenReturn(Mono.just(mockResponse));

        // Servicio bajo prueba
        AgePredictionService service = new AgePredictionService(webClientMock);

        // Act
        AgePredictionDTO result = service.getAgePredictionByName("ash");

        // Assert
        assertNotNull(result);
        assertEquals("ash", result.getName());
        assertEquals(18, result.getAge());
        assertEquals(999, result.getCount());
    }
}
