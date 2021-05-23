package com.xyy.interceptor;

import com.xyy.po.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String url=request.getRequestURI();
		if(url.indexOf("Login")!=-1||url.indexOf("login")!=-1) {
			return true;
		}
		if(url.indexOf("Skip")!=-1||url.indexOf("skip")!=-1) {
			return true;
		}
		if(url.indexOf("Index")!=-1||url.indexOf("index")!=-1) {
			return true;
		}
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("login_user");
		if(user!=null) {
			return true;
		}
		request.setAttribute("msg", "您还没有登录，请先登录");
		request.getRequestDispatcher("/skip").forward(request, response);
		return false;
	}

}
