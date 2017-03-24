package com.swu.service;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import com.swu.dao.impl.UserDAOimpl;
import com.swu.dto.User;
import com.swu.util.TimeUtil;
import com.swu.util.UNIDGenerate;

/**
 * 登录相关业务逻辑处理
 * @Title: LoginService
 * @package com.swu.service
 * @Description: TODO
 * @author ljuenan@linewell
 * @date 2016-2-28 下午11:09:03
 * @version V1.0
 */
public class LoginService {
	/**
	 * 
	 * 功能：登录逻辑处理
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-2-28 下午11:08:47
	 * @param
	 * @return
	 *
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object loginService(HttpServletRequest request,Object data,String code,User user){
		// 获取验证码，验证是否正确	
		if (request.getSession().getAttribute("code") == null
				|| !request.getSession().getAttribute("code").toString().equals(code)) {
			data="验证码错误，请重新输入";
		}else if(user != null){
			// 判断是否存在该用户
			UserDAOimpl userDao = new UserDAOimpl();
			List<Object> userList = (List)userDao.serchByCondition(user);
			if (userList.size() <= 0) {
				data="用户名密码错误，请重新输入！";
			}else{
				request.getSession().setAttribute("user", userList.get(0));
				User user1 = (User) userList.get(0);
				SpiderService.delTemp(user1.getUser_unid());
				SpiderService.delTempImages(user1.getUser_unid());
				data = null;
			}
		}
		return data;
	}
	
	/**
	 * 
	 * 功能：注册功能业务逻辑处理
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-2-29 下午8:59:05
	 * @param
	 * @return
	 *
	 */
	public static Object registerService(Object data,User user){
		if(user != null){
			//给user添加unid和创建时间
			user.setUser_unid(new UNIDGenerate().getUnid());
			user.setUser_time(TimeUtil.getNowTime());
			
			UserDAOimpl userDao = new UserDAOimpl();
			data = userDao.add(user);
		}
		return data;
	}
	
	/**
	 * 
	 * 功能：找回密码功能业务逻辑
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-2-29 下午9:04:41
	 * @param
	 * @return
	 *
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object findPwd(Object data,User user){
		if(user != null){
			 UserDAOimpl userDao = new UserDAOimpl();
			 List<String> result = (List)userDao.serchByCondition(user);
			 if(result.size()>=0){
				 data=result.get(0);
			 }
		}
		return data;
	}
	
	/**
	 * 
	 * 功能：账户信息修改（重置）
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-2-29 下午9:15:49
	 * @param
	 * @return
	 *
	 */
	public static Object updateUser(Object data,User user){
		if(user !=null){
			UserDAOimpl userDao = new UserDAOimpl();
			data = userDao.update(user);
		}
		return data;
	}
	/**
	 * 
	 * 
	 * 功能：判断用户名是否存在
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-16 上午11:46:47
	 * @param
	 * @return
	 *
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object checkUser(String userName){
		Object data = null;	
		UserDAOimpl userDao = new UserDAOimpl();
		List<Object> list = (List)userDao.checkUser(userName);
		if(list.size()>0){
			data = "*用户名已存在";
		}else{
			data = "";
		}
		return data;
	}
	/**
	 * 
	 * 
	 * 功能：获取密保问题和答案
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-17 上午8:51:04
	 * @param
	 * @return
	 *
	 */
	public static Object getUserByName(String userName){
		Object data = null;	
		UserDAOimpl userDao = new UserDAOimpl();
		data = userDao.getUserByName(userName);
		return data;
	}
	/**
	 * 
	 * 
	 * 功能：生成随机6位数密码
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-17 上午11:24:16
	 * @param
	 * @return
	 *
	 */
	public static String getRandomPwd(){
		int randomInt = new Random().nextInt(999999);
		String randomPwd = String.valueOf(randomInt);	
		int strLen = randomPwd.length();
		int len = 6-strLen;
		String str = "";
		for(int i= 0;i<len;i++){
			str += "0";
		}
		return str + randomPwd;
	}
	
}
