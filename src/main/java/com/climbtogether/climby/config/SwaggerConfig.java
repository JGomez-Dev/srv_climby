package com.climbtogether.climby.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/soa/v2/api.docs").setViewName("forward:/v2/api-docs");
		registry.addViewController("/soa/swagger-resources/configuration/ui").setViewName("forward:/swagger-resource/configuration/ui");
		registry.addViewController("/soa/swagger-resources/configuration/security").setViewName("forward:/swagger-resources/configuration/security");
		registry.addViewController("/soa/swagger-resources").setViewName("forward:/swagger-resources");
	}
	
	@Bean
	public Docket simpleDiffServiceApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("core")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
				
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Climby Swagger")
				.description("Sirve para saber que funcionan los metodos")
				.version("1.0")
				.build();
	}
	
}
