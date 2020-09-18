package com.app.articulos.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.articulos.model.Articulo;
import com.app.articulos.model.BadRequest;
import com.app.articulos.model.service.ArticuloService;

@RestController
public class ArticuloController {

	@Autowired
	private ArticuloService articuloService;

	private final static Logger LOG = LogManager.getLogger(ArticuloController.class);

	@GetMapping("/get")
	public ResponseEntity<Object> getAll() {
		try {
			LOG.info("Iniciando getAll...");
			List<Articulo> listArticulo = this.articuloService.findAll();

			if (CollectionUtils.isEmpty(listArticulo)) {
				return new ResponseEntity<>(new BadRequest("No se encontraron registros", HttpStatus.NOT_FOUND.value()),
						HttpStatus.NOT_FOUND);
			}

			LOG.info("Total articulos: {}", listArticulo.size());
			return new ResponseEntity<>(listArticulo, HttpStatus.OK);

		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return new ResponseEntity<>(new BadRequest(e.getMessage(), HttpStatus.BAD_REQUEST.value()),
					HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/get/{id}/{cantidad}")
	public ResponseEntity<Object> getById(@PathVariable Long id, @PathVariable Integer cantidad) {
		try {
			LOG.info("Iniciando getById...");
			Articulo articulo = this.articuloService.findById(id, cantidad);

			if (articulo == null) {
				return new ResponseEntity<>(
						new BadRequest("No se encontró el registro solicitado", HttpStatus.NOT_FOUND.value()),
						HttpStatus.NOT_FOUND);
			}

			LOG.info("Id encontrado: {}", articulo.getProducto().getId());
			return new ResponseEntity<>(articulo, HttpStatus.OK);

		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return new ResponseEntity<>(new BadRequest(e.getMessage(), HttpStatus.BAD_REQUEST.value()),
					HttpStatus.BAD_REQUEST);
		}
	}

}
