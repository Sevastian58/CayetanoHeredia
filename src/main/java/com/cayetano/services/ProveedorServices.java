package com.cayetano.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cayetano.dao.ProveedorRepository;
import com.cayetano.entity.Proveedor;



@Service
public class ProveedorServices {
	@Autowired
	private ProveedorRepository r;
	
	public List<Proveedor> listarTodos(){
		return r.findAll();
	}
	
	
	
}
