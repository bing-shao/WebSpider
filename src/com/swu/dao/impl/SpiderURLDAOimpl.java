package com.swu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.swu.dao.BaseDAO;
import com.swu.dao.CallBack;
import com.swu.dao.DAOHelper;
import com.swu.dto.SpiderURL;
import com.swu.dto.Stat;
import com.swu.dto.URLFavorite;

public class SpiderURLDAOimpl implements BaseDAO {
	/**
	 * 
	 * 功能：插入临时网址记录表
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-13 上午12:12:53
	 * @param
	 * @return
	 *
	 */
	public boolean add(Object obj) {
		SpiderURL spiderUrl = (SpiderURL) obj;
		String sql = "insert into DESIGN_TEMP_WEBPAGE " +
				"(WEBPAGE_UNID,WEBPAGE_URL,WEBPAGE_DEPTH,WEBPAGE_CRAWL,WEBPAGE_USER,WEBPAGE_FLAG,WEBPAGE_THREAD)" +
				"values(?,?,?,?,?,?,?)";
		Object[] params = {spiderUrl.getWebpage_unid(),spiderUrl.getWebpage_url(),spiderUrl.getWebpage_depth(),
						   spiderUrl.getWebpage_crawl(),spiderUrl.getWebpage_user(),spiderUrl.getWebpage_flag(),
						   spiderUrl.getWebpage_thread()};
		return DAOHelper.executeUpdate(sql, params);
	}
	/**
	 * 
	 * 功能：插入统计表
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-13 上午12:13:18
	 * @param
	 * @return
	 *
	 */
	public boolean addStatUrl(Object obj) {
		Stat statUrl = (Stat) obj;
		String sql = "insert into DESIGN_STATURL " +
				"(STATURL_UNID,STATURL_USER,STATURL_TOTALNUM,STATURL_TOTALTIME,STATURL_CREATTIME)" +
				"values(?,?,?,?,?)";
		Object[] params = {statUrl.getSTATURL_UNID(),statUrl.getSTATURL_USER(),statUrl.getSTATURL_TOTALNUM(),
						   statUrl.getSTATURL_TOTALTIME(),statUrl.getSTATURL_CREATTIME()};
		return DAOHelper.executeUpdate(sql, params);
	}
	/**
	 * 
	 * 功能：修改最后插入的数据的状态为end
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-13 下午4:41:41
	 * @param
	 * @return
	 *
	 */
	public boolean update(Object obj,String userUnid) {
		String state = (String) obj;
		String sql = "update DESIGN_TEMP_WEBPAGE set WEBPAGE_STATE = ? where " +
					 " WEBPAGE_CRAWL=(select max(WEBPAGE_CRAWL) from DESIGN_TEMP_WEBPAGE where WEBPAGE_USER = ?) ";
		Object[] params ={state,userUnid};
		return DAOHelper.executeUpdate(sql, params);
	}
	/**
	 * 
	 * 功能：收藏URL
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-13 下午4:57:53
	 * @param
	 * @return
	 *
	 */
	public boolean addURLFavorite(Object obj) {
		URLFavorite urlFavorite = (URLFavorite) obj;
		String sql = "insert into DESIGN_WEBPAGE " +
					 "(WEBPAGE_UNID,WEBPAGE_URL,WEBPAGE_CREATE_TIME,WEBPAGE_REMARK,WEBPAGE_USER) " +
					 "values (?,?,?,?,?)";
		Object[] params ={urlFavorite.getWEBPAGE_UNID(),urlFavorite.getWEBPAGE_URL(),urlFavorite.getWEBPAGE_CREATE_TIME(),
						  urlFavorite.getWEBPAGE_REMARK(),urlFavorite.getWEBPAGE_USER()};
		return DAOHelper.executeUpdate(sql, params);
	}

	/**
	 * 
	 * 功能：分页总数统计
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-13 下午5:52:25
	 * @params
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
	 * 功能：分页条件查询
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-13 下午6:41:35
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
						SpiderURL spiderURL = new SpiderURL();
						spiderURL.setWebpage_unid(rs.getString("webpage_unid"));
						spiderURL.setWebpage_crawl(rs.getString("webpage_crawl"));
						spiderURL.setWebpage_depth(rs.getString("webpage_depth"));
						spiderURL.setWebpage_flag(rs.getString("webpage_flag"));
						spiderURL.setWebpage_thread(rs.getString("webpage_thread"));
						spiderURL.setWebpage_url(rs.getString("webpage_url"));
						spiderURL.setWebpage_user(rs.getString("webpage_user"));
						list.add(spiderURL);
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
	 * 功能：检查使用
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-13 下午6:45:38
	 * @param
	 * @return
	 *
	 */
	public List<Object> queryCheck(String userUnid) {
		String sql = "select WEBPAGE_UNID from DESIGN_TEMP_WEBPAGE where WEBPAGE_STATE=? and WEBPAGE_USER= ?";
		Object[] params = {"end",userUnid};
		return DAOHelper.executeQuery(sql, params, new CallBack() {
			public List<Object> getResults(ResultSet rs) {
				List<Object> list = new ArrayList<Object>();
				try {
					while (rs.next()) {
						list.add(rs.getString("WEBPAGE_UNID"));
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
	 * 功能：删除临时表记录
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-15 下午3:12:41
	 * @param
	 * @return
	 *
	 */
	public boolean delTemp(String userUnid) {
		String sql="delete from DESIGN_TEMP_WEBPAGE where WEBPAGE_USER = ?";
		Object[] params = {userUnid};
		return DAOHelper.executeUpdate(sql, params);
	}
	public boolean del(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean update(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
