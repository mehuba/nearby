package com.mehuba.nearby;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * Created by zhaoyibin on 18:11 12/02/2018
 */

@SpringBootApplication
public class NearbyApp {
    public static void main(String[] args) {
        SpringApplication.run(NearbyApp.class, args);
    }

//    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Inspect Spring Boot created beans.");
            String[] names = ctx.getBeanDefinitionNames();
            Arrays.sort(names);
            for (String name : names) {
                System.out.println("-" + name);
            }
        };
    }
}
