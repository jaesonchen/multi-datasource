package com.asiainfo.multidatasource.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.asiainfo.multidatasource.datasource.DataSource;
import com.asiainfo.multidatasource.datasource.DataSourceHolder;

/**
 * @Description: TODO
 * 
 * @author       zq
 * @date         2017年5月7日  下午3:24:27
 * Copyright: 	  北京亚信智慧数据科技有限公司
 */
@Component
@Aspect
@Order(1)
public class DataSourceAspect {

	private static final Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);
	
    @Pointcut("execution(* com.asiainfo.multidatasource..service..*.*(..))")
    public void aspect() {}
    
	@Before("aspect()")
	public void before(JoinPoint point) {
		
		logger.info("before {}", point);
		
        MethodSignature proxySignature = (MethodSignature) point.getSignature();
        Method proxyMethod = proxySignature.getMethod();
        Class<?> target = point.getTarget().getClass();
        Method targetMethod = null;
        try {
            targetMethod = target.getMethod(proxyMethod.getName(), proxyMethod.getParameterTypes());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        if (targetMethod != null) {
            Transactional transactional = target.getAnnotation(Transactional.class);
            if (transactional != null) {
            	DataSource clazzDatasource = target.getAnnotation(DataSource.class);
            	DataSource methodDatasource = targetMethod.getAnnotation(DataSource.class);
                if (methodDatasource != null) {
                	logger.debug("using specify method datasource({}) ......", methodDatasource.value());
                    DataSourceHolder.setDataSource(methodDatasource.value());
                } else if (clazzDatasource != null) {
                	logger.debug("using specify clazz datasource({}) ......", clazzDatasource.value());
                    DataSourceHolder.setDataSource(clazzDatasource.value());
                } else {
                    logger.warn("does not specify any datasource, using default datasource ......");
                }
            } else {
            	logger.debug("non transactional method, using default datasource({}) ......");
            }
        }
	}

	@AfterReturning("aspect()")
	public void afterReturn(JoinPoint joinPoint) {
		logger.info("afterReturn {}", joinPoint);
		DataSourceHolder.clear();
	}
}
