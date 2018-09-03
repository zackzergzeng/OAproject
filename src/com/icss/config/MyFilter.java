package com.icss.config;

import org.springframework.web.filter.CharacterEncodingFilter;

public class MyFilter extends CharacterEncodingFilter {
	public MyFilter() {
		this.setEncoding("utf-8");
		this.setForceEncoding(true);
	}
}
