package edu.stupaysys.controller;

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

import edu.stupaysys.po.Customer;
import edu.stupaysys.po.CustomerExample;
import edu.stupaysys.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService ;
	@RequestMapping(value = "/findallcustomer")
	public String HandleFindallCustomer(Model model, HttpSession session) {
		CustomerExample customerExample = new CustomerExample();
		List<Customer> list = this.customerService.findAllCustomer(customerExample);
		String JSON_list = (new Gson()).toJson(list);
		model.addAttribute("list", JSON_list);
		
		Map<String, String> keynamemap = new HashMap<String, String> ();
		keynamemap.put("custid", "客户号");
		keynamemap.put("custname", "客户名");
		keynamemap.put("custcreateid", "客户创建人号");
		keynamemap.put("custdor", "客户所在宿舍");
		keynamemap.put("custphone", "客户联系电话");
		keynamemap.put("custbundleid", "客户所选套餐");
		keynamemap.put("custnetvaliddate", "客户套餐有效期");
		keynamemap.put("custcreatedate", "客户创建时间");
		String JSON_keynamemap = (new Gson()).toJson(keynamemap);
		model.addAttribute("keynamemap", JSON_keynamemap);
		
		return "manager";
			}
	@RequestMapping(value = "/delonecustomer",produces = "application/json; charset=utf-8")
	@ResponseBody
	public int HandleDelOneUser(@RequestParam("trdata") String trdata) {
		System.out.println(trdata);
		Map datamap = new HashMap();
		datamap = (new Gson()).fromJson(trdata, Map.class);
				Integer key =Integer.parseInt( (String) datamap.get("custid"));
		int influnce_row = 0;
		try {
			influnce_row =	this.customerService.delOneCustomer(key);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return influnce_row;
		}
	@RequestMapping(value = "/updateonecustomer",produces = "application/json; charset=utf-8")
	@ResponseBody
	public int HandleUpdateOneCustomer(@RequestParam("mes") String mes) {
		System.out.println(mes);
		Customer newcustomer = (new Gson()).fromJson(mes, Customer.class);
		System.out.println(newcustomer.toString());
		int influnce_row = 0;
		try {
			influnce_row =	this.customerService.updateOneCustomer(newcustomer);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return influnce_row;
	}
	@RequestMapping(value = "/addonecustomer",produces = "application/json; charset=utf-8")
	@ResponseBody
	public int HandleAddOneCustomer(@RequestParam("mes") String mes) {
		System.out.println(mes);
		Customer newcustomer = (new Gson()).fromJson(mes, Customer.class);
		System.out.println(newcustomer.toString());
		int influnce_row = 0;
		try {
			influnce_row =	this.customerService.addOneCustomer(newcustomer);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
				return influnce_row;
	}
}
