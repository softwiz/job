/*
	 * タイトル：ログインDaoInterface
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
public interface MasterDetailDaoInterface<M, D> {

	public List<M> selectMasterList(M bean);

	public List<D> selectDetailList(M bean);

	public M selectMaster(M bean);

	public void insertMaster(M bean);

	public void updateMaster(M bean);

	public void deleteMaster(M bean);

	public D selectDetail(D bean);

	public void insertDetail(D bean);

	public void updateDetail(D bean);

	public void deleteDetail(D bean);

}
