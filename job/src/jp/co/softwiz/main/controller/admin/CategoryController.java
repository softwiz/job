/*
 * タイトル：カテゴリ画面
 * 説明    ：
 *
 * 著作権  ：Copyright(c) 2014 SOFTWIZ
 * 会社名  ：株式会社 SOFTWIZ
 *
 * 変更履歴   ：2014/04/04
 * 新規登録   :
 */

package jp.co.softwiz.main.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.softwiz.main.common.constants.ModelConstants;
import jp.co.softwiz.main.domain.admin.CateMainBean;
import jp.co.softwiz.main.domain.admin.CateSubBean;
import jp.co.softwiz.main.service.iface.admin.CategoryServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.google.gson.Gson;



/**
 * @author jk-yun@softwiz.jp
 * @version 1.0
 */
@Controller
public class CategoryController {

	//カテゴリサービス(DI)
	@Autowired private CategoryServiceInterface	categoryService;

	/**
	 * カテゴリ画面初期
	 * @param
	 * @return ModelAndView
	 */
	@RequestMapping(value = ModelConstants.REQ_MAPPING_CATEGORY)
    public ModelAndView initPage(HttpServletRequest request, CateMainBean bean)
    {
		/********************************************************************************/
		/* ModelAndView 生成 */
		/********************************************************************************/
		ModelAndView view = new ModelAndView(ModelConstants.PAGE_MODEL_CATEGORY_MAIN);

		//属性情報取得
		Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);
		if (map != null) {
			bean = (CateMainBean) map.get("bean");
		}
        view.addObject("list", categoryService.selectMasterList(bean));
        view.addObject("info", bean);
       return view;
    }

	/** カテゴリビュー
	 * @param
	 * @return ModelAndView
	 */
	@RequestMapping(value = ModelConstants.REQ_MAPPING_CATEGORY_VIEW, method = RequestMethod.POST)
    public ModelAndView categoryViewPage(HttpServletRequest request, CateMainBean bean)
    {
		/********************************************************************************/
		/* ModelAndView 生成 */
		/********************************************************************************/
        ModelAndView view = new ModelAndView(ModelConstants.PAGE_MODEL_CATEGORY_VIEW);

        view.addObject("info", bean);
        view.addObject("bean", categoryService.selectMaster(bean));
        return view;
    }

	/** カテゴリ情報登録
	 * @param
	 * @return ModelAndView
	 */
	@RequestMapping(value = ModelConstants.REQ_MAPPING_CATEGORY_REGIST, method = RequestMethod.POST)
    public ModelAndView categoryRegistPage(HttpServletRequest request, CateMainBean bean)
    {
		/********************************************************************************/
		/* ModelAndView 生成 */
		/********************************************************************************/
		ModelAndView view = new ModelAndView("redirect:.." + ModelConstants.REQ_MAPPING_CATEGORY + ".html");

		//属性情報保存
		FlashMap fm = RequestContextUtils.getOutputFlashMap(request);
		fm.put("bean", bean);

		categoryService.registMaster(request, bean);

		return view;

    }

	/** カテゴリ情報削除
	 * @param
	 * @return ModelAndView
	 */
	@RequestMapping(value = ModelConstants.REQ_MAPPING_CATEGORY_DELETE, method = RequestMethod.POST)
    public ModelAndView categoryDeletePage(HttpServletRequest request, CateMainBean bean)
    {
		/********************************************************************************/
		/* ModelAndView 生成 */
		/********************************************************************************/
		ModelAndView view = new ModelAndView("redirect:.." + ModelConstants.REQ_MAPPING_CATEGORY + ".html");

		//属性情報保存
		FlashMap fm = RequestContextUtils.getOutputFlashMap(request);
		fm.put("bean", bean);

		categoryService.deleteMaster(request, bean);

		return view;

    }

	/**
	 * カテゴリ順番変更
	 * @param
	 * @return ModelAndView
	 */
	@RequestMapping(value = ModelConstants.REQ_MAPPING_CATE_MAIN_UPDATE, method = RequestMethod.POST)
    public ModelAndView modifyPage(HttpServletRequest request, CateMainBean bean
    									, @RequestParam("useDiv") List<String> useList)
    {
		/********************************************************************************/
		/* ModelAndView 生成 */
		/********************************************************************************/
        ModelAndView view = new ModelAndView(ModelConstants.PAGE_MODEL_CATEGORY_MAIN);

        categoryService.setCateMainUseDivList(useList);

        view.addObject("info", bean);
        view.addObject("list", categoryService.selectMasterList(bean));
        return view;
    }

	/**
	 * 共通項目中分類リストを取得する。
	 * @param request
	 * @param response
	 * @param mainCode
	 * @see
	 *
	 */
	@RequestMapping(value = ModelConstants.REQ_MAPPING_GET_CATE_SUB_LIST, method = RequestMethod.GET)
	public void getCateSubList(HttpServletRequest request, HttpServletResponse response
											,CateMainBean bean) throws IOException {
		List<CateSubBean> subList =  categoryService.selectDetailList(bean);

		response.setContentType( "application/json" );
	    response.setCharacterEncoding( "UTF-8" );
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter writer = response.getWriter();
		writer.print(new Gson().toJson( subList) );
		writer.close();
	}



}
