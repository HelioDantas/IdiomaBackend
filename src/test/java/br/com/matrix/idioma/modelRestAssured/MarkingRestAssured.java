package br.com.matrix.idioma.modelRestAssured;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;

public class MarkingRestAssured {
	
	@BeforeClass
	public static void setUp() {
		RestAssured.baseURI = "http://localhost:8080/";
	}
	
	@Test
	public void getResquestMarkingOK(){		
		RestAssured.given().
		when().
			get("/marking/1").
		then().
			statusCode(200).
			body("id", is(1)).
			body("audioId", notNullValue()).
			body("userId", notNullValue()).		
			body("begin", notNullValue()).
			body("end", notNullValue());										
	}
	
}
