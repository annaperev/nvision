package com.nvision.printstat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class SpringSwaggerJpaRestH2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringSwaggerJpaRestH2Application.class, args);
    }
}
