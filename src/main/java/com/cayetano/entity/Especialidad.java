package com.cayetano.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name="especialidad")
public class Especialidad {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codespecialidad")
	private Integer codigo;
	@Column(name="especialidad")
	private String nombre;
	
	@JsonIgnore
	@OneToMany(mappedBy = "esp")
	private List<Medico> listaEspe;
	
	@OneToOne(mappedBy="espeSala")
	@JsonIgnore
	private Sala sala;
	
	@JsonIgnore
	@OneToMany(mappedBy = "espeCita")
	private List<Cita> listaEspeCita;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Medico> getListaEspe() {
		return listaEspe;
	}

	public void setListaEspe(List<Medico> listaEspe) {
		this.listaEspe = listaEspe;
	}

	
	
	
	
	
	
	
	
	
}
