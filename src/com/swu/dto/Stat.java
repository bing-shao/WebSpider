package com.swu.dto;
/**
 * 
 * @Title: StatUrl
 * @package com.swu.dto
 * @Description: 爬行记录表
 * @author ljuenan@linewell
 * @date 2016-3-12 下午11:57:19
 * @version V1.0
 */
public class Stat {
	private String STATURL_UNID;		//编号
	private String STATURL_USER;		//用户编号
	private String STATURL_TOTALNUM;	//总计爬行个数
	private String STATURL_TOTALTIME;	//总计爬行时间
	private String STATURL_CREATTIME;	//创建时间
	/**
	 * @return the sTATURL_UNID
	 */
	public String getSTATURL_UNID() {
		return STATURL_UNID;
	}
	/**
	 * @param sTATURL_UNID 
	 *				the sTATURL_UNID to set
	 */
	public void setSTATURL_UNID(String sTATURL_UNID) {
		STATURL_UNID = sTATURL_UNID;
	}
	/**
	 * @return the sTATURL_USER
	 */
	public String getSTATURL_USER() {
		return STATURL_USER;
	}
	/**
	 * @param sTATURL_USER 
	 *				the sTATURL_USER to set
	 */
	public void setSTATURL_USER(String sTATURL_USER) {
		STATURL_USER = sTATURL_USER;
	}
	/**
	 * @return the sTATURL_TOTALNUM
	 */
	public String getSTATURL_TOTALNUM() {
		return STATURL_TOTALNUM;
	}
	/**
	 * @param sTATURL_TOTALNUM 
	 *				the sTATURL_TOTALNUM to set
	 */
	public void setSTATURL_TOTALNUM(String sTATURL_TOTALNUM) {
		STATURL_TOTALNUM = sTATURL_TOTALNUM;
	}
	/**
	 * @return the sTATURL_TOTALTIME
	 */
	public String getSTATURL_TOTALTIME() {
		return STATURL_TOTALTIME;
	}
	/**
	 * @param sTATURL_TOTALTIME 
	 *				the sTATURL_TOTALTIME to set
	 */
	public void setSTATURL_TOTALTIME(String sTATURL_TOTALTIME) {
		STATURL_TOTALTIME = sTATURL_TOTALTIME;
	}
	/**
	 * @return the sTATURL_CREATTIME
	 */
	public String getSTATURL_CREATTIME() {
		return STATURL_CREATTIME;
	}
	/**
	 * @param sTATURL_CREATTIME 
	 *				the sTATURL_CREATTIME to set
	 */
	public void setSTATURL_CREATTIME(String sTATURL_CREATTIME) {
		STATURL_CREATTIME = sTATURL_CREATTIME;
	}
	/**
	 * 功能：
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-12 下午11:57:11
	 * @param
	 * @return
	 *
	 */
	@Override
	public String toString() {
		return "StatUrl [STATURL_UNID=" + STATURL_UNID + ", STATURL_USER=" + STATURL_USER + ", STATURL_TOTALNUM="
				+ STATURL_TOTALNUM + ", STATURL_TOTALTIME=" + STATURL_TOTALTIME + ", STATURL_CREATTIME="
				+ STATURL_CREATTIME + "]";
	}
	
}
