package com.abc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
@PropertySource("classpath:common.properties")
@Import(BaseConfiguration.class)
public class VendorApplication {

    @Bean
    public ExecutorService executorService(){
        return Executors.newFixedThreadPool(16);
    }

    public static void main(String[] args) {
        SpringApplication.run(VendorApplication.class);
    }

}
