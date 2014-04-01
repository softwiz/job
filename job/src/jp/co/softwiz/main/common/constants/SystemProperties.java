/*
	 * タイトル：システム完了の属性定義
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
public class SystemProperties {

	//COMMON
	//public static final String ROOT_FILE_PATH			= "/pleiades/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/focuswf/";
	//public static final String ROOT_FILE_PATH			= "/pleiades/workspace/focuswf/WebContent/";
	public static final String ROOT_FILE_PATH			= "/usr/local/tomcat/webapps/focuswf/";
	public static final String ADM_PROPERTIES_PATH		= "WEB-INF/properties/admsetting.properties";
	public static final String ROOT_URL					= "http://localhost:8080/focuswf/";
	//public static final String ROOT_URL					= "http://www.softwiz.co.jp/focuswf/";
	public static final String DOWN_LOAD_PATH			= "/files/";
	public static final String UP_LOAD_PATH				= "/upload/";
	public static final String FACTORY_DB 				= "Postgres";
}

 /**public class SystemProperties {

	//COMMON
	public static final String ROOT_FILE_PATH			= "/usr/local/tomcat7/webapps/hanryuupload";
	public static final String ROOT_URL					= "http://upload.hanryudpt.jp";
	public static final String DOWN_LOAD_PATH			= "/files/";
	public static final String UP_LOAD_PATH				= "/upload/";
}*/