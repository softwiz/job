package jp.co.softwiz.main.domain;

/* Code Generator Information.
 * generator Version 1.0.0 release 2007/10/10
 * generated Date Tue Nov 12 15:32:07 JST 2013
 */
import java.io.Serializable;

/**
 * T_cate_subVo.
 * @author gtc-yun
 * @version 1.0 
 * history 
 * Symbol	Date		Person		Note
 * [1]		2013/11/12	gtc-yun		Generated.
 */
public class T_cate_subVo implements Serializable{

	public static final String TABLE = "T_CATE_SUB";

	/**
	 * maincode:bpchar(3) <Primary Key>
	 */
	private String maincode;

	/**
	 * subcode:bpchar(3) <Primary Key>
	 */
	private String subcode;

	/**
	 * subname:varchar(100)
	 */
	private String subname;

	/**
	 * subvalue:varchar(100)
	 */
	private String subvalue;

	/**
	 * subvalue2:varchar(100)
	 */
	private String subvalue2;

	/**
	 * subvalue3:varchar(100)
	 */
	private String subvalue3;

	/**
	 * vieworder:int4(10)
	 */
	private int vieworder;

	/**
	 * usediv:bpchar(1)
	 */
	private String usediv;

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
	* Constractor
	*/
	public T_cate_subVo(){}

	/**
	* Constractor
	* @param <code>maincode</code>
	* @param <code>subcode</code>
	*/
	public T_cate_subVo(String maincode, String subcode){
		this.maincode = maincode;
		this.subcode = subcode;
	}

	public String getMaincode(){ return this.maincode; }

	public void setMaincode(String maincode){ this.maincode = maincode; }

	public String getSubcode(){ return this.subcode; }

	public void setSubcode(String subcode){ this.subcode = subcode; }

	public String getSubname(){ return this.subname; }

	public void setSubname(String subname){ this.subname = subname; }

	public String getSubvalue(){ return this.subvalue; }

	public void setSubvalue(String subvalue){ this.subvalue = subvalue; }

	public String getSubvalue2(){ return this.subvalue2; }

	public void setSubvalue2(String subvalue2){ this.subvalue2 = subvalue2; }

	public String getSubvalue3(){ return this.subvalue3; }

	public void setSubvalue3(String subvalue3){ this.subvalue3 = subvalue3; }

	public int getVieworder(){ return this.vieworder; }

	public void setVieworder(int vieworder){ this.vieworder = vieworder; }

	public String getUsediv(){ return this.usediv; }

	public void setUsediv(String usediv){ this.usediv = usediv; }

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

	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("[T_cate_subVo:");
		buffer.append(" maincode: ");
		buffer.append(maincode);
		buffer.append(" subcode: ");
		buffer.append(subcode);
		buffer.append(" subname: ");
		buffer.append(subname);
		buffer.append(" subvalue: ");
		buffer.append(subvalue);
		buffer.append(" subvalue2: ");
		buffer.append(subvalue2);
		buffer.append(" subvalue3: ");
		buffer.append(subvalue3);
		buffer.append(" vieworder: ");
		buffer.append(vieworder);
		buffer.append(" usediv: ");
		buffer.append(usediv);
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
		buffer.append("]");
		return buffer.toString();
	}

}
