package com.abc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:common.properties")
@Import(BaseConfiguration.class)
public class VendorApplication {

    public static void main(String[] args) {
        SpringApplication.run(VendorApplication.class);
    }

}
