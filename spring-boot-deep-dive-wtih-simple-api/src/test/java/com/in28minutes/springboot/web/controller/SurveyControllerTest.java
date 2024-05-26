package com.in28minutes.springboot.web.controller;

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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

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
}
