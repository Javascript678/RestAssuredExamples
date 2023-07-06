package com.rest.api.get;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETNONBDDAPI {
	
	//prepare the request
	//hit the API
	//get the response
	//fetch the values from response
	
	RequestSpecification request;
	
	@BeforeTest
	public void setup() {
		RestAssured.baseURI = "https://gorest.co.in";
		request = RestAssured.given();
		request.header("Authorization", "Bearer e4b8e1f593dc4a731a153c5ec8cc9b8bbb583ae964ce650a741113091b4e2ac6");
	
	}
	
	
	@Test
	public void getUser_Non_Bdd_Test(){
		
		
		Response response = request.get("/public/v2/users");
		
		System.out.println(response.getStatusCode() +" "+ response.statusLine());
		System.out.println(response.prettyPrint());
		System.out.println(response.getHeader("Server"));
		
		List<Header> headersList = response.getHeaders().asList();
		System.out.println(headersList.size());
		//headersList.forEach(e -> System.out.println(e.getName() + ":" + e.getValue()));	
		for(Header e : headersList) {
			System.out.println(e.getName() + ":" + e.getValue());
		}
	}
	
	
	@Test
	public void getUser_Non_Bdd_WithQueryParams_Test(){
						
		request.queryParam("name", "naveen");
		request.queryParam("gender", "male");
		
		Response response = request.get("/public/v2/users");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
		
		System.out.println(response.getHeader("Server"));
		System.out.println(response.getCookie("PHPSESSID"));
		System.out.println(response.getStatusLine());
		System.out.println(response.getContentType());

		JsonPath js = response.jsonPath();
		List<Object> idList = js.getList("id");
		System.out.println(idList);
		Assert.assertTrue(idList.contains(628270));
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.getHeader("Server"), "cloudflare");

	}
	
	
	@Test
	public void getUser_Non_Bdd_HashMap_QueryParams_Test(){
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("first_name", "John");
		params.put("gender", "male");
		
		request.queryParams(params);
		
		Response response = request.get("public-api/users");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
		System.out.println(response.getHeader("Server"));
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.getHeader("Server"), "cloudflare");
	}
	
	
	
	
	
	
	

}
