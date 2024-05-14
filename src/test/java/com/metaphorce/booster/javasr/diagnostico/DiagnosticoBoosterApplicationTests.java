package com.metaphorce.booster.javasr.diagnostico;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.metaphorce.booster.javasr.diagnostico.controller.UsuarioController;

@SpringBootTest
class DiagnosticoBoosterApplicationTests {
	
	@Autowired
	UsuarioController userController;

	@Test
	void contextLoads() {
		assertThat(userController).isNotNull();
	}

}
