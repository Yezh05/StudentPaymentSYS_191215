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

import edu.stupaysys.po.User;
import edu.stupaysys.po.UserExample;
import edu.stupaysys.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/findalluser")
	public String HandleFindUser(Model model, HttpSession session) {
		UserExample userExample = new UserExample();
		List<User> userslist =this.userService.findAllUser(userExample);
		Gson gson = new Gson();
		String Json_userlist = gson.toJson(userslist);
		/*System.out.println(Json_userlist);*/
		model.addAttribute("list", Json_userlist);

		Map<String, String> keynamemap = new HashMap<String, String> ();
		keynamemap.put("userid", "用户号");
		keynamemap.put("username", "用户名");
		keynamemap.put("userpassword", "用户密码");
		keynamemap.put("userlimit", "用户权限");
		keynamemap.put("userstate", "用户状态");
		String JSON_keynamemap = (new Gson()).toJson(keynamemap);
		model.addAttribute("keynamemap", JSON_keynamemap);
		
		return "manager";
	}
	@RequestMapping(value = "/deloneuser",produces = "application/json; charset=utf-8")
	@ResponseBody
	public int HandleDelOneUser(@RequestParam("trdata") String trdata) {
		System.out.println(trdata);
		Map datamap = new HashMap();
		datamap = (new Gson()).fromJson(trdata, Map.class);
				Integer key =Integer.parseInt( (String) datamap.get("userid"));
		int influnce_row = 0;
		try {
			influnce_row =	this.userService.delOneUser(key);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return influnce_row;
		}
	@RequestMapping(value = "/updateoneuser",produces = "application/json; charset=utf-8")
	@ResponseBody
	public int HandleUpdateOneUser(@RequestParam("mes") String mes) {
		System.out.println(mes);
		User newuser = (new Gson()).fromJson(mes, User.class);
		System.out.println(newuser.toString());
		int influnce_row = 0;
		try {
			influnce_row =	this.userService.updateOneUser(newuser);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return influnce_row;
	}
	@RequestMapping(value = "/addoneuser",produces = "application/json; charset=utf-8")
	@ResponseBody
	public int HandleAddOneUser(@RequestParam("mes") String mes) {
		System.out.println(mes);
		User newuser = (new Gson()).fromJson(mes, User.class);
		System.out.println(newuser.toString());
		int influnce_row = 0;
		try {
			influnce_row =	this.userService.addOneUser(newuser);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return influnce_row;
	}
}
