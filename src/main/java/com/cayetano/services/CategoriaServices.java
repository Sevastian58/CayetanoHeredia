package com.cayetano.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cayetano.dao.CategoriaRepository;
import com.cayetano.entity.Categoria;




@Service
public class CategoriaServices {
	@Autowired
	private CategoriaRepository n;
	
	public List<Categoria> listarTodos(){
		return n.findAll();
	}
	public List<Categoria> listaPorProveedor(Integer codpro){
		return n.findAllByProveedor(codpro);
	}
}
