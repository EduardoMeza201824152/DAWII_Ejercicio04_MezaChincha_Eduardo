package com.universidad.service;

import java.util.List;
import java.util.Optional;

import com.universidad.entity.Asignatura;

public interface AsignaturaService {

	public abstract List<Asignatura> listaAsignatura();
	public abstract Optional<Asignatura> obtienePorId(int id);
	public abstract List<Asignatura> listaPorNombre(String nom);
	public abstract Asignatura insertaActualizaAsignatura(Asignatura obj);
	public abstract void eliminaAsignatura(int id);
	
}
