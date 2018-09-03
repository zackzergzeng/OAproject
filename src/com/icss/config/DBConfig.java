package com.icss.config;

import java.beans.PropertyVetoException;
import java.lang.management.PlatformManagedObject;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sun.xml.internal.ws.encoding.DataSourceStreamingDataHandler;
@Configuration
@MapperScan(basePackages= {"com.icss.dao"})
@EnableTransactionManagement
public class DBConfig {
	
	public DataSource dataSource() throws PropertyVetoException {
		ComboPooledDataSource pool =new ComboPooledDataSource();
		pool.setJdbcUrl("jdbc:mysql://localhost:3306/oa?characterEncoding=utf-8");
		pool.setUser("root");
		pool.setDriverClass("com.mysql.jdbc.Driver");
		pool.setPassword("123");
		pool.setMaxPoolSize(20);
		pool.setMinPoolSize(5);
		return pool;
	}
	@Bean
	public SqlSessionFactory sessionFactory() throws Exception {
		SqlSessionFactoryBean factoryBean=new SqlSessionFactoryBean();
		factoryBean.setDataSource(this.dataSource());
//		PathMatchingResourcePatternResolver rs=new PathMatchingResourcePatternResolver();
//		factoryBean.setConfigLocation(rs.getResource("classpath:mybatis-cfg.xml"));
		return factoryBean.getObject();
	}
	@Bean
	public PlatformTransactionManager transactionManager() throws PropertyVetoException {
		DataSourceTransactionManager txm=new DataSourceTransactionManager(this.dataSource());
		return txm;
	}
}
