package com.twilio;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class MessageTest {

	@Test
	public void getAPICircuitTest_2() {

		Response response = given()
				.auth()
				.basic("ACe47dbf32cc434cf97ba9eb0c25d63d7a", "50c7d996a392e3391fb94d1c9d1813ae")
				.when()
				.get("https://api.twilio.com/2010-04-01/Accounts/ACe47dbf32cc434cf97ba9eb0c25d63d7a/Messages.json");

		int statusCode = response.getStatusCode();
		System.out.println("api response status code: " + statusCode);
		Assert.assertEquals(statusCode, 200);

		System.out.println(response.prettyPrint());

	}

}
