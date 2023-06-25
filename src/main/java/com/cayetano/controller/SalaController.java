package com.cayetano.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cayetano.entity.Sala;
import com.cayetano.services.SalaServices;

@Controller
@RequestMapping("/sala")
public class SalaController {
	
	@Autowired
	private SalaServices serSala;
	
	@RequestMapping("/listaSalaEspecialidad")
	@ResponseBody
	public List<Sala> listaSalasEspecialidad(@RequestParam("especialidad") int espe) {
		return serSala.listarSalaEspecialidad(espe);
	}
}
