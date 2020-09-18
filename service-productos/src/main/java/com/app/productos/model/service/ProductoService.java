package com.app.productos.model.service;

import java.util.List;

import com.app.productos.model.entity.Producto;

public interface ProductoService {

	public List<Producto> findAll() throws Exception;

	public Producto findById(Long id) throws Exception;

}
