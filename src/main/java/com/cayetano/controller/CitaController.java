package com.cayetano.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cayetano.entity.Cita;
import com.cayetano.entity.Especialidad;
import com.cayetano.entity.Medico;
import com.cayetano.entity.Paciente;
import com.cayetano.entity.Sala;
import com.cayetano.services.CitaServices;
import com.cayetano.services.EspecialidadServices;
import com.cayetano.services.MedicoServices;
import com.cayetano.services.PacienteServices;
import com.cayetano.services.SalaServices;

@Controller
@RequestMapping("/cita")
public class CitaController {
	@Autowired
	private CitaServices serCita;
	
	@Autowired
	private EspecialidadServices serEspecialidad;
	
	@Autowired
	private MedicoServices serMedico;
	
	@Autowired
	private SalaServices serSala;
	
	@Autowired
	private PacienteServices serPaciente;
		
	@RequestMapping("/lista")
	public String Index(Model model) {
		return "cita";
	}
	
	@RequestMapping("/listaCreate")
	@ResponseBody
	public List<Cita> listaCreate(@RequestParam("especialidad") Integer codEspe, 
			@RequestParam("sala") String numSala,
			@RequestParam("medico") String codMed,
			@RequestParam("fecha") String fecha){
		LocalDate fechaDate= LocalDate.parse(fecha);
		return serCita.listarCitasCreate(codEspe, numSala, codMed, fechaDate);
	}
	
	@RequestMapping("/grabar")
	public String GrabarCita(@RequestParam("especialidad") Integer codEspe, 
			@RequestParam("sala") String numSala,
			@RequestParam("medico") String codMed,
			@RequestParam("fecha") String fecha,
			@RequestParam("codPaciente") String codPaciente,
			@RequestParam("hora") String hora,
			RedirectAttributes redirect) {
		
		Cita c = new Cita();
		c.setFecha(LocalDate.parse(fecha));
		c.setHora(LocalTime.parse(hora));
		
		Especialidad espe= new Especialidad();
		espe.setCodigo(codEspe);
		
		c.setEspeCita(espe);
		
		Sala s = new Sala();
		s.setCodigo(numSala);
		
		c.setSalaCita(s);
		
		Medico m = new Medico();
		m.setCodigo(codMed);
		
		c.setMedCita(m);
		
		
		Paciente p = new Paciente();
		p=serPaciente.buscarPorID(codPaciente);
		if(p!=null) {
			c.setPacienteCita(p);
			
			serCita.registrar(c);
			
			redirect.addFlashAttribute("MENSAJE","Cita registrada");
			
		}
		else {
			System.out.println("error en el codigo de paciente " + codPaciente);
		}
		
		return "redirect:/cita/lista";
		
	}
	
	
}
