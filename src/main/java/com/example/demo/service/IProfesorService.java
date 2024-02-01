package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Profesor;

public interface IProfesorService {

	
	public void guardar(Profesor profesor);

	public void actualizar(Profesor profesor);

	public void actualizarParcial(String nombre, String horario,String materia, Integer id);

	public Profesor buscar(Integer id);

	public void eliminar(Integer id);

	public List<Profesor> consultarTodos(String horario);
}
