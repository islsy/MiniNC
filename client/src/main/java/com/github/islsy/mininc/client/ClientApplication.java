package com.github.islsy.mininc.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
        Logger logger = LoggerFactory.getLogger(ClientApplication.class);
        logger.info("MiniNC start successfully!");
        logger.info("You can trigger RPC calls through the following interfaces:");
        logger.info("http://127.0.0.1:12310/swagger-ui.html");


    }
}