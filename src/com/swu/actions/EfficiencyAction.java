package com.swu.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.swu.dto.User;
import com.swu.service.EfficiencyService;
import com.swu.util.PrintUtil;
/**
 * 
 * 
 * @Title: EfficiencyAction
 * @package: com.swu.actions
 * @Description: 效率分析
 * @author ljuenan@linewell
 * @date 2016-3-15 下午9:29:48
 * @version V1.0
 */
public class EfficiencyAction extends ActionSupport{
	
	private static final long serialVersionUID = -4228819855752932940L;
	/**
	 * 
	 * 
	 * 功能：效率分析
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-15 下午9:30:44
	 * @param
	 * @return
	 *
	 */
	public String efficiency(){
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
		if("queryURL".equals(fn)){
			//查询url数据
			data = EfficiencyService.queryURL(userUnid);
		}else if("queryImage".equals(fn)){
			//查询image数据
			data = EfficiencyService.queryImage(userUnid);
		}
		 //返回值
		JSONObject result = new JSONObject();
		result.put("data", data);
		PrintUtil.print(response, result);
		
        return null;
	}
}
