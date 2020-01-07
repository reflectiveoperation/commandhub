package com.cristianperez.commandhub.controller;

import com.cristianperez.commandhub.model.PullRequest;
import com.cristianperez.commandhub.service.Processor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AppController {

    private Processor processor;

    public AppController(final Processor processor) {
        this.processor = processor;
    }

    @GetMapping("/pullrequest")
    public ResponseEntity<PullRequest[]> getPullRequest() {
        return processor.getPullRequest();
    }

}
