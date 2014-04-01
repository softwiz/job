/*
	 * タイトル：ログインサービス
	 * 説明    ：ログインサービス
	 *
	 * 著作権  ：Copyright(c) 2014 SOFTWIZ
	 * 会社名  ：株式会社 SOFTWIZ
	 *
	 * 変更履歴   ：
	 * 新規登録   :2014/01/27
*/

package jp.co.softwiz.main.service.impl.login;

import javax.servlet.http.HttpServletRequest;

import jp.co.softwiz.main.common.constants.CommonConst;
import jp.co.softwiz.main.common.constants.SystemProperties;
import jp.co.softwiz.main.common.util.CommonUtil;
import jp.co.softwiz.main.dao.iface.login.LoginDaoInterface;
import jp.co.softwiz.main.domain.login.LoginBean;
import jp.co.softwiz.main.service.iface.login.LoginServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.util.WebUtils;


/**
 * @author jk-yun
 * @version 0.1
 *
 */
@Service
public class LoginServiceImpl implements LoginServiceInterface {

	//ログインDAO(DI)
	@Qualifier("Login-" + SystemProperties.FACTORY_DB)
	@Autowired private LoginDaoInterface	loginDao;

	private LoginBean loginBean;

	/**
	 * LoginBeanをセット
	 * @param　LoginBean bean
	 * @return
	 */
	public void setLoginBean(LoginBean bean) {
		loginBean = bean;
	}

	public LoginServiceImpl() {

	}

	/**
	 * ログイン情報を取得してセッションに保存する
	 * @param HttpServletRequest request
	 * @return
	 */
	public LoginBean getLogin(HttpServletRequest request){

		LoginBean bean = loginDao.getLoginBean(loginBean);
		if(bean != null) {

			bean.setLoginDiv("0"); //login
			bean.setSessionId(request.getSession().getId());
			bean.setConnectIp(CommonUtil.getUserAddress(request));
			//ログイン情報登録
			int result = loginDao.updateLoginInfo(bean);
			if(result <= 0) {
				return null;
			} else {
				bean = loginDao.getLoginBean(loginBean);
				//bean.setAuthMap(loginDao.getAuthMap(bean));
				//sbean.setMenuTree(CommonUtil.getDefaultMenuTree(bean.getAuthMap()));
				/* セッション登録 */
				WebUtils.setSessionAttribute(request, CommonConst.LOGIN_USER_KEY, bean);
				return bean;
			}
		}
		return null;
	}

	/**
	 * パスワード情報取得する。
	 * @param CateBean bean
	 * @return
	 * @return
	 */
	public LoginBean getLoginPass(LoginBean bean){
		return loginDao.getLoginPass(bean);
	}

}
