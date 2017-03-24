package com.swu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.swu.dao.BaseDAO;
import com.swu.dao.CallBack;
import com.swu.dao.DAOHelper;
import com.swu.dto.Stat;

public class EfficiencyDAOimpl implements BaseDAO{

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

	public List<Object> serchByCondition(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 
	 * 
	 * 功能：url抓取总效率
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-19 上午1:02:09
	 * @param
	 * @return
	 *
	 */
	public List<Object> queryURL(String userUnid){
		String sql = "select * from DESIGN_STATURL where STATURL_USER=? order by STATURL_CREATTIME";
		Object[] params = {userUnid};
		return DAOHelper.executeQuery(sql, params, new CallBack() {
			public List<Object> getResults(ResultSet rs) {
				List<Object> list = new ArrayList<Object>();
				try {
					while (rs.next()) {
						Stat stat  = new Stat();
						stat.setSTATURL_CREATTIME(rs.getString("STATURL_CREATTIME"));
						stat.setSTATURL_TOTALNUM(rs.getString("STATURL_TOTALNUM"));
						stat.setSTATURL_TOTALTIME(rs.getString("STATURL_TOTALTIME"));
						stat.setSTATURL_UNID(rs.getString("STATURL_UNID"));
						stat.setSTATURL_USER(rs.getString("STATURL_USER"));
						list.add(stat);
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
	 * 功能：images抓取总效率
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-19 上午1:02:24
	 * @param
	 * @return
	 *
	 */
	public List<Object> queryImage(String userUnid){
		String sql = "select * from DESIGN_STATIMAGES where STATIMAGES_USER=? order by STATIMAGES_CREATTIME";
		Object[] params = {userUnid};
		return DAOHelper.executeQuery(sql, params, new CallBack() {
			public List<Object> getResults(ResultSet rs) {
				List<Object> list = new ArrayList<Object>();
				try {
					while (rs.next()) {
						Stat stat  = new Stat();
						stat.setSTATURL_CREATTIME(rs.getString("STATIMAGES_CREATTIME"));
						stat.setSTATURL_TOTALNUM(rs.getString("STATIMAGES_TOTALNUM"));
						stat.setSTATURL_TOTALTIME(rs.getString("STATIMAGES_TOTALTIME"));
						stat.setSTATURL_UNID(rs.getString("STATIMAGES_UNID"));
						stat.setSTATURL_USER(rs.getString("STATIMAGES_USER"));
						list.add(stat);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
		});
}
}
