package com.app.inventory.facade;

import java.util.List;
import java.util.Optional;
import com.app.inventory.Dto.OrderDTO;
import com.app.inventory.model.Order;

public interface IOrder {

	public List<Order> EncontrarOrder();
	public Optional<Order> getOne(int id_ped);
	public Order finById(int id_ped);
	public void create(Order order);
	public void update(Order order);
	public void delete(Order order);
	public Order guardar(OrderDTO orderDTO);
	
}
