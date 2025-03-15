package pl.pjatk.PatSza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import pl.pjatk.PatSza.FirstPart.ClassProperties;

@SpringBootApplication
@Configuration
@ImportResource("classpath:beans.xml")
@EnableConfigurationProperties(ClassProperties.class)
public class PatSzaApplication {

	public PatSzaApplication(ClassProperties classProperties) {
		System.out.println(classProperties.getLoginUrl() + " " + classProperties.getCredentials().getUser() + " " + classProperties.getCredentials().getPassword());
	}

	public static void main(String[] args) {
		SpringApplication.run(PatSzaApplication.class, args);
	}

}
