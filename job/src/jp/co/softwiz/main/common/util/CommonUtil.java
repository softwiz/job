/*
 * タイトル：共通UTIL関数
 * 説明    ：
 *
	 * 著作権  ：Copyright(c) 2013 SOFTWIZ
	 * 会社名  ：株式会社 SOFTWIZ
	 *
	 * 変更履歴   ：
	 * 新規登録   :2014/01/27
*/

package jp.co.softwiz.main.common.util;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import jp.co.softwiz.main.common.constants.CommonConst;
import jp.co.softwiz.main.common.constants.SystemProperties;
import jp.co.softwiz.main.domain.login.LoginBean;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DurationFormatUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.ibm.icu.text.Transliterator;

/**
 * @author jk-yun
 * @version
 */
public class CommonUtil{

	// クライアントIPを取得
	private static final String	HEADER_X_FORWARDED_FOR	= "X-FORWARDED-FOR";

	/**
	 * 入力した文字列がNULLの場合、””を返却（長さ０の空白文字）
	 * @param str
	 * @return
	 * @see
	 */
	public static String nullToString(String str) {
		if (StringUtils.isEmpty(str)) {
			return "";
		} else {
			return str;
		}
	}

	/**
	 * 入力した文字列がNULLの場合、int 0『ゼロ』を返却
	 * @param intVal
	 * @return
	 * @see
	 */
	public static int nullToZero(Integer intVal) {
		if (intVal == null) {
			return 0;
		} else {
			return intVal.intValue();
		}
	}

	/**
	 * 入力された数値がNULLの場合’０’「ゼロ」を返却
	 * method description
	 * @param intVal
	 * @return
	 * @see
	 */
	public static Integer nullToIntegerZero(Integer intVal){
		if (intVal == null){
			return new Integer(0);
		}else{
			return intVal;
		}
	}

	/**
	 * 入力した文字列がNULLの場合、double 0『ゼロ』を返却
	 * @param intVal
	 * @return
	 * @see
	 */
	public static double nullToDoubleZero(Double dVal) {
		if (dVal == null) {
			return 0;
		} else {
			return dVal.doubleValue();
		}
	}

	/**
	 * 入力した文字列がNULLの場合、double 0『ゼロ』を返却
	 * method description
	 * @param inVal
	 * @return
	 * @see
	 */
	public static BigInteger nullToBigIntegerZero(Integer inVal){
		if (inVal == null){
			return new BigInteger(String.valueOf(0));
		}else{
			return new BigInteger(inVal.toString());
		}
	}

	/**
	 * 入力した文字列がNULLの場合、double 0『ゼロ』を返却
	 * method description
	 * @param inVal
	 * @return
	 * @see
	 */
	public static BigDecimal nullToBigDecimalZero(BigDecimal inVal){
		if (inVal == null){
			return new BigDecimal(String.valueOf(0));
		}else{
			return inVal;
		}
	}

	/**
	 * 入力した文字列①の左側から入力した文字列②を指定した数字の数分付けて返却
	 * @param str1
	 * @param str2
	 * @param idx
	 * @return
	 * @see
	 * ID : COM_UTIL_004
	 */
	public static String leftPadding(String str1, String str2, int length) {
		StringBuffer SB = new StringBuffer();
		int startIdx = str1.length();
		for(int i=startIdx; i<length; i++) {
			SB.append(str2);
		}
		SB.append(str1);
		return SB.toString();
	}

	/**
	 * 入力した文字列①の左側から入力した文字列②を指定した数字の数分付けて返却
	 * @param str1
	 * @param str2
	 * @param idx
	 * @return
	 * @see
	 * ID : COM_UTIL_005
	 */
	public static String rightPadding(String str1, String str2, int length) {
		StringBuffer SB = new StringBuffer();
		int startIdx = str1.length();
		for (int i = startIdx; i < length; i++) {
			SB.append(str2);
		}

		StringBuffer strSB = new StringBuffer(str1);
		strSB.append(SB);

		return strSB.toString();
	}

	/**
	 * 入力した日付が正しいかチェックしtrueまたはfalseを返却
	 * @param date
	 * @return
	 * @see
	 * ID : COM_UTIL_006
	 */
	public static boolean isValidDate(String date) {
		boolean isValid = true;
		/*** 日付変数初期化 ***/
		String strYear = "";
		String strMonth = "";
		String strDay = "";

		int iYear = 0;
		int iMonth = 0;
		int iDay = 0;
		//日付が入力されてない場合または長さが８桁じゃないとFalseを返却
		if (StringUtils.isEmpty(date) || date.length() < 8) {
			isValid = false;
		} else {
			/*** 日付パラメータPARSE ***/
			strYear = date.substring(0, 4);
			strMonth = date.substring(4, 6);
			strDay = date.substring(6, 8);
			iYear = Integer.parseInt(strYear);
			iMonth = Integer.parseInt(strMonth);
			iDay = Integer.parseInt(strDay);
		}

		Calendar cal = new GregorianCalendar(iYear, iMonth - 1, iDay);

		// 日付/時刻の解釈を厳密に行う
		cal.setLenient(false);
		try {
			iYear = cal.get(Calendar.YEAR);
			iMonth = cal.get(Calendar.MONTH) + 1;
			iDay = cal.get(Calendar.DATE);
		} catch (Exception e) {
			isValid = false;
		}
		return isValid;
	}

