/*
	 * タイトル：ログインDaoInterface
	 * 説明    ：
	 *
	 * 著作権  ：Copyright(c) 2014 SOFTWIZ
	 * 会社名  ：株式会社 SOFTWIZ
	 *
	 * 変更履歴   ：
	 * 新規登録   :2014/01/27
*/

package jp.co.softwiz.main.dao.iface.login;

import jp.co.softwiz.main.domain.login.LoginBean;

/**
 * @author jk-yun
 * @version
 *
 */
public interface LoginDaoInterface {

	public LoginBean getLoginBean(LoginBean bean);

	public int updateLoginInfo(LoginBean bean);

	public LoginBean getLoginPass(LoginBean bean);

}
