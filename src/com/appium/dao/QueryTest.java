package com.appium.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.dbutils.com.DataSourceUtils;

public class QueryTest {

	public static void main(String[] args) throws SQLException {
		
		
	QueryRunner qy=	new QueryRunner(DataSourceUtils.getDataSource());
	String sql="select * from user_profile limit 10	;";
	List<Map<String,Object>> list = qy.query(sql, new MapListHandler());
	for( Map<String,Object> map : list ){
		for(String key : map.keySet()){
			System.out.print(key+"..."+map.get(key));
		}
		System.out.println();
	}
	
	}

}
