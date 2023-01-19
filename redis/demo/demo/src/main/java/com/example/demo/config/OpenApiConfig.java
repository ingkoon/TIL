package com.example.demo.config;


import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI oepnAPI(){
        Info info = new Info()
                .title("swagger tset")
                .version("v1")
                .description("api 설정");

        return new OpenAPI()
                .components(new Components())
                .info(info);
    }
}
