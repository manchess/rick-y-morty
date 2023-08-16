package com.practica.rick_morty.prueba;

import com.practica.rick_morty.prueba.beans.RMApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PruebaApplication {

	public static void main(String[] args) {
		final String CHARACTERS_URL = "https://rickandmortyapi.com/api/character";

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<RMApi> response = restTemplate.getForEntity(CHARACTERS_URL, RMApi.class);

		System.out.println(response.getBody().getInfo());

//		SpringApplication.run(PruebaApplication.class, args);
	}

}
