package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

	@PostMapping(consumes = MediaType.APPLICATION_XML_VALUE )
	public void guardar(@RequestBody Profesor profesor) {
		this.iProfesorService.guardar(profesor);

	}

	// http://localhost:8080/API/v1.0/Nomina/profesores/guardar

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_XML_VALUE)
	public void actualizar(@RequestBody Profesor profesor, @PathVariable Integer id) {
		profesor.setId(id);
		this.iProfesorService.actualizar(profesor);

	}

	@PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_XML_VALUE)
	public void actualizarParcial(@RequestBody Profesor profesor,@PathVariable Integer id) {
		profesor.setId(id);
		this.iProfesorService.actualizarParcial(profesor.getNombre(), profesor.getHorario(), profesor.getMateria(),
				id);

	}

	@GetMapping(path = "/{id}", produces = "application/xml")
	public ResponseEntity<Profesor> buscar(@PathVariable Integer id) {
		
		Profesor prof= this.iProfesorService.buscar(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(prof);

	}

	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable Integer id) {
		this.iProfesorService.eliminar(id);

	}

	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public   ResponseEntity< List<Profesor>> consultarTodos(@RequestParam(required = false, defaultValue = "matutino") String horario) {

		
		List<Profesor> profesores= this.iProfesorService.consultarTodos(horario);
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_242", "Lista consultada de manera satisfactoria");
		return new ResponseEntity<>(profesores, cabeceras,242) ;

	}

	// http://localhost:8080/API/v1.0/Nomina/profesores/consultarTodos?horario=matutino
}
