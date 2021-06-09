package com.universidad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universidad.entity.Asignatura;
import com.universidad.repository.AsignaturaRepository;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

	@Autowired
	private AsignaturaRepository repository;
	
	@Override
	public List<Asignatura> listaAsignatura() {
		return repository.findAll();
	}

	@Override
	public Optional<Asignatura> obtienePorId(int id) {
		return repository.findById(id);
	}
	
	@Override
	public List<Asignatura> listaPorNombre(String nom) {
		return repository.listaAsignatura("%"+nom+"%");
	}

	@Override
	public Asignatura insertaActualizaAsignatura(Asignatura obj) {
		return repository.save(obj);
	}

	@Override
	public void eliminaAsignatura(int id) {
		repository.deleteById(id);
	}

}
