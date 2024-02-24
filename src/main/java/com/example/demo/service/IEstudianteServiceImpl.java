package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.to.EstudianteLigeroTO;
import com.example.demo.service.to.EstudianteTO;

@Service
public class IEstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public void guardar(EstudianteTO estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insertar( this.convertirTO(estudiante));
	}

	@Override
	public void actualizar(EstudianteTO estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.actualizar( this.convertirTO(estudiante));
	}

	@Override
	public void actualizarParcial(String apellido, String nombre, Integer id) {
		// TODO Auto-generated method stub
		this.estudianteRepository.actualizarParcial(apellido, nombre, id);
	}

	@Override
	public Estudiante buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionar(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.estudianteRepository.eliminar(id);
	}

	@Override
	public List<Estudiante> consultarTodos() {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarTodos();
	}
    //---Nivel 3 
	@Override
	public List<EstudianteTO> consultarTodosTO() {
		// TODO Auto-generated method stub
		
		List<Estudiante> lista =this.estudianteRepository.seleccionarTodos();
		List<EstudianteTO> listaFinal= new ArrayList<>();
		for(Estudiante est:lista) {
			listaFinal.add(this.convertir(est));
		}
		return listaFinal;
	}
	
	private Estudiante convertirTO(EstudianteTO estTO) {

		Estudiante estu = new Estudiante();
		estu.setApellido(estTO.getApellido());
		estu.setFechaNacimiento(estTO.getFechaNacimiento());
		estu.setGenero(estTO.getGenero());
		estu.setNombre(estTO.getNombre());
		estu.setId(estTO.getId());
		estu.setCarrera(estTO.getCarrera());
		estu.setCorreo(estTO.getCorreo());
		estu.setCreditos(estTO.getCreditos());
		estu.setSemestre(estTO.getSemestre());
		estu.setTelefono(estTO.getTelefono());

		return estu;
	}
	
	private EstudianteTO convertir(Estudiante est) {
		
		EstudianteTO estuTO= new EstudianteTO();
		estuTO.setApellido(est.getApellido());
		estuTO.setFechaNacimiento(est.getFechaNacimiento());
		estuTO.setGenero(est.getGenero());
		estuTO.setNombre(est.getNombre());
		estuTO.setId(est.getId());
		estuTO.setCarrera(est.getCarrera());
		estuTO.setCorreo(est.getCorreo());
		estuTO.setCreditos(est.getCreditos());
		estuTO.setSemestre(est.getSemestre());
		estuTO.setTelefono(est.getTelefono());
		
		
		return estuTO;
		
	}

	@Override
	public EstudianteTO buscarTO(Integer id) {
		// TODO Auto-generated method stub
		;
		return this.convertir(this.estudianteRepository.seleccionar(id));
	}

	
	private EstudianteLigeroTO convertirLigero(Estudiante est) {
		
		EstudianteLigeroTO estuLigeroTO= new EstudianteLigeroTO();
		
		estuLigeroTO.setNombre(est.getNombre());
		estuLigeroTO.setId(est.getId());
		estuLigeroTO.setApellido(est.getApellido());

		
		
		return estuLigeroTO;
		
	}
	@Override
	public EstudianteLigeroTO consultarTO(Integer id) {
		// TODO Auto-generated method stub
		return this.convertirLigero(this.estudianteRepository.seleccionar(id));
	}

}
