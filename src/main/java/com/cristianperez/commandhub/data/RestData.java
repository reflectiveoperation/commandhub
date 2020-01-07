package com.cristianperez.commandhub.data;

import com.cristianperez.commandhub.model.PullRequest;
import com.cristianperez.commandhub.service.adapter.SourceData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Repository
public class RestData implements SourceData {

    private RestTemplate restTemplate;
    private String token;
    private String pullRequestUrl;

    public RestData(final RestTemplate restTemplate, final @Value("${github-token}") String token,
                    final @Value("${pull-request-url}") String pullRequestUrl) {
        this.restTemplate = restTemplate;
        this.token = token;
        this.pullRequestUrl = pullRequestUrl;
    }

    @Override
    public ResponseEntity<PullRequest[]> getPullRequestData() {
        var headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setBearerAuth(token);
        var entity = new HttpEntity<>("", headers);
        var response = restTemplate.exchange(pullRequestUrl, HttpMethod.GET, entity, PullRequest[].class);
        return ResponseEntity.ok(response.getBody());
    }

}
