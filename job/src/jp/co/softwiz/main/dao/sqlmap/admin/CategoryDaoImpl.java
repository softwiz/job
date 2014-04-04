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

import java.util.List;

import jp.co.softwiz.main.dao.iface.admin.CategoryDaoInterface;
import jp.co.softwiz.main.domain.admin.CateMainBean;
import jp.co.softwiz.main.domain.admin.CateSubBean;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author jk-yun@softwiz.jp
 * @version
 */
@Repository
@Component("Category-Postgres")
public class CategoryDaoImpl extends SqlSessionDaoSupport implements CategoryDaoInterface {

	@Autowired private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 大分類カテゴリ情報を取得する
	 * @param LoginBean bean
	 * @return LoginBean
	 */
	public List<CateMainBean> selectMasterList(CateMainBean bean){

		//カテゴリのメイン情報リストを取得する。
		return sqlSessionTemplate.selectList("Category.selectMasterList", bean);
	}

		/**sssssss
	 * 共通項目中分類リストを取得する。
	 * @param String mainCode
	 * @return List<CateMainBean>
	 */
	public List<CateSubBean> selectDetailList(CateMainBean bean){

		//カテゴリのメイン情報リストを取得する。
		return sqlSessionTemplate.selectList("Category.selectDetailList", bean);
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
