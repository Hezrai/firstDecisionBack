package com.hezrai.spring.jpa.postgresql.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.hezrai.spring.jpa.postgresql.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hezrai.spring.jpa.postgresql.model.Usuario;


// Ah, mais permissivo que isso só se estivesse distribuindo abraços grátis!
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UsuarioController {


	@Autowired
	UsuarioRepository usuarioRepository;

	@RequestMapping("/usuarios")
	public ResponseEntity<List<Usuario>> getAllUsuario(@RequestParam(required = false) String title) {
		try {
			List<Usuario> usuarios = new ArrayList<Usuario>();

			if (title == null)
				usuarioRepository.findAll().forEach(usuarios::add);
			else
				usuarioRepository.findByNomeContaining(title).forEach(usuarios::add);

			if (usuarios.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(usuarios, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable("id") long id) {
		Optional<Usuario> usuarioData = usuarioRepository.findById(id);

		if (usuarioData.isPresent()) {
			return new ResponseEntity<>(usuarioData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
		try {
			Usuario _usuario = usuarioRepository
					.save(new Usuario(usuario.getNome(), usuario.getCargo(), usuario.getEmail(), usuario.getSenha(), false));
			return new ResponseEntity<>(_usuario, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable("id") long id, @RequestBody Usuario usuario) {
		Optional<Usuario> usuarioData = usuarioRepository.findById(id);

		if (usuarioData.isPresent()) {
			Usuario _usuario = usuarioData.get();
			_usuario.setNome(usuario.getNome());
			_usuario.setCargo(usuario.getCargo());
			_usuario.setEmail((usuario.getEmail()));
			_usuario.setPublished(usuario.isPublished());
			return new ResponseEntity<>(usuarioRepository.save(_usuario), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<HttpStatus> deleteUsuario(@PathVariable("id") long id) {
		try {
			usuarioRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/usuarios")
	public ResponseEntity<HttpStatus> deleteAllUsuarios() {
		try {
			usuarioRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping("/usuarios/published")
	public ResponseEntity<List<Usuario>> findByPublished() {
		try {
			List<Usuario> usuarios = usuarioRepository.findByPublished(true);

			if (usuarios.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(usuarios, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
