/*
	 * タイトル：TestInfoBean
	 * 説明    ：
	 *
	 * 著作権  ：Copyright(c) 2014 SOFTWIZ
	 * 会社名  ：株式会社 SOFTWIZ
	 *
	 * 変更履歴   ：2014/04/03
	 * 新規登録   :
*/

package jp.co.softwiz.main.domain.test;

import jp.co.softwiz.main.domain.TTestInfo;

/**
 * @author jk-yun@softwiz.jp
 * @version
 *
 */
public class TestInfoBean extends  TTestInfo{
	private String searchTestno;	//検索条件：メインコード
	private String searchTestname;	//検索条件：メイン名
	public String getSearchTestno() {
		return searchTestno;
	}

	public void setSearchTestno(String searchTestno) {
		this.searchTestno = searchTestno;
	}
	public String getSearchTestname() {
		return searchTestname;
	}
	public void setSearchTestname(String searchTestname) {
		this.searchTestname = searchTestname;
	}




}
