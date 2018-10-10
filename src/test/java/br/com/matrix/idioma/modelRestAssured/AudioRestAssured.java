package br.com.matrix.idioma.modelRestAssured;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.notNullValue;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;

public class AudioRestAssured {

	@BeforeClass
	public static void setUp() {
		RestAssured.baseURI = "http://localhost:8080/";
	}
	
	@Test
	public void getRequestAudioOk() {
		
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
