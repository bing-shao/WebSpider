package com.swu.dto;

/**
 * 
 * @Title: SpiderURL
 * @package com.swu.dto
 * @Description: TODO
 * @author ljuenan@linewell
 * @date 2016-3-10 下午8:47:15
 * @version V1.0
 */
public class SpiderURL {
	private String webpage_unid;	//编号
	private String webpage_url;		//url
	private String webpage_depth;	//深度
	private String webpage_crawl;	//抓取时间
	private String webpage_user;	//用户
	private String webpage_flag;	//标记
	private String webpage_thread;	//线程名
	private String webpage_state;	//状态值，用于标记是否找完
	/**
	 * @return the webpage_state
	 */
	public String getWebpage_state() {
		return webpage_state;
	}
	/**
	 * @param webpage_state 
	 *				the webpage_state to set
	 */
	public void setWebpage_state(String webpage_state) {
		this.webpage_state = webpage_state;
	}
	/**
	 * @return the webpage_flag
	 */
	public String getWebpage_flag() {
		return webpage_flag;
	}
	/**
	 * @return the webpage_thread
	 */
	public String getWebpage_thread() {
		return webpage_thread;
	}
	/**
	 * @param webpage_thread 
	 *				the webpage_thread to set
	 */
	public void setWebpage_thread(String webpage_thread) {
		this.webpage_thread = webpage_thread;
	}
	/**
	 * @param webpage_flag 
	 *				the webpage_flag to set
	 */
	public void setWebpage_flag(String webpage_flag) {
		this.webpage_flag = webpage_flag;
	}
	/**
	 * @return the webpage_unid
	 */
	public String getWebpage_unid() {
		return webpage_unid;
	}
	/**
	 * @param webpage_unid 
	 *				the webpage_unid to set
	 */
	public void setWebpage_unid(String webpage_unid) {
		this.webpage_unid = webpage_unid;
	}
	/**
	 * @return the webpage_url
	 */
	public String getWebpage_url() {
		return webpage_url;
	}
	/**
	 * @param webpage_url 
	 *				the webpage_url to set
	 */
	public void setWebpage_url(String webpage_url) {
		this.webpage_url = webpage_url;
	}
	/**
	 * @return the webpage_depth
	 */
	public String getWebpage_depth() {
		return webpage_depth;
	}
	/**
	 * @param webpage_depth 
	 *				the webpage_depth to set
	 */
	public void setWebpage_depth(String webpage_depth) {
		this.webpage_depth = webpage_depth;
	}
	/**
	 * @return the webpage_crawl
	 */
	public String getWebpage_crawl() {
		return webpage_crawl;
	}
	/**
	 * @param webpage_crawl 
	 *				the webpage_crawl to set
	 */
	public void setWebpage_crawl(String webpage_crawl) {
		this.webpage_crawl = webpage_crawl;
	}
	/**
	 * @return the webpage_user
	 */
	public String getWebpage_user() {
		return webpage_user;
	}
	/**
	 * @param webpage_user 
	 *				the webpage_user to set
	 */
	public void setWebpage_user(String webpage_user) {
		this.webpage_user = webpage_user;
	}
	/**
	 * 功能：
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-12 下午11:59:44
	 * @param
	 * @return
	 *
	 */
	@Override
	public String toString() {
		return "SpiderURL [webpage_unid=" + webpage_unid + ", webpage_url=" + webpage_url + ", webpage_depth="
				+ webpage_depth + ", webpage_crawl=" + webpage_crawl + ", webpage_user=" + webpage_user
				+ ", webpage_flag=" + webpage_flag + ", webpage_thread=" + webpage_thread + ", webpage_state="
				+ webpage_state + ", getWebpage_state()=" + getWebpage_state() + ", getWebpage_flag()="
				+ getWebpage_flag() + ", getWebpage_thread()=" + getWebpage_thread() + ", getWebpage_unid()="
				+ getWebpage_unid() + ", getWebpage_url()=" + getWebpage_url() + ", getWebpage_depth()="
				+ getWebpage_depth() + ", getWebpage_crawl()=" + getWebpage_crawl() + ", getWebpage_user()="
				+ getWebpage_user() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
}
