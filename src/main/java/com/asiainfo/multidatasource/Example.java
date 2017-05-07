package com.asiainfo.multidatasource;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.asiainfo.multidatasource.service.IUserService;

/**
 * @Description: TODO
 * 
 * @author       zq
 * @date         2017年5月7日  下午5:17:33
 * Copyright: 	  北京亚信智慧数据科技有限公司
 */
public class Example {

	/** 
	 * @Description: TODO
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:application-core-configure.xml"});
		IUserService service = context.getBean(IUserService.class);
		System.out.println(service.queryUser("10001"));
		service.save("10004", "test");
		context.close();
	}
}
