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

import com.app.inventory.Dto.PurchaseDTO;
import com.app.inventory.facadeimp.ProductDao;
import com.app.inventory.facadeimp.PurchaseDao;
import com.app.inventory.facadeimp.SupplierDao;
import com.app.inventory.model.Product;
import com.app.inventory.model.Purchase;
import com.app.inventory.model.Supplier;

@Controller
@RequestMapping({"/Bodeguero"})
public class PurchaseController {

	@Autowired
	PurchaseDao purdao;
	
	@Autowired
	ProductDao prodao;
	
	@Autowired
	SupplierDao supdao;
	
	@RequestMapping({"/PurchaseWEB"})
	public String ListPurchase(Model model) {
		
		model.addAttribute("Purchase", purdao.EncontrarPurchaseOrder());
		
		List<Product> lstprod = prodao.EncontrarProduct();
		model.addAttribute("Product", lstprod);
		
		List<Supplier> lstSupplier = supdao.EncontrarSupplier();
		model.addAttribute("Supplier", lstSupplier);
		
		return "PurchaseWEB";
		
	}
	
	@RequestMapping({"/getOnePurchase"})
	@ResponseBody
	public Optional<Purchase> getOne(long id_com) {
		return purdao.getOne(id_com);
	}
	
	@PostMapping({"/PurchaseCrear/save"})
	public String create(PurchaseDTO purchasedto) {
		try {
		purdao.guardar(purchasedto);
		
		return "redirect:/Bodeguero/PurchaseWEB?exito";
		
		} catch (Exception e) {
			return "redirect:/Bodeguero/PurchaseWEB?fallo";
		}
	}
	
	@RequestMapping(value="/PurchaseUpdate", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Purchase purchase) {
		purdao.update(purchase);
		return "redirect:/admin/PurchaseWEB";
		
	}
	
}
