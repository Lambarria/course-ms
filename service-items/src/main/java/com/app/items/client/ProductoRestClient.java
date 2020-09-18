package com.app.items.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.items.model.Producto;

@FeignClient(name = "servicio-productos")
public interface ProductoRestClient {

	@GetMapping("/get")
	public List<Producto> getAll() throws Exception;

	@GetMapping("/get/{id}")
	public Producto getById(@PathVariable Long id) throws Exception;

}
