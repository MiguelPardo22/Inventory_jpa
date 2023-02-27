package com.app.inventory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.inventory.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
