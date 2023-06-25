package com.cayetano.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cayetano.dao.HistorialClinicoRepository;
import com.cayetano.entity.HistorialClinico;

@Service
public class HistorialClinicoServices {
	@Autowired
	private HistorialClinicoRepository hr;
	
	public void registrar(HistorialClinico h) {
		hr.save(h);
	}
	public void actualizar(HistorialClinico h) {
		hr.save(h);
	}
	public void eliminarPorID(Integer cod) {
		hr.deleteById(cod);
	}
	public HistorialClinico buscarPorID(Integer cod) {
		return hr.findById(cod).orElse(null);
	}
	public List<HistorialClinico> listarHistorialClinico(){
		return hr.findAll();
	}
	public HistorialClinico buscarPorPaciente(String codPaciente) {
		return hr.buscarPorPaciente(codPaciente);
	}

}
