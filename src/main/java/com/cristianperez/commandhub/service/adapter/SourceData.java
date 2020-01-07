package com.cristianperez.commandhub.service.adapter;

import com.cristianperez.commandhub.model.PullRequest;
import org.springframework.http.ResponseEntity;

public interface SourceData {
    ResponseEntity<PullRequest[]> getPullRequestData();
}
