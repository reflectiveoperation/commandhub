package com.cristianperez.commandhub.service;

import com.cristianperez.commandhub.service.adapter.SourceData;
import com.cristianperez.commandhub.model.PullRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Processor {

    private SourceData sourceData;

    public Processor(final SourceData sourceData) {
        this.sourceData = sourceData;
    }

    public ResponseEntity<PullRequest[]> getPullRequest() {
        return sourceData.getPullRequestData();
    }
}
