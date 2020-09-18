package com.app.productos.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.productos.model.entity.Producto;
import com.app.productos.model.repository.ProductoRepository;
import com.app.productos.model.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public List<Producto> findAll() throws Exception {
		try {
			return (List<Producto>) this.productoRepository.findAll();

		} catch (Exception e) {
			throw new Exception(e.getMessage(), e);
		}
	}

	@Override
	public Producto findById(Long id) throws Exception {
		try {
			return this.productoRepository.findById(id).orElse(null);

		} catch (Exception e) {
			throw new Exception(e.getMessage(), e);
		}
	}

}
