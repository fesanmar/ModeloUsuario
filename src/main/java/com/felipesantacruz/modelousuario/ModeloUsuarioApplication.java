package com.felipesantacruz.modelousuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ModeloUsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModeloUsuarioApplication.class, args);
	}

}
