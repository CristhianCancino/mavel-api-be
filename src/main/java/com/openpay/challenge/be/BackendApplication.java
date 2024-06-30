package com.openpay.challenge.be;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.openpay.challenge.marvelapi", "com.openpay.challenge.be"})
@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
						.info(new Info().title("Marvel API")
										.description("Operations pertaining to characters in Marvel API")
										.version("v1.0.0")
										.license(new License().name("Apache 2.0").url("http://springdoc.org")))
						.externalDocs(new ExternalDocumentation()
										.description("Marvel API Documentation")
										.url("https://marvelapi.docs.github.org"));
	}

}
