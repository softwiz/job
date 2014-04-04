/*
 * タイトル：ModelAndViewのパラメータキー及びオブジェクトキー定義
 * 説明    ：
 *
	 * 著作権  ：Copyright(c) 2014 SOFTWIZ
	 * 会社名  ：株式会社 SOFTWIZ
	 *
	 * 変更履歴   ：
	 * 新規登録   :2014/01/27
*/

package jp.co.softwiz.main.common.constants;

/**
 * @author jk-yun
 * @version 1.0
 */
public class ModelConstants {

	/****************************
	 * 共通 Model セット用
	 ****************************/
	public static final String STRING_USER_NAME 									= "USERNAME";
	public static final String STRING_LOGIN_SESSION									= "login";
	public static final String STRING_MODEL_OBJECT_PAGING_ELEMENTS					= "pageElements";
	public static final String STRING_MODEL_OBJECT_PAGING_START_NO 					= "LIST_START";
	public static final String STRING_MODEL_OBJECT_PAGING_END_NO 					= "LIST_END";


	/****************************
	 * 共通 parameter セット用
	 ****************************/
	public static final String STRING_PARAMETER_MOVEDPAGE 							= "movedPage";
	public static final String STRING_MODEL_OBJECT_PAGEELEMENTLIST					= "pageElementList";

	/****************************
	 * マッピング　セット用
	 ****************************/
	//ログイン
	public static final String REQ_MAPPING_LOGIN 									= "/login/login";
	public static final String REQ_MAPPING_LOGOUT 									= "/login/logout";
	public static final String REQ_MAPPING_LOGIN_PROCESS 							= "/login/loginProcess";
	public static final String REQ_MAPPING_PASSWORD 								= "/password/password";
	public static final String REQ_MAPPING_PASSWORD_PROCESS 						= "/password/passwordProcess";
	public static final String REQ_MAPPING_MAIN										= "/mypage/main";

	//カテゴリ情報
	public static final String REQ_MAPPING_CATEGORY 								= "/admin/category";
	public static final String REQ_MAPPING_CATEGORY_VIEW							= "/admin/categoryview";
	public static final String REQ_MAPPING_CATE_MAIN_UPDATE 						= "/admin/categoryUpdate";
	public static final String REQ_MAPPING_GET_CATE_SUB_LIST 						= "/admin/categorySub";
	public static final String REQ_MAPPING_CATE_SUB_VIEW 							= "/admin/categorySubView";
	public static final String REQ_MAPPING_CATE_SUB_UPDATE 							= "/admin/categorySubUpdate";
	public static final String REQ_MAPPING_CATE_SUB_DELETE 							= "/admin/categorySubDelete";

	/****************************
	 * ページVIEWネームセット用
	 ****************************/
	/** ログイン **/
	public static final String PAGE_MODEL_LOGIN 									= "/login/login";
	public static final String PAGE_MODEL_PASSWORD 									= "/password/password";
	public static final String PAGE_MODEL_MYPAGE									= "/mypage/main";


	/** エラー画面 **/
	public static final String PAGE_MODEL_ERROR										= "/error/error";

	//カテゴリ情報
	public static final String PAGE_MODEL_CATEGORY_MAIN 							= "/admin/category";
	public static final String PAGE_MODEL_CATEGORY_VIEW 							= "/admin/categoryview";
	public static final String PAGE_MODEL_CATEGORY_SUB 								= "/admin/categorySub";

	/****************************
	 * Redirect Login
	 ****************************/
	public static final String STRING_REDIRECT_LOGIN 								= ".."+PAGE_MODEL_LOGIN+".html";
}
