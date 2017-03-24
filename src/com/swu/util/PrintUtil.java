package com.swu.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
/**
 * 打印工具
 * @Title: PrintUtil
 * @package com.swu.util
 * @Description: TODO
 * @author ljuenan@linewell
 * @date 2016-2-28 下午2:57:31
 * @version V1.0
 */
public class PrintUtil {
	/**
	 * 打印字符串
	 * 
	 * @param response
	 * @param obj
	 */
	public static String print(HttpServletResponse response, Object obj) {
		if (obj == null) {
			return null;
		}
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(obj.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
