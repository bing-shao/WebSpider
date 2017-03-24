package com.swu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.swu.dao.BaseDAO;
import com.swu.dao.CallBack;
import com.swu.dao.DAOHelper;
import com.swu.dto.URLFavorite;

public class FavoriteURLDAOimpl implements BaseDAO {

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
	 * 功能：删除收藏夹记录表
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-15 下午3:14:51
	 * @param
	 * @return
	 *
	 */
	public boolean deleteList(String unid ,String userUnid){
		String sql = "delete from DESIGN_WEBPAGE where WEBPAGE_UNID =? and WEBPAGE_USER =?";
		Object[] params = {unid,userUnid}; 
		return DAOHelper.executeUpdate(sql, params);
	}
	
	public boolean updateRemark(String unid,String remark ,String userUnid){
		String sql = "update  DESIGN_WEBPAGE set WEBPAGE_REMARK =? where WEBPAGE_UNID =? and WEBPAGE_USER =?";
		Object[] params = {remark,unid,userUnid}; 
		return DAOHelper.executeUpdate(sql, params);
		
	}
	/**
	 * 
	 * 
	 * 功能：分页查询总数
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-15 下午1:53:59
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
	 * @since 2016-3-15 下午1:54:21
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
						URLFavorite urlFavorite = new URLFavorite();
						urlFavorite.setWEBPAGE_CREATE_TIME(rs.getString("WEBPAGE_CREATE_TIME"));
						urlFavorite.setWEBPAGE_REMARK(rs.getString("WEBPAGE_REMARK"));
						urlFavorite.setWEBPAGE_UNID(rs.getString("WEBPAGE_UNID"));
						urlFavorite.setWEBPAGE_URL(rs.getString("WEBPAGE_URL"));
						urlFavorite.setWEBPAGE_USER(rs.getString("WEBPAGE_USER"));
						list.add(urlFavorite);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
		});
	}

}
