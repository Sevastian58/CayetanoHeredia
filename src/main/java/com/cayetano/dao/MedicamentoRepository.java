package com.cayetano.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cayetano.entity.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, String> {

}
