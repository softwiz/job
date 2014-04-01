/**
 *
 */
package jp.co.softwiz.main.common.error;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.softwiz.main.common.constants.ModelConstants;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author jk-yun
 * @version 1.0
 *
 */
public class PreludebExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception exception) {
        ModelAndView view = new ModelAndView(ModelConstants.PAGE_MODEL_ERROR);
        view.addObject("exception", exception.getClass().getName());
        view.addObject("exceptionMessage", exception.getMessage());

        return view;
	}

}
