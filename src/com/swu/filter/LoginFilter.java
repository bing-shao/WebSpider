package com.swu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {

	private String[] passlist;

	public void init(FilterConfig config) throws ServletException {
		passlist = config.getInitParameter("passlist").split(",");
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException,
			ServletException {

		// 获取request对象
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");

		// 获取客户端请求的资源路径
		String uri = request.getRequestURI();
		// 获取请求资源
		int index = uri.lastIndexOf("/");
		String source = uri.substring(index + 1);
		boolean f = false;// 设置页面被拦截(不放行)
		for (String s : passlist) {
			// 判断当前请求的页面是否在被放行列表之内
			if (s.trim().equals(source)) {
				f = true;// 标记为true(放行)
			}
		}

		// 对指定页面放行
		if (f) {
			chain.doFilter(req, resp);
		} else {
			// 获取session的内容(判断是否登陆)
			Object obj = request.getSession().getAttribute("user");
			if (obj == null) {
				// 未登录

				request.setAttribute("msg", "请先登录");

				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				chain.doFilter(req, resp);
			}
		}
	}

	public void destroy() {

	}
}