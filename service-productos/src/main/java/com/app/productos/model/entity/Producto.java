package com.app.productos.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {

	/**
	 * Serial version.
	 */
	private static final long serialVersionUID = 5394104618446613659L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROD_SEQ")
	@SequenceGenerator(sequenceName = "PROD_SEQ", name = "PROD_SEQ")
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "precio")
	private Double precio;

	@Column(name = "fecha_creacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}
