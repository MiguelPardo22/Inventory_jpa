package com.app.inventory.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping({ "/admin" })
public class ProductController {

	@Autowired
	ProductDao prodao;

	@Autowired
	MeasureDao meadao;

	@Autowired
	CategoryDao catdao;

	@RequestMapping({ "/ProdWEB" })
	public String ListUser(Model modelo) {

		modelo.addAttribute("Product", prodao.EncontrarProduct());

		List<Category> lstcat = catdao.EncontrarCategory();
		modelo.addAttribute("Category", lstcat);

		List<Measure> lstmed = meadao.EncontrarMeasure();
		modelo.addAttribute("Measure", lstmed);

		return "ProdWEB";
	}

	@GetMapping("/jsonProd")
	public ResponseEntity<Map<String, Object>> allState() {
		List<Product> lstprod = prodao.EncontrarProduct();
		Map<String, Object> respon = new HashMap<String, Object>();
		respon.put("data", lstprod);
		return new ResponseEntity<>(respon, HttpStatus.OK);
	}

	@RequestMapping({ "/getOneProduct" })
	@ResponseBody
	public Optional<Product> getOne(Long id_prod) {
		return prodao.getOne(id_prod);
	}

	@PostMapping({ "/Productcrear" })
	public String create(Product product) {
		try {
			this.prodao.create(product);
			return "redirect:/admin/ProdWEB?exito";
		} catch (Exception e) {
			return "redirect:/admin/ProdWEB?fallo";
		}
	}

	@RequestMapping(value = "/Productupdate", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Product product) {
		try {
		this.prodao.update(product);
		return "redirect:/admin/ProdWEB?exitoUp";
		
		} catch (Exception e) {
			return "redirect:/admin/ProdWEB?falloUp";
		}
	}

	@RequestMapping(value = "/Productdelete", method = { RequestMethod.PUT, RequestMethod.GET })
	public String delete(Long id_prod) {

		try {
		Product prod = prodao.finById(id_prod);
		prod.setEst("Inactivo");

		this.prodao.delete(prod);
		return "redirect:/admin/ProdWEB?exitoDe";
		
		} catch (Exception e) {
			return "redirect:/admin/ProdWEB?falloDe";
		}
	}

}
