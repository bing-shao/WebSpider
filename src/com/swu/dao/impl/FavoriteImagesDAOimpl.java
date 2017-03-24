package com.swu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.swu.dao.BaseDAO;
import com.swu.dao.CallBack;
import com.swu.dao.DAOHelper;
import com.swu.dto.ImagesFavorite;
/**
 * 
 * 
 * @Title: FavoriteImagesDAOimpl
 * @package: com.swu.dao.impl
 * @Description: TODO
 * @author ljuenan@linewell
 * @date 2016-3-18 下午11:37:13
 * @version V1.0
 */
public class FavoriteImagesDAOimpl implements BaseDAO {

	public boolean add(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean del(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * 
	 * 
	 * 功能：删除收藏夹记录表的图片记录
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-18 下午11:38:03
	 * @param
	 * @return
	 *
	 */
	public boolean deleteList(String unid ,String userUnid){
		String sql = "delete from DESIGN_IMAGES where IMAGES_UNID =? and IMAGES_USER =?";
		Object[] params = {unid,userUnid}; 
		return DAOHelper.executeUpdate(sql, params);
	}
	/**
	 * 
	 * 
	 * 功能：修改收藏夹的图片记录
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-18 下午11:38:13
	 * @param
	 * @return
	 *
	 */
	public boolean updateRemark(String unid,String remark ,String userUnid){
		String sql = "update  DESIGN_IMAGES set IMAGES_REMARK =? where IMAGES_UNID =? and IMAGES_USER =?";
		Object[] params = {remark,unid,userUnid}; 
		return DAOHelper.executeUpdate(sql, params);
		
	}
	/**
	 * 
	 * 
	 * 功能：分页查询总数
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-18 下午11:39:24
	 * @param
	 * @return
	 *
	 */
	public List<Object> queryCount(Object obj){
		String sql = (String) obj;
		return DAOHelper.executeQuery(sql, null, new CallBack() {
			public List<Object> getResults(ResultSet rs) {
				List<Object> list = new ArrayList<Object>();
				try {
					while (rs.next()) {
						int count = rs.getInt("total");
						list.add(count);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
		});
		
	}
	/**
	 * 
	 * 
	 * 功能：分页条件查询
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-18 下午11:39:43
	 * @param
	 * @return
	 *
	 */
	public List<Object> serchByCondition(Object obj) {
		String sql = (String) obj;
		return DAOHelper.executeQuery(sql, null, new CallBack() {
			public List<Object> getResults(ResultSet rs) {
				List<Object> list = new ArrayList<Object>();
				try {
					while (rs.next()) {
						ImagesFavorite imagesFavorite = new ImagesFavorite();
						imagesFavorite.setIMAGES_CREAT_TIME(rs.getString("iMAGES_CREAT_TIME"));
						imagesFavorite.setIMAGES_REMARK(rs.getString("iMAGES_REMARK"));
						imagesFavorite.setIMAGES_SOURCE(rs.getString("iMAGES_SOURCE"));
						imagesFavorite.setIMAGES_TYPE(rs.getString("iMAGES_TYPE"));
						imagesFavorite.setIMAGES_UNID(rs.getString("iMAGES_UNID"));
						imagesFavorite.setIMAGES_URL(rs.getString("iMAGES_URL"));
						imagesFavorite.setIMAGES_USER(rs.getString("iMAGES_USER"));
						list.add(imagesFavorite);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
		});
	}


}
