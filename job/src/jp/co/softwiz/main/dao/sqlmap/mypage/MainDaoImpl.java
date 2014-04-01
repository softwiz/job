/*
	 * タイトル：案件情報照会DaoImpl
	 * 説明    ：
	 *
	 * 著作権  ：Copyright(c) 2014 SOFTWIZ
	 * 会社名  ：株式会社 SOFTWIZ
	 *
	 * 変更履歴   ：
	 * 新規登録   :2014/01/27
*/

package jp.co.softwiz.main.dao.sqlmap.mypage;
import jp.co.softwiz.main.dao.iface.mypage.MainDaoInterface;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


/**
 * @author jk-yun
 *
 */
@Repository
@Component("Main-Postgres")
public class MainDaoImpl implements MainDaoInterface {

	@Autowired private SqlSessionTemplate sqlSessionTemplate;

	//案件情報リストを取得する。
//	public List<AdmBean> getCalAdmList(AdmBean bean) {
//		return sqlSessionTemplate.selectList("Main.getCalAdmList", bean);
//	}


}