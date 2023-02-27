package com.app.inventory.facade;

import java.util.List;
import java.util.Optional;

import com.app.inventory.model.Category;


public interface ICategory {

	public List<Category> EncontrarCategory();
	public Optional<Category> getOne(Long id_cat);
	public Category finById(Long id_cat);
	public void create(Category category);
	public void update(Category category);
	public void delete(Category category);
	
}
