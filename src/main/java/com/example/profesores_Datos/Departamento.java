package com.example.profesores_Datos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the departamento database table.
 * 
 */
@Entity
@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dep_codigo")
	private int depCodigo;

	private String nombre;

	public Departamento() {
	}

	public int getDepCodigo() {
		return this.depCodigo;
	}

	public void setDepCodigo(int depCodigo) {
		this.depCodigo = depCodigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}