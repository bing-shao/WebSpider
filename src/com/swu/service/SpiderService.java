package com.swu.service;

import java.util.List;

import com.swu.dao.impl.SpiderImagesDAOimpl;
import com.swu.dao.impl.SpiderURLDAOimpl;
import com.swu.dto.ImagesFavorite;
import com.swu.dto.SpiderImages;
import com.swu.dto.SpiderURL;
import com.swu.dto.URLFavorite;
import com.swu.util.TimeUtil;
import com.swu.util.UNIDGenerate;

public class SpiderService {
	/**
	 * 
	 * 功能：分页查询临时表
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-13 下午9:02:10
	 * @param
	 * @return
	 *
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<SpiderURL> queryURL(String condition,String currPage,String userUnid){
		SpiderURLDAOimpl daoimpl = new SpiderURLDAOimpl();
		String sql = "";
		if("".equals(condition)){
			sql = "select t.* from " +
				  "(select ROWNUM as r,s.* from " +
				  "(select * from DESIGN_TEMP_WEBPAGE where WEBPAGE_FLAG = 'true' and  WEBPAGE_USER = '"+userUnid+"' " +
				  " order by WEBPAGE_CRAWL desc)s) t " +
				  " where t.r>'"+Integer.parseInt(currPage)*12+"' and t.r<='"+(Integer.parseInt(currPage)+1)*12+"'";
		}else{
			sql = "select t.* from " +
				  "(select ROWNUM as r,s.* from " +
				  "(select * from DESIGN_TEMP_WEBPAGE  where WEBPAGE_FLAG = 'true' and  WEBPAGE_USER = '"+userUnid+"' " +
				  " and WEBPAGE_URL like '%"+condition+"%'" +
				  " order by WEBPAGE_CRAWL desc)s) t " +
				  " where t.r>'"+Integer.parseInt(currPage)*12+"' and t.r<'"+(Integer.parseInt(currPage)+1)*12+"'";
		}
		List<SpiderURL> urlList = (List)daoimpl.serchByCondition(sql);
		return urlList;
	}
	/**
	 * 
	 * 功能：查询总记录数
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-13 下午9:02:27
	 * @param
	 * @return
	 *
	 */
	public static Object queryCount(String condition,String userUnid){
		SpiderURLDAOimpl daoimpl = new SpiderURLDAOimpl();
		String sql = "";
		if("".equals(condition)){
			sql = "select count(WEBPAGE_UNID) as total from DESIGN_TEMP_WEBPAGE where WEBPAGE_FLAG = 'true' and WEBPAGE_USER = '"+userUnid+"'";
		}else{
			sql = "select count(WEBPAGE_UNID)as total from DESIGN_TEMP_WEBPAGE where  WEBPAGE_FLAG = 'true' and WEBPAGE_USER = '"+userUnid+"' and  WEBPAGE_URL like '%"+condition+"%'";
		}
		int size = (Integer) daoimpl.queryCount(sql).get(0);
		return size;
	}
	
	
	/**
	 * 
	 * 功能：图片分页查询临时表
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-13 下午9:02:10
	 * @param
	 * @return
	 *
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<SpiderImages> queryImages(String condition,String currPage,String userUnid){
		SpiderImagesDAOimpl daoimpl = new SpiderImagesDAOimpl();
		String sql = "";
		if("".equals(condition)){
			sql = "select t.* from " +
				  "(select ROWNUM as r,s.* from " +
				  "(select * from DESIGN_TEMP_IMAGES where  IMAGES_USER = '"+userUnid+"' " +
				  " order by IMAGES_CRAWL desc)s) t " +
				  " where t.r>'"+Integer.parseInt(currPage)*12+"' and t.r<='"+(Integer.parseInt(currPage)+1)*12+"'";
		}else{
			sql = "select t.* from " +
				  "(select ROWNUM as r,s.* from " +
				  "(select * from DESIGN_TEMP_IMAGES  where IMAGES_USER = '"+userUnid+"' " +
				  " and IMAGES_URL like '%"+condition+"%'" +
				  " order by IMAGES_CRAWL desc)s) t " +
				  " where t.r>'"+Integer.parseInt(currPage)*12+"' and t.r<'"+(Integer.parseInt(currPage)+1)*12+"'";
		}
		List<SpiderImages> ImagesList = (List)daoimpl.serchByCondition(sql);
		return ImagesList;
	}
	/**
	 * 
	 * 功能：图片查询总记录数
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-13 下午9:02:27
	 * @param
	 * @return
	 *
	 */
	public static Object queryCountImages(String condition,String userUnid){
		SpiderImagesDAOimpl daoimpl = new SpiderImagesDAOimpl();
		String sql = "";
		if("".equals(condition)){
			sql = "select count(IMAGES_UNID) as total from DESIGN_TEMP_IMAGES where IMAGES_USER = '"+userUnid+"'";
		}else{
			sql = "select count(IMAGES_UNID)as total from DESIGN_TEMP_IMAGES where   IMAGES_USER = '"+userUnid+"' and  IMAGES_URL like '%"+condition+"%'";
		}
		int size = (Integer) daoimpl.queryCount(sql).get(0);
		return size;
	}
	
	
	/**
	 * 
	 * 功能：添加URL到收藏夹逻辑处理
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-13 下午4:37:42
	 * @param
	 * @return
	 *
	 */
	public static String addURLFavorite(String webpageURL,String User){
		String data="";
		SpiderURLDAOimpl daoimpl = new SpiderURLDAOimpl();
		URLFavorite urlFavorite = new URLFavorite();
		urlFavorite.setWEBPAGE_UNID(new UNIDGenerate().getUnid());
		urlFavorite.setWEBPAGE_URL(webpageURL);
		urlFavorite.setWEBPAGE_CREATE_TIME(TimeUtil.getNowTime());
		urlFavorite.setWEBPAGE_REMARK("暂无信息");
		urlFavorite.setWEBPAGE_USER(User);
		boolean flag = daoimpl.addURLFavorite(urlFavorite);
		if(flag==true){
			data="收藏成功！";
		}else{
			data="收藏失败，请重新尝试！";
		}
		return data;
	}
	
