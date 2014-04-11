/*
 * タイトル：
 * 説明    ：
 *
 * 著作権  ：Copyright(c) 2014 SOFTWIZ
 * 会社名  ：株式会社 SOFTWIZ
 *
 * 変更履歴   ：
 * 新規登録   : 2014/04/03
 */

package jp.co.softwiz.main.service.iface;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jk-yun@softwiz.jp
 * @version
 * @param <T>
 *
 */
public interface StandardServiceInterface<T> {


	public List<T> selectList(T bean);

	public T select(T bean);

	public void regist(HttpServletRequest request, T bean);

	public void delete(HttpServletRequest request, T bean);
}
