package com.app.inventory.Controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.inventory.Dto.PurchaseOrderDTO;
import com.app.inventory.facadeimp.ProductDao;
import com.app.inventory.facadeimp.PurchaseOrderDao;
import com.app.inventory.facadeimp.SupplierDao;
import com.app.inventory.model.Product;
import com.app.inventory.model.Purchaseorder;
import com.app.inventory.model.Supplier;
import com.app.inventory.model.User;

@Controller
@RequestMapping("/admin")
public class PurchaseOrderController {

	@Autowired
	PurchaseOrderDao purchaseorderdao;
	
	@Autowired
	SupplierDao supdao;
	
	@Autowired
	ProductDao prodao;

	
	@RequestMapping({"/PurchaseOrderWEB"})
	public String ListOrderCompra(Model model) {
		model.addAttribute("PurchaseOrder", purchaseorderdao.EncontrarPurchaseOrder());
		
		List<Supplier> lstSupplier = supdao.EncontrarSupplier();
		model.addAttribute("Supplier", lstSupplier);
		
		List<Product> lstProduct = prodao.EncontrarProduct();
		model.addAttribute("Product", lstProduct);
		
		return "PurchaseOrderWEB";
	}
	
	@RequestMapping({"/getOnePurchaseOrder"})
	@ResponseBody
	public Optional<Purchaseorder> getOne(Long id_orden_compra) {
		return purchaseorderdao.getOne(id_orden_compra);
	}
	
    @PostMapping({"/PurchaseOrderCrear/save"})
	public String create(PurchaseOrderDTO purchaseOrderDTO, Model modelo, HttpSession session) {
		purchaseorderdao.guardar(purchaseOrderDTO);
		User us = (User) session.getAttribute("usuario");
		modelo.addAttribute("usuario",us);
		return "redirect:/admin/PurchaseOrderWEB";
	}
    
	
	@RequestMapping(value="/PurchaseOrderUpdate", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Purchaseorder purchaseorder) {
		purchaseorderdao.update(purchaseorder);
		return "redirect:/PurchaseOrderWEB";
	}
	
}
