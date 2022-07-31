package ru.germandilio.thymeleaf_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@EnableAspectJAutoProxy
public class ThymeleafDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThymeleafDemoApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource securityDataSource() {
        return DataSourceBuilder.create().build();
    }
}
