package com.cristianperez.commandhub.presentation;

import com.cristianperez.commandhub.model.PullRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RestController
@RequestMapping("/api")
public class WebController {

    private RestTemplate restTemplate;
    private String token;
    private String pullRequestUrl;

    public WebController(RestTemplate restTemplate, @Value("${github-token}") String token,
                         @Value("${pull-request-url}") String pullRequestUrl) {
        this.restTemplate = restTemplate;
        this.token = token;
        this.pullRequestUrl = pullRequestUrl;
    }

    @GetMapping("/github")
    public ResponseEntity<PullRequest[]> testMethod() {

        var headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setBearerAuth(token);

        var entity = new HttpEntity<>("", headers);

        var response = restTemplate.exchange(pullRequestUrl, HttpMethod.GET, entity, PullRequest[].class);

        return ResponseEntity.ok(response.getBody());
    }

}
