package edu.stupaysys.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.stupaysys.po.User;
import edu.stupaysys.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String toLogin() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String toLogin(Integer userid,String userpassword, Model model, HttpSession session) {
		
		User user = null;
		try {
			user =this.userService.findUserById(userid);
			} catch (Exception e) {
				System.out.println("发生错误+"+e.toString());
			model.addAttribute("msg", "发生错误，请重试。");
		}
		
		/*System.out.println(user.getUserid()+" "+user.getUserpassword());
		System.out.println(userid+" "+userpassword);*/
		if(user!=null){		
		if (userid != null && userid.equals(user.getUserid()) && userpassword != null && userpassword.equals(user.getUserpassword())) {
			session.setAttribute("USER_SESSION", user);
			return "redirect:main";
		}}
		model.addAttribute("msg", "用户账号或密码错误，请重新输入。");
		return "login";
	}
	/*@RequestMapping(value="/main")
	public String toMain() {
		return "main";
	}*/
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
	/*public User findOneUserById(String UserId) {
		SqlSession session = MybatisUtils.getSession();
		User Result_user = session.selectOne("edu.sys.mapper.Mapper.findOneUserById",UserId);
		System.out.println(Result_user);
		return Result_user;
	}*/
	/*public User findOneUserById(String UserId) {
		
	}*/
}
