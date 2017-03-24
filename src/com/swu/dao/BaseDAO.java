package com.swu.dao;

import java.util.List;

public interface BaseDAO {
	/**
	 * 
	 * 功能：添加
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-2-27 下午6:58:40
	 * @param obj
	 * @return boolean
	 *
	 */
	public boolean add(Object obj);
	/**
	 * 
	 * 功能：修改
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-2-27 下午6:58:53
	 * @param obj
	 * @return boolean
	 *
	 */
	public boolean update(Object obj);
	/**
	 * 
	 * 功能：删除
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-2-27 下午7:00:15
	 * @param obj
	 * @return boolean
	 *
	 */
	public boolean del(Object obj);
	/**
	 * 
	 * 功能： 条件查询List
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-2-27 下午7:00:35
	 * @param obj
	 * @return List
	 *
	 */
	public List<Object> serchByCondition(Object obj);

}
