package jp.co.softwiz.main.common.util;

import jp.co.softwiz.main.common.constants.ModelConstants;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerAspect {

	private static final Logger		logger	= Logger.getLogger(ExceptionHandlerAspect.class);

    @ExceptionHandler(Exception.class)
    public void handleException(Exception e) {
    	logger.error(e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ModelAndView handleRuntimeException(RuntimeException e) {
    	ModelAndView view = new ModelAndView(ModelConstants.PAGE_MODEL_ERROR);
        view.addObject("exception", e.getClass().getName());
        view.addObject("exceptionMessage", e.getMessage());

        return view;
    }
}

