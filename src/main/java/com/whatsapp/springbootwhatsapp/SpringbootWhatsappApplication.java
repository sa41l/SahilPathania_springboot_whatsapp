package com.whatsapp.springbootwhatsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(
		exclude = {DataSourceAutoConfiguration.class}
)
@EnableSwagger2
@EnableTransactionManagement
@EnableAutoConfiguration
@Component
public class SpringbootWhatsappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWhatsappApplication.class, args);
	}

	public Docket apis() {
		return (new Docket(DocumentationType.SWAGGER_2)).select().apis(RequestHandlerSelectors.basePackage("com.whatsapp.springbootwhatsapp")).build();
	}
}
