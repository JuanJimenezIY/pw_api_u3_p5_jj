package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Profesor;

@Repository
@Transactional
public class IProfesorRepositoryImpl implements IProfesorRepository{

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Profesor profesor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(profesor);
	}

	@Override
	public void actualizar(Profesor profesor) {
		// TODO Auto-generated method stub
		this.entityManager.merge(profesor);
	}

	@Override
	public void actualizarParcial(String nombre, String horario, String materia, Integer id) {
		// TODO Auto-generated method stub
		
		Query query = this.entityManager.createQuery("UPDATE Profesor p SET p.nombre=:valor1,p.horario=:valor2, p.materia=:valor3 WHERE p.id=:valor4");
		query.setParameter("valor1", nombre);
		query.setParameter("valor2", horario);
		query.setParameter("valor3", materia);
		query.setParameter("valor4", id);
		query.executeUpdate();
		
	}

	@Override
	public Profesor seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Profesor.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.seleccionar(id));
	}

	@Override
	public List<Profesor> seleccionarTodos(String horario) {
		// TODO Auto-generated method stub
		TypedQuery<Profesor> myQuery= this.entityManager.createQuery("SELECT p FROM Profesor p WHERE p.horario = :variable",Profesor.class);
		myQuery.setParameter("variable", horario);
		return myQuery.getResultList();
		
	}

}
