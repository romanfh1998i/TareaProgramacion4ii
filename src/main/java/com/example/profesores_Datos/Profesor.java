package com.example.profesores_Datos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the profesor database table.
 * 
 */
@Entity
@NamedQuery(name="Profesor.findAll", query="SELECT p FROM Profesor p")
public class Profesor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String email;

	@Column(name="dep_codigo")
	private int depCodigo;

	private String direccion;

	@Column(name="fecha_nacimiento")
	private String fechaNacimiento;

	private String nombres;

	private int telefono;

	public Profesor() {
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getDepCodigo() {
		return this.depCodigo;
	}

	public void setDepCodigo(int depCodigo) {
		this.depCodigo = depCodigo;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public int getTelefono() {
		return this.telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

}