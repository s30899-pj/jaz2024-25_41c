package pl.pjatk.PatSza.FirstPart;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataConfiguration {

    @Bean
    public Pojo pojo(@Value("${my.custom.property:My default value}") String myCustomProperty)  {
        System.out.println(myCustomProperty);
        return new Pojo("Jan","Kowalski",20);
    }

    @Bean
    public List<String> defaultData() {
        return List.of("First String","Second String","Third String","Fourth String", "Fifth String");
    }

    @Bean
    @ConditionalOnProperty(prefix = "my.custom", name = "homework", havingValue = "true")
    public PojoHomework pojoHomework() {
        return new PojoHomework();
    }


}