   package com.app.inventory.facadeimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.inventory.Dto.OrderDTO;
import com.app.inventory.Repository.Detalle_OrderCompraRepository;
import com.app.inventory.Repository.InventoryRepository;
import com.app.inventory.Repository.OrderDetailRepository;
import com.app.inventory.Repository.OrderRepository;
import com.app.inventory.facade.IOrder;
import com.app.inventory.model.Inventory;
import com.app.inventory.model.Order;
import com.app.inventory.model.OrderDetail;

@Service
public class OrderDao implements IOrder {

	@Autowired
	OrderRepository orrepo;

	@Autowired
	OrderDetailRepository ordetrepo;

	@Autowired
	InventoryRepository invenrepo;

	@Autowired
	Detalle_OrderCompraRepository detcom;
	
	@Override
	public List<Order> EncontrarOrder() {
		return orrepo.EstadoEnProceso();
	}

	@Override
	public Optional<Order> getOne(int id_Ped) {
		return orrepo.findById(id_Ped);
	}

	@Override
	public Order finById(int id_ped) {
		return orrepo.getReferenceById(id_ped);
	}

	@Override
	public void create(Order order) {
		this.orrepo.save(order);

	}

	@Override
	public void update(Order order) {
		this.orrepo.save(order);
	}

	@Override
	public void delete(Order order) {
		Order or = orrepo.getById((int) order.getId_Ped());
		this.orrepo.save(or);
	}

	@Override
	public Order guardar(OrderDTO orderDTO) {
		
		Order or = new Order(orderDTO.getName_cli(), orderDTO.getTot(),
				orderDTO.getId_usu_fk(), orderDTO.getId_est_fk());

		OrderDetail detor = new OrderDetail();
		detor.setId_ped_fk(or);
		detor.setCant(orderDTO.getCant());
		detor.setId_prod_fk(orderDTO.getId_prod_fk());
		detor.setSub(orderDTO.getSub());

		Inventory inven = new Inventory();
		
		inven.setId_det_ped_fk(detor);
		inven.setExis(- detor.getCant());
		inven.setId_prod_fk(orderDTO.getId_prod_fk());
		
		this.invenrepo.save(inven);
		this.ordetrepo.save(detor);
		return orrepo.save(or);

	}

	public ResponseEntity<String> detalles(Order order) {
		
		try {
			order.setTotal(order.getTotal());
			orrepo.save(order);
			
			for (OrderDetail detor : order.getDetalles()) {
				
				detor.setId_ped_fk(order);
				detor.setSub(detor.getSub());
				ordetrepo.save(detor);
				
				Inventory inven = new Inventory();
				
				inven.setId_det_ped_fk(detor);
				inven.setExis(- detor.getCant());
				inven.setId_prod_fk(detor.getId_prod_fk());
				this.invenrepo.save(inven);
				
		    }			
				return ResponseEntity.ok("Pedido creado correctamente");
			} catch (Exception e) {
				 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el pedido: " + e.getMessage());
			}
		
	}
	
}
