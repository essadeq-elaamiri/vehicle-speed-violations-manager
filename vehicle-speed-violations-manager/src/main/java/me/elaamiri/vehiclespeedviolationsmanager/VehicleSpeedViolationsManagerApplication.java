package me.elaamiri.vehiclespeedviolationsmanager;

import com.thoughtworks.xstream.XStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VehicleSpeedViolationsManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleSpeedViolationsManagerApplication.class, args);
	}

	@Bean
	public XStream xStream() {
		XStream xStream = new XStream();

		xStream.allowTypesByWildcard(new String[] { "me.elaamiri.**" });
		return xStream;
	}
}
