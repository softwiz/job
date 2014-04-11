/*
	 * タイトル：LoginBean
	 * 説明    ：
	 *
	 * 著作権  ：Copyright(c) 2014 SOFTWIZ
	 * 会社名  ：株式会社 SOFTWIZ
	 *
	 * 変更履歴   ：2014/04/03
	 * 新規登録   :
*/

package jp.co.softwiz.main.domain.admin;

import jp.co.softwiz.main.domain.TCateMain;

/**
 * @author jk-yun@softwiz.jp
 * @version
 *
 */
public class CateMainBean extends  TCateMain{
	private String searchMainCode;	//検索条件：メインコード
	private String searchMainName;	//検索条件：メイン名
	private int subNum;				//サーブカテゴリの数
	private String createDay; 		//生成日（YYYY-MM-DD）

	/**
	 * searchMainCodeを取得します。
	 * @return searchMainCode
	 */
	public String getSearchMainCode() {
	    return searchMainCode;
	}

	/**
	 * searchMainCodeを設定します。
	 * @param searchMainCode searchMainCode
	 */
	public void setSearchMainCode(String searchMainCode) {
	    this.searchMainCode = searchMainCode;
	}

	/**
	 * searchMainNameを取得します。
	 * @return searchMainName
	 */
	public String getSearchMainName() {
	    return searchMainName;
	}

	/**
	 * searchMainNameを設定します。
	 * @param searchMainName searchMainName
	 */
	public void setSearchMainName(String searchMainName) {
	    this.searchMainName = searchMainName;
	}

	/**
	 * subNumを取得します。
	 * @return subNum
	 */
	public int getSubNum() {
	    return subNum;
	}

	/**
	 * subNumを設定します。
	 * @param subNum subNum
	 */
	public void setSubNum(int subNum) {
	    this.subNum = subNum;
	}

	/**
	 * createDayを取得します。
	 * @return createDay
	 */
	public String getCreateDay() {
	    return createDay;
	}

	/**
	 * createDayを設定します。
	 * @param createDay createDay
	 */
	public void setCreateDay(String createDay) {
	    this.createDay = createDay;
	}


}
