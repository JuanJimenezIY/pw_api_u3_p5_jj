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

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

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
	
	
	@PostMapping(consumes = MediaType.APPLICATION_XML_VALUE )
	public void guardar(@RequestBody Estudiante estudiante) {
		this.iEstudianteService.guardar(estudiante);

	}
	// http://localhost:8080/API/v1.0/Matricula/estudiantes

	// para decirle que va a manejar el verbo GET con la anotacion
	@GetMapping(path = "/{id}", produces = "application/xml")
	public  ResponseEntity<Estudiante>  buscar(@PathVariable Integer id) {
		
		//240: grupo satisfactorio 
		//240: Recurso Estudiante encontrado satisfactoriamente
		Estudiante estu = this.iEstudianteService.buscar(id);
		//200 OK
		//contrato de la API (documento,pdf, Swagger.io)
		
		
		return ResponseEntity.status(HttpStatus.OK).body(estu);
		// http://localhost:8080/API/v1.0/Matricula/estudiantes/{id} GET
	}

	//para consultar todo no necesito 
	//@GetMapping(path = "/consultarTodos")
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public  ResponseEntity<List<Estudiante>>  consultarTodos(@RequestParam(required = false,defaultValue = "masculino") String genero) {
		
		List<Estudiante> lista = this.iEstudianteService.consultarTodos(genero);
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_242", "Lista consultada de manera satisfactoria");
		cabeceras.add("mensaje_info", "El sistema va a estar en mantenimiento el fin de semana");
		return new ResponseEntity<>(lista, cabeceras,242) ;
		// http://localhost:8080/API/v1.0/Matricula/estudiantes/consultarTodos?genero=masculino&edad=100
	}

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizar(@RequestBody Estudiante estudiante,@PathVariable Integer id) {
		estudiante.setId(id);
		this.iEstudianteService.actualizar(estudiante);

		// http://localhost:8080/API/v1.0/Matricula/estudiantes/{id} PUT parametro para saber que estoy actualizando ese estudiante
	}

	@PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
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
