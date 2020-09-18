package com.app.items.model.service;

import java.util.List;

import com.app.items.model.Item;

public interface ItemService {

	public List<Item> findAll() throws Exception;

	public Item findById(Long id, Integer cantidad) throws Exception;

}
