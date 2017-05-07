package com.asiainfo.multidatasource.datasource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: TODO
 * 
 * @author       zq
 * @date         2017年5月7日  下午3:13:42
 * Copyright: 	  北京亚信智慧数据科技有限公司
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface DataSource {
	
	String value() default DataSource.master;
	
	public static String master = "master";
    public static String slave = "slave";
}
