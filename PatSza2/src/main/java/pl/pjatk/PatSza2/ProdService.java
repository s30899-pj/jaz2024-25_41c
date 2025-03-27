package pl.pjatk.PatSza2;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProdService implements HandlerServiceInterface {

    @Override
    public String SendMessage() {
        return "Hello from Prod";
    }

    @Override
    public String getServiceType() {
        return "prod";
    }
}
