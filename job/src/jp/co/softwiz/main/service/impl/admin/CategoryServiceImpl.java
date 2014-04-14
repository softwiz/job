/*
	 * タイトル：カテゴリサービス
	 * 説明    ：カテゴリサービス
	 *
	 * 著作権  ：Copyright(c) 2014 SOFTWIZ
	 * 会社名  ：株式会社 SOFTWIZ
	 *
	 * 変更履歴   ：2014/04/03
	 * 新規登録   :
*/

package jp.co.softwiz.main.service.impl.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jp.co.softwiz.main.common.constants.CommonConst;
import jp.co.softwiz.main.common.constants.SystemProperties;
import jp.co.softwiz.main.common.util.CommonUtil;
import jp.co.softwiz.main.dao.iface.admin.CategoryDaoInterface;
import jp.co.softwiz.main.domain.admin.CateMainBean;
import jp.co.softwiz.main.domain.admin.CateSubBean;
import jp.co.softwiz.main.service.iface.admin.CategoryServiceInterface;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author jk-yun@softwiz.jp
 * @version 0.1
 *
 */
@Service
public class CategoryServiceImpl implements CategoryServiceInterface {

	//カテゴリDAO(DI)
	@Qualifier("Category-" + SystemProperties.FACTORY_DB)
	@Autowired private CategoryDaoInterface	categoryDao;

	/**
	 * 大分類の共通項目情報を取得する。
	 * @param HttpServletRequest request
	 * @return
	 */
	public List<CateMainBean> selectMasterList(CateMainBean bean){

		return categoryDao.selectMasterList(bean);
	}

	public CateMainBean selectMaster(CateMainBean bean) {
		if (StringUtils.isNotEmpty(bean.getMaincode()))
			return categoryDao.selectMaster(bean);
		else
			return null;
	}

	/**
	 * 共通項目中分類リストを取得する。
	 * @param String mainCode
	 * @return List<CateMainBean>
	 */
	public List<CateSubBean> selectDetailList(CateMainBean bean){

		return categoryDao.selectDetailList(bean);
	}

	public CateSubBean selectDetail(CateSubBean bean) {
		CateMainBean mainBean = new CateMainBean();
		mainBean.setMaincode(bean.getMaincode());
		List<CateSubBean> cateSubList = categoryDao.selectDetailList(mainBean);

		if (StringUtils.isNotEmpty(bean.getMaincode()) && StringUtils.isNotEmpty(bean.getSubcode())) {
			bean = categoryDao.selectDetail(bean);
		}
		if(cateSubList == null || cateSubList.size() == 0) bean.setMaxVieworder(1);
		else bean.setMaxVieworder(cateSubList.size()+1);

		return bean;
	}

	/**
	 * 共通項目大分類情報を登録する。
	 * @param String mainCode
	 * @return List<CateMainBean>
	 */
	@Transactional
	public void registMaster(HttpServletRequest request, CateMainBean bean){
		bean.setDeleteflag(CommonConst.STRING_DELETE_FLAG_N);
		bean.setModifydate(CommonUtil.getNowDate());
		bean.setModifyuser(CommonUtil.getLoginUserId(request));
		if (StringUtils.isEmpty(bean.getMaincode())) {
			bean.setMaincode(categoryDao.selectCateMainMaxKey());
			bean.setCreatedate(CommonUtil.getNowDate());
			bean.setCreateuser(CommonUtil.getLoginUserId(request));
			categoryDao.insertMaster(bean);
		} else {
			categoryDao.updateMaster(bean);
		}
	}

	/**
	 * 共通項目大分類情報を登録する。
	 * @param String mainCode
	 * @return List<CateMainBean>
	 */
	@Transactional
	public void deleteMaster(HttpServletRequest request, CateMainBean bean){
		bean.setDeleteflag(CommonConst.STRING_DELETE_FLAG_N);
		bean.setDeletedate(CommonUtil.getNowDate());
		bean.setDeleteuser(CommonUtil.getLoginUserId(request));

		categoryDao.deleteMaster(bean);
		categoryDao.deleteCateSubForMainKey(bean);
	}

	/**
	 * 共通項目大分類情報を登録する。
	 * @param String mainCode
	 * @return List<CateMainBean>
	 */
	@Transactional
	public void registDetail(HttpServletRequest request, CateSubBean bean){
		int preViewOrder = 0;
		CateMainBean mainBean = new CateMainBean();
		mainBean.setMaincode(bean.getMaincode());
		List<CateSubBean> cateSubList = categoryDao.selectDetailList(mainBean);

		bean.setDeleteflag(CommonConst.STRING_DELETE_FLAG_N);
		bean.setModifydate(CommonUtil.getNowDate());
		bean.setModifyuser(CommonUtil.getLoginUserId(request));

		if (StringUtils.isEmpty(bean.getMaincode()) || StringUtils.isEmpty(bean.getSubcode())) {
			bean.setSubcode(categoryDao.selectCateSubMaxKey(bean));
			bean.setCreatedate(CommonUtil.getNowDate());
			bean.setCreateuser(CommonUtil.getLoginUserId(request));
			categoryDao.insertDetail(bean);
		} else {
			categoryDao.updateDetail(bean);
			for(CateSubBean subBean : cateSubList) {
				if(bean.getSubcode().equals(subBean.getSubcode()))
					preViewOrder = subBean.getVieworder();
			}

		}

		if(preViewOrder < bean.getVieworder()&&preViewOrder != 0)
			setBetterViewOrder(bean, cateSubList, preViewOrder);
		else
			setLessViewOrder(bean, cateSubList, preViewOrder);
	}

	/**
	 * 共通項目大分類情報を登録する。
	 * @param String mainCode
	 * @return List<CateMainBean>
	 */
	@Transactional
	public void deleteDetail(HttpServletRequest request, CateSubBean bean){
		bean.setDeleteflag(CommonConst.STRING_DELETE_FLAG_N);
		bean.setDeletedate(CommonUtil.getNowDate());
		bean.setDeleteuser(CommonUtil.getLoginUserId(request));

		categoryDao.deleteDetail(bean);
	}

	/**
	 * 大分類の使用可否をアップデートする。
	 * @param HttpServletRequest request
	 * @return
	 */
	@Transactional
	public void setCateMainUseDivList(List<String> list){

		for(String useDiv : list) {
			String[] tmp = useDiv.split(CommonConst.STRING_FORMAT_SLASH);
			CateMainBean bean = new CateMainBean();
			bean.setMaincode(tmp[0]);
			bean.setUsediv(tmp[1]);
			categoryDao.updateCateMainUseDiv(bean);

		}
	}

	private void setBetterViewOrder(CateSubBean cateSubBean, List<CateSubBean> cateSubList, int preViewOrder){
		for(CateSubBean bean : cateSubList) {
			if(!bean.getSubcode().equals(cateSubBean.getSubcode())) {
				if(bean.getVieworder() >= cateSubBean.getVieworder()) {
						bean.setVieworder(bean.getVieworder() - 1);
						categoryDao.updateDetail(bean);
				}
			}
		}
	}

	private void setLessViewOrder(CateSubBean cateSubBean, List<CateSubBean> cateSubList, int preViewOrder){
		for(CateSubBean bean : cateSubList) {
			if(!bean.getSubcode().equals(cateSubBean.getSubcode())) {
				if(bean.getVieworder() >= cateSubBean.getVieworder()) {
					if(preViewOrder > bean.getVieworder() || preViewOrder == 0) {
						bean.setVieworder(bean.getVieworder() + 1);
						categoryDao.updateDetail(bean);
					}
				}
			}
		}
	}



}
