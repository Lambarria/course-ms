package com.app.productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.productos.model.entity.Producto;
import com.app.productos.model.service.ProductoService;

@RestController
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@GetMapping("/get")
	public List<Producto> getAll() throws Exception {
		try {
			return this.productoService.findAll();

		} catch (Exception e) {
			throw new Exception(e.getMessage(), e);
		}
	}

	@GetMapping("/get/{id}")
	public Producto getById(@PathVariable Long id) throws Exception {
		try {
			return this.productoService.findById(id);

		} catch (Exception e) {
			throw new Exception(e.getMessage(), e);
		}
	}

}
