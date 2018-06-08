package com.fengdu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2 
@EnableWebMvc 	
@ComponentScan(basePackages = { "com.fengdu.controller" }) // 必须存在 扫描的API Controller package name 也可以直接扫描class
public class SwaggerConfig  {
//	@Bean
//	public Docket customDocket() {
//		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
//	}
//	private ApiInfo apiInfo() {
////		Contact contact = new Contact("天空", "https://gitee.com/WiliamWang/my-shop", "2366207000@qq.com");
////		return new ApiInfo("my-shop前台API接口", // 大标题 title
////				"my-shop前台API接口", // 小标题
////				"0.0.1", // 版本
////				"www.tianyanshenghuo.com", // termsOfServiceUrl
////				contact, // 作者
////				"my-shop", // 链接显示文字
////				"https://gitee.com/WiliamWang/my-shop"// 网站链接
////		);
//		  return new ApiInfoBuilder().title("RESTful API document").version("2.0")
//		            .contact(new Contact("tiankong", "https://gitee.com/WiliamWang/my-shop", "2366207000@qq.com")).build();
//	}
	
  /*  @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build();
    }
	 
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("RESTful API document").version("2.0")
            .contact(new Contact("tiankong", "https://gitee.com/WiliamWang/my-shop", "2366207000@qq.com")).build();
    }*/
	   
	
  /*  @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/swagger/**").addResourceLocations("classpath:/static/swagger/");
    }*/

    @Bean  
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)  
                .apiInfo(apiInfo())  
                .select()  
                .apis(RequestHandlerSelectors.basePackage("com.fengdu.controller"))  
                .paths(PathSelectors.any())  
                .build();  
    }  
  
    private ApiInfo apiInfo() {  
        return new ApiInfoBuilder()  
                .title("Spring+Swagger2构建APP RESTful 接口 1.0")  
                .termsOfServiceUrl("https://gitee.com/WiliamWang/my-shop")  
                .contact("tiankong")  
                .version("2.0")  
                .build();  
    }  
}