package com.fmss.ikrestproject.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI(@Value("${application-description}") String description,


                                 @Value("${application-version}") String version) {
        return new OpenAPI()
                .info(new Info()
                        .title(" Ik My Backend")
                        .version(version)
                        .description(description)
                        .license(new License().name("Ik My Backend")));
    }
}
