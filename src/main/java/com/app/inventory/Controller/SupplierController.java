package com.app.inventory.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.inventory.facadeimp.SupplierDao;
import com.app.inventory.model.Supplier;

@Controller
@RequestMapping({"/admin"})
public class SupplierController {

	@Autowired
	public SupplierDao supplierdao;
	
	@RequestMapping({"/SupplierWEB"})
	public String ListProveedor(Model model) {
		model.addAttribute("Supplier", supplierdao.EncontrarSupplier());
		return "SupplierWEB";
	}
	
	@RequestMapping({"/getOne"})
	@ResponseBody
	public Optional<Supplier> getOne(Long id_Proveedor) {
		return supplierdao.getOne(id_Proveedor);
	}
	
	@PostMapping({"/SupplierCrear"})
	public String create(Supplier supplier) {
		
		try {
		supplierdao.create(supplier);
		return "redirect:/admin/SupplierWEB?exito";
		} catch (Exception e) {
			return "redirect:/admin/SupplierWEB?fallo";
		}
	}
	
	@RequestMapping(value="/SupplierUpdate", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Supplier supplier) {
		try {
		
		supplierdao.update(supplier);
		return "redirect:/admin/SupplierWEB?exitoUp";
		
		} catch (Exception e) {
			return "redirect:/admin/SupplierWEB?falloUp";
		}
		
	}
	
	@RequestMapping(value="/SupplierDelete", method = {RequestMethod.PUT, RequestMethod.GET})
	public String delete(Long id_Proveedor) {
		
		try {
		
		Supplier sup = supplierdao.finById(id_Proveedor);
		sup.setEst("Inactivo");
		
		this.supplierdao.delete(sup);
		return "redirect:/admin/SupplierWEB?exitoDe";
		
		} catch (Exception e) {
			return "redirect:/admin/SupplierWEB?exitoDe";
		}
		
	}
	
}
