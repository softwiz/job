package jp.co.softwiz.main.domain;

/* Code Generator Information.
 * generator Version 1.0.0 release 2007/10/10
 * generated Date Wed Apr 02 13:34:14 JST 2014
 */
import java.io.Serializable;

/**
 * T_login_histVo.
 * @author gtc-yun
 * @version 1.0 
 * history 
 * Symbol	Date		Person		Note
 * [1]		2014/04/02	gtc-yun		Generated.
 */
public class T_login_histVo implements Serializable{

	public static final String TABLE = "T_LOGIN_HIST";

	/**
	 * loginno:serial(10) <Primary Key>
	 */
	private int loginno;

	/**
	 * siteid:bpchar(3)
	 */
	private String siteid;

	/**
	 * userid:varchar(20)
	 */
	private String userid;

	/**
	 * roles:varchar(100)
	 */
	private String roles;

	/**
	 * yearmonthday:varchar(8)
	 */
	private String yearmonthday;

	/**
	 * logindiv:bpchar(1)
	 */
	private String logindiv;

	/**
	 * flagsuccess:bpchar(1)
	 */
	private String flagsuccess;

	/**
	 * sessionid:varchar(50)
	 */
	private String sessionid;

	/**
	 * connectip:varchar(30)
	 */
	private String connectip;

	/**
	 * createdate:timestamp(29,6)
	 */
	private java.sql.Timestamp createdate;

	/**
	* Constractor
	*/
	public T_login_histVo(){}

	/**
	* Constractor
	* @param <code>loginno</code>
	*/
	public T_login_histVo(int loginno){
		this.loginno = loginno;
	}

	public int getLoginno(){ return this.loginno; }

	public void setLoginno(int loginno){ this.loginno = loginno; }

	public String getSiteid(){ return this.siteid; }

	public void setSiteid(String siteid){ this.siteid = siteid; }

	public String getUserid(){ return this.userid; }

	public void setUserid(String userid){ this.userid = userid; }

	public String getRoles(){ return this.roles; }

	public void setRoles(String roles){ this.roles = roles; }

	public String getYearmonthday(){ return this.yearmonthday; }

	public void setYearmonthday(String yearmonthday){ this.yearmonthday = yearmonthday; }

	public String getLogindiv(){ return this.logindiv; }

	public void setLogindiv(String logindiv){ this.logindiv = logindiv; }

	public String getFlagsuccess(){ return this.flagsuccess; }

	public void setFlagsuccess(String flagsuccess){ this.flagsuccess = flagsuccess; }

	public String getSessionid(){ return this.sessionid; }

	public void setSessionid(String sessionid){ this.sessionid = sessionid; }

	public String getConnectip(){ return this.connectip; }

	public void setConnectip(String connectip){ this.connectip = connectip; }

	public java.sql.Timestamp getCreatedate(){ return this.createdate; }

	public void setCreatedate(java.sql.Timestamp createdate){ this.createdate = createdate; }

	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("[T_login_histVo:");
		buffer.append(" loginno: ");
		buffer.append(loginno);
		buffer.append(" siteid: ");
		buffer.append(siteid);
		buffer.append(" userid: ");
		buffer.append(userid);
		buffer.append(" roles: ");
		buffer.append(roles);
		buffer.append(" yearmonthday: ");
		buffer.append(yearmonthday);
		buffer.append(" logindiv: ");
		buffer.append(logindiv);
		buffer.append(" flagsuccess: ");
		buffer.append(flagsuccess);
		buffer.append(" sessionid: ");
		buffer.append(sessionid);
		buffer.append(" connectip: ");
		buffer.append(connectip);
		buffer.append(" createdate: ");
		buffer.append(createdate);
		buffer.append("]");
		return buffer.toString();
	}

}
