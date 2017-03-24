package com.swu.dto;
/**
 * 
 * 
 * @Title: ImagesFavorite
 * @package: com.swu.dto
 * @Description: TODO
 * @author ljuenan@linewell
 * @date 2016-3-17 下午11:22:39
 * @version V1.0
 */
public class ImagesFavorite {
	private String IMAGES_UNID;			//收藏夹图片编号
	private String IMAGES_URL;			//收藏夹图片地址
	private String IMAGES_REMARK;		//收藏夹图片备注
	private String IMAGES_TYPE;			//收藏夹图片类型
	private String IMAGES_SOURCE;		//收藏夹图片来源
	private String IMAGES_CREAT_TIME;	//收藏夹图片创建时间
	private String IMAGES_USER;			//收藏夹图片所属用户
	/**
	 * @return the iMAGES_UNID
	 */
	public String getIMAGES_UNID() {
		return IMAGES_UNID;
	}
	/**
	 * @param iMAGES_UNID the 
	 *     			iMAGES_UNID to set
	 */
	public void setIMAGES_UNID(String iMAGES_UNID) {
		IMAGES_UNID = iMAGES_UNID;
	}
	/**
	 * @return the iMAGES_URL
	 */
	public String getIMAGES_URL() {
		return IMAGES_URL;
	}
	/**
	 * @param iMAGES_URL the 
	 *     			iMAGES_URL to set
	 */
	public void setIMAGES_URL(String iMAGES_URL) {
		IMAGES_URL = iMAGES_URL;
	}
	/**
	 * @return the iMAGES_REMARK
	 */
	public String getIMAGES_REMARK() {
		return IMAGES_REMARK;
	}
	/**
	 * @param iMAGES_REMARK the 
	 *     			iMAGES_REMARK to set
	 */
	public void setIMAGES_REMARK(String iMAGES_REMARK) {
		IMAGES_REMARK = iMAGES_REMARK;
	}
	/**
	 * @return the iMAGES_TYPE
	 */
	public String getIMAGES_TYPE() {
		return IMAGES_TYPE;
	}
	/**
	 * @param iMAGES_TYPE the 
	 *     			iMAGES_TYPE to set
	 */
	public void setIMAGES_TYPE(String iMAGES_TYPE) {
		IMAGES_TYPE = iMAGES_TYPE;
	}
	/**
	 * @return the iMAGES_SOURCE
	 */
	public String getIMAGES_SOURCE() {
		return IMAGES_SOURCE;
	}
	/**
	 * @param iMAGES_SOURCE the 
	 *     			iMAGES_SOURCE to set
	 */
	public void setIMAGES_SOURCE(String iMAGES_SOURCE) {
		IMAGES_SOURCE = iMAGES_SOURCE;
	}
	/**
	 * @return the iMAGES_CREAT_TIME
	 */
	public String getIMAGES_CREAT_TIME() {
		return IMAGES_CREAT_TIME;
	}
	/**
	 * @param iMAGES_CREAT_TIME the 
	 *     			iMAGES_CREAT_TIME to set
	 */
	public void setIMAGES_CREAT_TIME(String iMAGES_CREAT_TIME) {
		IMAGES_CREAT_TIME = iMAGES_CREAT_TIME;
	}
	/**
	 * @return the iMAGES_USER
	 */
	public String getIMAGES_USER() {
		return IMAGES_USER;
	}
	/**
	 * @param iMAGES_USER the 
	 *     			iMAGES_USER to set
	 */
	public void setIMAGES_USER(String iMAGES_USER) {
		IMAGES_USER = iMAGES_USER;
	}
	/**
	 * 
	 * 功能：toString
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-17 下午11:46:41
	 * @param
	 * @return
	 *
	 */
	@Override
	public String toString() {
		return "ImagesFavorite [IMAGES_UNID=" + IMAGES_UNID + ", IMAGES_URL=" + IMAGES_URL + ", IMAGES_REMARK="
				+ IMAGES_REMARK + ", IMAGES_TYPE=" + IMAGES_TYPE + ", IMAGES_SOURCE=" + IMAGES_SOURCE
				+ ", IMAGES_CREAT_TIME=" + IMAGES_CREAT_TIME + ", IMAGES_USER=" + IMAGES_USER + "]";
	}
	
	
}
