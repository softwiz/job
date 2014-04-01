package jp.co.softwiz.main.controller.mypage;

import javax.servlet.http.HttpServletRequest;

import jp.co.softwiz.main.common.constants.ModelConstants;
import jp.co.softwiz.main.common.util.CommonUtil;
import jp.co.softwiz.main.domain.login.LoginBean;
import jp.co.softwiz.main.service.iface.mypage.MainServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;





@Controller
public class MainController {

	//ログインサービス(DI)
	@Autowired private MainServiceInterface	mainService;

	@RequestMapping(value = ModelConstants.REQ_MAPPING_MAIN, method = RequestMethod.GET)
    public ModelAndView initPage(HttpServletRequest request)
    {
		// ログインチェック及び照会権限チェック
		LoginBean loginSession = CommonUtil.getLoginSession(request);
		//bean.setUsercode(loginSession.getUserCode());
		ModelAndView view = new ModelAndView(ModelConstants.PAGE_MODEL_MYPAGE);
		view.addObject("login", loginSession);
		//view.addObject("admList",mainService.getCalAdmList(bean));
        return view;
    }


}
