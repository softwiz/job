/*
 * タイトル：
 * 説明    ：
 *
	 * 著作権  ：Copyright(c) 2014 SOFTWIZ
	 * 会社名  ：株式会社 SOFTWIZ
	 *
	 * 変更履歴   ：
	 * 新規登録   :2014/01/27
*/

package jp.co.softwiz.main.service.iface.login;

import javax.servlet.http.HttpServletRequest;

import jp.co.softwiz.main.domain.login.LoginBean;

/**
 * @author jk-yun
 * @version
 *
 */
public interface LoginServiceInterface {

	public void setLoginBean(LoginBean bean);

	public LoginBean getLogin(HttpServletRequest request);

	public LoginBean getLoginPass(LoginBean bean);
}
