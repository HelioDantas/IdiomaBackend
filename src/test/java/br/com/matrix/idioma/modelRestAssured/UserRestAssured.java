package br.com.matrix.idioma.modelRestAssured;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;

public class UserRestAssured {
	
	@BeforeClass
	public static void setUp() {
		RestAssured.baseURI = "http://localhost:8080/";
	}
	
	@Test
	public void getResquestUserWhenBodyOk() {
		RestAssured.given().
		when().
			get("/user/1").
			then().statusCode(200)
			.body("email", containsString("mario@unicarioca.edu.br"))
			.body("login", containsString("mario"))
			.body("name", containsString("Mario"))
			.body("password", containsString("123456"));			
	}
	
	@Test
	public void getResquestUserOK(){		
		RestAssured.given().
		when().
			get("/user/1").
		then().
			statusCode(200).
			body("id", is(1)).
			body("login", notNullValue()).
			body("password", notNullValue()).
			body("email", notNullValue()).
			body("name", notNullValue());										
	}
	
	
	
}
