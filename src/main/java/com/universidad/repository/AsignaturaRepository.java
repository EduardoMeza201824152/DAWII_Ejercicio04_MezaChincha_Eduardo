package com.universidad.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.universidad.entity.Asignatura;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Integer>{

	//no olvidar que @Query toma los nombres del bean de la clase (Asignatura.java)
	//esto hace que no funcione si le pones los nombres de la BD
	@Query("select a from Asignatura a where a.nombre like :param_filtro")
	public abstract List<Asignatura> listaAsignatura(@Param("param_filtro") String filtro);
	
	public abstract Optional<Asignatura> findById(int id);;
	
}
