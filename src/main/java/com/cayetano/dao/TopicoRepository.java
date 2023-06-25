package com.cayetano.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cayetano.entity.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Integer> {

}
