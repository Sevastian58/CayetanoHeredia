package com.cayetano.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="proveedor")
public class Proveedor{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CODProveedor")
	private Integer codigo;
	@Column(name="Descripcion")
	private String descripcion;
	
	@OneToMany(mappedBy = "proveedor")
	@JsonIgnore
	private List<Categoria> ListaCategoria;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Categoria> getListaCategoria() {
		return ListaCategoria;
	}

	public void setListaCategoria(List<Categoria> listaCategoria) {
		ListaCategoria = listaCategoria;
	}
	
	
	

}



