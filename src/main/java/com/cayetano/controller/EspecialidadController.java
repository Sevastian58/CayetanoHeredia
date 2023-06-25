package com.cayetano.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cayetano.entity.Especialidad;
import com.cayetano.services.EspecialidadServices;

@Controller
@RequestMapping("/especialidad")
public class EspecialidadController {

	@Autowired
	private EspecialidadServices serEspecialidad;
	
	
	@RequestMapping("/lista")
	@ResponseBody
	public List<Especialidad> listarTodo(){
		return serEspecialidad.listarTodos();
	}
}
