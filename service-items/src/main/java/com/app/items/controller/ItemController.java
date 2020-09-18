package com.app.items.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.items.model.Item;
import com.app.items.model.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;

	private final static Logger LOG = LogManager.getLogger(ItemController.class);

	private final static String EMPTY = "No se encontró ningún registro.";
	private final static String ERROR = "El servicio no está disponible en este momento. Puedes intentarlo de nuevo más tarde.";

	@HystrixCommand(fallbackMethod = "fallbackGetAll")
	@GetMapping("/get")
	public ResponseEntity<Object> getAll() {
		try {
			LOG.info("[itemService] getAll...");
			List<Item> listItem = this.itemService.findAll();

			return listItem == null ? new ResponseEntity<>(EMPTY, HttpStatus.NOT_FOUND)
					: new ResponseEntity<>(listItem, HttpStatus.OK);

		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return this.fallbackGetAll();
		}
	}

	@HystrixCommand(fallbackMethod = "FallbackGetById")
	@GetMapping("/get/{id}/{cantidad}")
	public ResponseEntity<Object> getById(@PathVariable Long id, @PathVariable Integer cantidad) {
		try {
			LOG.info("[itemService] getById...");
			Item item = this.itemService.findById(id, cantidad);

			return item == null ? new ResponseEntity<>(EMPTY, HttpStatus.NOT_FOUND)
					: new ResponseEntity<>(item, HttpStatus.OK);

		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return this.FallbackGetById(id, cantidad);
		}
	}

	public ResponseEntity<Object> fallbackGetAll() {
		return new ResponseEntity<>(ERROR, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<Object> FallbackGetById(Long id, Integer cantidad) {
		return new ResponseEntity<>(ERROR, HttpStatus.NOT_FOUND);
	}

}
