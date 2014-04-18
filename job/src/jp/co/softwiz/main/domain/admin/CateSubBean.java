package jp.co.softwiz.main.domain.admin;

import jp.co.softwiz.main.domain.TCateSub;

public class CateSubBean extends  TCateSub {
	private String searchMaincode;	//検索条件：メインコード
	private String searchMainname;	//検索条件：メイン名
	private String mainname;		//メインコード
	private String createday; 	//生成日（YYYY-MM-DD）
	private int maxVieworder; 		//表示順番
	public String getSearchMaincode() {
		return searchMaincode;
	}
	public void setSearchMaincode(String searchMaincode) {
		this.searchMaincode = searchMaincode;
	}
	public String getSearchMainname() {
		return searchMainname;
	}
	public void setSearchMainname(String searchMainname) {
		this.searchMainname = searchMainname;
	}
	public String getMainname() {
		return mainname;
	}
	public void setMainname(String mainname) {
		this.mainname = mainname;
	}
	public String getCreateday() {
		return createday;
	}
	public void setCreateday(String createday) {
		this.createday = createday;
	}
	public int getMaxVieworder() {
		return maxVieworder;
	}
	public void setMaxVieworder(int maxVieworder) {
		this.maxVieworder = maxVieworder;
	}



}
