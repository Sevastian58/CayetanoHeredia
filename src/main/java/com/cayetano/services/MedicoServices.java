package com.cayetano.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cayetano.dao.MedicoRepository;
import com.cayetano.entity.Medico;



@Service
public class MedicoServices {
	@Autowired
	private MedicoRepository mr;
	
	
	public void adicionar(Medico m) {
		mr.save(m);
	}
	
	public void modificar(Medico m) {
		mr.save(m);
	}
	
	public void eliminar(String cod) {
		mr.deleteById(cod);
	}
	
	public Medico buscarPorID(String cod) {
		return mr.findById(cod).orElse(null);
	}
	
	public List<Medico> ListarTodo(){
		return mr.findAll();
	}
	
	public int ultimoCodigo() {
		return mr.ultimpCodigo();
	}
	
	public List<Medico> listarMedicoPorEspecialidad(int espe){
		return mr.listarMedicoPorEspecialidad(espe);
	}
}
