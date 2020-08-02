package com.github.islsy.mininc.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: lsy
 * @Date: 2020/7/28 2:40 下午
 */

@EnableSwagger2
@Profile({"qa","rd"})
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket controllerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("接口文档")
                        .description("")
                        .version("")
                        .build())
                .enable(true)//enableSwagger
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.github.islsy.mininc.client.controller"))
                .paths(PathSelectors.any())
                .build();
    }

}
