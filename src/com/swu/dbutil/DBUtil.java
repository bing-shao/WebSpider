package com.swu.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * 数据库操作
 * 
 */
public class DBUtil {

	/**
	 * 数据库驱动类名称
	 */
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";

	/**
	 * 创建数据库连接对象
	 */
	private static Connection connnection = null;

	/**
	 * 创建PreparedStatement对象
	 */

	static {
		try {
			// 加载数据库驱动程序
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动错误");
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 建立数据库连接
	 * 
	 * @return 数据库连接
	 */
	public static Connection getConnection() {
		try {
			// 获取连接
			connnection = DriverManager.getConnection("proxool.DBPool");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return connnection;
	}

}
