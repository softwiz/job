/*
	 * タイトル：スタンダードDaoInterface
	 * 説明    ：
	 *
	 * 著作権  ：Copyright(c) 2014 SOFTWIZ
	 * 会社名  ：株式会社 SOFTWIZ
	 *
	 * 変更履歴   ：2014/04/03
	 * 新規登録   :
*/

package jp.co.softwiz.main.dao.iface;

import java.util.List;

/**
 * @author jk-yun@softwiz.jp
 * @version
 * @param <T>
 *
 */
public interface StandardDaoInterface<T> {

	public List<T> selectList(T bean);

	public T select(T bean);

	public void insert(T bean);

	public void update(T bean);

	public void delete(T bean);

}
