package edu.stupaysys.service;

import java.util.List;

import edu.stupaysys.po.Order;
import edu.stupaysys.po.OrderExample;

public interface OrderService {
	public List<Order> findAllOrder(OrderExample orderExample);
	public int delOneOrder(Integer key) ;
	public int updateOneOrder(Order order) ;
	public int addOneOrder(Order order) ;
	
}
