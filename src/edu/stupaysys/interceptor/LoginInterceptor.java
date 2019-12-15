package edu.stupaysys.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import edu.stupaysys.po.User;


public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO 自动生成的方法存根
		String url = request.getRequestURI();
		if (url.indexOf("/login")>=0) {
			return true;
		}
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("USER_SESSION");
		/*System.out.println("GETUSERSESSION+"+user);*/
		if (user!=null) {
			return true;
		}
		request.setAttribute("msg", "你还没有登录，请重新登录。");
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		return false;
	}

}