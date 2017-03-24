package com.swu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.swu.dao.BaseDAO;
import com.swu.dao.CallBack;
import com.swu.dao.DAOHelper;

/**
 * 
 * 
 * @Title: EfficiencyImagesDAOimpl
 * @package: com.swu.dao.impl
 * @Description: TODO
 * @author ljuenan@linewell
 * @date 2016-3-18 下午10:47:06
 * @version V1.0
 */
public class EfficiencyImagesDAOimpl implements BaseDAO {
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
	 * 功能：柱状图数据查找
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-14 下午9:30:32
	 * @param
	 * @return
	 *
	 */
	public List<Object> queryHistogram(Object obj) {
		String userUnid = (String) obj;
		String sql = "select  IMAGES_THREAD,count(IMAGES_UNID) as num from DESIGN_TEMP_IMAGES where IMAGES_USER = ? group by IMAGES_THREAD";
		Object params[] = {userUnid};
		return DAOHelper.executeQuery(sql, params, new CallBack() {
			public List<Object> getResults(ResultSet rs) {
				List<Object> list = new ArrayList<Object>();
				try {
					while (rs.next()) {
						String[] data={rs.getString("IMAGES_THREAD"), rs.getString("num")};
						list.add(data);
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
	 * 功能：折线图
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-18 下午10:48:24
	 * @param
	 * @return
	 *
	 */
	public List<Object> queryPolygram(Object obj) {
		String userUnid = (String) obj;
		String sql = "select IMAGES_CRAWL ,count(IMAGES_UNID) as num from DESIGN_TEMP_IMAGES where IMAGES_USER = ?  group by IMAGES_CRAWL order by IMAGES_CRAWL";
		Object params[] = {userUnid};
		return DAOHelper.executeQuery(sql, params, new CallBack() {
			public List<Object> getResults(ResultSet rs) {
				List<Object> list = new ArrayList<Object>();
				try {
					while (rs.next()) {
						String[] data={rs.getString("IMAGES_CRAWL"), rs.getString("num")};
						list.add(data);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
		});
	}

	public List<Object> serchByCondition(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
