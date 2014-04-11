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

package jp.co.softwiz.main.dao.iface.admin;

import jp.co.softwiz.main.dao.iface.MasterDetailDaoInterface;
import jp.co.softwiz.main.domain.admin.CateMainBean;
import jp.co.softwiz.main.domain.admin.CateSubBean;

/**
 * @author jk-yun@softwiz.jp
 * @version
 *
 */
public interface CategoryDaoInterface extends MasterDetailDaoInterface<CateMainBean, CateSubBean> {

	public String selectCateMainMaxKey();

	public void deleteCateSubForMainKey(CateMainBean bean);

	public void updateCateMainUseDiv(CateMainBean bean);
}
