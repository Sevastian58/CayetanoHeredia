package com.cayetano.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class RolEnlacePK implements Serializable{
	private int idrol;
	private int idenlace;
	
	public int getIdrol() {
		return idrol;
	}
	public void setIdrol(int idrol) {
		this.idrol = idrol;
	}
	public int getIdenlace() {
		return idenlace;
	}
	public void setIdenlace(int idenlace) {
		this.idenlace = idenlace;
	}
	//Hashcod--->método que genere un número según los 
				//atributos de la clase actual
	//equals----> método que valida el número generado
	@Override
	public int hashCode() {
		return Objects.hash(idenlace, idrol);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RolEnlacePK other = (RolEnlacePK) obj;
		return idenlace == other.idenlace && idrol == other.idrol;
	}
	
	
}
