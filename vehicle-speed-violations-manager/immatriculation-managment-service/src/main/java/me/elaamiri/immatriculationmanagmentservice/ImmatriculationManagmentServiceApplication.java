package me.elaamiri.immatriculationmanagmentservice;

import com.thoughtworks.xstream.XStream;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ImmatriculationManagmentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImmatriculationManagmentServiceApplication.class, args);
    }


    @Bean
        // for axon server connection
    CommandBus commandBus(){
        return SimpleCommandBus.builder().build();
    }

    @Bean
    public XStream xStream() {
        XStream xStream = new XStream();

        xStream.allowTypesByWildcard(new String[] { "me.elaamiri.**" });
        return xStream;
    }
}
