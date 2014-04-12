/*
	 * タイトル：テストDaoImpl
	 * 説明    ：
	 *
	 * 著作権  ：Copyright(c) 2014 SOFTWIZ
	 * 会社名  ：株式会社 SOFTWIZ
	 *
	 * 変更履歴   ：2014/04/03
	 * 新規登録   :
*/

package jp.co.softwiz.main.dao.sqlmap.test;

import jp.co.softwiz.main.dao.iface.test.TestDaoInterface;
import jp.co.softwiz.main.dao.sqlmap.TestDao;
import jp.co.softwiz.main.domain.test.TestInfoBean;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author jk-yun@softwiz.jp
 * @version
 */
@Repository
@Component("Test-Postgres")
public class TestDaoImpl extends TestDao implements TestDaoInterface {

	/**
	 * 大分類カテゴリのKEYを取得する。
	 * @return String
	 */
	public int getSelectListCount(TestInfoBean bean) {
		return sqlSessionTemplate.selectOne("Test.getSelectListCount", bean);
	}

	/**
	 * 大分類カテゴリのKEYを取得する。
	 * @return String
	 */
	public String selectTestInfoMaxKey() {
		return sqlSessionTemplate.selectOne("Test.selectTestInfoMaxKey");
	}

}
