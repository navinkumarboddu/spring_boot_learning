package com.in28minutes.springboot.web.controller;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import com.in28minutes.springboot.web.model.Question;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.springboot.web.Application;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.hamcrest.Matchers.containsString;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyControllerIT {

	@LocalServerPort
	private int port;

	private TestRestTemplate template = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Before
	public void before() {
		headers.add("Authorization", createHttpAuthenticationHeaderValue(
				"in28minutes", "123456"));
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	}


	@Test
	public void retrieveSurveyQuestion() throws Exception {
		String expected = """
            {
                "id": "Question1",
                "description": "Largest Country in the World",
                "correctAnswer": "Russia",
                "options": ["India", "Russia", "United States", "China"]
            }
        """;

		ResponseEntity<String> response = template.exchange(createUrl("/surveys/Survey1/questions/Question1"),
				HttpMethod.GET, new HttpEntity<String>("DUMMY_DOESNT_MATTER", headers), String.class);

		JSONAssert.assertEquals(expected, response.getBody(), false);
	}

	private String createUrl(String uri) {
		return "http://localhost:" + port + uri;
	}

	private String createHttpAuthenticationHeaderValue(String userId,
													   String password) {

		String auth = userId + ":" + password;

		byte[] encodedAuth = Base64.encode(auth.getBytes(Charset
				.forName("US-ASCII")));

		String headerValue = "Basic " + new String(encodedAuth);

		return headerValue;
	}

	@Test
	public void retrieveSurveyQuestions() throws Exception {
		HttpEntity<String> entity = new HttpEntity<>(null, headers);

		ResponseEntity<List<Question>> response = template.exchange(
				createUrl("/surveys/Survey1/questions"), HttpMethod.GET,
				entity, new ParameterizedTypeReference<List<Question>>() {});

		Question sampleQuestion = new Question("Question1",
				"Largest Country in the World", "Russia", Arrays.asList(
				"India", "Russia", "United States", "China"));

		List<Question> questions = response.getBody();
		assertTrue(questions != null && questions.contains(sampleQuestion));
	}

	TestRestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void addQuestion() {

		Question question = new Question("DOESNTMATTER", "Question1", "Russia",
				Arrays.asList("India", "Russia", "United States", "China"));

		HttpEntity entity = new HttpEntity<Question>(question, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createUrl("/surveys/Survey1/questions"),
				HttpMethod.POST, entity, String.class);

		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);

		assertTrue(actual.contains("/surveys/Survey1/questions/"));

	}


}