/*
 * タイトル：ログイン画面
 * 説明    ：
 *
 * 著作権  ：Copyright(c) 2014 SOFTWIZ
 * 会社名  ：株式会社 SOFTWIZ
 *
 * 変更履歴   ：
 * 新規登録   :2014/01/27
*/

package jp.co.softwiz.main.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import jp.co.softwiz.main.common.constants.CommonConst;
import jp.co.softwiz.main.common.constants.ModelConstants;
import jp.co.softwiz.main.common.util.CommonUtil;
import jp.co.softwiz.main.domain.login.LoginBean;
import jp.co.softwiz.main.service.iface.login.LoginServiceInterface;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.WebUtils;


/**
 * @author jk-yun
 * @version 1.0
 */
@Controller
public class LoginController {

	private static final Logger		logger	= Logger.getLogger(LoginController.class);
	//ログインサービス(DI)
	@Autowired private LoginServiceInterface	loginService;

	/**
	 * ログイン画面初期
	 * @param
	 * @return ModelAndView
	 */
	@RequestMapping(value = ModelConstants.REQ_MAPPING_LOGIN, method = RequestMethod.GET)
    public ModelAndView initPage(HttpServletRequest request, String errFlg)
    {
		/********************************************************************************/
		/* ModelAndView 生成 */
		/********************************************************************************/
        ModelAndView view = new ModelAndView(ModelConstants.PAGE_MODEL_LOGIN);

        LoginBean loginSession = CommonUtil.getLoginSession(request);
		if(loginSession != null) {
			RedirectView rv = new RedirectView(".." + ModelConstants.PAGE_MODEL_MYPAGE + ".html");
			rv.setExposeModelAttributes(false);
			return new ModelAndView(rv);
		}
		if(errFlg!=null && errFlg.equals("1"))
			view.addObject("errFlg", errFlg);
        return view;
    }

	/**
	 * ログインプロセス実行
	 * @param CateBean loginBean
	 * @return ModelAndView
	 */
	@RequestMapping(value = ModelConstants.REQ_MAPPING_LOGIN_PROCESS, method = RequestMethod.GET)
	public ModelAndView doLoginProcess(@Valid LoginBean cmd, BindingResult result,
								HttpServletRequest request, LoginBean loginBean) {
		/********************************************************************************/
		/* DEBUG 開始 */
		/********************************************************************************/
		logger.debug("LoginController - log START");

		/********************************************************************************/
		/* ModelAndView 生成 */
		/********************************************************************************/
		ModelAndView view = new ModelAndView(ModelConstants.PAGE_MODEL_LOGIN);

		if (result.hasErrors()) {
			view.addObject("errFlg", "1");
			return view;
		}
		String userId = SecurityContextHolder.getContext().getAuthentication().getName();
		loginBean.setUserId(userId);

		loginService.setLoginBean(loginBean);

		//ログインサービス実行

		LoginBean resultBean = loginService.getLogin(request);
		if(resultBean != null){
			logger.debug("LOGIN SUCCESS");
			RedirectView rv = new RedirectView(".." + ModelConstants.PAGE_MODEL_MYPAGE + ".html");
			rv.setExposeModelAttributes(false);
			return new ModelAndView(rv);

		}else{
			logger.debug("LOGIN ID PASSWORD ERROR");
			view.addObject("errFlg", "1");
		}
        /********************************************************************************/
		/* DEBUG 終了 */
		/********************************************************************************/
		logger.debug("LoginController - log END ");

        return view;

	}

	/**
	 * ログイン画面初期
	 * @param
	 * @return ModelAndView
	 */
	@RequestMapping(value = ModelConstants.REQ_MAPPING_LOGOUT, method = RequestMethod.GET)
    public ModelAndView logoutPage(HttpServletRequest request)
    {
		/********************************************************************************/
		/* ModelAndView 生成 */
		/********************************************************************************/
        ModelAndView view = new ModelAndView(ModelConstants.PAGE_MODEL_LOGIN);

        WebUtils.setSessionAttribute(request, CommonConst.LOGIN_USER_KEY, null);

        return view;
    }




}
