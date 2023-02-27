package com.app.inventory.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.inventory.Dto.OrderDTO;
import com.app.inventory.Repository.InventoryRepository;
import com.app.inventory.facadeimp.OrderDao;
import com.app.inventory.facadeimp.ProductDao;
import com.app.inventory.facadeimp.UserDao;
import com.app.inventory.model.Inventory;
import com.app.inventory.model.Order;
import com.app.inventory.model.OrderDetail;
import com.app.inventory.model.Product;
import com.app.inventory.model.User;


@Controller
public class OrderController {

	@Autowired
	OrderDao ordao;
	
	@Autowired
	UserDao usdao;
	
	@Autowired
	ProductDao prodao;
	
	@RequestMapping({"/OrderWEB"})
	public String ListOrder(Model modelo) {
		
		modelo.addAttribute("Order", ordao.EncontrarOrder());
		
		List<User> lstuser = usdao.EncontrarUser();
		modelo.addAttribute("User", lstuser);
		
		List<Product> lstprod = prodao.EncontrarProduct();
		modelo.addAttribute("Product", lstprod);
	
		return "OrderWEB";
	}
	
	@RequestMapping({"/getOneOrder"})
	@ResponseBody
	public Optional<Order> getOne(int id_ped) {
		return ordao.getOne(id_ped);
	}
	 
	private ArrayList<OrderDetail> obtenerDetalles(HttpServletRequest request){
		ArrayList<OrderDetail> detalles = (ArrayList<OrderDetail>) request.getAttribute("detalles");
		
		if(detalles == null) {
			
			detalles = new ArrayList<>();
			
		}
		return detalles;
	}
	
	
	@PostMapping({"/OrderCrear/save"})
	public String create(OrderDTO orderDTO, Model modelo, HttpServletRequest request) {	
		ordao.guardar(orderDTO);
		return "redirect:/OrderWEB";
	}
	
	@RequestMapping(value="/OrderUpdate", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Order order) {
		ordao.update(order);
		return "redirect:/OrderWEB";
	}
	
	
	
}
