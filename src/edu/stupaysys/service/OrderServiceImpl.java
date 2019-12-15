package edu.stupaysys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.stupaysys.dao.OrderMapper;
import edu.stupaysys.po.Order;
import edu.stupaysys.po.OrderExample;
@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderMapper orderMapper;
	@Override
	public List<Order> findAllOrder(OrderExample orderExample) {
		// TODO 自动生成的方法存根
		List<Order> list = this.orderMapper.selectByExample(orderExample);
		return list;
	}
	@Override
	public int delOneOrder(Integer key) {
		int influnce_row = this.orderMapper.deleteByPrimaryKey(key);
		return influnce_row;
	}
	@Override
	public int updateOneOrder(Order order) {
		int influnce_row = this.orderMapper.updateByPrimaryKey(order);
		return influnce_row;
	}
	@Override
	public int addOneOrder(Order order) {
		int influnce_row = this.orderMapper.insert(order);
		return influnce_row;
	}

}
