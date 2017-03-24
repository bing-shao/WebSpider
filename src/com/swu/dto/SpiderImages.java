package com.swu.dto;

/**
 * 
 * @Title: SpiderImage
 * @package com.swu.dto
 * @Description: TODO
 * @author ljuenan@linewell
 * @date 2016-3-10 下午8:47:00
 * @version V1.0
 */
public class SpiderImages {
	private String IMAGES_UNID;			//编号
	private String IMAGES_URL;			//图片地址
	private String IMAGES_TYPE;			//图片类型
	private String IMAGES_SOURCE;		//图片来源
	private String IMAGES_DEPTH;		//图片抓取深度
	private String IMAGES_CRAWL;		//图片抓取时间
	private String IMAGES_USER;			//所属用户编号
	private String IMAGES_THREAD;		//图片所属线程名
	private String IMAGES_STATE;		//用于标记是否抓完
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
	 * @return the iMAGES_DEPTH
	 */
	public String getIMAGES_DEPTH() {
		return IMAGES_DEPTH;
	}
	/**
	 * @param iMAGES_DEPTH the 
	 *     			iMAGES_DEPTH to set
	 */
	public void setIMAGES_DEPTH(String iMAGES_DEPTH) {
		IMAGES_DEPTH = iMAGES_DEPTH;
	}
	/**
	 * @return the iMAGES_CRAWL
	 */
	public String getIMAGES_CRAWL() {
		return IMAGES_CRAWL;
	}
	/**
	 * @param iMAGES_CRAWL the 
	 *     			iMAGES_CRAWL to set
	 */
	public void setIMAGES_CRAWL(String iMAGES_CRAWL) {
		IMAGES_CRAWL = iMAGES_CRAWL;
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
	 * @return the iMAGES_THREAD
	 */
	public String getIMAGES_THREAD() {
		return IMAGES_THREAD;
	}
	/**
	 * @param iMAGES_THREAD the 
	 *     			iMAGES_THREAD to set
	 */
	public void setIMAGES_THREAD(String iMAGES_THREAD) {
		IMAGES_THREAD = iMAGES_THREAD;
	}
	/**
	 * @return the iMAGES_STATE
	 */
	public String getIMAGES_STATE() {
		return IMAGES_STATE;
	}
	/**
	 * @param iMAGES_STATE the 
	 *     			iMAGES_STATE to set
	 */
	public void setIMAGES_STATE(String iMAGES_STATE) {
		IMAGES_STATE = iMAGES_STATE;
	}
	/**
	 * 
	 * 功能：toString
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-17 下午9:52:52
	 * @param
	 * @return
	 *
	 */
	@Override
	public String toString() {
		return "SpiderImages [IMAGES_UNID=" + IMAGES_UNID + ", IMAGES_URL=" + IMAGES_URL + ", IMAGES_TYPE="
				+ IMAGES_TYPE + ", IMAGES_SOURCE=" + IMAGES_SOURCE + ", IMAGES_DEPTH=" + IMAGES_DEPTH
				+ ", IMAGES_CRAWL=" + IMAGES_CRAWL + ", IMAGES_USER=" + IMAGES_USER + ", IMAGES_THREAD="
				+ IMAGES_THREAD + ", IMAGES_STATE=" + IMAGES_STATE + "]";
	}
	
	
	
	
}
