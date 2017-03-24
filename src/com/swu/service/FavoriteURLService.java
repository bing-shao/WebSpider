package com.swu.service;

import java.util.List;

import com.swu.dao.impl.FavoriteURLDAOimpl;
import com.swu.dto.URLFavorite;

public class FavoriteURLService {
	/**
	 * 
	 * 
	 * 功能：收藏夹的分页查询
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-15 下午3:04:59
	 * @param
	 * @return
	 *
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<URLFavorite> queryURL(String condition,String currPage,String userUnid){
		FavoriteURLDAOimpl daoimpl = new FavoriteURLDAOimpl();
		String sql = "";
		if("".equals(condition)){
			sql = "select t.* from " +
				  "(select ROWNUM as r,s.* from " +
				  "(select * from DESIGN_WEBPAGE where  WEBPAGE_USER = '"+userUnid+"' " +
				  " order by WEBPAGE_CREATE_TIME desc)s) t " +
				  " where t.r>'"+Integer.parseInt(currPage)*12+"' and t.r<='"+(Integer.parseInt(currPage)+1)*12+"'";
		}else{
			sql = "select t.* from " +
				  "(select ROWNUM as r,s.* from " +
				  "(select * from DESIGN_WEBPAGE  where  WEBPAGE_USER = '"+userUnid+"' " +
				  " and WEBPAGE_URL like '%"+condition+"%'" +
				  " order by WEBPAGE_CREATE_TIME desc)s) t " +
				  " where t.r>'"+Integer.parseInt(currPage)*12+"' and t.r<'"+(Integer.parseInt(currPage)+1)*12+"'";
		}
		List<URLFavorite> urlList = (List)daoimpl.serchByCondition(sql);
		return urlList;
	}
	/**
	 * 
	 * 
	 * 功能：收藏夹总记录数查询
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-15 下午3:05:15
	 * @param
	 * @return
	 *
	 */
	public static Object queryCount(String condition,String userUnid){
		FavoriteURLDAOimpl daoimpl = new FavoriteURLDAOimpl();
		String sql = "";
		if("".equals(condition)){
			sql = "select count(WEBPAGE_UNID) as total from DESIGN_WEBPAGE where  WEBPAGE_USER = '"+userUnid+"'";
		}else{
			sql = "select count(WEBPAGE_UNID)as total from DESIGN_WEBPAGE where   WEBPAGE_USER = '"+userUnid+"' and  WEBPAGE_URL like '%"+condition+"%'";
		}
		int size = (Integer) daoimpl.queryCount(sql).get(0);
		return size;
	}
	/**
	 * 
	 * 
	 * 功能：删除收藏夹
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-15 下午5:00:17
	 * @param
	 * @return
	 *
	 */
	public static String deleteList(String unid ,String userUnid){
		String data = "";
		FavoriteURLDAOimpl daoimpl = new FavoriteURLDAOimpl();
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
	 * @since 2016-3-15 下午5:04:08
	 * @param
	 * @return
	 *
	 */
	public static String updateRemark(String unid,String remark ,String userUnid){
		String data = "";
		FavoriteURLDAOimpl daoimpl = new FavoriteURLDAOimpl();
		boolean result = daoimpl.updateRemark(unid,remark,userUnid);
		if(result==true){
			data = "修改成功";
		}else{
			data = "修改失败";
		}
		return data;
	}
}
