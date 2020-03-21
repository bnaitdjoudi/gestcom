package dz.facturation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * main class for spring boot
 */

@ComponentScan("dz.facturation")
@SpringBootApplication
@EnableJpaRepositories
public class FacturationApp {
    public static void main(String[] args) {
        SpringApplication.run(FacturationApp.class, args);
    }
}
