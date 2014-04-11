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

package jp.co.softwiz.main.dao.sqlmap;

import java.util.List;

import jp.co.softwiz.main.domain.admin.CateMainBean;
import jp.co.softwiz.main.domain.admin.CateSubBean;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jk-yun@softwiz.jp
 * @version
 */
public class CategoryDao extends SqlSessionDaoSupport {

	@Autowired protected SqlSessionTemplate sqlSessionTemplate;

	public List<CateMainBean> selectMasterList(CateMainBean bean){
		return sqlSessionTemplate.selectList("Category.selectMasterList", bean);
	}

	public List<CateSubBean> selectDetailList(CateMainBean bean){
		return sqlSessionTemplate.selectList("Category.selectDetailList", bean);
	}

	public CateMainBean selectMaster(CateMainBean bean) {
		return sqlSessionTemplate.selectOne("TCateMainMapper.selectByPrimaryKey", bean);
	}

	public void insertMaster(CateMainBean bean) {
		sqlSessionTemplate.insert("TCateMainMapper.insert", bean);
	}

	public void updateMaster(CateMainBean bean) {
		sqlSessionTemplate.update("TCateMainMapper.updateByPrimaryKeySelective", bean);
	}

	public void deleteMaster(CateMainBean bean) {
		sqlSessionTemplate.delete("TCateMainMapper.deleteByPrimaryKey", bean);
	}
}
