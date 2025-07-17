package com.sherpa.entrevue;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@Configuration
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);


    public static void main(String[] args) {
        SpringApplicationBuilder app = new SpringApplicationBuilder(Application.class);

        app.run(args);
    }


    @Bean
    public CommandLineRunner verifyDatabaseConnection(JdbcTemplate jdbcTemplate) {
        return args -> {
            try {
                Integer result = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
                logger.info("Database is reachable: " + result);
            } catch (Exception e) {
                logger.info("Failed to connect to the database:", e);

                System.exit(1); // non-zero exit code on failure
            }
        };
    }
}
