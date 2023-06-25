package com.cayetano.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cayetano.dao.EspecialidadRepository;
import com.cayetano.entity.Especialidad;






@Service
public class EspecialidadServices {
	@Autowired
	private EspecialidadRepository tr;
	
	public List<Especialidad> listarTodos(){
		return tr.findAll();
	}
	
}
