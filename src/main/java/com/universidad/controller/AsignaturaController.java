package com.universidad.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.universidad.entity.Asignatura;
import com.universidad.service.AsignaturaService;

import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
@RestController
@RequestMapping("/rest/asignatura")
public class AsignaturaController {

	@Autowired
	private AsignaturaService service;
	
	//list
	@GetMapping
	public ResponseEntity<List<Asignatura>> lista(){
		log.info(">>>> lista ");
		List<Asignatura> lstAsignatura = service.listaAsignatura();
		return ResponseEntity.ok(lstAsignatura);
	}
	
	//find by id
	@GetMapping("/buscarPorId/{id}")
	public ResponseEntity<Optional<Asignatura>> buscar(@PathVariable("id") int id) {
		log.info(">>>> busca por id : " + id);
		Optional<Asignatura> optAsignatura = service.obtienePorId(id);
		if (optAsignatura.isPresent()) {
			return ResponseEntity.ok(optAsignatura);
		} else {
			log.info(">>>> busca por id - no existe asignatura con id: " + id);
			return ResponseEntity.badRequest().build();
		}
	}
	
	//list by name
	@GetMapping("/buscarPorNombre/{nom}")
	public ResponseEntity<List<Asignatura>> listaPorNombre(@PathVariable("nom") String filtro){
		log.info(">>>> lista por nombre ");
		List<Asignatura> lstAsignatura = service.listaPorNombre(filtro);
		return ResponseEntity.ok(lstAsignatura);
	}
	
	//insert
	@PostMapping
	public ResponseEntity<Asignatura> registra(@RequestBody Asignatura obj){
		log.info(">>>> registra  " + obj.getId());
		Asignatura objSalida = service.insertaActualizaAsignatura(obj);
		if (objSalida != null) {
			return ResponseEntity.ok(objSalida);
		}else {
			log.info(">>>> registra - error al momento de registrar");
			return ResponseEntity.badRequest().build();
		}
	}
	
	//update
	@PutMapping
	public ResponseEntity<Asignatura> actualiza(@RequestBody Asignatura obj){
		log.info(">>>> actualiza  " + obj.getId());
		Optional<Asignatura> optAsignatura = service.obtienePorId(obj.getId());
		if (optAsignatura.isPresent()) {
			Asignatura objSalida = service.insertaActualizaAsignatura(obj);
			if (objSalida != null) {
				return ResponseEntity.ok(objSalida);
			}else {
				return ResponseEntity.badRequest().build();
			}	
		}else {
			log.info(">>>> actualiza - no existe asignatura con id: " + obj.getId());
			return ResponseEntity.badRequest().build();
		}
	}
	
	//delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Asignatura> elimina(@PathVariable("id") int id){
		log.info(">>>> elimina  " + id);
		Optional<Asignatura> optAsignatura = service.obtienePorId(id);
		if (optAsignatura.isPresent()) {
			service.eliminaAsignatura(id);
			return ResponseEntity.ok(optAsignatura.get());
		}else {
			log.info(">>>> elimina - no existe asignatura con id: " + id);
			return ResponseEntity.badRequest().build();
		}
	}
	
}
