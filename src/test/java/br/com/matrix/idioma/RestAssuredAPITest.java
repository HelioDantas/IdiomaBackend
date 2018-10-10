package br.com.matrix.idioma;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;

import static org.assertj.core.api.Assertions.not;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import org.hamcrest.Matchers.*;
import org.hamcrest.core.Is;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.module.jsv.JsonSchemaValidator.*;

public class RestAssuredAPITest {

	@BeforeClass
	public static void setUp() {
		RestAssured.baseURI = "https://idiomabackend.herokuapp.com";
	}
	
	@Test
	public void getResquestAudio(){
		
		RestAssured.given().
		when().
			get("/audio/1").
		then().
			statusCode(200).
			body("id", is(1)).
			body("link", notNullValue()).
			body("description", notNullValue()).
			body("title", notNullValue()).
			body("duration", notNullValue()).
			body("creationDate", notNullValue()).
			body("englishTranscription", notNullValue()).
			body("portugueseTranscription", notNullValue());										
	}
}
