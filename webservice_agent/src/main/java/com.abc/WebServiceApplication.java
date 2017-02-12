package com.abc;


import com.abc.model.rest.DecisionResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
@Import(BaseConfiguration.class)
@EnableSwagger2
public class WebServiceApplication {

//    @Bean
//    public InternalResourceViewResolver internalResourceViewResolver(){
//        return new InternalResourceViewResolver("/WEB-INF/pages/", ".jsp");
//    }

    @Bean
    public ConcurrentHashMap<UUID, DecisionResponse> decisionMap() {
        return new ConcurrentHashMap<UUID, DecisionResponse>();
    }

    @Bean
    public Docket swagger() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build();
    }

    public static void main(String[] args) {
        SpringApplication.run(WebServiceApplication.class);
    }

}