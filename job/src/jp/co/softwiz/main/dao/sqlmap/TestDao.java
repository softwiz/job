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

import jp.co.softwiz.main.domain.test.TestInfoBean;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jk-yun@softwiz.jp
 * @version
 */
public class TestDao extends SqlSessionDaoSupport {

	@Autowired protected SqlSessionTemplate sqlSessionTemplate;

	public List<TestInfoBean> selectList(TestInfoBean bean){
		return sqlSessionTemplate.selectList("Test.selectList", bean);
	}

	public TestInfoBean select(TestInfoBean bean) {
		return sqlSessionTemplate.selectOne("TTestInfoMapper.selectByPrimaryKey", bean);
	}

	public void insert(TestInfoBean bean) {
		sqlSessionTemplate.insert("TTestInfoMapper.insert", bean);
	}

	public void update(TestInfoBean bean) {
		sqlSessionTemplate.update("TTestInfoMapper.updateByPrimaryKeySelective", bean);
	}

	public void delete(TestInfoBean bean) {
		sqlSessionTemplate.delete("TTestInfoMapper.deleteByPrimaryKey", bean);
	}
}
