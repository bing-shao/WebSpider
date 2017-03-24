/**
 * 
 */
package com.swu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 
 * @Title: EncodeFilter
 * @package com.swu.filter
 * @Description: TODO
 * @author ljuenan@linewell
 * @date 2016-2-27 下午7:11:43
 * @version V1.0
 */
public class EncodeFilter implements Filter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * 功能：编码过滤
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-2-27 下午7:12:45
	 * @param
	 * @return
	 *
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;chartset=utf-8");
		response.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}
}
