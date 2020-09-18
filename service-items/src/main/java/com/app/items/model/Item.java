package com.app.items.model;

import java.io.Serializable;

public class Item implements Serializable {

	/**
	 * Serial version.
	 */
	private static final long serialVersionUID = -2026825155161594669L;

	private Producto producto;
	private Integer cantidad;

	public Item() {

	}

	public Item(Producto producto, Integer cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getTotal() {
		return this.producto.getPrecio() * this.cantidad;
	}

}
