package com.cayetano.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cayetano.dao.TopicoRepository;
import com.cayetano.entity.Topico;

@Service
public class TopicoServices {
	@Autowired
	private TopicoRepository tr;
	
	
	public void registrar(Topico p) {
		tr.save(p);
	}
	public void actualizar(Topico p) {
		tr.save(p);
	}
	public void eliminarPorID(Integer cod) {
		tr.deleteById(cod);
	}
	public Topico buscarPorID(Integer cod) {
		return tr.findById(cod).orElse(null);
	}
	public List<Topico> listarTopico(){
		return tr.findAll();
	}
}
