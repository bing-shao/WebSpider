package com.swu.service;

import com.swu.dao.impl.EfficiencyDAOimpl;


/**
 * 
 * 
 * @Title: EfficiencyService
 * @package: com.swu.service
 * @Description: 效率分析逻辑处理
 * @author ljuenan@linewell
 * @date 2016-3-15 下午9:41:28
 * @version V1.0
 */
public class EfficiencyService {
	/**
	 * 
	 * 
	 * 功能：查找URL统计信息
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-15 下午9:43:09
	 * @param
	 * @return
	 *
	 */
	public static Object queryURL(String userUnid){
		Object data = null;
		EfficiencyDAOimpl dao = new EfficiencyDAOimpl();
		data = dao.queryURL(userUnid);
		return data;
	}
	/**
	 * 
	 * 
	 * 功能：查找图片统计信息
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-15 下午9:43:23
	 * @param
	 * @return
	 *
	 */
	public static Object queryImage(String userUnid){
		Object data = null;
		EfficiencyDAOimpl dao = new EfficiencyDAOimpl();
		data = dao.queryImage(userUnid);
		return data;
	}
}
