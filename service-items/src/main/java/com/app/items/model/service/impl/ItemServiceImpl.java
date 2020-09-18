package com.app.items.model.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.items.client.ProductoRestClient;
import com.app.items.model.Item;
import com.app.items.model.Producto;
import com.app.items.model.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ProductoRestClient productoRestClient;

	@Override
	public List<Item> findAll() throws Exception {
		try {
			List<Producto> listProducto = this.productoRestClient.getAll();
			return listProducto != null && !listProducto.isEmpty()
					? listProducto.stream().map(product -> new Item(product, 100)).collect(Collectors.toList())
					: null;

		} catch (Exception e) {
			throw new Exception(e.getMessage(), e);
		}
	}

	@Override
	public Item findById(Long id, Integer cantidad) throws Exception {
		try {
			Producto producto = this.productoRestClient.getById(id);
			return producto != null ? new Item(producto, cantidad) : null;

		} catch (Exception e) {
			throw new Exception(e.getMessage(), e);
		}
	}

}
