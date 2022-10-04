package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

@RestController
@RequestMapping("/api")
public class UsuarioController {
    @Autowired
	private UsuarioRepository repository;
	
	
	@GetMapping("/usuarios")
	public List<Usuario> allPersons(){
		return repository.findAll();
	}
	
	@GetMapping("/usuarios/{name}")
	public List<Usuario> findByName(@PathVariable("name") String name) {
		return repository.findByName(name);
	}
	
	@PostMapping("/usuario")
	public Usuario createPerson(@RequestBody Usuario usuario) {
		return repository.save(usuario);
	}
	
	@PutMapping("/usuario/{id}")
	public Usuario updatePerson(@PathVariable int id ,@RequestBody Usuario usuario) {
		return repository.save(usuario);
	}
	
	@DeleteMapping("/usuario/{id}")
	public void deletePerson(@PathVariable("id") Long id) {
		repository.deleteById(id);
	}
}
