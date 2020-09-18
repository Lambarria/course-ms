package com.app.articulos.model.service;

import java.util.List;

import com.app.articulos.model.Articulo;

public interface ArticuloService {

	public List<Articulo> findAll() throws Exception;

	public Articulo findById(Long id, Integer cantidad) throws Exception;

}
