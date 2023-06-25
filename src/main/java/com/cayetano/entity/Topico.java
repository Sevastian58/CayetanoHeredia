package com.cayetano.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name="topico")
public class Topico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idtopico")
	private Integer codigo;
	@Column(name="temperatura")
	private double temperatura;
	@Column(name="peso")
	private double peso;
	@Column(name="altura")
	private double altura;
	@Column(name="fecha")	
	private LocalDateTime fecha;
	
	//relacion uno a uno
	@ManyToOne
	@JoinColumn(name="CODPaciente")
	private Paciente pacienteTopico;
	

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Paciente getPacienteTopico() {
		return pacienteTopico;
	}

	public void setPacienteTopico(Paciente pacienteTopico) {
		this.pacienteTopico = pacienteTopico;
	}
	@PrePersist
	public void asignarfecha() {
		fecha=LocalDateTime.now();
	}

	

	
	
	
}
