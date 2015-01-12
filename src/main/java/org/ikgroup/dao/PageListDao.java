package org.ikgroup.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;

public class PageListDao {
	
	private SqlSessionFactoryBean sqlSessionFactory;
	
	public void test() throws Exception{
		SqlSession session = sqlSessionFactory.getObject().openSession();
		session.getConfiguration().getMappedStatement("");
	}

}
