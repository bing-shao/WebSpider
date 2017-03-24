package com.swu.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.swu.dto.User;
import com.swu.service.EfficiencyURLService;
import com.swu.util.PrintUtil;

/**
 * 
 * @Title: EfficiencyURLAction
 * @package com.swu.actions
 * @Description: TODO
 * @author ljuenan@linewell
 * @date 2016-3-14 下午8:27:02
 * @version V1.0
 */
public class EfficiencyURLAction extends ActionSupport{
	
	private static final long serialVersionUID = 6751736277895202370L;
	/**
	 * 
	 * 功能：URL本次效率分析
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-14 下午8:27:09
	 * @param
	 * @return
	 *
	 */
	public String efficiencyURL(){
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
		
		
		//记录网页爬行成功数与失败数
		if("Pie_char".equals(fn)){
			data = EfficiencyURLService.getPie(userUnid);
		}
		//记录每个线程效率比较
		else if("Histogram".equals(fn)){
			data = EfficiencyURLService.Histogram(userUnid);
		}
		//记录每个时间点抓取个数
		else if("Polygram".equals(fn)){
			data = EfficiencyURLService.Polygram(userUnid);
		}
		
		 //返回值
		JSONObject result = new JSONObject();
		result.put("data", data);
		PrintUtil.print(response, result);
		
        return null;
	}
}
