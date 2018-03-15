package springdemo.aop;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private Logger logger = Logger.getLogger(getClass().getName());

	@Pointcut("execution(* springdemo.controller.*.*(..))")
	public void controllerPackage() {
	}

	@Pointcut("execution(* springdemo.service.*.*(..))")
	public void servicePackage() {
	}

	@Pointcut("execution(* springdemo.dao.*.*(..))")
	public void daoPackage() {
	}

	@Pointcut("controllerPackage() || servicePackage() || daoPackage()")
	public void allServices() {
	}

	@Before("allServices()")
	public void before(JoinPoint joinpoint) {

		String method = joinpoint.getSignature().toShortString();
		logger.info("@Before: Method called: " + method);

		Object[] arguments = joinpoint.getArgs();

		for (Object temp : arguments) {
			logger.info("Argument: " + temp);
		}
	}
	
	@AfterReturning(pointcut="allServices()",returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		
		String method = joinPoint.getSignature().toShortString();
		logger.info("@AfterReturning: Method called: " + method);
		logger.info("Result: " + result);
	}
}
