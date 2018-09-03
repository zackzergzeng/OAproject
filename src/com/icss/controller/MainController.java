package com.icss.controller;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.icss.config.DBConfig;
import com.icss.config.MainConfig;
import com.icss.config.MyFilter;



public class MainController implements WebApplicationInitializer {

	public void onStartup(ServletContext servletcontext) throws ServletException {
		// TODO Auto-generated method stub
		AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();
		context.register(MainConfig.class);
		context.register(DBConfig.class);
		context.setServletContext(servletcontext);
		Dynamic servlet=servletcontext.addServlet("springmvc", new DispatcherServlet(context));
		servlet.addMapping("*.do");
		servlet.setLoadOnStartup(1);
		javax.servlet.FilterRegistration.Dynamic filter =servletcontext.addFilter("utf8", new MyFilter());
		filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, "/*");
	}

}
