package com.swu.service;

import com.swu.dao.impl.EfficiencyImagesDAOimpl;

/**
 * 
 * 
 * @Title: EfficiencyImagesService
 * @package: com.swu.service
 * @Description: TODO
 * @author ljuenan@linewell
 * @date 2016-3-18 下午10:47:01
 * @version V1.0
 */
public class EfficiencyImagesService {
	/**
	 * 
	 * 
	 * 功能：获取柱状图
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-18 下午10:45:17
	 * @param
	 * @return
	 *
	 */
	public static Object Histogram(String userUnid){
		Object data = null;
		EfficiencyImagesDAOimpl dao = new EfficiencyImagesDAOimpl();
		data = dao.queryHistogram(userUnid);
		return data;
	}
	/**
	 * 
	 * 
	 * 功能：获取折线图
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-18 下午10:45:28
	 * @param
	 * @return
	 *
	 */
	public static Object Polygram(String userUnid){
		Object data = null;
		EfficiencyImagesDAOimpl dao = new EfficiencyImagesDAOimpl();
		data = dao.queryPolygram(userUnid);
		return data;
	}
}
