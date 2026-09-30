package com.careeropenings.CareerOpenings.Case;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CareerOpeningsDBTestCase {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void shouldReturnCandidateWhenValidIdProvided() throws Exception {

		// Act + Assert
		mockMvc.perform(get("/getCandidateDetails/1"))

				.andExpect(status().isOk())

				.andExpect(jsonPath("$.candidateId").value(1))

				.andExpect(jsonPath("$.firstName").value("Alice"))

				.andExpect(jsonPath("$.lastName").value("De"))

				.andExpect(jsonPath("$.email").value("johnde.de@example.com"));
		
	}
}
