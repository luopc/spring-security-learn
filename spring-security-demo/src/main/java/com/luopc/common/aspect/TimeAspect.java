package com.luopc.common.aspect;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class TimeAspect {

	@Around("execution(* com.luopc.web.controller.UserController.*(..))")
	public Object handleControlllerMethod(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("aspect begin");
		long startTime = new Date().getTime();

		Object obj = pjp.proceed();

		Long time = new Date().getTime() - startTime;
		System.out.println("aspect end 耗时:" + time + "+ obj：" + obj);
		return obj;
	}
}
