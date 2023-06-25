package com.cayetano.entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name="medico")
public class Medico {

	@Id
	@Column(name="codmedico")
	private String codigo;
	@Column(name="dnimedico")
	private String dni;
	@Column(name="nombremedico")
	private String nombre;
	@Column(name="apellidosmedico")
	private String apellido;
	@Column(name="telefono")
	private String telefono;
	@Column(name="edadmedico")
	private int edad;
	@Column(name="sexo")
	private String sexo;
	@Column(name="correomedico")
	private String correo;
	
	public Medico() {
		
	}
	
	@ManyToOne
	@JoinColumn(name="especialidad")
	private Especialidad esp;

	@JsonIgnore
	@OneToMany(mappedBy = "medCita")
	private List<Cita> listaMedCita;

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


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
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


	public Especialidad getEsp() {
		return esp;
	}


	public void setEsp(Especialidad esp) {
		this.esp = esp;
	}


	
	
	
}
