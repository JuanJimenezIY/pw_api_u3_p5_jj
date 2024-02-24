package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.to.EstudianteLigeroTO;
import com.example.demo.service.to.EstudianteTO;

public interface IEstudianteService {

	public void guardar(EstudianteTO estudiante);
	public void actualizar(EstudianteTO estudiante);
	public void actualizarParcial(String apellido, String nombre ,Integer id);
	
	public Estudiante buscar(Integer id);
	public void eliminar(Integer id);
	
	public List<Estudiante> consultarTodos();
	
	//---
	public List<EstudianteTO> consultarTodosTO();
	
	//-- 
	public EstudianteTO buscarTO(Integer id);
	
	public EstudianteLigeroTO consultarTO(Integer id);
}
