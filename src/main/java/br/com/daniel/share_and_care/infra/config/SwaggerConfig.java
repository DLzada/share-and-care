package br.com.daniel.share_and_care.infra.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Share & Care API")
                        .description("API REST para gestão de doações e controle de estoque de alimentos.")
                        .version("v1.0.0"));
    }
}
