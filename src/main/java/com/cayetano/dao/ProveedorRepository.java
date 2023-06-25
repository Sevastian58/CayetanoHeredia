package com.cayetano.dao;



import org.springframework.data.jpa.repository.JpaRepository;


import com.cayetano.entity.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer>{
	
}
