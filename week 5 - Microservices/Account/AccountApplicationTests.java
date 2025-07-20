package com.cognizant.account;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AccountApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void testGetAccountDetails() {
		ResponseEntity<String> response = restTemplate.getForEntity("/accounts/00987987973432", String.class);
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
		assertThat(response.getBody()).contains("00987987973432");
		assertThat(response.getBody()).contains("savings");
		assertThat(response.getBody()).contains("234343");
	}
}
