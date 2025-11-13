package com.tpi.solicitudes.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

/**
 * Configuración de RestClient moderno para comunicación entre microservicios (Spring 6.1+)
 * Este bean reemplaza la necesidad de WebClient reactivo cuando no necesitamos reactividad
 */
@Configuration
public class RestClientConfig {

    @Value("${services.logistica.url:http://localhost:8081}")
    private String logisticaUrl;

    @Value("${google.maps.base-url:https://maps.googleapis.com/maps/api}")
    private String googleMapsBaseUrl;

    /**
     * RestClient para ms-logistica (síncrono, mejor para operaciones síncronas)
     */
    @Bean
    public RestClient restClientLogistica() {
        return RestClient.builder()
                .baseUrl(logisticaUrl)
                .build();
    }

    /**
     * RestClient para Google Maps Distance Matrix API
     */
    @Bean
    public RestClient googleMapsRestClient() {
        return RestClient.builder()
                .baseUrl(googleMapsBaseUrl)
                .build();
    }
}
