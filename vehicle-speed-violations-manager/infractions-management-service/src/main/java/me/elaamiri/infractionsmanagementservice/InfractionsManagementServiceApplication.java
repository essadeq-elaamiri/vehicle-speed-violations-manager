package me.elaamiri.infractionsmanagementservice;

import com.thoughtworks.xstream.XStream;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class InfractionsManagementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfractionsManagementServiceApplication.class, args);
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
