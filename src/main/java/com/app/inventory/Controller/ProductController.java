package com.app.inventory.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.inventory.facadeimp.CategoryDao;
import com.app.inventory.facadeimp.MeasureDao;
import com.app.inventory.facadeimp.ProductDao;
import com.app.inventory.model.Category;
import com.app.inventory.model.Measure;
import com.app.inventory.model.Product;

@Controller
public class ProductController {

	@Autowired
	ProductDao prodao;
	
	@Autowired
	MeasureDao meadao;
	
	@Autowired
	CategoryDao catdao;
	
	@RequestMapping({"/ProdWEB", "/"})
	public String ListUser(Model modelo){
		
		modelo.addAttribute("Product", prodao.EncontrarProduct());
		
		List<Category> lstcat = catdao.EncontrarCategory();
		modelo.addAttribute("Category", lstcat); 
		
		List<Measure> lstmed = meadao.EncontrarMeasure();
		modelo.addAttribute("Measure", lstmed);
		
		return "ProdWEB";
	}
	
	@RequestMapping({"/getOneProduct"})
	@ResponseBody
	public Optional<Product> getOne(Long id_prod){
		return prodao.getOne(id_prod);
	}
	
	@PostMapping({"/Productcrear"})
	public String create(Product product){
		
		this.prodao.create(product);
		return "redirect:/ProdWEB";
	}
	
	@RequestMapping(value="/Productupdate", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Product product){
		this.prodao.update(product);
		return "redirect:/ProdWEB";
	}
	
	@RequestMapping(value="/Productdelete", method = {RequestMethod.PUT, RequestMethod.GET})
	public String delete(Long id_prod) {
		
		Product prod = prodao.finById(id_prod);
		prod.setEst("Inactivo");
		
		this.prodao.delete(prod);
		return "redirect:/ProdWEB";
	}
	
}

