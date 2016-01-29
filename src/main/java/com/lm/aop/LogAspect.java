package com.lm.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

	private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

	/**
	 * 切入点：表示在哪个类的哪个方法进行切入。配置有切入点表达式
	 */
	@Pointcut("execution(* com.lm.service.*.*(..))")
	public void pointcutExpression() {}

	/**
	 * 1 前置通知
	 * 
	 * @param joinPoint
	 */
	@Before("pointcutExpression()")
	public void beforeMethod(JoinPoint joinPoint) {
		logger.debug(joinPoint.getTarget().toString()+": "+joinPoint.getSignature().getName()+
				" before..........");
	}

	/**
	 * 2 后置通知
	 * 
	 */
	@After("pointcutExpression()")
	public void afterMethod(JoinPoint joinPoint) {
		logger.debug(joinPoint.getTarget().toString()+": "+joinPoint.getSignature().getName()+
				" after..........");
	}

	/**
	 * 3 返回通知
	 *
	 * @param joinPoint
	 * @param returnValue
	 * 
	 */
	@AfterReturning(value = "pointcutExpression()", returning = "returnValue")
	public void afterRunningMethod(JoinPoint joinPoint, Object returnValue) {
		logger.debug(joinPoint.getTarget().toString()+": "+joinPoint.getSignature().getName()+
				" finish,result: " + (null==returnValue?"void":returnValue));
	}

	/**
	 * 4 异常通知
	 * 
	 * @param joinPoint
	 * @param e
	 */
	@AfterThrowing(value = "pointcutExpression()", throwing = "e")
	public void afterThrowingMethod(JoinPoint joinPoint, Exception e) {
		logger.debug(joinPoint.getTarget().toString()+": "+joinPoint.getSignature().getName()+
				" exception, errorInfo: " + e);
	}

	// /**
	// * 5 环绕通知
	// *
	// */
	// @Around("pointcutExpression()")
	// public Object aroundMethod(ProceedingJoinPoint pjd) {
	//
	// Object result = null;
	// String methodName = pjd.getSignature().getName();
	//
	// try {
	// // 前置通知
	// logger.debug("The method " + methodName + " begins with " +
	// Arrays.asList(pjd.getArgs()));
	// // 执行目标方法
	// result = pjd.proceed();
	// // 返回通知
	// logger.debug("The method " + methodName + " ends with " + result);
	// } catch (Throwable e) {
	// // 异常通知
	// logger.debug("The method " + methodName + " occurs exception:" + e);
	// throw new RuntimeException(e);
	// }
	// // 后置通知
	// logger.debug("The method " + methodName + " ends");
	//
	// return result;
	// }

}
