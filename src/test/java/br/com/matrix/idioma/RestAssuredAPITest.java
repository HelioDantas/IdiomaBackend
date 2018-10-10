package br.com.matrix.idioma;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
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
	
	@Test
	public void getResquestMarkingOK(){		
		RestAssured.given().
		when().
			get("/marking?userId=1&audioId=1").
		then().
			statusCode(200).
			body("id", is(1)).
			body("login", notNullValue()).
			body("password", notNullValue()).
			body("email", notNullValue()).
			body("name", notNullValue());										
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
