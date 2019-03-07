package com.willbest.keepfit;

import com.willbest.keepfit.utilandpojo.date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@EnableWebSocket
@EnableNeo4jRepositories
@SpringBootApplication
public class KeepfitApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeepfitApplication.class, args);
    }

}
