/*
	 * タイトル：ログインDaoInterface
	 * 説明    ：
	 *
	 * 著作権  ：Copyright(c) 2014 SOFTWIZ
	 * 会社名  ：株式会社 SOFTWIZ
	 *
	 * 変更履歴   ：2014/04/03
	 * 新規登録   :
*/

package jp.co.softwiz.main.dao.iface.test;

import jp.co.softwiz.main.dao.iface.StandardDaoInterface;
import jp.co.softwiz.main.domain.test.TestInfoBean;

/**
 * @author jk-yun@softwiz.jp
 * @version
 *
 */
public interface TestDaoInterface extends StandardDaoInterface<TestInfoBean> {

	public String selectTestInfoMaxKey();

}
