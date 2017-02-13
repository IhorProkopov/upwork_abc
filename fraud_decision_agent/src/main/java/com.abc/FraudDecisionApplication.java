package com.abc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@PropertySource("classpath:application.properties")
@Import(BaseConfiguration.class)
@EnableJpaRepositories("com.abc")
public class FraudDecisionApplication {

    public static void main(String[] args) {
        SpringApplication.run(FraudDecisionApplication.class);
    }

}
