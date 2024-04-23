package dev.micfro.springwebclient.controller;

import dev.micfro.springwebclient.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/webclient")
public class WebClientController {

    private final WebClient webClient;

    @Autowired
    public WebClientController(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping("/v2/posts/{id}")
    public ResponseEntity<Mono<Post>> getPost(@PathVariable String id) {
        Mono<Post> postMono = webClient
                .get()
                .uri("/posts/{id}", id)
                .retrieve()
                .bodyToMono(Post.class);

        return new ResponseEntity<>(postMono, HttpStatus.OK);
    }
}
