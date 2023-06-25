package com.cayetano.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;

@Entity
@Table(name="citas")
public class Cita {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codcitas")
	private Integer codigo;
	@Column(name="fechacita")
	private LocalDate fecha;
	@Column(name="horacita")
	private LocalTime hora;
	@Column(name="estadocita")
	private int estado;
	
	@ManyToOne
	@JoinColumn(name="CODPaciente")
	private Paciente pacienteCita;
	
	@ManyToOne
	@JoinColumn(name="CODEspecialidad")
	private Especialidad espeCita;
	
	@ManyToOne
	@JoinColumn(name="numsala")
	private Sala salaCita;
	
	@ManyToOne
	@JoinColumn(name="CODMedico")
	private Medico medCita;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Paciente getPacienteCita() {
		return pacienteCita;
	}

	public void setPacienteCita(Paciente pacienteCita) {
		this.pacienteCita = pacienteCita;
	}

	public Especialidad getEspeCita() {
		return espeCita;
	}

	public void setEspeCita(Especialidad espeCita) {
		this.espeCita = espeCita;
	}

	public Sala getSalaCita() {
		return salaCita;
	}

	public void setSalaCita(Sala salaCita) {
		this.salaCita = salaCita;
	}

	public Medico getMedCita() {
		return medCita;
	}

	public void setMedCita(Medico medCita) {
		this.medCita = medCita;
	}
	
	
	
	
}
