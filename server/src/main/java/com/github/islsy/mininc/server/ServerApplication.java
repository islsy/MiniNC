package com.github.islsy.mininc.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
        Logger logger = LoggerFactory.getLogger(ServerApplication.class);
        logger.info("MiniNCServer start successfully!");
        logger.info("Ready to receive MiniNCServer call.");
    }


}