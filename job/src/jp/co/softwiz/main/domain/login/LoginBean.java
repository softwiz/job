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
import jp.co.softwiz.main.domain.T_login_infoVo;


/**
 * @author jk-yun
 * @version
 *
 */
public class LoginBean extends T_login_infoVo {

	private String userName;
	private String loginDiv;
	private String menuTree;
	private String locale;


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginDiv() {
		return loginDiv;
	}
	public void setLoginDiv(String loginDiv) {
		this.loginDiv = loginDiv;
	}
	public String getMenuTree() {
		return menuTree;
	}
	public void setMenuTree(String menuTree) {
		this.menuTree = menuTree;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}




}
