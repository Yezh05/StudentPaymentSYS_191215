package edu.stupaysys.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import edu.stupaysys.po.Bundle;
import edu.stupaysys.po.BundleExample;
import edu.stupaysys.po.Customer;
import edu.stupaysys.po.CustomerExample;
import edu.stupaysys.po.Order;
import edu.stupaysys.service.BundleService;
import edu.stupaysys.service.CustomerService;
import edu.stupaysys.service.OrderService;

@Controller
public class NetRenewController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private BundleService bundleService;
	@Autowired
	private OrderService orderService;
	
	Date ordercreatetime = null ;
	
	@RequestMapping(value = "/netrenew")
	public String HandleToNetRenew(Model model, HttpSession session) {
		
		List<Customer> list = this.customerService.findAllCustomer(new CustomerExample());
		
		
		
		String JSON_list = (new Gson()).toJson(list);
		model.addAttribute("list", JSON_list);
		return "netrenew";
	}
	@RequestMapping(value = "/getsomebundleinfo",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String GetSomeBundleInfo(@RequestParam("bundleid") String Str_bundleid) {
		ordercreatetime = new  Date();
		Integer bundleid = 0;
		try {
			bundleid = Integer.parseInt(Str_bundleid);
		} catch (Exception e) {
			System.out.println(e.toString());
			return "502";
		}
		Bundle bundle =this.bundleService.findBundleById(bundleid);
		Map<String, String> datamap = new HashMap<String, String>();
		datamap.put("bundleinfo", bundle.getBundlename());
		datamap.put("bundleprice",  bundle.getBundleprice().toString());
		String JSON_list = (new Gson()).toJson(datamap);
		return JSON_list;
	}
	@RequestMapping(value = "/renewNet",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String ReNewNet(@RequestParam("neworder") String JSON_neworder) {
		System.out.println(JSON_neworder);
		Order neworder = null;
		try {
			neworder = (new Gson()).fromJson(JSON_neworder, Order.class);
			neworder.setOrdercreatetime(ordercreatetime);
			neworder.setOrderpaytime(new Date());
			System.out.println(neworder.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		int influnce_order_row = 0;
		try {
			influnce_order_row = this.orderService.addOneOrder(neworder);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		Customer thiscustomer = this.customerService.findCustomerById(neworder.getOrdercustid());
		Bundle thisbundle =this.bundleService.findBundleById(thiscustomer.getCustbundleid());
		Date validdate = thiscustomer.getCustnetvaliddate();
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(validdate); 
			calendar.add(calendar.MONTH, thisbundle.getBundlevalidtime());
			validdate=calendar.getTime();
		thiscustomer.setCustnetvaliddate(validdate);
		int influnce_customer_row = 0;
		try {
			influnce_customer_row = this.customerService.updateOneCustomer(thiscustomer);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		Map<String, String> datamap = new HashMap<String, String>();
		
		if (influnce_order_row!=0&&influnce_customer_row!=0){
			datamap.put("mes", "续费成功");
			datamap.put("newvaliddate", validdate.toString());
			
		}else{
			datamap.put("mes", "续费失败，出现错误");
			datamap.put("newvaliddate", "续费失败，出现错误");
			
		}
		String JSON_list = (new Gson()).toJson(datamap);
		return JSON_list;
	}
}
