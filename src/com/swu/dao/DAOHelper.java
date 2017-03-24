package com.swu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.swu.dbutil.DBUtil;

/**
 * 
 * 数据库操作相关的封装类,封装了所有的增删改以及查询的操作
 * 
 * @author Administrator
 * 
 */
public class DAOHelper {

	/**
	 * 封装所有更新的操作(添加,删除,修改)
	 * 
	 * @param conn
	 * @param sql
	 * @param values
	 * @return
	 */
	public static boolean executeUpdate(String sql, Object[] values) {
		PreparedStatement ps = null;
		Connection conn=null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < values.length; i++) {
				ps.setObject(i + 1, values[i]);
			}
			int i = ps.executeUpdate();
			if (i > 0) {

				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null)ps.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * 根据指定sql语句执行相关查询
	 * 
	 * @param sql
	 *            需要执行的sql查询语句
	 * @param values
	 *            执行sql查询时需要的参数值
	 * @param callBack
	 *            回调函数对象:将获取结果的任务以回调的方式交给调用者处理
	 * @return
	 */
	public static List<Object> executeQuery(String sql, Object[] values, CallBack callBack) {
		PreparedStatement ps=null;
		Connection conn=null;
		ResultSet rs=null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			// 当查询条件不为空时,设置查询条件对应的值
			if (values != null) {
				for (int i = 0; i < values.length; i++) {
					ps.setObject(i + 1, values[i]);
				}
			}
			rs = ps.executeQuery();
			return callBack.getResults(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null) rs.close();
				if(ps != null)ps.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
