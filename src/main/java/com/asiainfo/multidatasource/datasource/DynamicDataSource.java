package com.asiainfo.multidatasource.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Description: TODO
 * 
 * @author       zq
 * @date         2017年5月7日  下午3:21:05
 * Copyright: 	  北京亚信智慧数据科技有限公司
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	/* 
	 * @Description: TODO
	 * @return
	 * @see org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource#determineCurrentLookupKey()
	 */
	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceHolder.getDataSouce();
	}
}
