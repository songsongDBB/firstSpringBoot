package com.dss.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    /**
     * 表示在执行 public * com.dss.girl.controller.GirlController.girlList()之前先执行这个方法,(..)表示传入什么参数都执行这个方法
     */
    @Pointcut("execution(public * com.dss.girl.controller.GirlController.*(..))")
    public void log(){
    }

    /**
     * 定义一个log方法，这样可以省略切入点的代码量
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        logger.info("面向切面编程开始。。。");
        //获取http请求信息

        //获取HttpServletRequest
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        //url
        logger.info("url={}", request.getRequestURL().toString());

        //method
        logger.info("method={}", request.getMethod());

        //ip
        logger.info("ip={}", request.getRemoteAddr());

        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数
        logger.info("method_agrs={}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
        logger.info("面向切面编程结束。。。");
    }

    /**
     * 在方法执行完后得到方法返回的数据
     * @param object
     */
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterRuntruning(Object object){
        logger.info("response={}", object.toString());
    }
}
