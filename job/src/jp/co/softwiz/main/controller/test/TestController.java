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

package jp.co.softwiz.main.controller.test;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jp.co.softwiz.main.common.constants.ModelConstants;
import jp.co.softwiz.main.common.util.Pager;
import jp.co.softwiz.main.domain.test.TestInfoBean;
import jp.co.softwiz.main.service.iface.test.TestServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;



/**
 * @author jk-yun@softwiz.jp
 * @version 1.0
 */
@Controller
public class TestController {

	//カテゴリサービス(DI)
	@Autowired private TestServiceInterface	testService;

	/**
	 * カテゴリ画面初期
	 * @param
	 * @return ModelAndView
	 */
	@RequestMapping(value = ModelConstants.REQ_MAPPING_TEST_LIST)
    public ModelAndView initPage(HttpServletRequest request, TestInfoBean bean)
    {
		/********************************************************************************/
		/* ModelAndView 生成 */
		/********************************************************************************/
		ModelAndView view = new ModelAndView(ModelConstants.PAGE_MODEL_TEST_LIST);

		//属性情報取得
		Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);
		if (map != null) {
			bean = (TestInfoBean) map.get("bean");
		}
        view.addObject("list", testService.selectList(bean));
        view.addObject("pageElements", Pager.getPageElements(bean.getMovedPage(), testService.getSelectListCount(bean)));
        view.addObject("info", bean);
       return view;
    }

	/** カテゴリビュー
	 * @param
	 * @return ModelAndView
	 */
	@RequestMapping(value = ModelConstants.REQ_MAPPING_TEST_VIEW, method = RequestMethod.POST)
    public ModelAndView categoryViewPage(HttpServletRequest request, TestInfoBean bean)
    {
		/********************************************************************************/
		/* ModelAndView 生成 */
		/********************************************************************************/
        ModelAndView view = new ModelAndView(ModelConstants.PAGE_MODEL_TEST_VIEW);

        view.addObject("info", bean);
        view.addObject("bean", testService.select(bean));
        return view;
    }

	/** カテゴリ情報登録
	 * @param
	 * @return ModelAndView
	 */
	@RequestMapping(value = ModelConstants.REQ_MAPPING_TEST_REGIST, method = RequestMethod.POST)
    public ModelAndView categoryRegistPage(HttpServletRequest request, TestInfoBean bean)
    {
		/********************************************************************************/
		/* ModelAndView 生成 */
		/********************************************************************************/
		ModelAndView view = new ModelAndView("redirect:.." + ModelConstants.REQ_MAPPING_TEST_LIST + ".html");

		//属性情報保存
		FlashMap fm = RequestContextUtils.getOutputFlashMap(request);
		fm.put("bean", bean);

		testService.regist(request, bean);

		return view;

    }

	/** カテゴリ情報削除
	 * @param
	 * @return ModelAndView
	 */
	@RequestMapping(value = ModelConstants.REQ_MAPPING_TEST_DELETE, method = RequestMethod.POST)
    public ModelAndView categoryDeletePage(HttpServletRequest request, TestInfoBean bean)
    {
		/********************************************************************************/
		/* ModelAndView 生成 */
		/********************************************************************************/
		ModelAndView view = new ModelAndView("redirect:.." + ModelConstants.REQ_MAPPING_TEST_LIST + ".html");

		//属性情報保存
		FlashMap fm = RequestContextUtils.getOutputFlashMap(request);
		fm.put("bean", bean);

		testService.delete(request, bean);

		return view;

    }

}
