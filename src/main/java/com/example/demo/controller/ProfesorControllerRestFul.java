package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Profesor;
import com.example.demo.service.IProfesorService;

@RestController
@RequestMapping(path = "/profesores")
public class ProfesorControllerRestFul {

	@Autowired
	private IProfesorService iProfesorService;

	@PostMapping(path = "/guardar")
	public void guardar(@RequestBody Profesor profesor) {
		this.iProfesorService.guardar(profesor);

	}
	
	// http://localhost:8080/API/v1.0/Nomina/profesores/guardar

	@PutMapping(path = "/actualizar")
	public void actualizar(@RequestBody Profesor profesor) {
		this.iProfesorService.actualizar(profesor);

	}

	@PatchMapping(path = "/actualizarParcial")
	public void actualizarParcial(@RequestBody Profesor profesor) {
		this.iProfesorService.actualizarParcial(profesor.getNombre(), profesor.getHorario(), profesor.getMateria(),
				profesor.getId());

	}

	@GetMapping(path = "/buscar/{id}")
	public Profesor buscar(@PathVariable Integer id) {
		return this.iProfesorService.buscar(id);

	}

	@DeleteMapping(path = "/borrar/{id}")
	public void borrar(@PathVariable Integer id) {
		this.iProfesorService.eliminar(id);

	}

	@GetMapping(path = "/consultarTodos")
	public List<Profesor> consultarTodos(@RequestParam String horario) {

		return this.iProfesorService.consultarTodos(horario);

	}
	
	// http://localhost:8080/API/v1.0/Nomina/profesores/consultarTodos?horario=matutino
}
