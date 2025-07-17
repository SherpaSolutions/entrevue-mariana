package com.sherpa.entrevue;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class Application {

    public static void main(String[] args) {
        SpringApplicationBuilder app = new SpringApplicationBuilder(Application.class);

        app.run(args);
    }

}
