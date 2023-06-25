package com.cayetano.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cayetano.entity.Medico;
import com.cayetano.entity.Sala;

public interface SalaRepository extends JpaRepository<Sala, String>{

	@Query(value="{ call listarSalaEspecialidad(?1) }", nativeQuery=true)
	public List<Sala> listarSalaEspecialidad(int codEspecialidad);
}
