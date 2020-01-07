//package com.cristianperez.commandhub.data;
//
//import com.cristianperez.commandhub.model.PullRequest;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.http.*;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Collections;
//
//import static org.junit.jupiter.api.Assertions.assertSame;
//import static org.mockito.Mockito.when;
//
//class RestDataTest {
//
//    @InjectMocks
//    private RestData restData;
//    @Mock
//    private RestTemplate mockedRestTemplate;
//    private String pullRequestUrl;
//    private String token;
//
//    @BeforeEach
//    void setUp() {
//        pullRequestUrl = "http://mock.url.com/";
//        token = "mockedToken123";
//        mockedRestTemplate = Mockito.mock(RestTemplate.class);
//        restData = new RestData(mockedRestTemplate, token, pullRequestUrl);
//    }
//
//    @Test
//    void whenGetPullRequestDataIsInvoked_returnsPullRequest() {
//        var headers = new HttpHeaders();
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//        PullRequest[] pullRequest = {PullRequest.builder().state("open").id(123L).body("test").title("someTitle").build()};
//        when(mockedRestTemplate.exchange(pullRequestUrl, HttpMethod.GET, new HttpEntity<>("", headers), PullRequest[].class)).thenReturn(new ResponseEntity<>(pullRequest, HttpStatus.OK));
//        var output = restData.getPullRequestData();
//        assertSame(pullRequest.getClass(), output.getClass());
//    }
//}