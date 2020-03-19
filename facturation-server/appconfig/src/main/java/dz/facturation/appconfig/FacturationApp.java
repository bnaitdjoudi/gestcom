package dz.facturation.appconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * main class for spring boot
 */
@ComponentScan("dz.facturation")
@SpringBootApplication
public class FacturationApp {

    public static void main(String[] args) {
        SpringApplication.run(FacturationApp.class, args);
    }
}
