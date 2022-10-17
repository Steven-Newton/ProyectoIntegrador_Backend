package com.javamonos.ecoinclusive;

import com.javamonos.ecoinclusive.jwt.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcoinclusiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcoinclusiveApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean<JwtFilter> jwtFilter(){
		FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/api/carrito/*");
		registrationBean.addUrlPatterns("/api/users/*");

		return registrationBean;
	}
}