package com.swu.dto;
/**
 * 
 * @Title: Pie
 * @package com.swu.dto
 * @Description: 饼图
 * @author ljuenan@linewell
 * @date 2016-3-14 下午8:50:49
 * @version V1.0
 */
public class Pie {
	private String numT ;		//捕捉成功数量
	private String numF ;		//捕捉失败数量
	/**
	 * @return the numT
	 */
	public String getNumT() {
		return numT;
	}
	/**
	 * @param numT 
	 *				the numT to set
	 */
	public void setNumT(String numT) {
		this.numT = numT;
	}
	/**
	 * @return the numF
	 */
	public String getNumF() {
		return numF;
	}
	/**
	 * @param numF 
	 *				the numF to set
	 */
	public void setNumF(String numF) {
		this.numF = numF;
	}
	/**
	 * 功能：toString
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-14 下午8:52:19
	 * @param
	 * @return
	 *
	 */
	@Override
	public String toString() {
		return "Pie [numT=" + numT + ", numF=" + numF + "]";
	}
	
}
