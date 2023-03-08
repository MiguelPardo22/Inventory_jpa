package com.app.inventory.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.inventory.Repository.OrderRepository;
import com.app.inventory.model.Order;

@Controller
@RequestMapping({"/mesero"})
public class OrderEstadoController {

	@Autowired
	OrderRepository orderrepo;
	
	@GetMapping({"/OrderPagado"})
	public String ListOrderPagado(Model modelo) {
		
	    List<Order> lstpagado = orderrepo.EstadoPagado();
	    modelo.addAttribute("pagado", lstpagado);
		
		return "OrderPagado";
	}
	
	@GetMapping({"/OrderSinPagar"})
	public String ListOrderSinPagar(Model modelo) {
		
	    List<Order> lstpagado = orderrepo.EstadoSinPagar();
	    modelo.addAttribute("SinPagar", lstpagado);
		
		return "OrderSinPagar";
	}
	
}
