package com.willbest.keepfit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
@CrossOrigin
@EnableWebSocket
@EnableNeo4jRepositories
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class KeepfitApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeepfitApplication.class, args);
    }

}
