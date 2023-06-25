package com.cayetano.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cayetano.entity.HistorialClinico;
import com.cayetano.entity.Paciente;

public interface HistorialClinicoRepository  extends JpaRepository<HistorialClinico, Integer>{
	@Query(value="call BUSCAR_HISTORIA_PACIENTE(?1)", nativeQuery=true)
	public HistorialClinico buscarPorPaciente(String codPaciente);
}
