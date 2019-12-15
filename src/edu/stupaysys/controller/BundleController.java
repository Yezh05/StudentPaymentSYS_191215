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

import edu.stupaysys.po.Bundle;
import edu.stupaysys.po.BundleExample;
import edu.stupaysys.service.BundleService;

@Controller
public class BundleController  {
	@Autowired
	private BundleService bundleService;
	@RequestMapping(value = "/findallbundle")
	public String HandleFindallBundle(Model model, HttpSession session) {
		BundleExample bundleExample = new BundleExample();
		List<Bundle> list = this.bundleService.findAllBundle(bundleExample);
		String JSON_list = (new Gson()).toJson(list);
		model.addAttribute("list", JSON_list);
		
		Map<String, String> keynamemap = new HashMap<String, String> ();
		keynamemap.put("bundleid", "套餐号");
		keynamemap.put("bundlename", "套餐名");
		keynamemap.put("bundlevalidtime", "套餐有效期(月)");
		keynamemap.put("bundlestate", "套餐状态");
		keynamemap.put("bundleprice", "套餐价格(￥)");
		keynamemap.put("bundleinfo", "套餐说明");
		String JSON_keynamemap = (new Gson()).toJson(keynamemap);
		model.addAttribute("keynamemap", JSON_keynamemap);
		
		return "manager";
	}
	@RequestMapping(value = "/delonebundle",produces = "application/json; charset=utf-8")
	@ResponseBody
	public int HandleDelOneUser(@RequestParam("trdata") String trdata) {
		System.out.println(trdata);
		Map datamap = new HashMap();
		datamap = (new Gson()).fromJson(trdata, Map.class);
				Integer key =Integer.parseInt( (String) datamap.get("bundleid"));
		int influnce_row = 0;
		try {
			influnce_row =	this.bundleService.delOneBundle(key);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return influnce_row;
		}
	@RequestMapping(value = "/updateonebundle",produces = "application/json; charset=utf-8")
	@ResponseBody
	public int HandleUpdateOneBundle(@RequestParam("mes") String mes) {
		System.out.println(mes);
		Bundle newbundle = (new Gson()).fromJson(mes, Bundle.class);
		System.out.println(newbundle.toString());
		int influnce_row = 0;
		try {
			influnce_row =	this.bundleService.updateOneBundle(newbundle);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return influnce_row;
	}
	@RequestMapping(value = "/addonebundle",produces = "application/json; charset=utf-8")
	@ResponseBody
	public int HandleaddOneBundle(@RequestParam("mes") String mes) {
		System.out.println(mes);
		Bundle newbundle = (new Gson()).fromJson(mes, Bundle.class);
		System.out.println(newbundle.toString());
		int influnce_row = 0;
		try {
			influnce_row =	this.bundleService.addOneBundle(newbundle);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return influnce_row;
	}
}
