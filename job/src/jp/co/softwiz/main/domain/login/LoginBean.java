/*
	 * タイトル：LoginBean
	 * 説明    ：
	 *
	 * 著作権  ：Copyright(c) 2014 SOFTWIZ
	 * 会社名  ：株式会社 SOFTWIZ
	 *
	 * 変更履歴   ：
	 * 新規登録   :2014/01/27
*/

package jp.co.softwiz.main.domain.login;
import java.util.Date;


/**
 * @author jk-yun
 * @version
 *
 */
public class LoginBean {

	private String userId;
	private String userCode;
	private String userName;
	private String roles;
	private String password;
	private String loginDiv;
	private String sessionId;
	private String connectIp;
	private Date connectDate;
	private String connectDay;
	private String menuTree;


	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLoginDiv() {
		return loginDiv;
	}
	public void setLoginDiv(String loginDiv) {
		this.loginDiv = loginDiv;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getConnectIp() {
		return connectIp;
	}
	public void setConnectIp(String connectIp) {
		this.connectIp = connectIp;
	}
	public Date getConnectDate() {
		return connectDate;
	}
	public void setConnectDate(Date connectDate) {
		this.connectDate = connectDate;
	}
	public String getConnectDay() {
		return connectDay;
	}
	public void setConnectDay(String connectDay) {
		this.connectDay = connectDay;
	}
	public String getMenuTree() {
		return menuTree;
	}
	public void setMenuTree(String menuTree) {
		this.menuTree = menuTree;
	}


}
