package com.swu.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.swu.dto.User;
import com.swu.service.SpiderService;
import com.swu.service.SpiderURLService;
import com.swu.util.PrintUtil;
/**
 * 
 * @Title: SpiderAction
 * @package com.swu.actions
 * @Description: TODO
 * @author ljuenan@linewell
 * @date 2016-3-8 下午9:22:32
 * @version V1.0
 */
public class SpiderAction extends ActionSupport  {

	private static final long serialVersionUID = 1509158633340619972L;
	/**
	 * 
	 * 功能：捕捉URL
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-8 下午9:22:43
	 * @param
	 * @return
	 *
	 */
	public String crawlURL(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		String url=request.getParameter("url");
		int crawDepth  =  Integer.parseInt(request.getParameter("depth")); //爬虫深度  
	    int threadCount = Integer.parseInt(request.getParameter("num")); //线程数量  
		User user =  (User) request.getSession().getAttribute("user");	//从session中获取user
		String userUnid = user.getUser_unid();	//获取use的编号
		//将线程数量存入session
		request.getSession().setAttribute("urlThreadCount",threadCount);
		//在捕捉之前，先删除临时表中的数据
		SpiderService.delTemp(userUnid);
		
		//实例化捕捉的对象,并开始捕捉
		SpiderURLService spiderURLService = new SpiderURLService();   
		spiderURLService.addUrl(url, 0);
        spiderURLService.spider(userUnid,crawDepth,threadCount);
        return null;
	}
	/**
	 * 
	 * 功能：查询临时列表
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-13 下午4:33:06
	 * @param
	 * @return
	 *
	 */
	public String queryURLList(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		Object data = null;
		Object size = null;
		
		try {
			String condition = request.getParameter("condition");
			String currPage = request.getParameter("currPage");
			User user =  (User) request.getSession().getAttribute("user");	//从session中获取user
			String userUnid = user.getUser_unid();	//获取use的编号
			//获取分页的size
			size = SpiderService.queryCount(condition,userUnid);
			data = SpiderService.queryURL(condition,currPage,userUnid);
			
			 //返回值
			JSONObject result = new JSONObject();
			result.put("data", data);
			result.put("size", size);
			PrintUtil.print(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
        return null;
	}
	/**
	 * 
	 * 功能：添加收藏夹
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-13 下午6:36:32
	 * @param
	 * @return
	 *
	 */
	public String favorite(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		Object data = null;
		
		try {
			String webpageURL = request.getParameter("webpage_url");
			User user =  (User) request.getSession().getAttribute("user");	//从session中获取user
			String userUnid = user.getUser_unid();	//获取use的编号
			data = SpiderService.addURLFavorite(webpageURL,userUnid);
			
			 //返回值
			JSONObject result = new JSONObject();
			result.put("data", data);
			PrintUtil.print(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
        return null;
	}
	/**
	 * 
	 * 功能：校验功能
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-13 下午6:38:21
	 * @param
	 * @return
	 *
	 */
	public String check(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		Object data = null;
		
		try {
			User user =  (User) request.getSession().getAttribute("user");	//从session中获取user
			String userUnid = user.getUser_unid();	//获取use的编号
			data = SpiderService.check(userUnid);
			 //返回值
			JSONObject result = new JSONObject();
			result.put("data", data);
			PrintUtil.print(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
	}

}
