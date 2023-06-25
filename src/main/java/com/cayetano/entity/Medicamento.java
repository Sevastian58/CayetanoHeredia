package com.cayetano.entity;



import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;


@Entity
@Table(name="medicamento")
public class Medicamento{
	@Id
	@Column(name="CODMedicamento")
	private String codigo;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="Stock")
	private int stock;
	@Column(name="precio")
	private int venta;
	@Column(name="cantidad")
	private int cantidad;
	@Column(name="Estado")
	private String estado;
	
	@ManyToOne
	@JoinColumn(name="CODCategoria")
	private Categoria categoria;

	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getVenta() {
		return venta;
	}
	public void setVenta(int venta) {
		this.venta = venta;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	


	
	
}
