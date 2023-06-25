package com.cayetano.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="categoria_de_medicamento")
public class Categoria{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CODCategoria")
	private Integer codigo;
	@Column(name="Descripcion")
	private String descripcion;
	
	
	@OneToMany(mappedBy = "categoria")
	@JsonIgnore
	private List<Medicamento> ListaMedicamento;

	@ManyToOne
	@JoinColumn(name="CODProveedor")
	private Proveedor proveedor;
	


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

	public List<Medicamento> getListaMedicamento() {
		return ListaMedicamento;
	}

	public void setListaMedicamento(List<Medicamento> listaMedicamento) {
		ListaMedicamento = listaMedicamento;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	

}



