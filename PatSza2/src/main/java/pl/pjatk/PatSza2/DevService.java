package pl.pjatk.PatSza2;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DevService implements HandlerServiceInterface {

    @Override
    public String sendMessage() {
        return "Hello from Dev";
    }

    @Override
    public String getServiceType() {
        return "dev";
    }
}
