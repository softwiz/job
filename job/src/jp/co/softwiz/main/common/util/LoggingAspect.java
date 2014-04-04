package jp.co.softwiz.main.common.util;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;



@Aspect
public class LoggingAspect {

	private static final Logger		logger	= Logger.getLogger(LoggingAspect.class);

	@Before("execution(* jp.co.softwiz.main.controller..*(..))")
    public void logBefore(JoinPoint joinPoint) {
		String packageName = joinPoint.getSignature().getDeclaringTypeName();
		String methodName = joinPoint.getSignature().getName();

		logger.info(new StringBuilder(packageName).append("-").append(methodName) + "--- Controller START");

    }

	@After("execution(public * jp.co.softwiz.main.controller..*(..))")
    public void logAfter(JoinPoint joinPoint) {

		String packageName = joinPoint.getSignature().getDeclaringTypeName();
		String methodName = joinPoint.getSignature().getName();

		logger.info(new StringBuilder(packageName).append("-").append(methodName) + "--- Controller END");

    }


}