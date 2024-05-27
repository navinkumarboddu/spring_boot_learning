package com.in28minutes.springboot.web.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.in28minutes.springboot.web.controller.SurveyController;
import com.in28minutes.springboot.web.model.Question;
import com.in28minutes.springboot.web.service.SurveyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.GetMapping;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = SurveyController.class)
public class SurveyControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SurveyService surveyService; // Ensure this is correctly initialized as a mock bean

	@Test
	public void testMethod() throws Exception {
		// Arrange
		Question mockQuestion = new Question("Question1", "Largest Country in the World", "Russia",
				Arrays.asList("India", "Russia", "United States", "China"));
		Mockito.when(surveyService.retrieveQuestion(Mockito.anyString(), Mockito.anyString())).thenReturn(mockQuestion);

		// Act
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/surveys/Survey1/questions/Question1")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		// Assert
		String expected = """
            {
                "id": "Question1",
                "description": "Largest Country in the World",
                "correctAnswer": "Russia"
            }
            """;
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}


	//@GetMapping("/surveys/{surveyId}/questions")
	@Test
	public void testRetrieveAllQuestions() throws Exception {
		Path path = Path.of("src/test/resources/questions.txt");
		String questionsJson = Files.readString(path);

		// Create an ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();

		// Convert the JSON string to a list of Question objects
		List<Question> questionList = objectMapper.readValue(questionsJson, new TypeReference<List<Question>>() {});

		// Arrange
		Mockito.when(surveyService.retrieveQuestions(Mockito.anyString())).thenReturn(questionList);

		// Act
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/surveys/Survey1/questions")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		// Assert
		JSONAssert.assertEquals(questionsJson, result.getResponse().getContentAsString(), false);

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
}
