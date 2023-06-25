package com.cayetano.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cayetano.entity.Cita;
import com.cayetano.entity.HistorialClinico;

public interface CitaRepository extends JpaRepository<Cita, Integer>{
	@Query(value="call listarCitasEspeMedSalaFecha(?1, ?2, ?3, ?4);", nativeQuery=true)
	public List<Cita> listarPorEspeSalaMedFecha(Integer codEspe, String numSala, String codMed, LocalDate fecha);
}
