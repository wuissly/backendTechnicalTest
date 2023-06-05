package com.challenge.backendtest.config;


import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SimilarProducts")
                        .description("Backend dev technical test")
                        .contact(new Contact().email("wuissly.guzman@gmail.com").name("Wuissly Guzmán"))
                        .version("1.0")
                );
    }
}
