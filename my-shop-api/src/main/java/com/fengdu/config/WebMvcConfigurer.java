//package com.fengdu.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//import com.fengdu.interceptor.AuthorizationInterceptor;
//@Configuration
//public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
//	/**
//	 * 在配置文件中配置的文件保存路径
//	 */
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(authenticationInterceptor()).addPathPatterns("/**"); // 拦截所有请求，通过判断是否有 @LoginRequired 注解
//																						// 决定是否需要登录
//		super.addInterceptors(registry);
//	}
//
//	@Bean
//	public AuthorizationInterceptor authenticationInterceptor() {
//		return new AuthorizationInterceptor();
//	}
//
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/upload/**").addResourceLocations("classpath:/upload/");
//		registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
//		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//		registry.addResourceHandler("/public/**").addResourceLocations("classpath:/public/");
//		registry.addResourceHandler("/css/**").addResourceLocations("classpath:/css/");
//		registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
//		registry.addResourceHandler("/v2/api-docs").addResourceLocations("/v2/api-docs");
//		registry.addResourceHandler("*.htm").addResourceLocations("*.htm");
//		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
//		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//		super.addResourceHandlers(registry);
//	}
//
//}
