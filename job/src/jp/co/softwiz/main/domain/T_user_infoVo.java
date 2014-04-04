package jp.co.softwiz.main.domain;

/* Code Generator Information.
 * generator Version 1.0.0 release 2007/10/10
 * generated Date Wed Apr 02 13:34:15 JST 2014
 */
import java.io.Serializable;

/**
 * T_user_infoVo.
 * @author gtc-yun
 * @version 1.0 
 * history 
 * Symbol	Date		Person		Note
 * [1]		2014/04/02	gtc-yun		Generated.
 */
public class T_user_infoVo implements Serializable{

	public static final String TABLE = "T_USER_INFO";

	/**
	 * siteid:bpchar(3) <Primary Key>
	 */
	private String siteid;

	/**
	 * usercode:varchar(50) <Primary Key>
	 */
	private String usercode;

	/**
	 * username:varchar(100)
	 */
	private String username;

	/**
	 * usernamekana:varchar(200)
	 */
	private String usernamekana;

	/**
	 * birthday:varchar(8)
	 */
	private String birthday;

	/**
	 * gender:bpchar(1)
	 */
	private String gender;

	/**
	 * zipcode:varchar(8)
	 */
	private String zipcode;

	/**
	 * address:varchar(500)
	 */
	private String address;

	/**
	 * nearstation:varchar(100)
	 */
	private String nearstation;

	/**
	 * telnum:varchar(14)
	 */
	private String telnum;

	/**
	 * celphone:varchar(14)
	 */
	private String celphone;

	/**
	 * mailaddress:varchar(200)
	 */
	private String mailaddress;

	/**
	 * etcdesc:varchar(300)
	 */
	private String etcdesc;

	/**
	 * createdate:timestamp(29,6)
	 */
	private java.sql.Timestamp createdate;

	/**
	 * createuser:varchar(30)
	 */
	private String createuser;

	/**
	 * modifydate:timestamp(29,6)
	 */
	private java.sql.Timestamp modifydate;

	/**
	 * modifyuser:varchar(30)
	 */
	private String modifyuser;

	/**
	 * deleteflag:bpchar(1)
	 */
	private String deleteflag;

	/**
	 * deletedate:timestamp(29,6)
	 */
	private java.sql.Timestamp deletedate;

	/**
	 * deleteuser:varchar(30)
	 */
	private String deleteuser;

	/**
	 * apprimageurl:varchar(200)
	 */
	private String apprimageurl;

	/**
	* Constractor
	*/
	public T_user_infoVo(){}

	/**
	* Constractor
	* @param <code>siteid</code>
	* @param <code>usercode</code>
	*/
	public T_user_infoVo(String siteid, String usercode){
		this.siteid = siteid;
		this.usercode = usercode;
	}

	public String getSiteid(){ return this.siteid; }

	public void setSiteid(String siteid){ this.siteid = siteid; }

	public String getUsercode(){ return this.usercode; }

	public void setUsercode(String usercode){ this.usercode = usercode; }

	public String getUsername(){ return this.username; }

	public void setUsername(String username){ this.username = username; }

	public String getUsernamekana(){ return this.usernamekana; }

	public void setUsernamekana(String usernamekana){ this.usernamekana = usernamekana; }

	public String getBirthday(){ return this.birthday; }

	public void setBirthday(String birthday){ this.birthday = birthday; }

	public String getGender(){ return this.gender; }

	public void setGender(String gender){ this.gender = gender; }

	public String getZipcode(){ return this.zipcode; }

	public void setZipcode(String zipcode){ this.zipcode = zipcode; }

	public String getAddress(){ return this.address; }

	public void setAddress(String address){ this.address = address; }

	public String getNearstation(){ return this.nearstation; }

	public void setNearstation(String nearstation){ this.nearstation = nearstation; }

	public String getTelnum(){ return this.telnum; }

	public void setTelnum(String telnum){ this.telnum = telnum; }

	public String getCelphone(){ return this.celphone; }

	public void setCelphone(String celphone){ this.celphone = celphone; }

	public String getMailaddress(){ return this.mailaddress; }

	public void setMailaddress(String mailaddress){ this.mailaddress = mailaddress; }

	public String getEtcdesc(){ return this.etcdesc; }

	public void setEtcdesc(String etcdesc){ this.etcdesc = etcdesc; }

	public java.sql.Timestamp getCreatedate(){ return this.createdate; }

	public void setCreatedate(java.sql.Timestamp createdate){ this.createdate = createdate; }

	public String getCreateuser(){ return this.createuser; }

	public void setCreateuser(String createuser){ this.createuser = createuser; }

	public java.sql.Timestamp getModifydate(){ return this.modifydate; }

	public void setModifydate(java.sql.Timestamp modifydate){ this.modifydate = modifydate; }

	public String getModifyuser(){ return this.modifyuser; }

	public void setModifyuser(String modifyuser){ this.modifyuser = modifyuser; }

	public String getDeleteflag(){ return this.deleteflag; }

	public void setDeleteflag(String deleteflag){ this.deleteflag = deleteflag; }

	public java.sql.Timestamp getDeletedate(){ return this.deletedate; }

	public void setDeletedate(java.sql.Timestamp deletedate){ this.deletedate = deletedate; }

	public String getDeleteuser(){ return this.deleteuser; }

	public void setDeleteuser(String deleteuser){ this.deleteuser = deleteuser; }

	public String getApprimageurl(){ return this.apprimageurl; }

	public void setApprimageurl(String apprimageurl){ this.apprimageurl = apprimageurl; }

	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("[T_user_infoVo:");
		buffer.append(" siteid: ");
		buffer.append(siteid);
		buffer.append(" usercode: ");
		buffer.append(usercode);
		buffer.append(" username: ");
		buffer.append(username);
		buffer.append(" usernamekana: ");
		buffer.append(usernamekana);
		buffer.append(" birthday: ");
		buffer.append(birthday);
		buffer.append(" gender: ");
		buffer.append(gender);
		buffer.append(" zipcode: ");
		buffer.append(zipcode);
		buffer.append(" address: ");
		buffer.append(address);
		buffer.append(" nearstation: ");
		buffer.append(nearstation);
		buffer.append(" telnum: ");
		buffer.append(telnum);
		buffer.append(" celphone: ");
		buffer.append(celphone);
		buffer.append(" mailaddress: ");
		buffer.append(mailaddress);
		buffer.append(" etcdesc: ");
		buffer.append(etcdesc);
		buffer.append(" createdate: ");
		buffer.append(createdate);
		buffer.append(" createuser: ");
		buffer.append(createuser);
		buffer.append(" modifydate: ");
		buffer.append(modifydate);
		buffer.append(" modifyuser: ");
		buffer.append(modifyuser);
		buffer.append(" deleteflag: ");
		buffer.append(deleteflag);
		buffer.append(" deletedate: ");
		buffer.append(deletedate);
		buffer.append(" deleteuser: ");
		buffer.append(deleteuser);
		buffer.append(" apprimageurl: ");
		buffer.append(apprimageurl);
		buffer.append("]");
		return buffer.toString();
	}

}
