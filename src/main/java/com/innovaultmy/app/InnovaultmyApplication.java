package com.innovaultmy.app;

import com.innovaultmy.app.interceptors.AuthInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

@SpringBootApplication
@EnableJpaRepositories("com.innovaultmy.app.repositories")
public class InnovaultmyApplication implements WebMvcConfigurer{

	public static void main(String[] args) throws Throwable{
		SpringApplication.run(InnovaultmyApplication.class, args);
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AuthInterceptor())
				.addPathPatterns("/**")
	 			.excludePathPatterns("/sesion/**", "/static/**");

	registry.addInterceptor(new WebContentInterceptor())
			.addPathPatterns("/**")
			.excludePathPatterns("/sesion/**", "/static/**");
	}
}