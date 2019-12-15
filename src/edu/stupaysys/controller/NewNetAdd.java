package edu.stupaysys.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import edu.stupaysys.po.Bundle;
import edu.stupaysys.po.BundleExample;
import edu.stupaysys.po.Customer;
import edu.stupaysys.po.CustomerExample;
import edu.stupaysys.po.Order;
import edu.stupaysys.po.User;
import edu.stupaysys.service.BundleService;
import edu.stupaysys.service.CustomerService;
import edu.stupaysys.service.OrderService;
import edu.stupaysys.service.UserService;

@Controller
public class NewNetAdd {
	@Autowired
	private UserService userService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private BundleService bundleService;
	@Autowired
	private OrderService orderService;
	
	Date createdate = new Date();
	
	@RequestMapping(value = "/newnetadd")
	public String HandleToPage(){
		return "newnetadd";
	}
	@RequestMapping(value = "/getNeedinfo",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String GetNeedInfo() {	
		createdate = new Date();
		List<Bundle> bundle_list =this.bundleService.findAllBundle(new BundleExample());
		int newKey = this.customerService.findMaxKey()+1;
		Map datamap = new HashMap<>();
		datamap.put("newKey", newKey);
		datamap.put("bundle_list", bundle_list);
		String JSON_list = (new Gson()).toJson(datamap);
		return JSON_list;
	}
	@RequestMapping(value = "/handleaddnew",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String HandleAddNew(@RequestParam("newdatamap") String JSON_newdatamap) {
		Date paytime = new Date();
		Map indatamap = (new Gson()).fromJson(JSON_newdatamap,HashMap.class);
		System.out.println(indatamap);
		System.out.println(indatamap.get("custid"));
		int influnce_order_row = 0;int influnce_user_row = 0;int influnce_cust_row = 0;
		/*try {*/
			User newuser = new User();
			newuser.setUserid(Integer.parseInt((String)indatamap.get("custid")));
			newuser.setUsername((String) indatamap.get("custname"));
			newuser.setUserpassword("123456");
			newuser.setUserlimit("3");
			newuser.setUserstate("1");
			influnce_user_row = this.userService.addOneUser(newuser);
			
			Order neworder = new Order();
			neworder.setOrderid(Integer.parseInt((String)indatamap.get("orderid")));
			neworder.setOrdercustid(Integer.parseInt((String)indatamap.get("custid")));
			neworder.setOrderbundleid(Integer.parseInt((String) indatamap.get("bundleid")));
			neworder.setOrdercreateuserid(Integer.parseInt((String) indatamap.get("custcreateid")));
			neworder.setOrdercreatetime(createdate);
			neworder.setOrderpaytime(paytime);
			neworder.setOrderstate(1);
			influnce_order_row = this.orderService.addOneOrder(neworder);
			
			Bundle needbundle = this.bundleService.findBundleById(Integer.parseInt((String)indatamap.get("bundleid")));
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(paytime); 
			calendar.add(calendar.MONTH, needbundle.getBundlevalidtime());
			Date validdate=calendar.getTime();
			
			Customer newcustomer = new Customer();
			newcustomer.setCustid(Integer.parseInt((String)indatamap.get("custid")));
			newcustomer.setCustname((String) indatamap.get("custname"));
			newcustomer.setCustcreateid(Integer.parseInt((String)indatamap.get("custcreateid")));
			newcustomer.setCustdor((String) indatamap.get("custdor"));
			newcustomer.setCustphone((String) indatamap.get("custphone"));
			newcustomer.setCustcreatedate(createdate);
			newcustomer.setCustbundleid(Integer.parseInt((String) indatamap.get("bundleid")));
			newcustomer.setCustnetvaliddate(validdate);
			influnce_cust_row = this.customerService.addOneCustomer(newcustomer);
			
		/*} catch (Exception e) {
			System.out.println(e.toString());
		}*/
		
		Map returndatamap = new HashMap<>();
		if(influnce_cust_row==0||influnce_order_row==0||influnce_user_row==0){
			returndatamap.put("mes", "出现错误");
		}else{
			returndatamap.put("mes", "开户成功");
		}
		String JSON_list = (new Gson()).toJson(returndatamap);
		return JSON_list;
	}
}
