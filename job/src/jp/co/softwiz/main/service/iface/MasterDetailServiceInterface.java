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
public interface MasterDetailServiceInterface<M, D> {


	public List<M> selectMasterList(M bean);

	public M selectMaster(M bean);

	public List<D> selectDetailList(M bean);

	public D selectDetail(D bean);

	public void registMaster(HttpServletRequest request, M bean);

	public void deleteMaster(HttpServletRequest request, M bean);

	public void registDetail(HttpServletRequest request, D bean);

	public void deleteDetail(HttpServletRequest request, D bean);
}
