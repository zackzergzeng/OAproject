package com.icss.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;


@EnableWebMvc
@ComponentScan(basePackages= {"com.icss.controller","com.icss.service"})
public class MainConfig {
	@Bean
	public UrlBasedViewResolver viewResolver() {
		UrlBasedViewResolver rsl=new UrlBasedViewResolver();
		rsl.setViewClass(JstlView.class);
		rsl.setPrefix("/");
		rsl.setSuffix(".jsp");
		return rsl;
	}
//	@Bean(name="multipartResolver")
//	public CommonsMultipartResolver multiPartResolver() {
//		CommonsMultipartResolver mprsl=new CommonsMultipartResolver();
//		mprsl.setMaxUploadSize(1024L*1024L*10L);
//		return mprsl;
//		
//	}
	
}
