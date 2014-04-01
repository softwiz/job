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

package jp.co.softwiz.main.service.impl.mypage;

import jp.co.softwiz.main.common.constants.SystemProperties;
import jp.co.softwiz.main.dao.iface.mypage.MainDaoInterface;
import jp.co.softwiz.main.service.iface.mypage.MainServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


/**
 * @author jk-yun
 * @version 0.1
 *
 */
@Service
public class MainServiceImpl implements MainServiceInterface {

	//ログインDAO(DI)
	@Qualifier("Main-" + SystemProperties.FACTORY_DB)
	@Autowired private MainDaoInterface	mainDao;

//	public List<AdmBean> getCalAdmList(AdmBean bean) {
//		return mainDao.getCalAdmList(bean);
//	}

}
