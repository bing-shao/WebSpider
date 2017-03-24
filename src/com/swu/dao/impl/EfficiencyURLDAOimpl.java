package com.swu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.swu.dao.BaseDAO;
import com.swu.dao.CallBack;
import com.swu.dao.DAOHelper;
import com.swu.dto.Pie;

public class EfficiencyURLDAOimpl implements BaseDAO {

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
	 * 功能：饼图数据查找
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-14 下午8:38:59
	 * @param userUnid
	 * @return List
	 *
	 */
	public List<Object> serchByCondition(Object obj) {
		String userUnid = (String) obj;
		String sql = "select " +
					 "sum(case when WEBPAGE_FLAG = 'true' then 1 else 0 end) as numT, " +
					 "sum(case when WEBPAGE_FLAG = 'false' then 1 else 0 end) as numF " +
					 "from DESIGN_TEMP_WEBPAGE " +
					 "where WEBPAGE_USER = ?";
		Object params[] = {userUnid};
		return DAOHelper.executeQuery(sql, params, new CallBack() {
			public List<Object> getResults(ResultSet rs) {
				List<Object> list = new ArrayList<Object>();
				try {
					while (rs.next()) {
						Pie pie = new Pie();
						pie.setNumT(rs.getString("numT"));
						pie.setNumF(rs.getString("numF"));
						list.add(pie);
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
	 * 功能：柱状图数据查找
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-14 下午9:30:32
	 * @param
	 * @return
	 *
	 */
	public List<Object> queryHistogram(Object obj) {
		String userUnid = (String) obj;
		String sql = "select  WEBPAGE_THREAD,count(WEBPAGE_UNID) as num from DESIGN_TEMP_WEBPAGE where WEBPAGE_USER = ? group by WEBPAGE_THREAD";
		Object params[] = {userUnid};
		return DAOHelper.executeQuery(sql, params, new CallBack() {
			public List<Object> getResults(ResultSet rs) {
				List<Object> list = new ArrayList<Object>();
				try {
					while (rs.next()) {
						String[] data={rs.getString("WEBPAGE_THREAD"), rs.getString("num")};
						list.add(data);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
		});
	}
	
	public List<Object> queryPolygram(Object obj) {
		String userUnid = (String) obj;
		String sql = "select WEBPAGE_CRAWL ,count(WEBPAGE_UNID) as num from DESIGN_TEMP_WEBPAGE where WEBPAGE_USER = ?  group by WEBPAGE_CRAWL order by WEBPAGE_CRAWL";
		Object params[] = {userUnid};
		return DAOHelper.executeQuery(sql, params, new CallBack() {
			public List<Object> getResults(ResultSet rs) {
				List<Object> list = new ArrayList<Object>();
				try {
					while (rs.next()) {
						String[] data={rs.getString("WEBPAGE_CRAWL"), rs.getString("num")};
						list.add(data);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
		});
	}

}
