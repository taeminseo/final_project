package com.spring.project.food.config;

import java.io.IOException;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

//설정등록
@Configuration
// 패키지를 스캔해서 객체생성
@MapperScan(basePackages = {"com.spring.project.food.shop","com.spring.project.food"})
public class DatabaseConfig {
	
	
	@Bean 
	public HikariDataSource dataSource() {
		
		HikariConfig hikariConfig  = new HikariConfig();
		hikariConfig.setDriverClassName("oracle.jdbc.OracleDriver");
		hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		hikariConfig.setUsername("oracle");
		hikariConfig.setPassword("oracle");
	
		
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		
		return dataSource;
	}
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws Exception  {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		PathMatchingResourcePatternResolver resovler = new PathMatchingResourcePatternResolver();
		sqlSessionFactory.setMapperLocations(resovler.getResources("/mappers/**/*Mapper.xml"));
		return sqlSessionFactory;
	}
	
	
	
	
	
	
	
}
