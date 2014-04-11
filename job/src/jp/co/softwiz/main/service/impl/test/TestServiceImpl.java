/*
	 * タイトル：カテゴリサービス
	 * 説明    ：カテゴリサービス
	 *
	 * 著作権  ：Copyright(c) 2014 SOFTWIZ
	 * 会社名  ：株式会社 SOFTWIZ
	 *
	 * 変更履歴   ：2014/04/03
	 * 新規登録   :
*/

package jp.co.softwiz.main.service.impl.test;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jp.co.softwiz.main.common.constants.CommonConst;
import jp.co.softwiz.main.common.constants.SystemProperties;
import jp.co.softwiz.main.common.util.CommonUtil;
import jp.co.softwiz.main.dao.iface.test.TestDaoInterface;
import jp.co.softwiz.main.domain.test.TestInfoBean;
import jp.co.softwiz.main.service.iface.test.TestServiceInterface;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author jk-yun@softwiz.jp
 * @version 0.1
 *
 */
@Service
public class TestServiceImpl implements TestServiceInterface {

	//カテゴリDAO(DI)
	@Qualifier("Test-" + SystemProperties.FACTORY_DB)
	@Autowired private TestDaoInterface	testDao;

	/**
	 * 大分類の共通項目情報を取得する。
	 * @param HttpServletRequest request
	 * @return
	 */
	public List<TestInfoBean> selectList(TestInfoBean bean){

		return testDao.selectList(bean);
	}

	/**
	 * 共通項目大分類情報を登録する。
	 * @param String mainCode
	 * @return List<CateMainBean>
	 */
	@Transactional
	public void regist(HttpServletRequest request, TestInfoBean bean){
		bean.setDeleteflag(CommonConst.STRING_DELETE_FLAG_N);
		bean.setModifydate(CommonUtil.getNowDate());
		bean.setModifyuser(CommonUtil.getLoginUserId(request));
		if (StringUtils.isEmpty(bean.getTestno())) {
			bean.setTestno(testDao.selectTestInfoMaxKey());
			bean.setCreatedate(CommonUtil.getNowDate());
			bean.setCreateuser(CommonUtil.getLoginUserId(request));
			testDao.insert(bean);
		} else {
			testDao.update(bean);
		}
	}

	/**
	 * 共通項目大分類情報を登録する。
	 * @param String mainCode
	 * @return List<CateMainBean>
	 */
	@Transactional
	public void delete(HttpServletRequest request, TestInfoBean bean){
		bean.setDeleteflag(CommonConst.STRING_DELETE_FLAG_N);
		bean.setDeletedate(CommonUtil.getNowDate());
		bean.setDeleteuser(CommonUtil.getLoginUserId(request));

		testDao.delete(bean);
	}

	public TestInfoBean select(TestInfoBean bean) {
		if (StringUtils.isNotEmpty(bean.getTestno()))
			return testDao.select(bean);
		else
			return null;
	}



}
