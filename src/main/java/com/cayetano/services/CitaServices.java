package com.cayetano.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cayetano.dao.CitaRepository;
import com.cayetano.entity.Cita;

@Service
public class CitaServices {
	@Autowired
	private CitaRepository cr;
	
	public void registrar(Cita c) {
		cr.save(c);
	}
	public void modificar(Cita c) {
		cr.save(c);
	}
	public List<Cita> listarCitasCreate(Integer codEspe, String numSala, String codMed, LocalDate fecha){
		return cr.listarPorEspeSalaMedFecha(codEspe, numSala, codMed, fecha);
	}
}
