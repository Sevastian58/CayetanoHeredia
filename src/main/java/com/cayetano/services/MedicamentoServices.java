package com.cayetano.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cayetano.dao.MedicamentoRepository;
import com.cayetano.entity.HistorialClinico;
import com.cayetano.entity.Medicamento;

@Service
public class MedicamentoServices {
	@Autowired
	private MedicamentoRepository tr;
	
	
	public void registrar(Medicamento p) {
		tr.save(p);
	}
	public void actualizar(Medicamento p) {
		tr.save(p);
	}
	public void eliminarPorID(String cod) {
		tr.deleteById(cod);
	}
	public Medicamento buscarPorID(String cod) {
		return tr.findById(cod).orElse(null);
	}
	public List<Medicamento> listarTodos(){
		return tr.findAll();
	}
}
