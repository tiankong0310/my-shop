package com.fengdu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2 
@EnableWebMvc 	
public class SwaggerConfig  {
/*    @Bean  
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)  
                .apiInfo(apiInfo())  
                .select()  
                .apis(RequestHandlerSelectors.basePackage("com.fengdu.api"))  
                .paths(PathSelectors.any())  
                .build();  
    }  */
    @Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).build();
	}
  
    private ApiInfo apiInfo() {  
        return new ApiInfoBuilder()  
                .title("my-shop小程序，APP，微信Swagger2构建APP RESTful api接口 1.0")  
                .termsOfServiceUrl("https://gitee.com/WiliamWang/my-shop")  
                .contact("tiankong")  
                .version("2.0")  
                .build();  
    }  
}