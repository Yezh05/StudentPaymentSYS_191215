package edu.stupaysys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.stupaysys.dao.CustomerMapper;
import edu.stupaysys.po.Customer;
import edu.stupaysys.po.CustomerExample;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerMapper customerMapper;  
	@Override
	public List<Customer> findAllCustomer(CustomerExample customerExample) {
		// TODO 自动生成的方法存根
		List<Customer> datalist = this.customerMapper.selectByExample(customerExample);
		return datalist;
	}
	@Override
	public int delOneCustomer(Integer key) {
		int influnce_row = this.customerMapper.deleteByPrimaryKey(key);
		return influnce_row;
	}
	@Override
	public int updateOneCustomer(Customer customer) {
		int influnce_row = this.customerMapper.updateByPrimaryKey(customer);
		return influnce_row;
	}
	@Override
	public int addOneCustomer(Customer customer) {
		int influnce_row = this.customerMapper.insert(customer);
		return influnce_row;
	}
	@Override
	public Customer findCustomerById(Integer key) {
		Customer customer = this.customerMapper.selectByPrimaryKey(key);	
		return customer;
	}
	@Override
	public int findMaxKey() {
		Integer maxkey = this.customerMapper.selectMaxKey();
		return maxkey;
	}

}
