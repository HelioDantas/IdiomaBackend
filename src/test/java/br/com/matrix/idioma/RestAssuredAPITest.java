package br.com.matrix.idioma;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;

import static org.assertj.core.api.Assertions.not;
import static org.hamcrest.CoreMatchers.*;

import static org.hamcrest.CoreMatchers.containsString;


import static org.hamcrest.CoreMatchers.notNullValue;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;

public class RestAssuredAPITest {

	@BeforeClass
	public static void setUp() {
		RestAssured.baseURI = "https://idiomabackend.herokuapp.com";
	}
	
	@Test
	public void getResquestAudioOK(){
		
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

	@Test
	public void givenUrl_whenSuccessOnGetsResponseAndJsonHasRequiredKV_thenCorrect() {
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
	public void getResquestAudioNotFound(){
		
		RestAssured.given().
		when().
			get("/audio/999999999").
		then().
			statusCode(404).
			body("title", containsString("org.springframework.web.servlet.PageNotFound")).
			body("detail", containsString("O audio não existe.")).
			body("timeStamp", notNullValue()).			
			body("devMensagem", containsString("br.com.matrix.idioma.config.ResourceNotFoundException"));
													
	}	

	
}
