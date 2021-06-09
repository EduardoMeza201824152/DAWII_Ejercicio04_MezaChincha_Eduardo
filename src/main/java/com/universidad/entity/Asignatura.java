package com.universidad.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "asignatura")
public class Asignatura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAsignatura")
	private Integer id;
	
	@Column(name = "nombreAsignatura")
	private String nombre;
	
	@Column(name = "creditosAsignatura")
	private Double creditos;
	
	@Column(name = "tipoAsignatura")
	private String tipo;
	
	@Column(name = "requisitosAsignatura")
	private String requisitos;

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

	public Double getCreditos() {
		return creditos;
	}

	public void setCreditos(Double creditos) {
		this.creditos = creditos;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	@Override
	public String toString() {
		return "Asignatura [id=" + id + ", nombre=" + nombre + ", creditos=" + creditos + ", tipo=" + tipo
				+ ", requisitos=" + requisitos + "]";
	}
	
	
}
