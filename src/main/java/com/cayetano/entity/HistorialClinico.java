package com.cayetano.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name="historial_clinico")
public class HistorialClinico {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codhistorialclinico")
	private int codigo;
	@Column(name="descripcion")
	private String descripcion;
	
	//relacion uno a uno
	@OneToOne
	@JsonIgnore
	@JoinColumn(name="CODPaciente")
	private Paciente pacienteHistoria;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Paciente getPacienteHistoria() {
		return pacienteHistoria;
	}

	public void setPacienteHistoria(Paciente pacienteHistoria) {
		this.pacienteHistoria = pacienteHistoria;
	}



	
	
	
}
