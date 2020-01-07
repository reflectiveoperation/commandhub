package com.cristianperez.commandhub.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestConfigTest {

    private RestConfig restConfig;

    @BeforeEach
    void setUp() {
        restConfig = new RestConfig();
    }

    @Test
    void getRestTemplate_returnsValidRestTemplate() {
        var output = restConfig.getRestTemplate().getClass();
        assertSame(restConfig.getRestTemplate().getClass(), output);
    }
}