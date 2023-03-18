package com.app.inventory.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.inventory.facadeimp.CategoryDao;
import com.app.inventory.model.Category;

@Controller
@RequestMapping({"/admin"})
public class CategoryController {

	@Autowired
	CategoryDao catdao;
	
	@RequestMapping({"/category"})
	public String ListCategoria(Model model) {
		model.addAttribute("Category", catdao.EncontrarCategory());
		return "CategoryWEB";
	}
	
	@RequestMapping({"/getOneCategory"})
	@ResponseBody
	public Optional<Category> getOne(Long id_cat) {
		return catdao.getOne(id_cat);
	}
	
	
	@PostMapping({"/CategoryCrear"})
	public String create(Category category) {
		
		try {
			catdao.create(category);
			return "redirect:/admin/category?exito";
		} catch (Exception e) {
			return "redirect:/admin/category?fallo";
		}
	
	}
	
	@RequestMapping(value="/CategoryUpdate", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Category category) {
		
		try {
			
			catdao.update(category);
			return "redirect:/admin/category?exitoUp";
			
		} catch (Exception e) {
			return "redirect:/admin/category?falloUp";
		}
	
	}
	
	@RequestMapping(value="/CategoryDelete", method = {RequestMethod.PUT, RequestMethod.GET})
	public String delete(Long id_cat) {
		
		try {

		Category cat = catdao.finById(id_cat);
		cat.setEst("Inactivo");
		
		this.catdao.delete(cat);
		return "redirect:/admin/category?exitoDe";
		
		} catch (Exception e) {
			return "redirect:/admin/category?falloDe";
		}
	}
	
}