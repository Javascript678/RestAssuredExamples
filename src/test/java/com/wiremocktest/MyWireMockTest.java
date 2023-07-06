//package com.wiremocktest;
//import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
//import static com.github.tomakehurst.wiremock.client.WireMock.equalToJson;
//import static com.github.tomakehurst.wiremock.client.WireMock.get;
//import static com.github.tomakehurst.wiremock.client.WireMock.post;
//import static com.github.tomakehurst.wiremock.client.WireMock.put;
//import static com.github.tomakehurst.wiremock.client.WireMock.delete;
//import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
//import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
//import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
//import static com.github.tomakehurst.wiremock.client.WireMock.putRequestedFor;
//import static com.github.tomakehurst.wiremock.client.WireMock.verify;
//import static org.testng.Assert.assertEquals;
//
//import java.io.IOException;
//import java.net.URI;
//
//import org.apache.http.HttpRequest;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import com.github.tomakehurst.wiremock.WireMockServer;
//import com.github.tomakehurst.wiremock.core.Options;
//
//
//public class MyWireMockTest {
//	
//
//    private WireMockServer wireMockServer;
//
//    @BeforeTest
//    public void setup() {
//        wireMockServer = new WireMockServer(Options.DEFAULT_PORT);
//        wireMockServer.start();
//    }
//
//    @AfterSuite
//    public void teardown() {
//        wireMockServer.stop();
//    }
//    
//    
//
//    @Test
//    public void testExample() throws IOException, InterruptedException {
//        stubFor(get(urlEqualTo("/example"))
//                .willReturn(aResponse()
//                    .withStatus(200)
//                    .withHeader("Content-Type", "application/json")
//                    .withBody("{\"message\": \"Hello, world!\"}")));
//
//        // Test code that makes a GET request to /example and verifies the response
//        
//        // Make a request to the mock server
//        HttpClient httpClient = HttpClient.newHttpClient();
//        HttpRequest httpRequest = HttpRequest.newBuilder()
//                .uri(URI.create("http://localhost:8080/example"))
//                .build();
//        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
//
//        // Verify the response
//        assertEquals(200, httpResponse.statusCode());
//        assertEquals("{\"message\": \"Hello, world!\"}", httpResponse.body());
//
//    }
//    
//    
//    @Test
//    public void testPostRequest() throws IOException, InterruptedException {    	
//    	//POST
//        String requestBody = "{\"name\": \"John\", \"age\": 30}";
//        String expectedResponse = "{\"message\": \"Success!\"}";
//
//        // Set up the mock response for the POST request
//        stubFor(post(urlEqualTo("/user"))
//                .withRequestBody(equalToJson(requestBody))
//                .willReturn(aResponse()
//                    .withStatus(200)
//                    .withHeader("Content-Type", "application/json")
//                    .withBody(expectedResponse)));
//
//        // Make a POST request to the mock server
//        HttpClient httpClient = HttpClient.newHttpClient();
//        HttpRequest httpRequest = HttpRequest.newBuilder()
//                .uri(URI.create("http://localhost:8080/user"))
//                .header("Content-Type", "application/json")
//                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
//                .build();
//        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
//
//        // Verify the response
//        assertEquals(200, httpResponse.statusCode());
//        assertEquals(expectedResponse, httpResponse.body());
//    }
//
//    
//    @Test
//    public void testPutRequestWithPathVariable() throws IOException, InterruptedException {
//        String name = "John";
//        String requestBody = "{\"age\": 35}";
//        String expectedResponse = "{\"message\": \"Success!\"}";
//
//        // Set up the mock response for the PUT request with the name as a path variable
//        stubFor(put(urlPathEqualTo("/user/" + name))
//                .withRequestBody(equalToJson(requestBody))
//                .willReturn(aResponse()
//                    .withStatus(200)
//                    .withHeader("Content-Type", "application/json")
//                    .withBody(expectedResponse)));
//
//        // Make a PUT request to the mock server with the user's name as a path variable
//        HttpClient httpClient = HttpClient.newHttpClient();
//        HttpRequest httpRequest = HttpRequest.newBuilder()
//                .uri(URI.create("http://localhost:8080/user/" + name))
//                .header("Content-Type", "application/json")
//                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
//                .build();
//        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
//
//        // Verify the response
//        assertEquals(200, httpResponse.statusCode());
//        assertEquals(expectedResponse, httpResponse.body());
//
//        // Verify that the request was made with the correct path variable and request body
//        verify(putRequestedFor(urlPathEqualTo("/user/" + name))
//                .withRequestBody(equalToJson(requestBody)));
//    }
//
//
//
//    
//}
//
//
//
