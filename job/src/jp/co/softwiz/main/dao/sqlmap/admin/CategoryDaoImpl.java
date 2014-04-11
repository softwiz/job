/*
	 * タイトル：カテゴリDaoImpl
	 * 説明    ：
	 *
	 * 著作権  ：Copyright(c) 2014 SOFTWIZ
	 * 会社名  ：株式会社 SOFTWIZ
	 *
	 * 変更履歴   ：2014/04/03
	 * 新規登録   :
*/

package jp.co.softwiz.main.dao.sqlmap.admin;

import jp.co.softwiz.main.dao.iface.admin.CategoryDaoInterface;
import jp.co.softwiz.main.dao.sqlmap.CategoryDao;
import jp.co.softwiz.main.domain.admin.CateMainBean;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author jk-yun@softwiz.jp
 * @version
 */
@Repository
@Component("Category-Postgres")
public class CategoryDaoImpl extends CategoryDao implements CategoryDaoInterface {

	/**
	 * 大分類カテゴリのKEYを取得する。
	 * @return String
	 */
	public String selectCateMainMaxKey() {
		return sqlSessionTemplate.selectOne("Category.selectCateMainMaxKey");
	}

	/**
	 * カテゴリサブデータを削除する。
	 * @param LoginBean bean
	 * @return LoginBean
	 */
	public void deleteCateSubForMainKey(CateMainBean bean){

		//大分類カテゴリの使用可否を変更する。
		sqlSessionTemplate.delete("Category.deleteCateSubForMainKey", bean);
	}

	/**
	 * 大分類カテゴリの使用可否を変更する。
	 * @param LoginBean bean
	 * @return LoginBean
	 */
	public void updateCateMainUseDiv(CateMainBean bean){

		//大分類カテゴリの使用可否を変更する。
		sqlSessionTemplate.update("Setup.updateCateMainUseDiv", bean);
	}

}
