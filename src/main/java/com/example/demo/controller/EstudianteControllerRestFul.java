package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


//API: por el proyecto java

//Servicio-> Controller: Clase Controller

@RestController  //Servicio
@RequestMapping(path = "/estudiantes")
public class EstudianteControllerRestFul {
	@Autowired
	private IEstudianteService iEstudianteService;
	
	//Metodos: capacidades
	@PostMapping(path = "/guardar")
	public void guardar(@RequestBody Estudiante estudiante) {
		this.iEstudianteService.guardar(estudiante);
		
	}
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/guardar

	//para decirle que va a manejar el verbo GET con la anotacion
	@GetMapping(path = "/buscar")
	public Estudiante buscar() {
		return this.iEstudianteService.buscar(1);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar
	
	
}
