/*
	 * タイトル：ログインDaoImpl
	 * 説明    ：
	 *
	 * 著作権  ：Copyright(c) 2014 SOFTWIZ
	 * 会社名  ：株式会社 SOFTWIZ
	 *
	 * 変更履歴   ：
	 * 新規登録   :2014/01/27
*/

package jp.co.softwiz.main.dao.sqlmap.login;

import jp.co.softwiz.main.common.constants.CommonConst;
import jp.co.softwiz.main.dao.iface.login.LoginDaoInterface;
import jp.co.softwiz.main.domain.login.LoginBean;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jk-yun
 * @version
 */
@Repository
@Component("Login-Postgres")
public class LoginDaoImpl extends SqlSessionDaoSupport implements LoginDaoInterface {

	@Autowired private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * ログイン情報を取得する
	 * @param CateBean bean
	 * @return LoginBean
	 */
	public LoginBean getLoginBean(LoginBean bean){

		//ユーザ基本情報の取得
		return (LoginBean)sqlSessionTemplate.selectOne("Login.getLoginUser", bean);
	}

	/**
	 * ログイン情報が正しいのであればログイン情報を保存し、履歴に保存する
	 * @param CateBean bean
	 * @return LoginBean
	 */
	@Transactional
	public int updateLoginInfo(LoginBean bean){

		//ログイン情報を変更
		sqlSessionTemplate.update("Login.updateLoginInfo", bean);
		//ログイン情報の取得
		LoginBean tmpBean = (LoginBean)sqlSessionTemplate.selectOne("Login.getLoginUser", bean);
		//ログイン履歴情報へ保存
		sqlSessionTemplate.insert("Login.insertLoginHist", tmpBean);

		return CommonConst.INT_RESULT_SUCCESS;
	}

	/**
	 * ログインユーザのパスワードを取得する。
	 * @param CateBean bean
	 * @return
	 */
	public LoginBean getLoginPass(LoginBean bean){
		return (LoginBean)sqlSessionTemplate.selectOne("Login.getLoginPass", bean);
	}

}
