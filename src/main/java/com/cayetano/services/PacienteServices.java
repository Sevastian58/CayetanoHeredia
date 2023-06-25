package com.cayetano.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cayetano.dao.PacienteRepository;
import com.cayetano.entity.Paciente;

@Service
public class PacienteServices {
	@Autowired
	private PacienteRepository repo;
	
	public void registrar(Paciente p) {
		repo.save(p);
	}
	public void actualizar(Paciente p) {
		repo.save(p);
	}
	public void eliminarPorID(String cod) {
		repo.deleteById(cod);
	}
	public Paciente buscarPorID(String cod) {
		return repo.findById(cod).orElse(null);
	}
	public List<Paciente> listarTodos(){
		return repo.findAll();
	}
	public int ultimoCodigo() {
		return repo.ultimoCodigo();
	}
	public List<Paciente> buscarPorNombre(String nombre){
		return repo.buscarPorNombre(nombre);
	}
}
