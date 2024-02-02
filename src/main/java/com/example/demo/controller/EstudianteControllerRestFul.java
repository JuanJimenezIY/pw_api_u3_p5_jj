package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

//API: por el proyecto java

//Servicio-> Controller: Clase Controller

@RestController // Servicio
@RequestMapping(path = "/estudiantes")
public class EstudianteControllerRestFul {
	@Autowired
	private IEstudianteService iEstudianteService;

	// Path Variable
	// http:pokemon.com/API/v1/jugadores/pokemon/consultar/1
	// .../consultar/3
	// .../consultar/{id}

	// Metodos: capacidades
	
	
	@PostMapping
	public void guardar(@RequestBody Estudiante estudiante) {
		this.iEstudianteService.guardar(estudiante);

	}
	// http://localhost:8080/API/v1.0/Matricula/estudiantes

	// para decirle que va a manejar el verbo GET con la anotacion
	@GetMapping(path = "/{id}")
	public Estudiante buscar(@PathVariable Integer id) {
		return this.iEstudianteService.buscar(id);
		// http://localhost:8080/API/v1.0/Matricula/estudiantes/{id} GET
	}

	//para consultar todo no necesito 
	//@GetMapping(path = "/consultarTodos")
	@GetMapping
	public List<Estudiante> consultarTodos(@RequestParam(required = false,defaultValue = "masculino") String genero) {
		
		return this.iEstudianteService.consultarTodos(genero);
		// http://localhost:8080/API/v1.0/Matricula/estudiantes/consultarTodos?genero=masculino&edad=100
	}

	@PutMapping(path = "/{id}")
	public void actualizar(@RequestBody Estudiante estudiante,@PathVariable Integer id) {
		estudiante.setId(id);
		this.iEstudianteService.actualizar(estudiante);

		// http://localhost:8080/API/v1.0/Matricula/estudiantes/{id} PUT parametro para saber que estoy actualizando ese estudiante
	}

	@PatchMapping(path = "/{id}")
	public void actualizarParcial(@RequestBody Estudiante estudiante,@PathVariable Integer id) {
		estudiante.setId(id);
		this.iEstudianteService.actualizarParcial(estudiante.getApellido(), estudiante.getNombre(), id);

		// http://localhost:8080/API/v1.0/Matricula/estudiantes/{id} PATCH
	}

	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable Integer id) {
		this.iEstudianteService.eliminar(id);

		// http://localhost:8080/API/v1.0/Matricula/estudiantes/{id} DELETE
	}

}
