package com.swu.service;

import com.swu.dao.impl.EfficiencyURLDAOimpl;

/**
 * 
 * @Title: EfficiencyURLService
 * @package com.swu.service
 * @Description: EfficiencyURLService逻辑处理
 * @author ljuenan@linewell
 * @date 2016-3-14 下午8:32:33
 * @version V1.0
 */
public class EfficiencyURLService {
	/**
	 * 
	 * 功能：获取饼图
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-14 下午8:55:25
	 * @param
	 * @return
	 *
	 */
	public static Object getPie(String userUnid){
		Object data = null;
		EfficiencyURLDAOimpl dao = new EfficiencyURLDAOimpl();
		data = dao.serchByCondition(userUnid);
		return data;
	}
	
	/**
	 * 
	 * 功能：获取柱状图
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-14 下午9:30:00
	 * @param
	 * @return
	 *
	 */
	public static Object Histogram(String userUnid){
		Object data = null;
		EfficiencyURLDAOimpl dao = new EfficiencyURLDAOimpl();
		data = dao.queryHistogram(userUnid);
		return data;
	}
	/**
	 * 
	 * 
	 * 功能：获取折线图
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-15 上午10:29:40
	 * @param
	 * @return
	 *
	 */
	public static Object Polygram(String userUnid){
		Object data = null;
		EfficiencyURLDAOimpl dao = new EfficiencyURLDAOimpl();
		data = dao.queryPolygram(userUnid);
		return data;
	}
	

}
