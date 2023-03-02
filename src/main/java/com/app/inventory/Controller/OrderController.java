package com.app.inventory.Controller;

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
import com.app.inventory.Repository.OrderDetailRepository;
import com.app.inventory.Repository.OrderRepository;
import com.app.inventory.facadeimp.OrderDao;
import com.app.inventory.facadeimp.ProductDao;
import com.app.inventory.facadeimp.UserDao;
import com.app.inventory.model.Order;
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
	
	@Autowired
	OrderRepository orrepo;
	
	@Autowired
	OrderDetailRepository ordetrepo;
	
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
	
	/*@PostMapping({"/OrderCrear/save"})
	public String create(Model modelo, HttpServletRequest request) {	
		ArrayList<OrderDetail> detalles = this.obtenerDetalles(request);
		
		
		Order or = orrepo.save(new Order());
		
		for (OrderDetail ordet : detalles) {
			
			OrderDetail ordet2 = new OrderDetail(ordet.getCant(), ordet.getSub(), or, ordet.getId_prod_fk());
			
			ordetrepo.save(ordet2);
		}
		
		return "redirect:/OrderWEB";
	}*/
	
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
