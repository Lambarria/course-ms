package com.app.articulos.model.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.articulos.model.Articulo;
import com.app.articulos.model.Producto;
import com.app.articulos.model.service.ArticuloService;

@Service
public class ArticuloServiceImpl implements ArticuloService {

	@Autowired
	private RestTemplate clientRestTemplate;

	/*
	 * sin ribbon
	 * 
	 * private final static String URL_ROOT = "http://localhost:8001";
	 */
	private final static String URL_ROOT = "http://servicio-productos";
	private final static String URL_FIND_ALL = URL_ROOT + "/get";
	private final static String URL_FIND_BY_ID = URL_ROOT + "/get/{id}";

	@Override
	public List<Articulo> findAll() throws Exception {
		try {
			List<Producto> listProducto = Arrays
					.asList(this.clientRestTemplate.getForObject(URL_FIND_ALL, Producto[].class));

			return listProducto.stream().map(product -> new Articulo(product, 100)).collect(Collectors.toList());

		} catch (Exception e) {
			throw new Exception(e.getMessage(), e);
		}
	}

	@Override
	public Articulo findById(Long id, Integer cantidad) throws Exception {
		try {
			Map<String, String> mapPathVariable = new HashMap<>();
			mapPathVariable.put("id", id.toString());

			return new Articulo(this.clientRestTemplate.getForObject(URL_FIND_BY_ID, Producto.class, mapPathVariable),
					cantidad);

		} catch (Exception e) {
			throw new Exception(e.getMessage(), e);
		}
	}

}
