package jp.co.softwiz.main.domain.admin;

import jp.co.softwiz.main.domain.T_cate_subVo;

public class CateSubBean extends  T_cate_subVo{
	private String searchMainCode;	//検索条件：メインコード
	private String searchMainName;	//検索条件：メイン名
	private String mainName;		//メインコード
	private String createDay; 	//生成日（YYYY-MM-DD）
	private int maxViewOrder; 		//表示順番

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
	 * mainNameを取得します。
	 * @return mainName
	 */
	public String getMainName() {
	    return mainName;
	}

	/**
	 * mainNameを設定します。
	 * @param mainName mainName
	 */
	public void setMainName(String mainName) {
	    this.mainName = mainName;
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

	/**
	 * maxViewOrderを取得します。
	 * @return maxViewOrder
	 */
	public int getMaxViewOrder() {
	    return maxViewOrder;
	}

	/**
	 * maxViewOrderを設定します。
	 * @param maxViewOrder maxViewOrder
	 */
	public void setMaxViewOrder(int maxViewOrder) {
	    this.maxViewOrder = maxViewOrder;
	}


}
