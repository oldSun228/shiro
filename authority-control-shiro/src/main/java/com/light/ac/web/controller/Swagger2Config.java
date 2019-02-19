package com.light.ac.web.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author fgs
 * @data 2019/2/19 14:39
 */

@Component
@Configuration
@EnableSwagger2
@EnableWebMvc
@ComponentScan("com.light.ac.web.controller")
public class Swagger2Config {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("医谷药区接口API 文档")
                .description("HTTP对外开放接口")
                .version("1.0.0")
                .termsOfServiceUrl("http://xxx.xxx.com")
                .license("LICENSE")
                .licenseUrl("http://xxx.xxx.com")
                .build();
    }

}
