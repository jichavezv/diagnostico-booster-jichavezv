package com.metaphorce.booster.javasr.diagnostico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metaphorce.booster.javasr.diagnostico.dto.ResponseDTO;
import com.metaphorce.booster.javasr.diagnostico.entity.Usuario;
import com.metaphorce.booster.javasr.diagnostico.service.UsuarioService;

@RestController
@RequestMapping("/api/")
public class UsuarioController {
	@Autowired
	UsuarioService service;

	@GetMapping("/user")
	public ResponseEntity<List<Usuario>> getAllData() {
		ResponseEntity<List<Usuario>> response = null;
		List<Usuario> list = null;

		list = this.service.getUsuarios();

		if(!list.isEmpty()) {
			response = new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
		} else {
			response = new ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);
		}

		return response;
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<Usuario> get(@PathVariable("id") long id) {
		ResponseEntity<Usuario> response = null;
		Usuario data = null;

		data = this.service.getUsuario(id);

		if (data != null) {
			response = new ResponseEntity<>(data, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return response;
	}

	@PostMapping("/user")
	public ResponseEntity<ResponseDTO<Boolean>> create(@RequestBody Usuario UsuarioData) {
		ResponseEntity<ResponseDTO<Boolean>> response;
		ResponseDTO<Boolean> dto = null;
		Boolean result = null;
		String message = null;
		HttpStatus status = null;

		try {
			result = this.service.saveUsuario(UsuarioData);

			if(result) {
				message = "Usuario saved.";
				status = HttpStatus.CREATED;
			} else {
				message = "Usuario not saved.";
				status = HttpStatus.BAD_REQUEST;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = false;
			message = "Can not saved the Usuario.";
			status = HttpStatus.BAD_REQUEST;
		} finally {
			dto = new ResponseDTO<>();
			dto.setObject(result);
			dto.setMessage(message);

			response = new ResponseEntity<ResponseDTO<Boolean>>(dto, status);
		}

		return response;
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<ResponseDTO<Boolean>> update(@PathVariable("id") long id, @RequestBody Usuario UsuarioUpdate) {
		ResponseEntity<ResponseDTO<Boolean>> response;
		ResponseDTO<Boolean> dto = null;
		Boolean result = null;
		String message = null;
		HttpStatus status = null;

		try {
			result = this.service.updateUsuario(id, UsuarioUpdate);

			if(result) {
				message = "Usuario updated.";
				status = HttpStatus.CREATED;
			} else {
				message = "Usuario not updated.";
				status = HttpStatus.BAD_REQUEST;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = false;
			message = "Can not updated the Usuario.";
			status = HttpStatus.BAD_REQUEST;
		} finally {
			dto = new ResponseDTO<>();
			dto.setObject(result);
			dto.setMessage(message);

			response = new ResponseEntity<ResponseDTO<Boolean>>(dto, status);
		}

		return response;
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<ResponseDTO<Boolean>> deleteTutorial(@PathVariable("id") long id) {
		ResponseEntity<ResponseDTO<Boolean>> response;
		ResponseDTO<Boolean> dto = null;
		Boolean result = null;
		String message = null;
		HttpStatus status = null;

		try {
			result = this.service.deleteUsuario(id);

			if(result) {
				message = "Usuario deleted.";
				status = HttpStatus.CREATED;
			} else {
				message = "Usuario not deleted.";
				status = HttpStatus.BAD_REQUEST;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = false;
			message = "Can not deleted the Usuario.";
			status = HttpStatus.BAD_REQUEST;
		} finally {
			dto = new ResponseDTO<>();
			dto.setObject(result);
			dto.setMessage(message);

			response = new ResponseEntity<ResponseDTO<Boolean>>(dto, status);
		}

		return response;
	}

}
