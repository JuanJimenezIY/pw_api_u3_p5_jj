package com.example.demo.repository.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="profesores")
public class Profesor {
	
	
	@Id
	@GeneratedValue(generator = "seq_profesor",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_profesor", sequenceName = "seq_profesor",allocationSize = 1)
	@Column(name="prof_id")
	private Integer id;
	@Column(name="prof_nombre")
	private String nombre;
	@Column(name="prof_apellido")
	private String apellido;
	@Column(name="prof_edad")
	private Integer edad;
	@Column(name="prof_materia")
	private String materia;
	@Column(name="prof_telefono")
	private String telefono;
	@Column(name="prof_horario")
	private String horario;
	
	
	//GET y SET
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	
	
	
	

}
