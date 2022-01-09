package com.study.springcore.aop_lab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// 使用 Java 配置來替代 .xml
@Configuration // 此類別為配置檔
@EnableAspectJAutoProxy // 啟動 AOP 自動代理機制
@ComponentScan // 啟動自動掃瞄
public class AOPConfig {
	@Bean(name = "dancer")
	public Performance dancer() {
		return new Dancer();
	}

	@Bean
	public Audience audience() {
		return new Audience();
	}
	
	@Bean
	public Introducter getIntroducter() {
		return new Introducter();
	}
}