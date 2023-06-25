package com.cayetano.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="sala")
public class Sala {
	@Id
	@Column(name="numsala")
	private String codigo;
	@Column(name="estadosala")
	private String estado;

	@OneToOne
	@JoinColumn(name="codespecialidad")
	private Especialidad espeSala;
	
	@OneToMany(mappedBy="salaCita")
	@JsonIgnore
	private List<Cita> listaSalasCita;
	
	public Sala() {
		
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Especialidad getEspeSala() {
		return espeSala;
	}
	public void setEspeSala(Especialidad espeSala) {
		this.espeSala = espeSala;
	}
	
	
	
	
	
	
}
