package com.abc

import com.abc.model.rest.UserResponse
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.*
import java.util.concurrent.ConcurrentHashMap

@SpringBootApplication
@Import(BaseConfiguration::class)
@EnableSwagger2
open class WebServiceApplication {

    @Bean
    open fun decisionMap(): ConcurrentHashMap<UUID, UserResponse> = ConcurrentHashMap()

    @Bean
    open fun swagger(): Docket =
            Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.any())
                    .paths(PathSelectors.any())
                    .build();

}

fun main(args: Array<String>) {
    SpringApplication.run(WebServiceApplication::class.java)
}