package jp.co.softwiz.main.domain;

/* Code Generator Information.
 * generator Version 1.0.0 release 2007/10/10
 * generated Date Wed Apr 02 13:34:15 JST 2014
 */
import java.io.Serializable;

/**
 * T_test_infoVo.
 * @author gtc-yun
 * @version 1.0 
 * history 
 * Symbol	Date		Person		Note
 * [1]		2014/04/02	gtc-yun		Generated.
 */
public class T_test_infoVo implements Serializable{

	public static final String TABLE = "T_TEST_INFO";

	/**
	 * testno:varchar(50) <Primary Key>
	 */
	private String testno;

	/**
	 * testname:varchar(100)
	 */
	private String testname;

	/**
	 * yearmonthday:varchar(8)
	 */
	private String yearmonthday;

	/**
	 * detailcontent:text(2147483647)
	 */
	private String detailcontent;

	/**
	 * imagepath:varchar(200)
	 */
	private String imagepath;

	/**
	 * filepath:varchar(200)
	 */
	private String filepath;

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
	* Constractor
	*/
	public T_test_infoVo(){}

	/**
	* Constractor
	* @param <code>testno</code>
	*/
	public T_test_infoVo(String testno){
		this.testno = testno;
	}

	public String getTestno(){ return this.testno; }

	public void setTestno(String testno){ this.testno = testno; }

	public String getTestname(){ return this.testname; }

	public void setTestname(String testname){ this.testname = testname; }

	public String getYearmonthday(){ return this.yearmonthday; }

	public void setYearmonthday(String yearmonthday){ this.yearmonthday = yearmonthday; }

	public String getDetailcontent(){ return this.detailcontent; }

	public void setDetailcontent(String detailcontent){ this.detailcontent = detailcontent; }

	public String getImagepath(){ return this.imagepath; }

	public void setImagepath(String imagepath){ this.imagepath = imagepath; }

	public String getFilepath(){ return this.filepath; }

	public void setFilepath(String filepath){ this.filepath = filepath; }

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

	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("[T_test_infoVo:");
		buffer.append(" testno: ");
		buffer.append(testno);
		buffer.append(" testname: ");
		buffer.append(testname);
		buffer.append(" yearmonthday: ");
		buffer.append(yearmonthday);
		buffer.append(" detailcontent: ");
		buffer.append(detailcontent);
		buffer.append(" imagepath: ");
		buffer.append(imagepath);
		buffer.append(" filepath: ");
		buffer.append(filepath);
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
		buffer.append("]");
		return buffer.toString();
	}

}
