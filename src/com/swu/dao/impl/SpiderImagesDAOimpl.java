package com.swu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.swu.dao.BaseDAO;
import com.swu.dao.CallBack;
import com.swu.dao.DAOHelper;
import com.swu.dto.ImagesFavorite;
import com.swu.dto.SpiderImages;
import com.swu.dto.Stat;
import com.swu.dto.URLFavorite;

public class SpiderImagesDAOimpl implements BaseDAO {
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
		SpiderImages spiderImage = (SpiderImages) obj;
		String sql = "insert into DESIGN_TEMP_IMAGES " +
				"(IMAGES_UNID,IMAGES_URL,IMAGES_TYPE,IMAGES_SOURCE,IMAGES_DEPTH,IMAGES_CRAWL,IMAGES_USER,IMAGES_THREAD)" +
				"values(?,?,?,?,?,?,?,?)";
		Object[] params = {spiderImage.getIMAGES_UNID(),spiderImage.getIMAGES_URL(),
				   spiderImage.getIMAGES_TYPE(),spiderImage.getIMAGES_SOURCE(),spiderImage.getIMAGES_DEPTH(),
				   spiderImage.getIMAGES_CRAWL(),spiderImage.getIMAGES_USER(),spiderImage.getIMAGES_THREAD()};
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
		String sql = "insert into DESIGN_STATIMAGES " +
				"(STATIMAGES_UNID,STATIMAGES_USER,STATIMAGES_TOTALNUM,STATIMAGES_TOTALTIME,STATIMAGES_CREATTIME)" +
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
		String sql = "update DESIGN_TEMP_IMAGES set IMAGES_STATE = ? where " +
					 " IMAGES_CRAWL=(select max(IMAGES_CRAWL) from DESIGN_TEMP_IMAGES where IMAGES_USER=?) ";
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
	 * 功能：收藏Images
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-13 下午4:57:53
	 * @param
	 * @return
	 *
	 */
	public boolean addImagesFavorite(Object obj) {
		ImagesFavorite imagesFavorite = (ImagesFavorite) obj;
		String sql = "insert into DESIGN_IMAGES " +
					 "(IMAGES_UNID,IMAGES_URL,IMAGES_CREAT_TIME,IMAGES_REMARK,IMAGES_USER,IMAGES_TYPE,IMAGES_SOURCE) " +
					 "values (?,?,?,?,?,?,?)";
		Object[] params ={imagesFavorite.getIMAGES_UNID(),imagesFavorite.getIMAGES_URL(),imagesFavorite.getIMAGES_CREAT_TIME(),
						  imagesFavorite.getIMAGES_REMARK(),imagesFavorite.getIMAGES_USER(),imagesFavorite.getIMAGES_TYPE(),
						  imagesFavorite.getIMAGES_SOURCE()};
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
						SpiderImages spiderImages = new SpiderImages();
						spiderImages.setIMAGES_UNID(rs.getString("IMAGES_UNID"));
						spiderImages.setIMAGES_CRAWL(rs.getString("IMAGES_CRAWL"));
						spiderImages.setIMAGES_DEPTH(rs.getString("IMAGES_DEPTH"));
						spiderImages.setIMAGES_SOURCE(rs.getString("IMAGES_SOURCE"));
						spiderImages.setIMAGES_THREAD(rs.getString("IMAGES_THREAD"));
						spiderImages.setIMAGES_URL(rs.getString("IMAGES_URL"));
						spiderImages.setIMAGES_USER(rs.getString("IMAGES_USER"));
						spiderImages.setIMAGES_TYPE(rs.getString("IMAGES_TYPE"));
						list.add(spiderImages);
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
		String sql = "select IMAGES_UNID from DESIGN_TEMP_IMAGES where IMAGES_STATE=? and IMAGES_USER=?";
		Object[] params = {"end",userUnid};
		return DAOHelper.executeQuery(sql, params, new CallBack() {
			public List<Object> getResults(ResultSet rs) {
				List<Object> list = new ArrayList<Object>();
				try {
					while (rs.next()) {
						list.add(rs.getString("IMAGES_UNID"));
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
	 * 功能：删除URL临时表记录
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
	/**
	 * 
	 * 
	 * 功能：删除IMAGES临时表记录
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-15 下午3:12:41
	 * @param
	 * @return
	 *
	 */
	public boolean delTempImages(String userUnid) {
		String sql="delete from DESIGN_TEMP_IMAGES where IMAGES_USER = ?";
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
