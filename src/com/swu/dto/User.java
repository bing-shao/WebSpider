package com.swu.dto;

public class User {
	
	private String user_unid;			//用户unid
	private String user_name;			//用户名
	private String user_pwd;			//密码
	private String user_sex;			//性别
	private String user_adr;			//地址
	private String user_birth;			//出生日期
	private String user_email;			//邮箱
	private String user_phone;			//电话
	private String user_remark;			//备注
	private String user_question;		//密保提示问题
	private String user_answer;			//密保答案
	private String user_time;			//创建时间
	
	/**
	 * 
	* 功能：user的get和set方法
	* @author 姓名 ljuenan@linewell.com
	* @since 2016-2-27 下午6:24:52
	* @param
	* @return
	*
	 */
	
	public String getUser_unid() {
		return user_unid;
	}
	public void setUser_unid(String user_unid) {
		this.user_unid = user_unid;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_adr() {
		return user_adr;
	}
	public void setUser_adr(String user_adr) {
		this.user_adr = user_adr;
	}
	public String getUser_birth() {
		return user_birth;
	}
	public void setUser_birth(String user_birth) {
		this.user_birth = user_birth;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_remark() {
		return user_remark;
	}
	public void setUser_remark(String user_remark) {
		this.user_remark = user_remark;
	}
	public String getUser_question() {
		return user_question;
	}
	public void setUser_question(String user_question) {
		this.user_question = user_question;
	}
	public String getUser_answer() {
		return user_answer;
	}
	public void setUser_answer(String user_answer) {
		this.user_answer = user_answer;
	}
	public String getUser_time() {
		return user_time;
	}
	public void setUser_time(String user_time) {
		this.user_time = user_time;
	}
	
	/**
	 * 构造方法
	 */
	public User(){
		super();
	}
	/**
	 * 构造方法
	 * @param user_unid
	 * @param user_name
	 * @param user_pwd
	 * @param user_sex
	 * @param user_adr
	 * @param user_birth
	 * @param user_email
	 * @param user_phone
	 * @param user_remark
	 * @param user_question
	 * @param user_answer
	 * @param user_time
	 */
	
	public User(String user_unid, String user_name, String user_pwd, String user_sex, String user_adr,
			String user_birth, String user_email, String user_phone, String user_remark, String user_question,
			String user_answer, String user_time) {
		super();
		this.user_unid = user_unid;
		this.user_name = user_name;
		this.user_pwd = user_pwd;
		this.user_sex = user_sex;
		this.user_adr = user_adr;
		this.user_birth = user_birth;
		this.user_email = user_email;
		this.user_phone = user_phone;
		this.user_remark = user_remark;
		this.user_question = user_question;
		this.user_answer = user_answer;
		this.user_time = user_time;
	}
	
	
	/**
	 * toString方法
	 */
	@Override
	public String toString() {
		return "User [user_unid=" + user_unid + ", user_name=" + user_name + ", user_pwd=" + user_pwd + ", user_sex="
				+ user_sex + ", user_adr=" + user_adr + ", user_birth=" + user_birth + ", user_email=" + user_email
				+ ", user_phone=" + user_phone + ", user_remark=" + user_remark + ", user_question=" + user_question
				+ ", user_answer=" + user_answer + ", user_time=" + user_time + "]";
	}
	
	
}
