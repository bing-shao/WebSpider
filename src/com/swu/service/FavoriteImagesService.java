package com.swu.service;

import java.util.List;

import com.swu.dao.impl.FavoriteImagesDAOimpl;
import com.swu.dto.ImagesFavorite;


/**
 * 
 * 
 * @Title: FavoriteImagesService
 * @package: com.swu.service
 * @Description: 图片收藏夹
 * @author ljuenan@linewell
 * @date 2016-3-18 下午11:31:30
 * @version V1.0
 */
public class FavoriteImagesService {
	/**
	 * 
	 * 
	 * 功能：收藏夹的分页查询
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-18 下午11:33:05
	 * @param
	 * @return
	 *
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<ImagesFavorite> queryImages(String condition,String currPage,String userUnid){
		FavoriteImagesDAOimpl daoimpl = new FavoriteImagesDAOimpl();
		String sql = "";
		if("".equals(condition)){
			sql = "select t.* from " +
				  "(select ROWNUM as r,s.* from " +
				  "(select * from DESIGN_IMAGES where  IMAGES_USER = '"+userUnid+"' " +
				  " order by IMAGES_CREAT_TIME desc)s) t " +
				  " where t.r>'"+Integer.parseInt(currPage)*12+"' and t.r<='"+(Integer.parseInt(currPage)+1)*12+"'";
		}else{
			sql = "select t.* from " +
				  "(select ROWNUM as r,s.* from " +
				  "(select * from DESIGN_IMAGES  where  IMAGES_USER = '"+userUnid+"' " +
				  " and IMAGES_URL like '%"+condition+"%'" +
				  " order by IMAGES_CREAT_TIME desc)s) t " +
				  " where t.r>'"+Integer.parseInt(currPage)*12+"' and t.r<'"+(Integer.parseInt(currPage)+1)*12+"'";
		}
		List<ImagesFavorite> urlList = (List)daoimpl.serchByCondition(sql);
		return urlList;
	}
	/**
	 * 
	 * 
	 * 功能：收藏夹总记录数查询
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-18 下午11:36:02
	 * @param
	 * @return
	 *
	 */
	public static Object queryCount(String condition,String userUnid){
		FavoriteImagesDAOimpl daoimpl = new FavoriteImagesDAOimpl();
		String sql = "";
		if("".equals(condition)){
			sql = "select count(IMAGES_UNID) as total from DESIGN_IMAGES where  IMAGES_USER = '"+userUnid+"'";
		}else{
			sql = "select count(IMAGES_UNID)as total from DESIGN_IMAGES where   IMAGES_USER = '"+userUnid+"' and  IMAGES_URL like '%"+condition+"%'";
		}
		int size = (Integer) daoimpl.queryCount(sql).get(0);
		return size;
	}
	/**
	 * 
	 * 
	 * 功能：删除收藏夹图片
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-18 下午11:35:45
	 * @param
	 * @return
	 *
	 */
	public static String deleteList(String unid ,String userUnid){
		String data = "";
		FavoriteImagesDAOimpl daoimpl = new FavoriteImagesDAOimpl();
		boolean result = daoimpl.deleteList(unid,userUnid);
		if(result==true){
			data = "删除成功";
		}else{
			data = "删除失败";
		}
		return data;
	}
	/**
	 * 
	 * 
	 * 功能：修改功能
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-18 下午11:36:18
	 * @param
	 * @return
	 *
	 */
	public static String updateRemark(String unid,String remark ,String userUnid){
		String data = "";
		FavoriteImagesDAOimpl daoimpl = new FavoriteImagesDAOimpl();
		boolean result = daoimpl.updateRemark(unid,remark,userUnid);
		if(result==true){
			data = "修改成功";
		}else{
			data = "修改失败";
		}
		return data;
	}
}
