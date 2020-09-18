package com.app.productos.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.productos.model.entity.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

}
