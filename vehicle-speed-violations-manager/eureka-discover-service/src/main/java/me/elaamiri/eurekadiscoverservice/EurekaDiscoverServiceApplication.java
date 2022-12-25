package me.elaamiri.eurekadiscoverservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaDiscoverServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaDiscoverServiceApplication.class, args);
    }

}
