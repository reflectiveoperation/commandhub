package com.cristianperez.commandhub.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PullRequest {

    private Long id;
    private String state;
    private String title;
    private String body;


}
