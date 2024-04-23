package dev.micfro.springwebclient.controler;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class WebClientConfig {

    // Create a WebClient bean that will be used to make requests to the JSONPlaceholder API
    @Bean
    public WebClient webClient() {

        return WebClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
