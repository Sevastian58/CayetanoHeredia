package com.cayetano.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cayetano.dao.SalaRepository;
import com.cayetano.entity.Sala;

@Service
public class SalaServices {

	@Autowired
	private SalaRepository repo;
	
	public List<Sala> listarTodo(){
		return	repo.findAll();
	}
	
	public List<Sala> listarSalaEspecialidad(int codEspe){
		return repo.listarSalaEspecialidad(codEspe);
	}
}
