package com.swu.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.swu.dto.User;
import com.swu.service.EfficiencyImagesService;
import com.swu.util.PrintUtil;

public class EfficiencyImagesAction extends ActionSupport{
	//序列号
	private static final long serialVersionUID = 199561546427712522L;
	/**
	 * 
	 * 
	 * 功能：Images本次效能分析
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-18 下午10:42:50
	 * @param
	 * @return
	 *
	 */
	public String efficiencyImages(){
		//获取request和response对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		//设置编码格式
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		//定义返回值
		Object data = null;
		//定义标识
		String fn = request.getParameter("fn");
		//从session中获取user
		User user =  (User) request.getSession().getAttribute("user");
		//获取用户编号
		String userUnid = user.getUser_unid();
		
		
		
		//记录每个线程效率比较
		if("Histogram".equals(fn)){
			data = EfficiencyImagesService.Histogram(userUnid);
		}
		//记录每个时间点抓取个数
		else if("Polygram".equals(fn)){
			data = EfficiencyImagesService.Polygram(userUnid);
		}
		
		 //返回值
		JSONObject result = new JSONObject();
		result.put("data", data);
		PrintUtil.print(response, result);
		
        return null;
	}
}