	/**
	 * 入力した年月の最終日を返却
	 *
	 * @param strYearMonth
	 * @return
	 * @see
	 * ID : COM_UTIL_007
	 */
	public static String getLastDay(String strYearMonth) {
		int year = 0;
		int month = 0;
		int day = 0;

		if (strYearMonth != null) {
			year = Integer.parseInt(strYearMonth.substring(0, 4));
			month = Integer.parseInt(strYearMonth.substring(4, 6));
		}
		switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				day = 31;
				break;
			case 2:
				if ((year % 4) == 0) {
					if ((year % 100) == 0 && (year % 400) != 0) {
						day = 28;
					} else {
						day = 29;
					}
				} else {
					day = 28;
				}
				break;
			default:
				day = 30;
		}
		return CommonUtil.leftPadding(String.valueOf(day), "0", 2);
	}
	/**
	 * 入力した年月の最終日を取得、年月日を返却
	 * @param strYearMonth
	 * @return
	 * @see
	 */
	public static String getLastDayYYYYMMDD(String strYearMonth){
		strYearMonth = strYearMonth.substring(0, 6);
		String yearMonthDay = new StringBuffer()
			.append(strYearMonth)
			.append(getLastDay(strYearMonth)).toString();
		return yearMonthDay;
	}
	public static String getLastDayYYYYMMDD(String strYear, String strMonth){
		String strYearMonth = new StringBuffer()
			.append(strYear)
			.append(CommonUtil.leftPadding(strMonth, "0", 2))
			.toString();

		String yearMonthDay = new StringBuffer()
			.append(strYearMonth)
			.append(getLastDay(strYearMonth)).toString();
		return yearMonthDay;
	}
	public static String getFirstDayYYYYMMDD(String strYearMonth){
		strYearMonth = strYearMonth.substring(0, 6);
		String yearMonthDay = new StringBuffer()
			.append(strYearMonth)
			.append("01")
			.toString();
		return yearMonthDay;
	}
	public static String getFirstDayYYYYMMDD(String strYear, String strMonth){
		String yearMonthDay = new StringBuffer()
			.append(strYear)
			.append(CommonUtil.leftPadding(strMonth, "0", 2))
			.append("01")
			.toString();
		return yearMonthDay;
	}

	/**
	 * 先月の日付を返却
	 * @param strFormat
	 * @return
	 * @see
	 * ID : COM_UTIL_008
	 */
	public static String getLastMonthDateTime(String strFormat) {
		SimpleDateFormat SDF = new SimpleDateFormat(strFormat);
		//開始日：本日の一ヶ月前の日
		Calendar cal1 = Calendar.getInstance();
		cal1.getTime();
		cal1.add(Calendar.MONTH, -1);
		cal1.add(Calendar.DATE, 1);
		return SDF.format(cal1.getTime());
	}

	/**
	 * method 検索開始日付を返却　：　当日より一か月前の日
	 * @param formatStr
	 * @return
	 * @see
	 */
	public static String getStartDate(String formatStr){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		cal.add(Calendar.DATE, +1);
		return new SimpleDateFormat(formatStr).format(cal.getTime());
	}

	/**
	 * 現在の日付を返却
	 * @param strFormat
	 * @return
	 * @see
	 * ID : COM_UTIL_008
	 */
	public static String getCurrentDateTime(String strFormat) {
		SimpleDateFormat SDF = new SimpleDateFormat(strFormat);
		return SDF.format(new Date());
	}
	/**
	 * 日付を足して、結果を返却
	 *
	 * @param field
	 * @param operator
	 * @param amount
	 * @param date
	 * @return
	 * @see
	 * ID : COM_UTIL_0009
	 */
	public static String getOpDate(int field, int operator, int amount, String date) {
		SimpleDateFormat SDF = new SimpleDateFormat(CommonConst.YYYYMMDD);
		String strYear = date.substring(0, 4);
		String strMonth = date.substring(4, 6);
		String strDay = date.substring(6, 8);
		int iYear = Integer.parseInt(strYear);
		int iMonth = Integer.parseInt(strMonth);
		int iDay = Integer.parseInt(strDay);
		Calendar cal = new GregorianCalendar(iYear, iMonth - 1, iDay);
		switch (field) {
			// year
			case CommonConst.YEAR:
				if (operator == CommonConst.PLUS) {
					cal.add(Calendar.YEAR, amount);
				} else {
					cal.add(Calendar.YEAR, -amount);
				}
				break;

			// month
			case CommonConst.MONTH:
				if (operator == CommonConst.PLUS) {
					cal.add(Calendar.MONTH, amount);
				} else {
					cal.add(Calendar.MONTH, -amount);
				}
				break;

			// day
			case CommonConst.DAY:
				if (operator == CommonConst.PLUS) {
					cal.add(Calendar.DATE, amount);
				} else {
					cal.add(Calendar.DATE, -amount);
				}
				break;
		}
		return SDF.format(cal.getTime());
	}

	/**
	 * 入力した全角文字を半角に変換して、返却
	 * @param strFullString
	 * @return
	 * @see
	 * ID : COM_UTIL_0010
	 */
	public static String toHalfString(String strFullString) {
		Transliterator tr = Transliterator.getInstance("Fullwidth-Halfwidth");
		String rtn = tr.transliterate(strFullString);
		return rtn;
	}

	/**
	 * 入力した半角文字を全角に変換して、返却
	 * @param strHalfString
	 * @return
	 * @see
	 * ID : COM_UTIL_0011
	 */
	public static String toFullString(String strHalfString) {
		Transliterator tr = Transliterator.getInstance("Halfwidth-Fullwidth");
		String rtn = tr.transliterate(strHalfString);
		return rtn;
	}

	/**
	 * 入力した文字にコンマをつけて返却 ex)1000 -> 1,000
	 * @param strMoney
	 * @return
	 * @see
	 * ID：COM_UTIL_012
	 */
	public static String getMoneyFormat(String strMoney) {
		NumberFormat nf = NumberFormat.getNumberInstance();
		double money = Double.parseDouble(strMoney);
		String retMoney = nf.format(money);
		return retMoney;
	}

	/**
	 * 入力した 文字列に『< 、 >、 & 』を 『 &lt; 、 &gt; 、 &amp;』に変換して返却
	 * @param str
	 * @return
	 * @see
	 * ID : COM_UTIL_013
	 */
	public static String replaceHtmlTag(String str) {
		String retStr = "";
		if (StringUtils.isNotEmpty(str)){
			retStr = str.replaceAll("&", "&amp;");
			retStr = retStr.replaceAll("<", "&lt;");
			retStr = retStr.replaceAll(">", "&gt;");
			retStr = retStr.replaceAll("\\#", "&#35;");
			retStr = retStr.replaceAll("\\(", "&#40;");
			retStr = retStr.replaceAll("\\)", "&#41;");
			retStr = retStr.replaceAll("\"", "&quot;");
		}
		return retStr;
	}

	public static String replaceDoubleQuote(String str) {
		String retStr = "";
		//System.out.println("1----------------------["+str+"]--------------------");
		//String.valueOf(b)
		if (StringUtils.isNotEmpty(str)){
			retStr = str.replaceAll("\"", "&quot;");
		}
		return retStr;
	}

	/**
	 * 入力した文字列に『’』を『&#39;』に変換して返却
	 * @param str
	 * @return
	 * @see
	 * ID :　COM_UTIL_014
	 */
	public static String replaceQuote(String str) {
		String retStr = str.replaceAll(",", "");
		return retStr;
	}

	/**
	 * 入力した文字列に『，』を『&#44;』に変換して返却
	 * @param str
	 * @return
	 * @see
	 * ID　:　COM_UTIL_015
	 */
	public static String replaceComma(String str) {
		String retStr = str.replaceAll(",", "");
		return retStr;
	}

	/**
	 * 入力された文字列の中でブランクを除外して返却
	 * method description
	 * @param str
	 * @return
	 * @see
	 */
	public static String replaceBlank(String str){
		String retStr = StringUtils.replace(str, " ", "");
		retStr = StringUtils.replace(retStr, "　","");
		return retStr;
	}

	/**
	 * 入力したひらがな文字をカタカナに変更
	 * @param strHira
	 * @return
	 * @see
	 * ID : COM_UTIL_016
	 */
	public static String hiraToKata(String strHira) {
		Transliterator tr = Transliterator.getInstance("Hiragana-Katakana");
		String strKata = tr.transliterate(strHira);
		return strKata;
	}

	/**
	 * 入力したカタカナ文字をひらがなに変更
	 * @param strKata
	 * @return
	 * @see
	 * ID : COM_UTIL_017
	 */
	public static String kataToHira(String strKata) {
		Transliterator tr = Transliterator.getInstance("KataKana-Hiragana");
		String strHira = tr.transliterate(strKata);
		return strHira;
	}

	/**
	 * 接続者IPを取得し返却
	 * method description
	 * @param request
	 * @return
	 * @see
	 */
	public static String getUserAddress(HttpServletRequest request) {
		String remoteAddr = null;
		Enumeration<?> headers = null;
		remoteAddr = request.getRemoteAddr();
		headers = request.getHeaders(HEADER_X_FORWARDED_FOR);

		if (headers != null) {
			while (headers.hasMoreElements()) {
				String[] ips = StringUtils.split((String) headers.nextElement(), ",");
				int size = ips.length;
				for (int i = 0; i < size; i++) {
					String proxy = ips[i].trim();
					if (!StringUtils.equals(proxy, "unknown") && (!StringUtils.isEmpty(proxy))) {
						return proxy;
					}
				}
			}
		}
		return remoteAddr;
	}

	/**
	 * ログインされているかチェック
	 * method description
	 * @param request
	 * @return
	 * @see
	 */
	public static boolean isLogin(HttpServletRequest request) {
		LoginBean login = (LoginBean) WebUtils.getSessionAttribute(request, CommonConst.LOGIN_USER_KEY);
		if (login != null) {
			// if (login.getUserId()!=null && login.getUserId().equals(userId)){
			return true;
			// }
		} else {
			return false;
		}
		// return false;
	}

	/**
	 * YYYYMMDDのフォマット型式で日付を返却
	 * @param date
	 * @return Date
	 * @see
	 */
	public static Date getDateFormat(String date) {
		SimpleDateFormat SDF = new SimpleDateFormat(CommonConst.FORMAT_YYYYMMDD);
		Date tmp = null;
		try {
			tmp = SDF.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tmp;
	}

	/**
	 * 指定した日付文字を指定しフォマットに変換して返却
	 * method description
	 * @param strDate
	 * @param format
	 * @return
	 * @see
	 */
	public static String getChangeDateFormat(String strDate, int format){
		//Date date = getDateFormat(strDate);
		int icnt = StringUtils.indexOf(strDate, '/');
		SimpleDateFormat sdf;
		if (icnt > 0){
			sdf = new SimpleDateFormat(CommonConst.YYYYMMDD, Locale.JAPAN);
		}else{
			sdf = new SimpleDateFormat(CommonConst.FORMAT_YYYYMMDD, Locale.JAPAN);
		}
		Date tmp = null;
		try{
			tmp = sdf.parse(strDate);
		}catch(ParseException e){
			e.printStackTrace();
		}
		Date date = tmp;
		String strFormat = null;

		switch(format){
			case 1 :
				strFormat = CommonConst.YYYYMM;
			case 2 :
				strFormat = CommonConst.YYYYMMDD;
				break;
			case 3 :
				strFormat = CommonConst.YYYYMMDDHHMMSS;
				break;
			case 4 :
				strFormat = CommonConst.FORMAT_YYMM;
				break;
			case 5 :
				strFormat = CommonConst.FORMAT_YYYYMM;
				break;
			case 6 :
				strFormat = CommonConst.FORMAT_YYYYMMDD;
				break;
		}
		SimpleDateFormat SDF = new SimpleDateFormat(strFormat);
		String retDate = SDF.format(date);
		return retDate;
	}

	/**
	 * method 指定した期間内の日を指定したフォーマットで変更し、リストに格納して返却
	 * @param startDate
	 * @param endDate
	 * @param format
	 * @return
	 * @see
	 */
	public static ArrayList<String> getDayList(String startDate, String endDate, int format){
		//日付リストの取得
		ArrayList<String> getDateList = getDayList(startDate, endDate);

		//日付形式の変更・格納
		ArrayList<String> outDateList = new ArrayList<String>();
		if(getDateList!=null && getDateList.size()>0){
			for(int i=0; i<getDateList.size(); i++){
				//日付のフォーマットを変更し、格納処理
				outDateList.add(getChangeDateFormat(getDateList.get(i), format));
			}
		}
		return outDateList;
	}
	/**
	 * method 指定した期間内の月をリストに格納して返却
	 * @param startDate
	 * @param endDate
	 * @return
	 * @see
	 */
	public static ArrayList<String> getMonthList(String startYearMonth, String endYearMonth) {
		/** =============================================================== **/
		/** Parameter 妥当性確認
		/** =============================================================== **/
		if(startYearMonth==null || StringUtils.isEmpty(startYearMonth) || startYearMonth.length()<6
		|| endYearMonth==null || StringUtils.isEmpty(endYearMonth) || endYearMonth.length()<6){
			return new ArrayList<String>();
		}

		/** =============================================================== **/
		/** Parameter 加工
		/** =============================================================== **/
		//検索開始年月
		startYearMonth = startYearMonth
								.replace("/", "").replace(".", "").replace("-", "")
								.substring(0, 6);
		//検索終了年月
		endYearMonth = endYearMonth
								.replace("/", "").replace(".", "").replace("-", "")
								.substring(0, 6);

		/** =============================================================== **/
		/** Data 加工
		/** =============================================================== **/
		ArrayList<String> monthList = new ArrayList<String>();
		for(int i=Integer.parseInt(startYearMonth); i<=Integer.parseInt(endYearMonth); i++){
			monthList.add(String.valueOf(i));
			if(String.valueOf(i).subSequence(4, 6).equals("12")){
				i+=88;
			}
		}
		return monthList;
	}
	/**
	 * 指定した期間内の日をリストに格納して返却
	 * @param startdate
	 * @param enddate
	 * @return ArrayList
	 * @see
	 */
	public static ArrayList<String> getDayList(String startDate, String endDate) {
		ArrayList<String> outDateList = new ArrayList<String>();
		// 開始日の年月日区切り文字削除
		if (!StringUtils.isEmpty(startDate)) {
			startDate = startDate.replace("/", "");
			startDate = startDate.replace("-", "");
		}
		// 終了日の年月日区切り文字削除
		if (!StringUtils.isEmpty(endDate)) {
			endDate = endDate.replace("/", "");
			endDate = endDate.replace("-", "");
		}
		Date localStartDate = getDateFormat(startDate);
		Date localEndDate = getDateFormat(endDate);
		Calendar calStart = Calendar.getInstance();
		Calendar calEnd = Calendar.getInstance();

		calStart.setTime(localStartDate);
		calEnd.setTime(localEndDate);
		// 20100221 日付の日数計算方法修正
		long d1 = calStart.getTime().getTime();
		long d2 = calEnd.getTime().getTime();
		int intervalDay = (int) ((d2 - d1) / (1000 * 60 * 60 * 24));
		// int intervalDay = calEnd.get(Calendar.DAY_OF_YEAR) - calStart.get(Calendar.DAY_OF_YEAR);
		String dateKey = "";

		for (int i = 0; i < intervalDay + 1; i++) {
			StringBuffer SB = new StringBuffer();
			SB.append(calStart.get(Calendar.YEAR));
			SB.append(CommonConst.STRING_FORMAT_SLASH);
			SB.append(calStart.get(Calendar.MONTH) + 1);
			SB.append(CommonConst.STRING_FORMAT_SLASH);
			SB.append(calStart.get(Calendar.DAY_OF_MONTH));
			//dateKey = calStart.get(Calendar.YEAR) + "/" + (calStart.get(Calendar.MONTH) + 1) + "/" + calStart.get(Calendar.DAY_OF_MONTH);
			dateKey = SB.toString();
			outDateList.add(dateKey);
			calStart.add(5, 1);
		}
		return outDateList;
	}
	public static ArrayList<String> getDayList(String yearMonth) {
		return getDayList(yearMonth.substring(0, 4), yearMonth.substring(4, yearMonth.length()));
	}

	/**
	 * 指定した日付に対する曜日を返却
	 * @param yearMonthDay
	 * @return
	 * @see
	 */
	@SuppressWarnings("static-access")
	public static int getWeekDay(String yearMonthDay) {
		if (!isValidDate(yearMonthDay)) {
			return -1;
		}

		Calendar caleandar = Calendar.getInstance();

		int year = Integer.parseInt(StringUtils.substring(yearMonthDay, 0, 4));
		int month = Integer.parseInt(StringUtils.substring(yearMonthDay, 4, 6));
		int day = Integer.parseInt(StringUtils.substring(yearMonthDay, 6, 8));

		caleandar.set(year, month - 1, day);
		return caleandar.get(caleandar.DAY_OF_WEEK);
	}

	/**
	 * マルチバイト用Substring
	 * @param str
	 * @param startIdx
	 * @param endIdx
	 * @return
	 * @see
	 */
	public static String mbSubString(String str, int startIdx, int endIdx) {
		StringBuffer SB = new StringBuffer(str);
		int strLen = SB.length();
		StringBuffer retSB = new StringBuffer();
		endIdx = startIdx+endIdx;
		for (int icnt=startIdx; icnt < endIdx; icnt++){
			if (icnt < strLen){
				retSB.append(SB.substring(icnt, icnt+1));
			}
		}
	    return retSB.toString();
    }

	/**
	 *
	 * ファイルを削除
	 * @param filePath
	 * @param fileName
	 * @see
	 */
	public static void deleteFile(String filePath, String fileName){
		StringBuffer SB = new StringBuffer();
		SB.append(filePath);
		SB.append(CommonConst.STRING_FORMAT_SLASH);
		SB.append(fileName);
		File file = new File(SB.toString());
		if (file.exists()){
			try {
				file.delete();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static String excelHeaderFileName(){
		String fileName = new StringBuffer()
			.append("attachment; filename=Excel_")
			.append(CommonUtil.getCurrentDateTime("yyMMddHHmmss"))
			.append(".xls")
			.toString();
		return fileName;
	}

	public static String excelHeaderFileName(String name){
		String fileName = new StringBuffer()
			.append("attachment; filename=")
			.append(name)
			.append("_")
			.append(CommonUtil.getCurrentDateTime("yyMMddHHmmss"))
			.append(".xls")
			.toString();
		return fileName;
	}


	/**
	 * パラメータが数字なのか確認してTRUE/FALSEを反す。
	 * @param number
	 * @return Boolean
	 * @see
	 *
	 */
	public static Boolean isNumber(String number){
		if(number.equals(CommonConst.STRING_NULL)) return false;
		for(int i=0;i<number.length();i++){
			if(!Character.isDigit(number.charAt(i))) return false;
		}
		return true;
	}

	/**
	 * 指定した少数点をラウンド
	 * method description
	 * @param str
	 * @return
	 * @see
	 */
	public static Integer getRoundVal(String str){
		if(str.indexOf(".")>0){
			String[] a = str.split("\\.");
			Integer returnInteger = Integer.parseInt(a[0]);
			Integer afterInteger =Integer.parseInt(String.valueOf(a[1].charAt(0)));
			if(afterInteger >= 5) return ++returnInteger;
			return returnInteger;
		}
		return Integer.parseInt(str);

	}

	/**
	 * 指定した文字を数値に変換し、返却
	 * method description
	 * @param str
	 * @return
	 * @see
	 */
	public static Integer stringToInteger(String str){
		Integer ret = 0;
		if (!StringUtils.isEmpty(str)){
			if(StringUtils.isNumeric(str)){
				ret = Integer.valueOf(str);
			}
		}
		return ret;
	}

	/**
	 * 文字列内の特定文字にパラメータELEMENTをセットする。
	 * str:■{}年{}月　MD売上集計 paramList:{"2010","03"} -> ■2010年03月　MD売上集計
	 * @param str
	 * @param paramList
	 * @return String
	 * @see
	 */
	public static String replaceParam(String str, String[] paramList){
		int i = 0;
		while(str.indexOf("{}")>-1){
			if(i<paramList.length){
				str = str.replaceFirst("\\{\\}", paramList[i++]);
			}
			else{
				str = str.replaceFirst("\\{\\}", "");
			}
		}
		return str;
	}

	/**
	 *  ログインチェック及び照会権限チェック
	 * @param request
	 * @param response
	 * @param authNo
	 * @param retUserAuthBean
	 * @return
	 * @see
	 */
	public static boolean loginCheckProcess(
			HttpServletRequest request, String authNo) {
		//LgoinBean 取得
		LoginBean login = (LoginBean) WebUtils.getSessionAttribute(request, CommonConst.LOGIN_USER_KEY);
		//取得したログインビンがNULLの場合、ログイン画面へ
		if (login ==null)
			return false;
		return true;

	}

	/**
	 *  ログインセッション情報を返す。
	 * @param request
	 * @param response
	 * @param authNo
	 * @param retUserAuthBean
	 * @return
	 * @see
	 */
	public static LoginBean getLoginSession(HttpServletRequest request) {
		//LoginBean 取得
		LoginBean login = (LoginBean) WebUtils.getSessionAttribute(request, CommonConst.LOGIN_USER_KEY);
		//取得したログインビンがNULLの場合、ログイン画面へ
		if (login ==null)
			return null;
		return login;

	}

	/**
	 * @description セッションからログインユーザーIDを取得し返却
	 * @method getLoginUserId
	 * @param request
	 * @return userId
	 */
	public static String getLoginUserId(HttpServletRequest request) {
		LoginBean login = (LoginBean) WebUtils.getSessionAttribute(request, CommonConst.LOGIN_USER_KEY);
		StringBuffer userId = new StringBuffer();
		if (login != null)
			userId.append(login.getUserid());
		return userId.toString();
	}

	/**
	 *　セッションからログインユーザー名を取得し返却
	 * @param request
	 * @return String
	 * @see
	 */
	public static String getLoginUserName(HttpServletRequest request) {
		LoginBean login = (LoginBean) WebUtils.getSessionAttribute(request, CommonConst.LOGIN_USER_KEY);
		String userName = "";
		if (login != null)
			userName = login.getUserName();
		return userName;
	}

	/**
	 *
	 * method description
	 * @param twoDepthMap
	 * @return
	 * @see
	 */
	public static String getFirstLink(TreeMap<String,List<String>> twoDepthMap){
		Set<String> set = twoDepthMap.keySet();
		Object []keys =set.toArray();
		return keys[0].toString().split(":")[0];
	}

	/**
	 *
	 * method description
	 * @param treeDepthMap
	 * @return
	 * @see
	 */
	public static String getFirstLink(List<String> treeDepthMap){
		String str = treeDepthMap.get(0);
		return str.split(":")[0];

	}








    /**
     * 開始時刻と終了時刻から処理時間を返す
     * 引数が Date 型のとき
     */
    public static String toDiffTime(Date startTime, Date endTime) {
        String diffTime = DurationFormatUtils.formatPeriod(startTime.getTime(),
                endTime.getTime(), CommonConst.FORMAT_HM);
        return diffTime;
    }


    /**
     * 開始時刻と終了時刻から処理時間を返す
     * 引数が String 型のとき
     *   startDate = "yyyy/MM/dd HHmm"
     *   endDate = "yyyy/MM/dd HHmm"
     * @return H時間m分
     */
    public static String toDiffTimeString(String startDate, String endTDate) {
		SimpleDateFormat SDF = new SimpleDateFormat(CommonConst.YYYYMMDDHHMM);
		Date startTime = null;
		Date endTime = null;

		try {
			startTime = SDF.parse(startDate);
			endTime = SDF.parse(endTDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
        String diffTime = "";
        if(startTime != null && endTime != null) {
        	diffTime = DurationFormatUtils.formatPeriod(startTime.getTime(),
                endTime.getTime(), CommonConst.FORMAT_HM);
        }
        return diffTime;
    }


    /**
     * 開始時刻と終了時刻から処理時間を返す
     * 引数が String 型のとき
     *   startDate = "yyyy/MM/dd HHmm"
     *   endDate = "yyyy/MM/dd HHmm"
     * @return HHmm
     */
    public static String toDiffTimeStringHHMM(String startDate, String endTDate) {
		SimpleDateFormat SDF = new SimpleDateFormat(CommonConst.YYYYMMDDHHMM);
		Date startTime = null;
		Date endTime = null;

		try {
			startTime = SDF.parse(startDate);
			endTime = SDF.parse(endTDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
        String diffTime = "";
        if(startTime != null && endTime != null) {
        	if(startTime.getTime() > endTime.getTime()) endTime = startTime;
        	diffTime = DurationFormatUtils.formatPeriod(startTime.getTime(),
                endTime.getTime(), CommonConst.FORMAT_HMMM);
        }
        return diffTime;
    }

    public static String getStartTime(String startTime, String unit) {
    	String min = startTime.substring(2, 4);
    	int minI = Integer.parseInt(min);
    	int unitI = Integer.parseInt(unit);
    	// 時間を取得する
    	int time = Integer.parseInt(startTime.substring(0, 2));
    	if((minI + unitI) >= 60) {
    		time = time + 1;
    	}
    	String rtnTime = Integer.toString(time);
    	if(time < 10) {
    		rtnTime = "0".concat(rtnTime);
    	}

    	// 分を取得する
    	int round = minI / unitI;
    	int mod = minI % unitI;

    	int minute = 0;
    	if(mod > 0) {
    		minute = (round + 1) * unitI;
    	} else {
    		minute = round * unitI;
    	}

    	if(minute == 60) {
    		minute = 0;
    	}

    	String rtnMinute = Integer.toString(minute);
    	if(minute < 10) {
    		rtnMinute = "0".concat(rtnMinute);
    	}
    	return rtnTime.concat(rtnMinute);
    }

    public static String getEndTime(String endTime, String unit) {
    	String min = endTime.substring(2, 4);
    	int minI = Integer.parseInt(min);
    	int unitI = Integer.parseInt(unit);
    	// 時間を取得する
    	int time = Integer.parseInt(endTime.substring(0, 2));
    	String rtnTime = Integer.toString(time);
    	if(time < 10) {
    		rtnTime = "0".concat(rtnTime);
    	}

    	// 分を取得する
    	int round = (int) Math.floor(minI / unitI);
    	int minute = round * unitI;

    	String rtnMinute = Integer.toString(minute);
    	if(minute < 10) {
    		rtnMinute = "0".concat(rtnMinute);
    	}
    	return rtnTime.concat(rtnMinute);
    }


    /**
     * HHMM形式の文字列から、float形式で時間を返す
     * @param sHHMM  HHMM形式の文字列
     * @return 時間(少数点)
     */
    public static double transHHMMStrToFloatHour(String sHHMM) {

    	if(sHHMM == null){
    		return 0;
    	}

    	if(sHHMM.length() != 4){
    		return 0;
    	}

    	String strHH = sHHMM.substring(0, 2);
    	String strMM = sHHMM.substring(2, 4);

    	int nHH = 0;
    	double fMM = 0;
    	double rtnHour = 0;
    	try{
	    	nHH = Integer.parseInt(strHH);
	    	fMM = Float.parseFloat(strMM);

	    	rtnHour = (float)(nHH + fMM / 60);
    	} catch (NumberFormatException e) {
    		return 0;
    	}
 		return rtnHour;
    }

    /**
     * HHMM形式のString型のListより合計を計算し、double形式で返却する
     * @param sHHMM  HHMM形式の文字列型List
     * @return 時間(少数点)
     */
    public static double calcSumOfStrtHourListD(ArrayList<String> strHHMMList) {

    	// リストがnullの場合、0返却
    	if(strHHMMList == null){
    		return 0;
    	}

    	// リストが空の場合、0返却
    	if(strHHMMList.size() == 0){
    		return 0;
    	}

    	double rtnSum = 0;
    	// リストの数分ループ
    	for(int i=0; i<strHHMMList.size(); i++){
    		rtnSum += transHHMMStrToFloatHour(strHHMMList.get(i));
    	}

    	return rtnSum;
    }

    /**
     * HHMM形式のString型のListより合計を計算し、XX時間YY分形式の文字列で返却する
     * @param sHHMM  HHMM形式の文字列
     * @return 時間（XX時間YY分）
     */
    public static String calcSumOfStrtHourListS(ArrayList<String> strHHMMList) {

    	double dSum = calcSumOfStrtHourListD(strHHMMList);

    	String rtnSum = "";
    	String sHH = "";
    	String sMM = "";

    	// XX時間
    	DecimalFormat dfHH = new DecimalFormat("00時間");
    	// 時間を文字列に
    	sHH = dfHH.format(Math.floor(dSum));

    	// 少数部分を取り出す
    	double dShosu = dSum % 1.0;
    	// 少数部より分を計算
    	double dHun = dShosu * 60;

    	// YY分
    	DecimalFormat dfMM = new DecimalFormat("00分");
    	sMM = dfMM.format(dHun);

    	// 時間＋分
    	rtnSum =  sHH.concat(sMM);

    	return rtnSum;
    }

    public static String fileCopyForPhoto(String path, String fileName, MultipartFile file) {
    	String saveFileUrl ="";
    	if(file != null) {
			String file1Name = file.getOriginalFilename();
			String savePath = SystemProperties.UP_LOAD_PATH + path;
			saveFileUrl = savePath+fileName + CommonConst.STRING_FORMAT_POINT + file1Name.substring(file1Name.length()-3);
			try {
				file.transferTo(new File(SystemProperties.ROOT_FILE_PATH + saveFileUrl));
			} catch (IllegalStateException e) {
				// TODO 自動生成された catch ブロック
				return CommonConst.STRING_NULL;
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				return CommonConst.STRING_NULL;
			}
    	}
    	return saveFileUrl;
    }

    /**
     * HHMM形式のString型のListより合計を計算し、XX時間YY分形式の文字列で返却する
     * @param sHHMM  HHMM形式の文字列
     * @return 時間（XX時間YY分）
     */
    public static String calcOfDoubleHour(double dHHdd) {

    	String rtnSum = "";
    	String sHH = "";
    	String sMM = "";

    	// XX時間
    	DecimalFormat dfHH = new DecimalFormat("00時間");
    	// 時間を文字列に
    	sHH = dfHH.format(Math.floor(dHHdd));

    	// 少数部分を取り出す
    	double dShosu = dHHdd % 1.0;
    	// 少数部より分を計算
    	double dHun = dShosu * 60;

    	// YY分
    	DecimalFormat dfMM = new DecimalFormat("00分");
    	sMM = dfMM.format(dHun);

    	// 時間＋分
    	rtnSum =  sHH.concat(sMM);

    	return rtnSum;
    }


    /**
     *
     * @param yearMonthDay
     * @return
     */
	public static String getWeekList(String yearMonthDay) {
		String week = "";
		switch(CommonUtil.getWeekDay(yearMonthDay)) {
         case 1:
        	 week = "日";
            break;
         case 2:
        	 week = "月";
            break;
         case 3:
        	 week = "火";
            break;
         case 4:
        	 week = "水";
            break;
         case 5:
        	 week = "木";
            break;
         case 6:
        	 week = "金";
            break;
         case 7:
        	 week = "土";
            break;
		}
		return yearMonthDay.substring(6, 8).concat("(").concat(week).concat(")");
	}

	public static List<String> getSelectListYear() {
		//現在年、月を取得
        Calendar cal1 = Calendar.getInstance();
     	int yearTemp = cal1.get(Calendar.YEAR);

     	List<String> yearList = new ArrayList<String>();
     	yearList.add(Integer.toString(yearTemp-1));
     	yearList.add(Integer.toString(yearTemp));
     	yearList.add(Integer.toString(yearTemp+1));

     	return yearList;
	}

	public static Timestamp getNowDate() {
		long now = System.currentTimeMillis();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

     	return timestamp;
	}

	public static String getCurrentYear(String searchYear) {
		String year;
		if(searchYear==null) {
			//現在年、月を取得
	        Calendar cal1 = Calendar.getInstance();
	     	int intYear = cal1.get(Calendar.YEAR);
	     	year = Integer.toString(intYear);
		}else
			year = searchYear;

     	return year;
	}

	public static String getCurrentMonth(String searchMonth) {
		String month;
		if(searchMonth==null) {
	        Calendar cal1 = Calendar.getInstance();
	     	int intMonth = cal1.get(Calendar.MONTH)+1;
	     	month = Integer.toString(intMonth);
		}else
			month = searchMonth;

		if(month.length()==1)
			month = CommonConst.STRING_VALUE_STANDARD_ZERO + month;

     	return month;
	}

	/**
	 * エラーメッセージをリストに保存し、返却する。
	 * method description
	 * @param BindingResult result
	 * @return ArrayList list
	 * @see
	 */
	public static ArrayList<String> getListInputErrMessage(BindingResult result) {
		ArrayList<String> list = new ArrayList<String>();

		for (ObjectError error : result.getAllErrors()) {
    		System.err.println("Error: " + error.getObjectName() + " - " + error.getCode() + " - "
    				+ error.getDefaultMessage());
    		list.add(error.getDefaultMessage());
    	}
		return list;
	}

}
