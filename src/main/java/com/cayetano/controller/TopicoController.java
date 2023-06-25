package com.cayetano.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cayetano.entity.Paciente;
import com.cayetano.entity.Topico;
import com.cayetano.services.PacienteServices;
import com.cayetano.services.TopicoServices;

@Controller
@RequestMapping("/topico")
public class TopicoController {
	@Autowired
	private PacienteServices serpa;
	@Autowired
	private TopicoServices serto;
	
	@RequestMapping("/lista")
	public String index(Model model) {
		model.addAttribute("listaPacientes", serpa.listarTodos());
		model.addAttribute("listartopico", serto.listarTopico());
		return "topico";
	}
	@RequestMapping("/grabar")	
	public String grabar(@RequestParam("codigo") Integer cod,
							@RequestParam("temperatura") int tem,
							@RequestParam("peso") double peso,
							@RequestParam("altura") double alt,							
							@RequestParam("paciente") String cop,
							RedirectAttributes redirect) {
					
		try {
			//crear objeto de la entidad Medicamento
			Topico med=new Topico();
			//setear
			med.setTemperatura(tem);
			med.setPeso(peso);
			med.setAltura(alt);
			//crear objeto de la entidad TipoMedicamento 
			Paciente tm=new Paciente();
			//setear codigo
			tm.setCodigo(cop);
			//enviar objeto "tm" al objeto "med"
			med.setPacienteTopico(tm);
			//valida cod
			if(cod==0) {
				//invocar al método registrarr
				serto.registrar(med);
				//crear un atributo
				redirect.addFlashAttribute("MENSAJE","Topico registrado");
			}
			else {
				//setear el código del objeto med
				med.setCodigo(cod);
				med.asignarfecha();
				//invocar al método actualizar
				serto.actualizar(med);
				//crear un atributo
				redirect.addFlashAttribute("MENSAJE","Topico actualizado");					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/topico/lista";
	}
	//ruta para buscar medicamento por su código
		//retorna JSON
		@RequestMapping("/buscar")
		@ResponseBody//--- para convertir en JSON el objeto retornado 
		public Topico buscarPorID(@RequestParam("codigo") Integer cod) {
			return serto.buscarPorID(cod);
		}
		
		//ruta para eliminar medicamento por su código
		@RequestMapping("/eliminar")
		public String eliminarPorID(@RequestParam("codigo") Integer cod,
									RedirectAttributes redirect) {
			serto.eliminarPorID(cod);
			redirect.addFlashAttribute("MENSAJE","Topico eliminado");
			
			return "redirect:/topico/lista";
		}
		
		
		

}
