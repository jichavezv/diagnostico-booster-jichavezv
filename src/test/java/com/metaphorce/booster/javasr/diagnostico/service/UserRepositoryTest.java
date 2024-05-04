package com.metaphorce.booster.javasr.diagnostico.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.metaphorce.booster.javasr.diagnostico.entity.Usuario;
import com.metaphorce.booster.javasr.diagnostico.repository.UsuarioRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {
	@Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UsuarioRepository repository;
    
    @Test
    public void whenFindByName_thenReturnUser() {
    	Usuario user = new Usuario();
    	user.setNombreUsuario("Usuario creado");
    	user.setContrasenia("T3st");
    	user.setRol("operativo");
    	
    	entityManager.persist(user);
    	entityManager.flush();
    	
    	Usuario foundUser = repository.findByNombreUsuario(user.getNombreUsuario());
    	
    	assertThat(foundUser.getNombreUsuario()).isEqualTo(user.getNombreUsuario());
    }
}
