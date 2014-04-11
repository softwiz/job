package jp.co.softwiz.main.common.util;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jp.co.softwiz.main.common.constants.CommonConst;
import jp.co.softwiz.main.domain.login.LoginBean;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Aspect
public class LoginCheckAspect {

	@Pointcut("execution(* jp.co.softwiz.main.controller..*(..))")
	public void formLogin() {
	}


	@Around("formLogin()")
	public ModelAndView writeFormAspect(ProceedingJoinPoint joinPoint) throws Throwable {
	    LoginBean loginSession = null;
	    ModelAndView view = new ModelAndView();

    	HttpServletRequest req = (HttpServletRequest)joinPoint.getArgs()[0];
	    HttpSession session = req.getSession();


	    if (req instanceof HttpServletRequest) {
	    	String locale = req.getParameter(CommonConst.STRING_PARAMETER_LOCALES);
	        loginSession = CommonUtil.getLoginSession((HttpServletRequest) req);
	        if (StringUtils.isNotEmpty(locale)) {
	        	session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, this.setLocales(locale));
	        }

	        view = (ModelAndView) joinPoint.proceed();
	        if (view != null) {
	        	view.addObject("login", loginSession);
	        }

	    }

	    return view;
	}

	private Locale setLocales(String locale) {
		 Locale locales = null;
		 if (locale.matches("ko")) {
			 locales = Locale.KOREAN;
		 } else if (locale.matches("en")){
			 locales = Locale.ENGLISH;
		 } else if (locale.matches("ja")){
			 locales = Locale.JAPANESE;
		 } else if (locale.matches("zh")){
			 locales = Locale.CHINESE;
		 } else {
			 locales = Locale.JAPANESE;
		 }
		 return locales;
	}

}