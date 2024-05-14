package com.metaphorce.booster.javasr.diagnostico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metaphorce.booster.javasr.diagnostico.entity.Usuario;
import com.metaphorce.booster.javasr.diagnostico.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository repository;

	public List<Usuario> getUsuarios() {
		List<Usuario> data = null;

		data = this.repository.findAll();

		return data;
	}

	public Usuario getUsuario(Long usuarioId) {
		Usuario data = null;

		try {
			data = this.repository.findById(usuarioId).get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Error --> " + e);
		}

		return data;
	}

	public boolean saveUsuario(Usuario newUsuario) {
		boolean flag = true;

		try {
			newUsuario = this.repository.save(newUsuario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
		}

		return flag;
	}

	public boolean updateUsuario(Long UsuarioId, Usuario UsuarioUpdate) {
		boolean flag = true;

		try {
			if(this.repository.existsById(UsuarioId)) {
				UsuarioUpdate = this.repository.save(UsuarioUpdate);
			} else {
				System.out.println("Usuario " + UsuarioId + " not exist.");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
		}

		return flag;
	}

	public boolean deleteUsuario(Long UsuarioId) {
		boolean flag = true;

		try {
			if(this.repository.existsById(UsuarioId)) {
				this.repository.deleteById(UsuarioId);
			} else {
				System.out.println("Usuario " + UsuarioId + " not exist.");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
		}

		return flag;
	}

}
