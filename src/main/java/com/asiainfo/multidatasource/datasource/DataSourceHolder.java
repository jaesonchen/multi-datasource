package com.asiainfo.multidatasource.datasource;

/**
 * @Description: TODO
 * 
 * @author       zq
 * @date         2017年5月7日  下午3:18:58
 * Copyright: 	  北京亚信智慧数据科技有限公司
 */
public class DataSourceHolder {

	public static final ThreadLocal<String> holder = new ThreadLocal<String>();
	
	public static void setDataSource(String name) {
        holder.set(name);
    }
    
    public static String getDataSouce() {
        return holder.get();
    }
    
    public static void clear() {
    	holder.remove();
    }
}