	/**
	 * 
	 * 功能：添加Images到收藏夹逻辑处理
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-13 下午4:37:42
	 * @param
	 * @return
	 *
	 */
	public static String addImagesFavorite(String imagesURL,String userUnid,String type,String source){
		String data="";
		SpiderImagesDAOimpl daoimpl = new SpiderImagesDAOimpl();
		ImagesFavorite imagesFavorite = new ImagesFavorite();
		imagesFavorite.setIMAGES_UNID(new UNIDGenerate().getUnid());
		imagesFavorite.setIMAGES_URL(imagesURL);
		imagesFavorite.setIMAGES_CREAT_TIME(TimeUtil.getNowTime());
		imagesFavorite.setIMAGES_REMARK("暂无信息");
		imagesFavorite.setIMAGES_USER(userUnid);
		imagesFavorite.setIMAGES_TYPE(type);
		imagesFavorite.setIMAGES_SOURCE(source);
		boolean flag = daoimpl.addImagesFavorite(imagesFavorite);
		if(flag==true){
			data="收藏成功！";
		}else{
			data="收藏失败，请重新尝试！";
		}
		return data;
	}
	/**
	 * 
	 * 功能：检查当前状态
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-13 下午9:02:44
	 * @param
	 * @return
	 *
	 */
	public static String check(String userUnid){
		String data = "";
		SpiderURLDAOimpl daoimpl = new SpiderURLDAOimpl();
		List<Object> list = daoimpl.queryCheck(userUnid);
		if(list.size() > 0){
			data="当前处于未抓取状态！";
		}else{
			data="当前处于抓取状态或无数据状态";
		}
		return data;
	}
	/**
	 * 
	 * 功能：检查Images当前状态
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-13 下午9:02:44
	 * @param
	 * @return
	 *
	 */
	public static String checkImages(String userUnid){
		String data = "";
		SpiderImagesDAOimpl daoimpl = new SpiderImagesDAOimpl();
		List<Object> list = daoimpl.queryCheck(userUnid);
		if(list.size() > 0){
			data="当前处于未抓取状态！";
		}else{
			data="当前处于抓取状态或无数据状态";
		}
		return data;
	}
	/**
	 * 
	 * 功能：删除URL临时表记录
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-13 下午9:08:41
	 * @param
	 * @return
	 *
	 */
	public static void delTemp(String userUnid){
		
		SpiderURLDAOimpl daoimpl = new SpiderURLDAOimpl();
		daoimpl.delTemp(userUnid);
	}
	
	/**
	 * 
	 * 功能：删除IMAGES临时表记录
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-13 下午9:08:41
	 * @param
	 * @return
	 *
	 */
	public static void delTempImages(String userUnid){
		
		SpiderImagesDAOimpl daoimpl = new SpiderImagesDAOimpl();
		daoimpl.delTempImages(userUnid);
	}
}
