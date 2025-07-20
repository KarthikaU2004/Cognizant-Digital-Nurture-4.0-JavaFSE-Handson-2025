package com.cognizant.loan;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LoanApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void testGetLoanDetails() {
		ResponseEntity<String> response = restTemplate.getForEntity("/loans/H00987987972342", String.class);
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
		assertThat(response.getBody()).contains("H00987987972342");
		assertThat(response.getBody()).contains("car");
		assertThat(response.getBody()).contains("400000");
	}
}
