package pl.pjatk.PatSza;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "custom")
public class ClassProperties {
    private String loginUrl;
    private Credentials credentials;

    @Data
    public static class Credentials {
        private String user;
        private String password;
    }
}
