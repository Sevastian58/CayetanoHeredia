package com.cayetano.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cayetano.entity.Paciente;
import com.cayetano.services.PacienteServices;

@Controller
@RequestMapping("/paciente")
public class PacienteController {
	@Autowired
	private PacienteServices serPaciente;
	
	@RequestMapping("/lista")
	public String index(Model model) {
		model.addAttribute("listaPacientes", serPaciente.listarTodos());
		return "paciente";
	}
	
	@RequestMapping("/grabar")	
	public String grabar(@RequestParam("codigo") String cod,
							@RequestParam("dni") String dni,
							@RequestParam("nombre") String nom,
							@RequestParam("apellido") String ape,
							@RequestParam("edad") int edad,
							@RequestParam("sexo") String sexo,
							@RequestParam("correo") String correo,
							@RequestParam("telefono") String telefono,
							RedirectAttributes redirect) {
		try {
			//crear objeto de la entidad Medicamento
			Paciente pac =new Paciente();
			//setear
			pac.setNombre(nom);
			pac.setApellido(ape);
			pac.setDni(dni);
			pac.setEdad(edad);
			pac.setSexo(sexo);
			pac.setCorreo(correo);
			pac.setTelefono(telefono);
			//valida cod
			if(cod.equals("null")) {
				
				int ultimoCodigo= serPaciente.ultimoCodigo() + 1;
				String nuevoCodigo="PAC"+ ultimoCodigo;
				
				pac.setCodigo(nuevoCodigo);
				
				serPaciente.registrar(pac);
				//crear un atributo
				redirect.addFlashAttribute("MENSAJE","Paciente registrado");
			}
			else {
				//setear el código del objeto med
				pac.setCodigo(cod);
				//invocar al método actualizar
				serPaciente.actualizar(pac);
				//crear un atributo
				redirect.addFlashAttribute("MENSAJE","Paciente actualizado");					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/paciente/lista";
	}
	
	//ruta para buscar medicamento por su código
	//retorna JSON
	@RequestMapping("/buscar")
	@ResponseBody//--- para convertir en JSON el objeto retornado 
	public Paciente   buscarPorID(@RequestParam("codigo") String cod) {
		return serPaciente.buscarPorID(cod);
	}
	
	@RequestMapping("/buscarPorNombre")
	@ResponseBody//--- para convertir en JSON el objeto retornado 
	public List<Paciente>   buscarPorNombre(@RequestParam("nombre") String nombre) {
		return serPaciente.buscarPorNombre(nombre);
	}
}
