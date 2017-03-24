package com.swu.dto;

public class URLFavorite {
	private String WEBPAGE_UNID;		//存储的网页unid
	private String WEBPAGE_URL;			//存储的网页url
	private String WEBPAGE_CREATE_TIME;//存储的网页创建时间
	private String WEBPAGE_REMARK;		//存储的网页备注
	private String WEBPAGE_USER;		//所属用户
	/**
	 * @return the wEBPAGE_UNID
	 */
	public String getWEBPAGE_UNID() {
		return WEBPAGE_UNID;
	}
	/**
	 * @param wEBPAGE_UNID 
	 *				the wEBPAGE_UNID to set
	 */
	public void setWEBPAGE_UNID(String wEBPAGE_UNID) {
		WEBPAGE_UNID = wEBPAGE_UNID;
	}
	/**
	 * @return the wEBPAGE_URL
	 */
	public String getWEBPAGE_URL() {
		return WEBPAGE_URL;
	}
	/**
	 * @param wEBPAGE_URL 
	 *				the wEBPAGE_URL to set
	 */
	public void setWEBPAGE_URL(String wEBPAGE_URL) {
		WEBPAGE_URL = wEBPAGE_URL;
	}
	/**
	 * @return the wEBPAGE_CREATE_TIME
	 */
	public String getWEBPAGE_CREATE_TIME() {
		return WEBPAGE_CREATE_TIME;
	}
	/**
	 * @param wEBPAGE_CREATE_TIME 
	 *				the wEBPAGE_CREATE_TIME to set
	 */
	public void setWEBPAGE_CREATE_TIME(String wEBPAGE_CREATE_TIME) {
		WEBPAGE_CREATE_TIME = wEBPAGE_CREATE_TIME;
	}
	/**
	 * @return the wEBPAGE_REMARK
	 */
	public String getWEBPAGE_REMARK() {
		return WEBPAGE_REMARK;
	}
	/**
	 * @param wEBPAGE_REMARK 
	 *				the wEBPAGE_REMARK to set
	 */
	public void setWEBPAGE_REMARK(String wEBPAGE_REMARK) {
		WEBPAGE_REMARK = wEBPAGE_REMARK;
	}
	/**
	 * @return the wEBPAGE_USER
	 */
	public String getWEBPAGE_USER() {
		return WEBPAGE_USER;
	}
	/**
	 * @param wEBPAGE_USER 
	 *				the wEBPAGE_USER to set
	 */
	public void setWEBPAGE_USER(String wEBPAGE_USER) {
		WEBPAGE_USER = wEBPAGE_USER;
	}
	/**
	 * 功能：toString
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-13 下午4:51:07
	 * @param
	 * @return
	 *
	 */
	@Override
	public String toString() {
		return "URLFavorite [WEBPAGE_UNID=" + WEBPAGE_UNID + ", WEBPAGE_URL=" + WEBPAGE_URL + ", WEBPAGE_CREATE_TIME="
				+ WEBPAGE_CREATE_TIME + ", WEBPAGE_REMARK=" + WEBPAGE_REMARK + ", WEBPAGE_USER=" + WEBPAGE_USER
				+ ", getWEBPAGE_UNID()=" + getWEBPAGE_UNID() + ", getWEBPAGE_URL()=" + getWEBPAGE_URL()
				+ ", getWEBPAGE_CREATE_TIME()=" + getWEBPAGE_CREATE_TIME() + ", getWEBPAGE_REMARK()="
				+ getWEBPAGE_REMARK() + ", getWEBPAGE_USER()=" + getWEBPAGE_USER() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
