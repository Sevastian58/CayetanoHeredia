package com.cayetano.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name="paciente")
public class Paciente {
	@Id
	@Column(name="codpaciente")
	private String codigo;
	@Column(name="dnipaciente")
	private String dni;
	@Column(name="nombrespaciente")
	private String nombre;
	@Column(name="apellidospaciente")
	private String apellido;
	@Column(name="edadpaciente")
	private int edad;
	@Column(name="sexo")
	private String sexo;
	@Column(name="correopaciente")
	private String correo;
	@Column(name="telefono")
	private String telefono;
	
	
	public Paciente() {
		
	}
	
	//relaciones con otras tablas
	@OneToOne(mappedBy="pacienteHistoria")
	@JsonIgnore
	private HistorialClinico historial;
	
	@OneToMany(mappedBy="pacienteTopico")
	@JsonIgnore
	private List<Topico> listaTopicos;
	
	@OneToMany(mappedBy="pacienteCita")
	@JsonIgnore
	private List<Cita> listaCitas;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public HistorialClinico getHistorial() {
		return historial;
	}
	public void setHistorial(HistorialClinico historial) {
		this.historial = historial;
	}
	public List<Topico> getListaTopicos() {
		return listaTopicos;
	}
	public void setListaTopicos(List<Topico> listaTopicos) {
		this.listaTopicos = listaTopicos;
	}
	public List<Cita> getListaCitas() {
		return listaCitas;
	}
	public void setListaCitas(List<Cita> listaCitas) {
		this.listaCitas = listaCitas;
	}
	
	
	
}
