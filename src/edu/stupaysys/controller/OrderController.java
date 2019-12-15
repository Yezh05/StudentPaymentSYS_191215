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

import edu.stupaysys.po.Order;
import edu.stupaysys.po.OrderExample;
import edu.stupaysys.service.OrderService;

@Controller
public class OrderController  {
	@Autowired
	private OrderService orderService;
	@RequestMapping(value = "/findallorder")
	public String HandleFindallOrder(Model model, HttpSession session) {
		OrderExample orderExample = new OrderExample();
		List<Order> list = this.orderService.findAllOrder(orderExample);
		String JSON_list = (new Gson()).toJson(list);
		model.addAttribute("list", JSON_list);
		
		Map<String, String> keynamemap = new HashMap<String, String> ();
		keynamemap.put("orderid", "订单号");
		keynamemap.put("ordercustid", "下单客户号");
		keynamemap.put("orderbundleid", "套餐号");
		keynamemap.put("ordercreateuserid", "订单创建人号");
		keynamemap.put("ordercreatetime", "订单创建时间");
		keynamemap.put("orderpaytime", "订单支付时间");
		keynamemap.put("orderstate", "订单状态");
		String JSON_keynamemap = (new Gson()).toJson(keynamemap);
		model.addAttribute("keynamemap", JSON_keynamemap);
		
		return "manager";
	}
	@RequestMapping(value = "/deloneorder",produces = "application/json; charset=utf-8")
	@ResponseBody
	public int HandleDelOneUser(@RequestParam("trdata") String trdata) {
		System.out.println(trdata);
		Map datamap = new HashMap();
		datamap = (new Gson()).fromJson(trdata, Map.class);
				Integer key =Integer.parseInt( (String) datamap.get("orderid"));
		int influnce_row = 0;
		try {
			influnce_row =	this.orderService.delOneOrder(key);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return influnce_row;
		}
	@RequestMapping(value = "/updateoneorder",produces = "application/json; charset=utf-8")
	@ResponseBody
	public int HandleUpdateOneOrder(@RequestParam("mes") String mes) {
		System.out.println(mes);
		Order neworder = (new Gson()).fromJson(mes, Order.class);
		System.out.println(neworder.toString());
		int influnce_row = 0;
		try {
			influnce_row =	this.orderService.updateOneOrder(neworder);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return influnce_row;
	}
	@RequestMapping(value = "/addoneorder",produces = "application/json; charset=utf-8")
	@ResponseBody
	public int HandleAddOneOrder(@RequestParam("mes") String mes) {
		System.out.println(mes);
		Order neworder = (new Gson()).fromJson(mes, Order.class);
		System.out.println(neworder.toString());
		int influnce_row = 0;
		try {
			influnce_row =	this.orderService.addOneOrder(neworder);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return influnce_row;
	}
}
