package com.cayetano.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cayetano.entity.Especialidad;
import com.cayetano.entity.Medico;

import com.cayetano.services.EspecialidadServices;
import com.cayetano.services.MedicoServices;


@Controller
@RequestMapping("/medico")
public class MedicoController {
	
	@Autowired
	private MedicoServices serMedico;
	@Autowired
	private EspecialidadServices serEspecialidad;
	
	@RequestMapping("/registrar")
	public void registrar() {
		
	}
	
	@RequestMapping("/lista")
	public String Index(Model model) {
		model.addAttribute("listaMedicos",serMedico.ListarTodo());
		model.addAttribute("listaEspecialidades",serEspecialidad.listarTodos());
		return "medico";
	}
	
	@RequestMapping("/listaMedicosEspecialidad")
	@ResponseBody
	public List<Medico> listaMedicosEspecialidad(@RequestParam("especialidad") int espe) {
		return serMedico.listarMedicoPorEspecialidad(espe);
	}
	
	
	
	@RequestMapping("/grabar")	
	public String grabar(@RequestParam("codigo") String cod,
			                @RequestParam("dni") String dni,
							@RequestParam("nombre") String nom,
							@RequestParam("apellido") String ape,
							@RequestParam("telefono") String tel,
							@RequestParam("edad") int edad,
							@RequestParam("sexo") String sexo,			
							@RequestParam("correo") String cor,
							@RequestParam("especialidad") int cod_esp,
							RedirectAttributes redirect) {
		try {
	
			Medico med=new Medico();

			med.setDni(dni);
			med.setNombre(nom);
			med.setApellido(ape);
			med.setTelefono(tel);
			med.setEdad(edad);
			med.setSexo(sexo);
			med.setCorreo(cor);

			Especialidad e=new Especialidad();


			e.setCodigo(cod_esp);
			med.setEsp(e);
			
			if(cod.equals("null")) {
				System.out.println("ingreso a grabar");
				int ultimoCodigo= serMedico.ultimoCodigo()+1;
				String nuevoCod= "MED"+ ultimoCodigo;
				System.out.println("el ultimo codigo es" + nuevoCod);
				med.setCodigo(nuevoCod);
				serMedico.adicionar(med);
				redirect.addFlashAttribute("MENSAJE","Medico registrado");
			}
			else {
				System.out.println("ingreso a modificar");
				med.setCodigo(cod);
				System.out.println("el codigo a modificar es " + cod);
				serMedico.modificar(med);
				redirect.addFlashAttribute("MENSAJE","Medico actualizado");					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/medico/lista";
	}
	
	@RequestMapping("/buscar")
	@ResponseBody
	public Medico buscarPorID(@RequestParam("codigo") String cod) {
		return serMedico.buscarPorID(cod);
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("codigo") String cod,
								RedirectAttributes redirect) {
		serMedico.eliminar(cod);
		redirect.addFlashAttribute("MENSAJE","Medico eliminado");
		
		return "redirect:/medico/lista";
	}
}
