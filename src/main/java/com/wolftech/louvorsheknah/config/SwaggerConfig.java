package com.wolftech.louvorsheknah.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wolftech.louvorsheknah.controller"))
                .paths(PathSelectors.any())
                .build()
                .groupName("Wolf Tech Masters")
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Louvor Sheknah API",
                "Esta API é utilizada para controlar as requisições REST do  Louvor Sheknah",
                "Versão 1.0",
                "https://gitlab.com/mlobo.dev/louvor-sheknah",
                new Contact("Márcio Lôbo ", "https://gitlab.com/mlobo.dev/louvor-sheknah", "mlobo.dev@gmail.com"),
                "OPEN COD",
                "https://gitlab.com/mlobo.dev/louvor-sheknah-backend",
                Collections.emptyList() // Vendor Extensions
        );
    }
}