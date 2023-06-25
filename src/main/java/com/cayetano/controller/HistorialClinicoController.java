package com.cayetano.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cayetano.entity.HistorialClinico;
import com.cayetano.entity.Paciente;
import com.cayetano.entity.Topico;
import com.cayetano.services.HistorialClinicoServices;
import com.cayetano.services.PacienteServices;



@Controller
@RequestMapping("/historiaClinica")
public class HistorialClinicoController {
	@Autowired
	private HistorialClinicoServices hispe;
	@Autowired
	private PacienteServices serpa;
	
	@RequestMapping("/lista")
	public String index(Model model) {
		model.addAttribute("listaPacientes", serpa.listarTodos());
		model.addAttribute("listarHistorialClinico", hispe.listarHistorialClinico());
		return "historiaClinica";
	}

	@RequestMapping("/grabar")	
	@ResponseBody
	public String grabar(@RequestParam("codigo") Integer cod,
						 @RequestParam("descripcion") String des,
						 @RequestParam("paciente") String cop,
						 RedirectAttributes redirect) {
		
	
		String mensaje="";
		try {
			//crear objeto de la entidad Medicamento
			HistorialClinico hc=new HistorialClinico();
			
			hc.setCodigo(cod);
			hc.setDescripcion(des);
			
			Paciente tm=new Paciente();
			
			tm.setCodigo(cop);
			
			hc.setPacienteHistoria(tm);
			hc.setCodigo(cod);
			hc.setDescripcion(des);
				
			if(cod==0) {
				hispe.registrar(hc);
			}
			else {
				hispe.actualizar(hc);
			}
			
				
			redirect.addFlashAttribute("MENSAJE","Historial de Paciente actualizado");
			mensaje="Historial Actualizado";
			
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
			return mensaje;
	    }
	@RequestMapping("/buscar")
	@ResponseBody
	public HistorialClinico buscarPorIdHistorialClinico(@RequestParam("codigo")Integer cod) {
		return hispe.buscarPorID(cod);
	}
	
	@RequestMapping("/buscarPorPaciente")
	@ResponseBody
	public HistorialClinico buscarPorPaciente(@RequestParam("codigo") String cod) {
		return hispe.buscarPorPaciente(cod);
	}
	
	@RequestMapping("/eliminar")
	public String eliminarPorID(@RequestParam("codigo")Integer cod,
			                     RedirectAttributes redirect) {
		hispe.eliminarPorID(cod);
		redirect.addFlashAttribute("MENSAJE","Historial eliminado");
		return "redirect:/historialclinico/lista";
	}
			                                                                             
	
	
	
	
	
}




