/*
 * タイトル：
 * 説明    ：
 *
 * 著作権  ：Copyright(c) 2014 SOFTWIZ
 * 会社名  ：株式会社 SOFTWIZ
 *
 * 変更履歴   ：
 * 新規登録   : 2014/04/03
 */

package jp.co.softwiz.main.service.iface.admin;

import java.util.List;

import jp.co.softwiz.main.domain.admin.CateMainBean;
import jp.co.softwiz.main.domain.admin.CateSubBean;
import jp.co.softwiz.main.service.iface.MasterDetailServiceInterface;

/**
 * @author jk-yun@softwiz.jp
 * @version
 *
 */
public interface CategoryServiceInterface extends MasterDetailServiceInterface<CateMainBean, CateSubBean> {

	public void setCateMainUseDivList(List<String> list);
}
