/**
 * 
 */
package com.swu.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.swu.dto.User;
import com.swu.service.LoginService;
import com.swu.util.PrintUtil;
import com.swu.util.SendEmail2;

/**
 * 
 * @Title: LoginAction
 * @package com.swu.actions
 * @Description: TODO
 * @author ljuenan@linewell
 * @date 2016-2-27 下午6:30:46
 * @version V1.0
 */
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = -3995536422356298450L;
	
	private String code;
	private User user;
	/**
	 * 
	 * 功能：登录功能
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-2-28 下午10:58:25
	 * @param
	 * @return
	 *
	 */
	public String login(){
		//申明返回值
	    Object data = new Object();
		
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		try {
			//业务逻辑处理
			data = LoginService.loginService(request, data, code, user);
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
	 * 功能：注册功能
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-2-28 下午11:30:51
	 * @param
	 * @return
	 *
	 */
	public String register(){
		//申明返回值
	    Object data = new Object();
		
		HttpServletResponse response = ServletActionContext.getResponse();		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		try {
			//业务逻辑处理
			data = LoginService.registerService(data, user);
			
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
	 * 功能：找回密码
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-2-29 下午8:57:17
	 * @param
	 * @return
	 *
	 */
	public String findPwd(){
		//申明返回值
	    Object data = new Object();
		
		HttpServletResponse response = ServletActionContext.getResponse();		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		try {
			//业务逻辑处理
			data = LoginService.findPwd(data, user);
			
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
	 * 功能：修改用户信息
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-2-29 下午8:58:28
	 * @param
	 * @return
	 *
	 */
	public String updateUser(){
		//申明返回值
	    Object data = new Object();
		
		HttpServletResponse response = ServletActionContext.getResponse();		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		try {
			//业务逻辑处理
			data = LoginService.updateUser(data, user);
			
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
	 * 
	 * 功能：校验注册用户名是否存在
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-17 上午8:48:44
	 * @param
	 * @return
	 *
	 */
	public String checkUser(){
		//申明返回值
	    Object data = new Object();
	    HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		try {
			//业务逻辑处理
			String userName = request.getParameter("userName");
			data = LoginService.checkUser(userName);
			
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
	 * 
	 * 功能：获取用户问题和答案
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-17 上午8:49:02
	 * @param
	 * @return
	 *
	 */
	public String getUserByName(){
		//申明返回值
	    Object data = new Object();
	    Object randomPwd = new Object();
	    HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		try {
			//业务逻辑处理
			String userName = request.getParameter("userName");
			data = LoginService.getUserByName(userName);
			randomPwd = LoginService.getRandomPwd();
			 //返回值
			JSONObject result = new JSONObject();
			result.put("data", data);
			result.put("randomPwd", randomPwd);
			PrintUtil.print(response, result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 
	 * 
	 * 功能：发邮件
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-17 上午11:45:28
	 * @param
	 * @return
	 *
	 */
	public String sendEmail(){
		//申明返回值
	    Object data = new Object();
	    HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		try {
			//业务逻辑处理
			String email = request.getParameter("email");
			String randomPwd = request.getParameter("randomPwd");
			boolean flag = SendEmail2.sendEmail2(email,randomPwd);
			if(flag){
				data="*随机密码已发送至您的邮箱";
			}else{
				data="*邮件发送失败，请刷新页面";
			}
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
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

}
