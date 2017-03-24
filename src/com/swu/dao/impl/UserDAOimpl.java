package com.swu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.swu.dao.BaseDAO;
import com.swu.dao.CallBack;
import com.swu.dao.DAOHelper;
import com.swu.dto.User;

public class UserDAOimpl implements BaseDAO {
	/**
	 * 
	 * 功能：人员注册功能
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-2-28 下午11:31:48
	 * @param
	 * @return
	 *
	 */
	public boolean add(Object obj) {
		User user = (User) obj;
		String sql = "insert into DESIGN_USER " +
				"(USER_UNID,USER_NAME,USER_PWD,USER_SEX,USER_ADR,USER_BIRTH,USER_EMAIL,USER_PHONE,USER_REMARK,USER_QUESTION,USER_ANSWER,USER_TIME)" +
				"values(?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = {user.getUser_unid(),user.getUser_name(),user.getUser_pwd(),
						   user.getUser_sex(),user.getUser_adr(),user.getUser_birth(),
						   user.getUser_email(),user.getUser_phone(),user.getUser_remark(),
						   user.getUser_question(),user.getUser_answer(),user.getUser_time()};
		return DAOHelper.executeUpdate(sql, params);
	}
	/**
	 * 
	 * 功能：用户信息重置
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-2-29 下午9:18:13
	 * @param
	 * @return
	 *
	 */
	public boolean update(Object obj) {
		User user = (User) obj;
		String sql = "update DESIGN_USER set " +
				"USER_PWD=? where USER_UNID=?";
		Object[] params = {user.getUser_pwd(),user.getUser_unid()};
		return DAOHelper.executeUpdate(sql, params);
	}

	public boolean del(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * 
	 * 功能：条件查询user(实现找回密码的验证和登录的验证)
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-2-27 下午11:10:35
	 * @param
	 * @return
	 *
	 */
	
	public List<Object> serchByCondition(Object obj){
		User user = (User) obj;
		String sql;
		Object[] params=null;
		if(user.getUser_pwd()!=null){
			sql = "select * from DESIGN_USER where USER_NAME ='"+user.getUser_name()+"' and USER_PWD ='"+user.getUser_pwd()+"'";
		}else{
			sql = "select * from DESIGN_USER where USER_NAME ='"+user.getUser_name()+
				  "' and USER_QUESTION ='"+user.getUser_question()+
				  "' and USER_ANSWER ="+user.getUser_answer()+"'";
		}
		return DAOHelper.executeQuery(sql, params, new CallBack() {
			public List<Object> getResults(ResultSet rs) {
				List<Object> list = new ArrayList<Object>();
				try {
					while (rs.next()) {
						User user = new User();
						user.setUser_adr(rs.getString("USER_ADR"));
						user.setUser_answer(rs.getString("USER_ANSWER"));
						user.setUser_birth(rs.getString("USER_BIRTH"));
						user.setUser_email(rs.getString("USER_EMAIL"));
						user.setUser_phone(rs.getString("USER_PHONE"));
						user.setUser_pwd(rs.getString("USER_PWD"));
						user.setUser_question(rs.getString("USER_QUESTION"));
						user.setUser_remark(rs.getString("USER_REMARK"));
						user.setUser_time(rs.getString("USER_TIME"));
						user.setUser_sex(rs.getString("USER_SEX"));
						user.setUser_unid(rs.getString("USER_UNID"));
						user.setUser_name(rs.getString("USER_NAME"));
						list.add(user);
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
	 * 功能：注册验证用户名是否存在
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-16 上午11:46:27
	 * @param
	 * @return
	 *
	 */
	public List<Object> checkUser(String userName){
		String sql= "select USER_UNID from DESIGN_USER where USER_NAME =?";
		Object[] params={userName};
		return DAOHelper.executeQuery(sql, params, new CallBack() {
			public List<Object> getResults(ResultSet rs) {
				List<Object> list = new ArrayList<Object>();
				try {
					while (rs.next()) {
						list.add(rs.getString("USER_UNID"));
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
	 * 功能：获取用户密保问题和答案和unid
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-17 上午8:52:38
	 * @param
	 * @return
	 *
	 */
	public List<Object> getUserByName(String userName){
		String sql= "select * from DESIGN_USER where USER_NAME =?";
		Object[] params={userName};
		return DAOHelper.executeQuery(sql, params, new CallBack() {
			public List<Object> getResults(ResultSet rs) {
				List<Object> list = new ArrayList<Object>();
				try {
					while (rs.next()) {
						User user = new User();
						user.setUser_answer(rs.getString("USER_ANSWER"));
						user.setUser_question(rs.getString("USER_QUESTION"));
						user.setUser_unid(rs.getString("USER_UNID"));
						user.setUser_email(rs.getString("USER_EMAIL"));
						list.add(user);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
		});
	}
}
