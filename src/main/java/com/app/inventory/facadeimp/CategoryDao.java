package com.app.inventory.facadeimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.inventory.Repository.CategoryRepository;
import com.app.inventory.facade.ICategory;
import com.app.inventory.model.Category;

@Service
public class CategoryDao implements ICategory{

	 @Autowired
	 CategoryRepository categoryrepo;
	
	@Override
	public List<Category> EncontrarCategory() {	
		return categoryrepo.ListCategoria();
	}

	@Override
	public Optional<Category> getOne(Long id_cat) {
		return categoryrepo.findById(id_cat);
	}

	@Override
	public Category finById(Long id_cat) {
		return categoryrepo.getReferenceById(id_cat);
	}

	@Override
	public void create(Category category) {
		categoryrepo.save(category);
	}

	@Override
	public void update(Category category) {
		categoryrepo.save(category);
	}

	@Override
	public void delete(Category category) {
		Category cat = this.categoryrepo.getById(category.getId_cat());
		categoryrepo.save(cat);
	}

}
