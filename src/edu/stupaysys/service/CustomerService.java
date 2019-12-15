package edu.stupaysys.service;

import java.util.List;

import edu.stupaysys.po.Customer;
import edu.stupaysys.po.CustomerExample;

public interface CustomerService {
	public List<Customer> findAllCustomer(CustomerExample customerExample);
	public int delOneCustomer(Integer key) ;
	public int updateOneCustomer(Customer customer);
	public int addOneCustomer(Customer customer);
	public Customer findCustomerById(Integer key);
	public int findMaxKey();
}
