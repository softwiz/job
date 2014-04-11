/*
	 * タイトル：共通コード大分類キー定義
	 * 説明    ：共通関数のパラメータ定数
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
 * @version
 *
 */
public class CommonConst {

	/****** ログインユーザーセッション キー ******/
	public static final String LOGIN_USER_KEY 			= "LOGIN_USER_SESSION_INFO";

	/****** ログインユーザー情報 *****/
	public static final String LOGIN_USER_INFO 			= "LOGIN_USER_REQUEST_INFO";

	/****** 日付フォマット関連 ******/
	public static final String MMDD						= "MM/Dd";
	public static final String YYYYMM					= "yyyy/MM";
	public static final String YYYYMMDD					= "yyyy/MM/dd";
	public static final String YYYYMMDDHHMMSS			= "yyyy/MM/dd HH:mm:ss";
	public static final String YYYYMMDDHHMM				= "yyyy/MM/dd HHmm";
	public static final String YYYYMD					= "yyyy/M/d";
	public static final String FORMAT_MMDD				= "MMdd";
	public static final String FORMAT_YYMM				= "yyMM";
	public static final String FORMAT_YYYYMM			= "yyyyMM";
	public static final String FORMAT_YYYYMMDD			= "yyyyMMdd";
	public static final String FORMAT_MMMM				= "MMMM";
	public static final String FORMAT_YYYYMD			= "yyyy年M月d日";
	public static final String FORMAT_HM				= "H時間m分";
	public static final String FORMAT_HMMM				= "HHmm";
	public static final String FORMAT_HM_MM				= "HH:mm";
	public static final int YEAR						= 0;
	public static final int MONTH						= 1;
	public static final int DAY							= 2;
	public static final int PLUS						= 0;
	public static final int MINUS						= 1;

	public static final long REQUEST_LIMIT				= 25*1024*1024;
	public static final long FILE_LIMT					= 5*1024*1024;
	public static final int MAX_MEMORY_SIZE				= 1024;

	/****** ページング関連 ******/
	//１ページに表示する最大レコード件数(10)
	public static final String LIST_COUNT 									= "10";
	//１ページに表示する最大レページング件数(10)
	public static final String PAGE_COUNT 									= "10";
	//１ページに表示するリスト始
	public static final String LIST_START 									= "LIST_START";
	//１ページに表示するリスト終了
	public static final String LIST_END 									= "LIST_END";

	/****** リターン値関連 ******/
	public static final int INT_RESULT_SUCCESS					= 1;

	/****** 数字関連 ******/
	public static final String STRING_VALUE_STANDARD_ZERO					= "0";
	public static final String STRING_VALUE_STANDARD_ONE					= "1";
	public static final String STRING_VALUE_STANDARD_TWO					= "2";
	public static final String STRING_VALUE_STANDARD_THREE					= "3";
	public static final String STRING_VALUE_STANDARD_FOUR					= "4";
	public static final String STRING_VALUE_ZERO_ONE						= "01";
	public static final String STRING_VALUE_MAINUS_ONE						= "-1";

	/****** FORMAT用関連 ******/
	public static final String STRING_FORMAT_SLASH							= "/";
	public static final String STRING_FORMAT_MINUS							= "-";
	public static final String STRING_NULL									= "";
	public static final String STRING_SPACE_NULL							= " ";
	public static final String STRING_FORMAT_APOSTROPHE       				= "'";
	public static final String STRING_FORMAT_APOSTROPHE_COMMA  			 	= "',";
	public static final String STRING_FORMAT_COMMA  						= ",";
	public static final String STRING_FORMAT_POINT  						= ".";
	public static final String STRING_FORMAT_MULTIPLICATION					= "*";
	public static final String STRING_PERCENT   							= "%";
	public static final String STRING_FORMAT_TAB	  						= "\t";
	public static final String STRING_PATTERN_YYYY_M_DD						= "\\d{4}/\\d{1}/\\d{2}";
	public static final String STRING_PATTERN_YYYY_M_D						= "\\d{4}/\\d{1}/\\d{1}";
	public static final String STRING_PATTERN_YYYY_MM_D						= "\\d{4}/\\d{2}/\\d{1}";
	public static final String STRING_PATTERN_YYYY_MM_DD					= "\\d{4}/\\d{2}/\\d{2}";

	/****** 共通パラメータ ******/
	public static final String STRING_PARAMETER_LOCALES						= "locale";

	/****** 共通ページリング ******/
	public static final String STRING_URL_LOGIN								= "redirect:../login/login.html";


	/****** 共通エラー ******/
	public static final String STRING_ERROR									= "error";

	/****** DB関連 ******/
	public static final String STRING_DELETE_FLAG_N							= "N";

}
