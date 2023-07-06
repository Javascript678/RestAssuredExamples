package com.rest.api.authentications;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GITOAuth2APITest {
	
	
	@Test
	public void gitTest() {
		
		
		String tokenUrl = "https://github.com/login/oauth/access_token";
		String clientId = "060a295397b25d25ee10";
		String clientSecret = "95804fab24c9e28298f1b243dad0c510a56a1969";
		String authorizationCode = "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";
		
		Response res = RestAssured.given().get("https://github.com/login/oauth/authorize?client_id=060a295397b25d25ee10&state=abcdefg");
		System.out.println(res.getBody().asString());
		
		

		Response response = RestAssured.given()
		    .formParam("client_id", clientId)
		    .formParam("client_secret", clientSecret)
		    .formParam("refresh_token", authorizationCode)
		    .formParam("grant_type", "refresh_token")
		    .post(tokenUrl);

		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
	}
	

}
